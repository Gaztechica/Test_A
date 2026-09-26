package ar.soft.Test.producer;

import org.junit.jupiter.api.*;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.redpanda.RedpandaContainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class IdempotencyTest {

////     1. Поднимаем контейнеры через Testcontainers
//    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15-alpine");
////    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("://beget.com");
//
//    static RedpandaContainer redpanda = new RedpandaContainer("dockerhub.timeweb.cloud/redpandadata/redpanda:v23.3.5");
//     1. Поднимаем контейнеры через Testcontainers с обходом блокировок РФ
//    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
//            org.testcontainers.utility.DockerImageName.parse("://beget.com")
//                    .asCompatibleSubstituteFor("postgres")
//    );
//
//    static RedpandaContainer redpanda = new RedpandaContainer(
//            org.testcontainers.utility.DockerImageName.parse("dockerhub.timeweb.cloud/redpandadata/redpanda:v23.3.5")
//                    .asCompatibleSubstituteFor("://redpanda.com")
//    );


    // 1. Поднимаем контейнеры через Testcontainers с обходом блокировок РФ
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            org.testcontainers.utility.DockerImageName.parse("postgres:15-alpine")
                    .asCompatibleSubstituteFor("postgres")
    );

    static RedpandaContainer redpanda = new RedpandaContainer(
            org.testcontainers.utility.DockerImageName.parse("dockerhub.timeweb.cloud/redpandadata/redpanda:v23.3.5")
                    .asCompatibleSubstituteFor("docker.redpanda.com/vectorized/redpanda")
    );



    private Connection dbConnection;
    private TestProducer producer;
    private TestConsumer consumer;
    private static final String TOPIC = "order-events";

//    @BeforeAll
//    static void startContainers() {
//        postgres.start();
//        redpanda.start();
//    }

    @BeforeAll
    static void startContainers() {
        // ПРИНУДИТЕЛЬНО УКАЗЫВАЕМ ПУТЬ К DOCKER DESKTOP ДЛЯ WINDOWS
        System.setProperty("tc.host", "tcp://127.0.0.1:2375");

        postgres.start();
        redpanda.start();
    }

    @AfterAll
    static void stopContainers() {
        postgres.stop();
        redpanda.stop();
    }

    @BeforeEach
    void setUp() throws Exception {
        // Подключаемся к динамическому порту Postgres, поднятому Testcontainers
        dbConnection = DriverManager.getConnection(postgres.getJdbcUrl(), postgres.getUsername(), postgres.getPassword());

        // Создаем тестовую таблицу с PRIMARY KEY для обеспечения уникальности
        try (Statement stmt = dbConnection.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS orders (" +
                    "order_id VARCHAR(50) PRIMARY KEY, " +
                    "status VARCHAR(20));");
            stmt.execute("TRUNCATE TABLE orders;"); // Очищаем перед тестом
        }

        // Инициализируем продюсера и консьюмера, передавая им динамический адрес Redpanda
        producer = new TestProducer(redpanda.getBootstrapServers());
        consumer = new TestConsumer(redpanda.getBootstrapServers(), dbConnection);
    }

    @AfterEach
    void tearDown() throws Exception {
        producer.close();
        consumer.close();
        if (dbConnection != null && !dbConnection.isClosed()) {
            dbConnection.close();
        }
    }

    @Test
    @DisplayName("Тест на идемпотентность: отправка сообщения 3 раза не должна дублировать запись в БД")
    void testIdempotentOrderProcessing() throws Exception {
        String orderId = "123";
        String jsonMessage = "{\"orderId\": \"123\", \"status\": \"PAID\"}";

        // Критерий приемки: Отправляем ОДНО И ТО ЖЕ сообщение 3 раза подряд
        producer.sendOrderEvent(TOPIC, orderId, jsonMessage);
        producer.sendOrderEvent(TOPIC, orderId, jsonMessage);
        producer.sendOrderEvent(TOPIC, orderId, jsonMessage);

        // Консьюмер вычитывает все 3 сообщения из очереди
        consumer.consumeAndSave(TOPIC);

        // Проверяем количество записей в базе данных
        try (Statement stmt = dbConnection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS row_count FROM orders WHERE order_id = '123'")) {

            if (rs.next()) {
                int rowCount = rs.getInt("row_count");

                // Доказываем защиту от дублей: записей должна быть ровно 1, несмотря на 3 сообщения
                Assertions.assertEquals(1, rowCount,
                        "Критическая ошибка: Защита от дублей не сработала! В БД создано более одной записи.");
                System.out.println("🔥 Успех! В БД обнаружена только " + rowCount + " запись. Идемпотентность подтверждена.");
            }
        }
    }
}

