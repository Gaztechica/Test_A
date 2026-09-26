package ar.soft.Test.Postgres.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserOrderDao {

    private final Connection connection;

    public UserOrderDao(Connection connection) {
        this.connection = connection;
    }

    /**
     * Вспомогательный метод маппинга (избегаем дублирования кода для LEFT JOIN запросов)
     */
//    private List<User> mapUsersWithOrders(ResultSet resultSet) throws Exception {
//        Map<Integer, User> userMap = new LinkedHashMap<>();
//        while (resultSet.next()) {
//            int userId = resultSet.getInt("user_id");
//            User user = userMap.get(userId);
//            if (user == null) {
//                user = new User(
//                        userId,
//                        resultSet.getString("user_name"),
//                        resultSet.getString("user_email"),
//                        resultSet.getString("user_status")
//                );
//                userMap.put(userId, user);
//            }
//
//            int orderId = resultSet.getInt("order_id");
//            if (!resultSet.wasNull()) {
//                Order order = new Order(
//                        orderId,
//                        userId,
//                        resultSet.getDouble("order_amount"),
//                        resultSet.getString("order_status")
//                );
//                user.orders().add(order);
//            }
//        }
//        return new ArrayList<>(userMap.values());
//    }

    /**
     * 1. Найти пользователя по части почты (LIKE '%@test%')
     */
//    public List<User> findUsersByEmailPart(String emailPart) throws Exception {
//        String sql = """
//            SELECT u.id AS user_id, u.names AS user_name, u.email AS user_email, u.status AS user_status,
//                   o.id AS order_id, o.amount AS order_amount, o.status AS order_status
//            FROM public.users u
//            LEFT JOIN public.orders o ON u.id = o.user_id
//            WHERE u.email LIKE ?
//        """;
//
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setString(1, "%" + emailPart + "%");
//            try (ResultSet resultSet = statement.executeQuery()) {
//                return mapUsersWithOrders(resultSet);
//            }
//        }
//    }
//
//    /**
//     * 2. Вывести список активных пользователей, созданных за последнюю неделю
//     */
//    public List<User> getRecentActiveUsers() throws Exception {
//        String sql = """
//            SELECT u.id AS user_id, u.names AS user_name, u.email AS user_email, u.status AS user_status,
//                   o.id AS order_id, o.amount AS order_amount, o.status AS order_status
//            FROM public.users u
//            LEFT JOIN public.orders o ON u.id = o.user_id
//            WHERE u.status = 'active' AND u.created_at >= NOW() - INTERVAL '7 days'
//        """;
//
//        try (Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(sql)) {
//            return mapUsersWithOrders(resultSet);
//        }
//    }
//
//    /**
//     * 3. Выбрать всех пользователей, у которых есть заказы на сумму > X (JOIN)
//     */
//    public List<User> getUsersWithOrdersAmountGreaterThan(double minAmount) throws Exception {
//        // Используем INNER JOIN, так как нам нужны только пользователи, у которых ТОЧНО есть подходящие заказы
//        String sql = """
//            SELECT u.id AS user_id, u.names AS user_name, u.email AS user_email, u.status AS user_status,
//                   o.id AS order_id, o.amount AS order_amount, o.status AS order_status
//            FROM public.users u
//            JOIN public.orders o ON u.id = o.user_id
//            WHERE o.amount > ?
//        """;
//
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setDouble(1, minAmount);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                return mapUsersWithOrders(resultSet);
//            }
//        }
//    }

    /**
     * 4. Вставить нового пользователя и его заказ (в одной транзакции)
     */
    public boolean insertUserWithOrder(String name, String email, double amount) throws Exception {
        String insertUserSql = "INSERT INTO public.users (names, email, status) VALUES (?, ?, 'active')";
        String insertOrderSql = "INSERT INTO public.orders (user_id, amount, status) VALUES (currval('public.users_id_seq'), ?, 'pending')";

        connection.setAutoCommit(false); // Аналог BEGIN;
        try (PreparedStatement psUser = connection.prepareStatement(insertUserSql);
             PreparedStatement psOrder = connection.prepareStatement(insertOrderSql)) {

            psUser.setString(1, name);
            psUser.setString(2, email);
            psUser.executeUpdate();

            psOrder.setDouble(1, amount);
            psOrder.executeUpdate();

            connection.commit(); // Аналог COMMIT;
            return true;
        } catch (Exception e) {
            connection.rollback(); // Аналог ROLLBACK;
            throw e;
        } finally {
            connection.setAutoCommit(true); // Возвращаем режим по умолчанию
        }
    }

    /**
     * 5. Обновить статус заказа по email пользователя
     */
    public int updateOrderStatusByEmail(String userEmail, String newStatus) throws Exception {
        String sql = """
            UPDATE public.orders 
            SET status = ? 
            WHERE user_id = (SELECT id FROM public.users WHERE email = ?)
        """;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newStatus);
            statement.setString(2, userEmail);
            return statement.executeUpdate(); // Возвращает количество измененных строк
        }
    }
}

