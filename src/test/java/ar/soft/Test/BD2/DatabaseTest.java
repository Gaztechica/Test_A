package ar.soft.Test.BD2;

import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.Connection;
import java.util.List;

public class DatabaseTest {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Postgres";

    private Connection connection;
    private UserOrderDao dao;

    @BeforeClass
    public void setUpConnection() {
        // Избавляемся от try/catch: если инициализатор выбросит ошибку, TestNG сам покажет её в отчете
        try {
            connection = DatabaseInitializer.createConnection(URL, USER, PASSWORD);
            dao = new UserOrderDao(connection);
        } catch (Exception e) {
            Assert.fail("Критическая ошибка подключения: " + e.getMessage());
        }
    }

    @BeforeMethod
    public void prepareData() {
        try {
            DatabaseInitializer.initialize(connection);
        } catch (Exception e) {
            Assert.fail("Критическая ошибка подготовки данных: " + e.getMessage());
        }
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUpData() {
        // Компактная и понятная очистка без try/catch блоков
        if (dao != null) {
            dao.deleteUsersByEmailPattern("%@test.com");
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        // Делегируем закрытие инициализатору
        DatabaseInitializer.closeConnection(connection);
    }

    @Test(description = "Проверка поиска пользователя по части email")
    public void testFindUserByEmailPart() {
        // Если база вернет ошибку (Optional.empty()), тест красиво упадет с понятным текстом
        int count = dao.getUserCountByEmailPart("ivan")
                .orElseThrow(() -> new AssertionError("Ошибка выполнения SQL-запроса в БД"));

        Assert.assertEquals(count, 1, "Количество пользователей не соответствует ожидаемому!");
    }

    @Test(description = "Проверка вывода активных пользователей за неделю")
    public void testGetRecentActiveUsers() {
        // Если произошла ошибка, orElseGet вернет пустой список, и тест упадет на Assert ниже
        List<String> activeUsers = dao.getRecentActiveUsers()
                .orElseGet(List::of);

        Assert.assertFalse(activeUsers.isEmpty(), "Список пользователей пуст или произошла ошибка БД");
        Assert.assertTrue(activeUsers.contains("alex@example.com"), "Список не содержит ожидаемого пользователя");
    }

    @Test(description = "Проверка атомарной вставки пользователя и заказа в транзакции")
    public void testInsertUserAndOrderInTransaction() {
        // Метод транзакции теперь возвращает чистый boolean
        boolean success = dao.insertUserWithOrder("Новый Тест", "transaction@test.com", 3000.50);

        Assert.assertTrue(success, "Транзакция завершилась ошибкой на стороне БД");
    }
}
