package ar.soft.Test.Postgres;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataUserOrderDao {

    private final Connection connection;

    // Передаем соединение через конструктор
    public DataUserOrderDao(Connection connection) {
        this.connection = connection;
    }

    // Метод для чтения объединенных данных (LEFT JOIN)
    public void printUsersWithOrders() throws Exception {
        String sql = """
            SELECT 
                u.id AS user_id, 
                u.names AS user_name, 
                o.id AS order_id, 
                o.amount AS order_amount, 
                o.status AS order_status
            FROM public.users u
            LEFT JOIN public.orders o ON u.id = o.user_id
            ORDER BY u.id
        """;

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("\n--- РЕЗУЛЬТАТ ЧТЕНИЯ ИЗ DAO ---");
            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String userName = resultSet.getString("user_name");
                int orderId = resultSet.getInt("order_id");
                double orderAmount = resultSet.getDouble("order_amount");
                String orderStatus = resultSet.getString("order_status");

                System.out.printf("Пользователь: [%d] %s | Заказ: ID %d, Сумма: %.2f, Статус: %s\n",
                        userId, userName, orderId, orderAmount, orderStatus);
            }
        }
    }
}

