package ar.soft.Test.Postgres.PostgresUser;

import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

public class DatabaseTest {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Postgres";

    private static Connection connection;
    private UserOrderDao dao;

    // Выполняется 1 раз при запуске тестового класса - открываем коннект
    @BeforeClass
    public void setUpConnection() throws Exception {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        dao = new UserOrderDao(connection);
        System.out.println("--- Соединение с PostgreSQL установлено ---");
    }

    // Выполняется ПЕРЕД каждым тестом - готовит чистую структуру и данные
    @BeforeMethod
    public void prepareData() throws Exception {
        DatabaseInitializer.initialize(connection);
        System.out.println("--- База данных инициализирована перед тестом ---");
    }

    // 1. Тест: найти пользователя по части почты (LIKE '%@test%') и убедиться, что он один
    @Test
    public void testFindUserByEmailPart() throws Exception {
        List<User> users = dao.findUsersByEmailPart("@test.com");

        // Проверяем требование задания: "убедиться, что он один"
        Assert.assertEquals(users.size(), 1, "Ожидался ровно 1 пользователь с такой частью почты!");
    }

    // 2. Тест: вывести список активных пользователей, созданных за последнюю неделю
    @Test
    public void testGetRecentActiveUsers() throws Exception {
        List<User> activeUsers = dao.getRecentActiveUsers();

        Assert.assertNotNull(activeUsers);
        // Здесь можно добавить дополнительные проверки на основе ваших seed-данных
    }

    // 3. Тест: выбрать всех пользователей, у которых есть заказы на сумму > 1000 (JOIN)
    @Test
    public void testGetUsersWithLargeOrders() throws Exception {
        List<User> users = dao.getUsersWithOrdersAmountGreaterThan(1000.0);

        Assert.assertFalse(users.isEmpty(), "Список пользователей с крупными заказами не должен быть пустым");
    }

    // 4. Тест: вставить нового пользователя и его заказ (в одной транзакции)
    @Test
    public void testInsertUserAndOrderInTransaction() throws Exception {
        boolean success = dao.insertUserWithOrder("Новый Юзер", "new@test.com", 2500.00);

        Assert.assertTrue(success, "Транзакция по добавлению пользователя и заказа завершилась ошибкой");
    }

    // 5. Тест: обновить статус заказа по email пользователя
    @Test
    public void testUpdateOrderStatusByEmail() throws Exception {
        int rowsUpdated = dao.updateOrderStatusByEmail("alex@example.com", "completed");

        Assert.assertTrue(rowsUpdated > 0, "Ни один статус заказа не был обновлен");
    }

    // Выполняется ПОСЛЕ каждого теста - очищает тестовые данные по признаку
    @AfterMethod
    public void cleanUpData() throws Exception {
        System.out.println("--- Очистка тестовых данных после теста ---");
        try (Statement statement = connection.createStatement()) {
            // Удаляем пользователей, у которых почта заканчивается на @test.com
            statement.executeUpdate("DELETE FROM public.users WHERE email LIKE '%@test.com'");
        }
    }

    // Выполняется 1 раз после всех тестов класса - закрываем коннект
    @AfterClass
    public void tearDown() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("--- Соединение с PostgreSQL закрыто ---");
        }
    }
}


