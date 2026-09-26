package ar.soft.Test.BD2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class DatabaseInitializer {

    private DatabaseInitializer() {}

    /**
     * Создает и настраивает подключение к БД, а также принудительно убивает зависшие сессии.
     */
    public static Connection createConnection(String url, String user, String password) throws SQLException {
        DriverManager.setLoginTimeout(5);
        Connection connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(true);

        // Принудительно очищаем чужие сессии прямо при старте
        try (Statement killStmt = connection.createStatement()) {
            killStmt.execute("""
                SELECT pg_terminate_backend(pid) 
                FROM pg_stat_activity 
                WHERE datname = 'postgres' AND pid <> pg_backend_pid();
                """);
        } catch (Exception e) {
            // Игнорируем или логируем предупреждение очистки сессий
        }
        return connection;
    }

    /**
     * Инициализирует структуру таблиц и наполняет тестовыми данными.
     */
    public static void initialize(Connection connection) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.setQueryTimeout(3);

            // Безопасная инициализация без деструктивного DROP
            stmt.execute(SqlQueries.CREATE_USERS_TABLE);
            stmt.execute(SqlQueries.CREATE_ORDERS_TABLE);
            stmt.execute(SqlQueries.INSERT_TEST_USERS);
            stmt.execute(SqlQueries.INSERT_TEST_ORDERS);

            // Синхронизация счетчиков
            stmt.execute("SELECT setval('users_id_seq', (SELECT MAX(id) FROM users));");
            stmt.execute("SELECT setval('orders_id_seq', (SELECT MAX(id) FROM orders));");
        }
    }

    /**
     * Безопасное закрытие соединения без проброса исключений.
     */
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
        }
    }
}
