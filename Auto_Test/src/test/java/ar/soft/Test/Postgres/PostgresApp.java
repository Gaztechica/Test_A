package ar.soft.Test.Postgres;

import java.sql.*;

public class PostgresApp {

    protected static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    protected static final String USER = "postgres";
    protected static final String PASSWORD = "Postgres";

//    public static void main(String[] args) {
//        //  Открываем соединение с БД
//        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
//            System.out.println("Соединение с PostgreSQL успешно установлено!");
//
//            // Выполняем операции
////            createTable(connection);
////            insertUser(connection, "Иван Иванов", "ivan@example.com");
////            insertUser(connection, "Петр Петров", "petr@example.com");
////            readUsers(connection);
//
//        } catch (SQLException e) {
//            System.err.println("Ошибка при работе с базой данных:");
//            e.printStackTrace();
//        }



    public static void main(String[] args) {
        // Конструкция try-with-resources автоматически закроет Connection и Statement
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            System.out.println("Успешное подключение к PostgreSQL!");

            // 1. Создание таблицы (если её нет)
            String createTableSql = "CREATE TABLE IF NOT EXISTS users (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(100), " +
                    "email VARCHAR(100))";
            stmt.execute(createTableSql);

            // 2. Вставка данных с использованием PreparedStatement (защита от SQL-инъекций)
            String insertSql = "INSERT INTO users (name, email) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
                pstmt.setString(1, "Иван Иванов");
                pstmt.setString(2, "ivan@example.com");
                pstmt.executeUpdate();
                System.out.println("Данные успешно добавлены!");
            }

            // 3. Чтение данных из БД
            String selectSql = "SELECT id, name, email FROM users";
            try (ResultSet rs = stmt.executeQuery(selectSql)) {
                System.out.println("\nСписок пользователей из БД:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    System.out.printf("ID: %d | Имя: %s | Email: %s%n", id, name, email);
                }
            }

        } catch (SQLException e) {
            System.err.println("Ошибка при работе с базой данных:");
            e.printStackTrace();
        }
    }


    }

//    private static void readUsers(Connection connection) {
//    }
//
//
//    private static void insertUser(Connection connection, String иванИванов, String mail) {
//
//    }
//
//    private static void createTable(Connection connection) {
//    }
//
//    public void ee() {
//        System.out.println();
//    }
//}



