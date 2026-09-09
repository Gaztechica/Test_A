package ar.soft.Test.BD;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initialize(Connection connection) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.setQueryTimeout(3);

            stmt.execute(SqlQueries.CREATE_USERS_TABLE);
            stmt.execute(SqlQueries.CREATE_ORDERS_TABLE);
            stmt.execute(SqlQueries.INSERT_TEST_USERS);
            stmt.execute(SqlQueries.INSERT_TEST_ORDERS);

            // Сдвигаем счетчики ID для обеих таблиц на актуальные значения
            stmt.execute("SELECT setval('users_id_seq', (SELECT MAX(id) FROM users));");
            stmt.execute("SELECT setval('orders_id_seq', (SELECT MAX(id) FROM orders));");
        }
    }
}





