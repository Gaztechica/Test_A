package ar.soft.Test.Postgres;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.*;

public class DatabaseTest extends PostgresApp {

//    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
//    private static final String USER = "postgres";
//    private static final String PASSWORD = "Postgres";

    private Connection connection;

    @BeforeMethod
    public void setUpData() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        connection.setAutoCommit(false); // Включаем режим ручных транзакций

        try (Statement statement = connection.createStatement()) {
            // Очищаем таблицы перед запуском (на случай, если прошлый тест упал)
            statement.execute("TRUNCATE public.orders, public.users RESTART IDENTITY CASCADE;");

            // Наполняем базовыми тестовыми данными
            statement.execute("INSERT INTO public.users (names, email, status, created_at) VALUES " +
                    "('Тестовый Пользователь', 'user1@test.com', 'active', NOW() - INTERVAL '3 days')," +
                    "('Иван Сидоров', 'ivan@gmail.com', 'active', NOW() - INTERVAL '10 days');");

            statement.execute("INSERT INTO public.orders (user_id, amount, status) VALUES " +
                    "(1, 1500.00, 'pending')," +
                    "(2, 800.00, 'pending');");

            connection.commit(); // Фиксируем изменения
            System.out.println("Данные для теста успешно подготовлены.");
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }

    @Test
    public void testUserQueries() throws SQLException {
        // 1. Проверяем, что пользователь по части почты один
        String selectLikeSql = "SELECT COUNT(*) FROM public.users WHERE email LIKE '%@test.com%'";
        try (PreparedStatement stmt = connection.prepareStatement(selectLikeSql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                int count = rs.getInt(1);
                Assert.assertEquals(count, 1, "Ожидался ровно один пользователь с почтой *@test.com");
            }
        }

        // 2. Вставка нового пользователя и его заказа в рамках одной транзакции
        String insertUserSql = "INSERT INTO public.users (names, email, status) VALUES (?, ?, ?)";
        String insertOrderSql = "INSERT INTO public.orders (user_id, amount, status) VALUES (?, ?, ?)";

        try (PreparedStatement userStmt = connection.prepareStatement(insertUserSql, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement orderStmt = connection.prepareStatement(insertOrderSql)) {

            // Добавляем юзера
            userStmt.setString(1, "Транзакционный Юзер");
            userStmt.setString(2, "tx_user@test.com");
            userStmt.setString(3, "active");
            userStmt.executeUpdate();

            // Получаем сгенерированный базой данных ID нового пользователя
            int newUserId = 0;
            try (ResultSet generatedKeys = userStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    newUserId = generatedKeys.getInt(1);
                }
            }

            // Добавляем его заказ, используя полученный ID
            orderStmt.setInt(1, newUserId);
            orderStmt.setDouble(2, 3500.00);
            orderStmt.setString(3, "pending");
            orderStmt.executeUpdate();

            connection.commit(); // Завершаем транзакцию вставки
            System.out.println("Транзакция создания пользователя и заказа выполнена успешно.");
        } catch (SQLException e) {
            connection.rollback();
            Assert.fail("Транзакция создания данных прервана: " + e.getMessage());
        }

        // 3. Обновление статуса заказа по email пользователя
        String updateSql = "UPDATE public.orders SET status = 'completed' " +
                "WHERE user_id = (SELECT id FROM public.users WHERE email = ?)";
        try (PreparedStatement updateStmt = connection.prepareStatement(updateSql)) {
            updateStmt.setString(1, "user1@test.com");
            int rowsUpdated = updateStmt.executeUpdate();
            connection.commit();
            Assert.assertTrue(rowsUpdated > 0, "Статус заказа не был обновлен");
        }
    }

    @AfterMethod
    public void tearDownData() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            try (Statement statement = connection.createStatement()) {
                // Удаляем всех пользователей, чья почта заканчивается на @test.com
                // Каскадное удаление (ON DELETE CASCADE) автоматически очистит их заказы
                statement.execute("DELETE FROM public.users WHERE email LIKE '%@test.com';");
                connection.commit();
                System.out.println("Тестовые данные успешно удалены после теста.");
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            } finally {
                connection.close(); // Обязательно закрываем соединение
            }
        }
    }
}


