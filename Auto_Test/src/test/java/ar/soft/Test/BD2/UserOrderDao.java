package ar.soft.Test.BD2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserOrderDao {
    private final Connection connection;

    public UserOrderDao(Connection connection) {
        this.connection = connection;
    }

    // Возвращаем Optional<Integer> вместо проброса исключения
    public Optional<Integer> getUserCountByEmailPart(String emailPart) {
        try (PreparedStatement stmt = connection.prepareStatement(SqlQueries.FIND_USER_BY_EMAIL_PART)) {
            stmt.setString(1, "%" + emailPart + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                int count = 0;
                while (rs.next()) count++;
                return Optional.of(count);
            }
        } catch (SQLException e) {
            return Optional.empty(); // В случае ошибки возвращаем пустой Optional
        }
    }

    // Возвращаем Optional<List<String>>
    public Optional<List<String>> getRecentActiveUsers() {
        List<String> emails = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(SqlQueries.GET_RECENT_ACTIVE_USERS);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                emails.add(rs.getString("email"));
            }
            return Optional.of(emails);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }


    public void deleteUsersByEmailPattern(String pattern) {
        try (PreparedStatement stmt = connection.prepareStatement(SqlQueries.DELETE_USERS_BY_EMAIL_PATTERN)) {
            stmt.setString(1, pattern);
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Просто логируем ошибку очистки в консоль, чтобы она не роняла тесты в AfterMethod
            System.err.println("Предупреждение: Не удалось очистить данные после теста: " + e.getMessage());
        }
    }



    // Пример для транзакции: возвращает true при успехе, false при любой ошибке SQL
    public boolean insertUserWithOrder(String name, String email, double amount) {
        try {
            connection.setAutoCommit(false);
            int userId = -1;
            try (PreparedStatement userStmt = connection.prepareStatement(SqlQueries.INSERT_NEW_USER)) {
                userStmt.setString(1, name);
                userStmt.setString(2, email);
                try (ResultSet rs = userStmt.executeQuery()) {
                    if (rs.next()) userId = rs.getInt(1);
                }
            }

            try (PreparedStatement orderStmt = connection.prepareStatement(SqlQueries.INSERT_NEW_ORDER)) {
                orderStmt.setInt(1, userId);
                orderStmt.setDouble(2, amount);
                orderStmt.executeUpdate();
            }

            connection.commit();
            return true;
        } catch (SQLException e) {
            try { connection.rollback(); } catch (SQLException ex) { /* ignore */ }
            return false;
        }
    }
}