package ar.soft.Test.Postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbaseManager {

    // Укажите ваши данные для подключения к PostgreSQL
    private static final String URL = "jdbc:postgresql://localhost:5432/your_database_name";
    private static final String USER = "postgres";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {

        // Открываем соединение с базой данных
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            // Включаем ручное управление транзакциями (аналог BEGIN ... COMMIT)
            connection.setAutoCommit(false);

            try (Statement statement = connection.createStatement()) {

                System.out.println("1. Удаление старых таблиц (если существовали)...");
                statement.executeUpdate("DROP TABLE IF EXISTS public.orders CASCADE");
                statement.executeUpdate("DROP TABLE IF EXISTS public.users CASCADE");

                System.out.println("2. Создание таблицы public.users...");
                statement.executeUpdate("""
                    CREATE TABLE public.users (
                        id SERIAL PRIMARY KEY,                         
                        names VARCHAR(100) NOT NULL,                    
                        email VARCHAR(150) UNIQUE NOT NULL,            
                        status VARCHAR(20) DEFAULT 'active',           
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
                    )
                """);

                System.out.println("3. Создание таблицы public.orders...");
                statement.executeUpdate("""
                    CREATE TABLE public.orders (
                        id SERIAL PRIMARY KEY,                         
                        user_id INT NOT NULL,                          
                        amount NUMERIC(10, 5) NOT NULL,                
                        status VARCHAR(20) DEFAULT 'pending',          
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
                        CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE CASCADE
                    )
                """);

                System.out.println("4. Наполнение таблицы пользователей данными...");
                statement.executeUpdate("""
                    INSERT INTO public.users (names, email, status, created_at) VALUES
                    ('Алексей Иванов', 'alex@example.com', 'active', NOW() - INTERVAL '10 days'),
                    ('Мария Петрова', 'maria@example.com', 'active', NOW() - INTERVAL '5 days'),
                    ('Иван Сидоров', 'ivan@example.com', 'suspended', NOW() - INTERVAL '1 day'),
                    ('Игорь Сидоров', 'igor@example.com', 'suspended', NOW() - INTERVAL '17 day'),
                    ('Коля Сидоров', 'in@test.com', 'suspended', NOW() - INTERVAL '10 day'),
                    ('Иван Васин', 'an@test.com', 'suspended', NOW() - INTERVAL '11 day')
                """);

                System.out.println("5. Наполнение таблицы заказов данными...");
                statement.executeUpdate("""
                    INSERT INTO public.orders (user_id, amount, status, created_at) VALUES
                    (1, 1500.00, 'paid', NOW() - INTERVAL '9 days'),
                    (1, 450.50, 'shipped', NOW() - INTERVAL '7 days'),
                    (2, 3200.00, 'pending', NOW() - INTERVAL '3 days'),
                    (2, 990.00, 'paid', NOW() - INTERVAL '2 days'),
                    (3, 5000.00, 'cancelled', NOW() - INTERVAL '12 hours')
                """);

                // Коммитим транзакцию (физически сохраняем все изменения в БД)
                connection.commit();
                System.out.println("Транзакция успешно зафиксирована (COMMIT)!");

                // ==========================================================
                // ЧТЕНИЕ ДАННЫХ (Выполнение SELECT запроса с LEFT JOIN)
                // ==========================================================
                System.out.println("\n--- Вывод объединенного списка пользователей и заказов ---");

                String selectJoinSql = """
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

                try (ResultSet resultSet = statement.executeQuery(selectJoinSql)) {
                    // Проходимся циклом по строкам результата ответа базы данных
                    while (resultSet.next()) {
                        int userId = resultSet.getInt("user_id");
                        String userName = resultSet.getString("user_name");
                        int orderId = resultSet.getInt("order_id"); // вернет 0, если null
                        double orderAmount = resultSet.getDouble("order_amount");
                        String orderStatus = resultSet.getString("order_status");

                        System.out.printf("Пользователь: [%d] %s | Заказ: ID %d, Сумма: %.2f, Статус: %s\n",
                                userId, userName, orderId, orderAmount, orderStatus);
                    }
                }

            } catch (Exception e) {
                // Если внутри блока try произошла любая ошибка, откатываем все изменения назад
                System.err.println("Произошла ошибка, выполняем откат (ROLLBACK)...");
                connection.rollback();
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.err.println("Не удалось установить соединение с базой данных.");
            e.printStackTrace();
        }
    }
}

