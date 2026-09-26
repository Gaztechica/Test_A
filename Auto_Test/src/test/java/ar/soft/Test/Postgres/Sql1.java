package ar.soft.Test.Postgres;

import java.math.BigDecimal;
import java.sql.*;

public class Sql1 extends PostgresApp {


        public static void main(String[] args) {

            // --- ШАГ 1: Инициализация схемы (Удаление старых и создание новых таблиц) ---

            String dropTablesScript = """
            DROP TABLE IF EXISTS orders CASCADE;
            DROP TABLE IF EXISTS users CASCADE;
        """;

            String createTablesScript = """
            CREATE TABLE users (
                id SERIAL PRIMARY KEY,
                names VARCHAR(150) NOT NULL,
                email VARCHAR(150) UNIQUE NOT NULL,
                status VARCHAR(50) NOT NULL,
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
            );

            CREATE TABLE orders (
                id SERIAL PRIMARY KEY,
                user_id INT NOT NULL,
                amount NUMERIC(10, 2) NOT NULL,
                status VARCHAR(50) NOT NULL,
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
            );
        """;

            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement statement = connection.createStatement()) {

                System.out.println("Подключение к СУБД для создания таблиц выполнено.");

                statement.execute(dropTablesScript);
                System.out.println("Старые таблицы (если они были) успешно удалены.");

                statement.execute(createTablesScript);
                System.out.println("SQL-скрипт выполнен: таблицы 'users' и 'orders' успешно созданы!");

            } catch (SQLException e) {
                System.err.println("Ошибка при выполнении SQL-скрипта инициализации:");
                e.printStackTrace();
                return; // Завершаем выполнение, если таблицы не создались
            }


            // --- ШАГ 2: Наполнение таблиц тестовыми данными через PreparedStatement ---

            String insertUserSQL = "INSERT INTO users (names, email, status) VALUES (?, ?, ?);";
            String insertOrderSQL = "INSERT INTO orders (user_id, amount, status) VALUES (?, ?, ?);";

            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                System.out.println("\nПодключение к СУБД для вставки данных выполнено.");

                // Отключаем авто-коммит для атомарного управления транзакцией
                connection.setAutoCommit(false);

                // 1. Вставка пользователей пакетом (Batch)
                try (PreparedStatement userStmt = connection.prepareStatement(insertUserSQL)) {
                    // Пользователь 1
                    userStmt.setString(1, "Иван Иванов");
                    userStmt.setString(2, "ivan@example.com");
                    userStmt.setString(3, "ACTIVE");
                    userStmt.addBatch();

                    // Пользователь 2
                    userStmt.setString(1, "Анна Петрова");
                    userStmt.setString(2, "anna@example.com");
                    userStmt.setString(3, "ACTIVE");
                    userStmt.addBatch();

                    // Пользователь 3
                    userStmt.setString(1, "Сергей Сидоров");
                    userStmt.setString(2, "sergey@example.com");
                    userStmt.setString(3, "SUSPENDED");
                    userStmt.addBatch();

                    userStmt.executeBatch();
                    System.out.println("Пользователи добавлены через PreparedStatement пакетно.");
                }

                // 2. Вставка заказов пакетом (Batch)
                try (PreparedStatement orderStmt = connection.prepareStatement(insertOrderSQL)) {
                    // Заказы для user_id = 1 (Иван)
                    addOrderToBatch(orderStmt, 1, "1500.50", "COMPLETED");
                    addOrderToBatch(orderStmt, 1, "430.00", "PROCESSING");

                    // Заказ для user_id = 2 (Анна)
                    addOrderToBatch(orderStmt, 2, "9990.00", "COMPLETED");

                    // Заказ для user_id = 3 (Сергей)
                    addOrderToBatch(orderStmt, 3, "750.00", "CANCELLED");

                    orderStmt.executeBatch();
                    System.out.println("Заказы добавлены через PreparedStatement пакетно.");
                }

                // Если всё прошло успешно — фиксируем транзакцию в PostgreSQL
                connection.commit();
                System.out.println("Транзакция успешно зафиксирована. Данные в БД!");

            } catch (SQLException e) {
                System.err.println("Ошибка при вставке данных! Откат всей транзакции.");
                e.printStackTrace();
            }
        }

        // Вспомогательный метод для упаковки заказов в пакет
        private static void addOrderToBatch(PreparedStatement stmt, int userId, String amount, String status) throws SQLException {
            stmt.setInt(1, userId);
            stmt.setBigDecimal(2, new BigDecimal(amount));
            stmt.setString(3, status);
            stmt.addBatch();
        }


}



