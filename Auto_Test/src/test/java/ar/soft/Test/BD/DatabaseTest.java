package ar.soft.Test.BD;

import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.concurrent.Callable;

public class DatabaseTest {

////    Postgres локально
//    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
//    private static final String USER = "postgres";
//    private static final String PASSWORD = "Postgres";

    // Динамически определяем хост: если тесты запущены в Docker, используем имя сервиса, иначе — localhost
    private static final String DB_HOST = System.getenv("DOCKER_ENV") != null ? "postgres" : "localhost";

    // Параметры подключения из docker-compose.yml
    private static final String URL = "jdbc:postgresql://" + DB_HOST + ":5432/test_db";
    private static final String USER = "test_user";
    private static final String PASSWORD = "test_password";

    private Connection connection;
    private UserOrderDao dao;

    @BeforeClass
    public void setUpConnection() {
        try {
            DriverManager.setLoginTimeout(5);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(true);

            // КРИТИЧЕСКИЙ ШАГ: Принудительно очищаем чужие сессии прямо из кода
            try (java.sql.Statement killStmt = connection.createStatement()) {
                killStmt.execute("""
                SELECT pg_terminate_backend(pid) 
                FROM pg_stat_activity 
                WHERE datname = 'postgres' AND pid <> pg_backend_pid();
                """);
            } catch (Exception e) {
                System.out.println("Предупреждение по очистке сессий (можно игнорировать): " + e.getMessage());
            }

            dao = new UserOrderDao(connection);
        } catch (Exception e) {
            Assert.fail("Критическая ошибка: Не удалось настроить подключение: " + e.getMessage());
        }
    }


    @BeforeMethod
    public void prepareData() {
        try {
            DatabaseInitializer.initialize(connection);
        } catch (Exception e) {
            Assert.fail("Критическая ошибка: Не удалось подготовить данные перед тестом: " + e.getMessage());
        }
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUpData() {
        if (dao != null) {
            try {
                dao.deleteUsersByEmailPattern("%@test.com");
            } catch (Exception e) {
                System.err.println("Предупреждение: Не удалось очистить данные после теста: " + e.getMessage());
            }
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("--- Соединение успешно закрыто и освобождено ---");
            }
        } catch (Exception e) {
            System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
        }
    }


    @Test(description = "Проверка поиска пользователя по части email (должен быть ровно один)")
    public void testFindUserByEmailPart() {
        int count = executeSafe(() -> dao.getUserCountByEmailPart("ivan"));

        Assert.assertEquals(count, 1, "Количество пользователей не соответствует ожидаемому!");
    }

    @Test(description = "Проверка вывода активных пользователей, созданных за последнюю неделю")
    public void testGetRecentActiveUsers() {
        List<String> activeUsers = executeSafe(() -> dao.getRecentActiveUsers());

        Assert.assertNotNull(activeUsers, "Список пользователей не должен быть null");
        Assert.assertTrue(activeUsers.contains("alex@example.com"), "Список не содержит ожидаемого пользователя");
    }

    @Test(description = "Проверка выбора пользователей с суммой заказа больше 1000")
    public void testGetUsersWithLargeOrders() {
        List<String> names = executeSafe(() -> dao.getUsersWithOrdersAmountGreaterThan(1000.0));

        Assert.assertFalse(names.isEmpty(), "Список пользователей с крупными заказами пуст");
        Assert.assertTrue(names.contains("Иван Иванов"), "Иван Иванов должен быть в списке крупных заказчиков");
    }

    @Test(description = "Проверка атомарной вставки пользователя и заказа в рамках одной транзакции")
    public void testInsertUserAndOrderInTransaction() {
        boolean success = executeSafe(() -> dao.insertUserWithOrder("Новый Тест", "transaction@test.com", 3000.50));

        Assert.assertTrue(success, "Транзакция завершилась ошибкой");
    }

    @Test(description = "Проверка обновления статуса заказа по email пользователя")
    public void testUpdateOrderStatusByEmail() {
        int updatedRows = executeSafe(() -> dao.updateOrderStatusByEmail("alex@example.com", "processing"));

        Assert.assertTrue(updatedRows > 0, "Ни одна строка статуса заказа не была обновлена");
    }

    /**
     * Утилитарный метод для исключения boilerplate try-catch и throws из тестовых методов.
     */
    private <T> T executeSafe(Callable<T> action) {
        try {
            return action.call();
        } catch (Exception e) {
            Assert.fail("Тест провален из-за непредвиденного исключения SQL: " + e.getMessage());
            return null;
        }
    }
}

