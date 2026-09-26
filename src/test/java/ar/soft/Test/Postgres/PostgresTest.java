package ar.soft.Test.Postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ar.soft.Test.Postgres.PostgresApp.*;

public class PostgresTest {


    // Параметры подключения к базе данных PostgreSQL
//    private static final String URL = "jdbc:postgresql://localhost:5432/my_database";
//    private static final String USER = "my_username";
//    private static final String PASSWORD = "my_password";

    public static void main(String[] args) {
        // Используем try-with-resources для автоматического закрытия соединения
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Успешное подключение к базе данных PostgreSQL!");

            // 1. Выведем список пользователей
            System.out.println("\n--- Список пользователей ---");
            printUsers(connection);

            // 2. Выведем объединенные данные (Пользователи и их заказы)
            System.out.println("\n--- Пользователи и их заказы ---");
            printUsersWithOrders(connection);

        } catch (SQLException e) {
            System.err.println("Ошибка при работе с базой данных: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Метод для вывода пользователей
    private static void printUsers(Connection connection) throws SQLException {
        String sql = "SELECT id, name, email, status FROM public.users";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) { // Выполняем запрос

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String status = resultSet.getString("status");

                System.out.printf("ID: %d | Имя: %s | Email: %s | Статус: %s%n", id, name, email, status);
            }
        }
    }

    // Метод для вывода пользователей вместе с их заказами (JOIN)
    private static void printUsersWithOrders(Connection connection) throws SQLException {
        String sql = "SELECT u.name, o.amount, o.status " +
                "FROM public.users u " +
                "LEFT JOIN public.orders o ON u.id = o.user_id";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String userName = resultSet.getString("name");
                double amount = resultSet.getDouble("amount");
                String orderStatus = resultSet.getString("status");

                // Если у пользователя нет заказов, amount будет 0, а status - null
                if (orderStatus == null) {
                    System.out.printf("Пользователь %s еще не делал заказов.%n", userName);
                } else {
                    System.out.printf("Пользователь: %s | Сумма заказа: %.2f руб. | Статус: %s%n",
                            userName, amount, orderStatus);
                }
            }
        }
    }


}
