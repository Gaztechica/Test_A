package ar.soft.Test.Postgres;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initialize(Connection connection) throws Exception {
        System.out.println("Выполняется инициализация структуры БД...");

        // Отключаем автокоммит для атомарности создания структуры
        connection.setAutoCommit(false);

        try (Statement statement = connection.createStatement()) {
            // 1. Сброс таблиц
            statement.executeUpdate("DROP TABLE IF EXISTS public.orders CASCADE");
            statement.executeUpdate("DROP TABLE IF EXISTS public.users CASCADE");

            // 2. Создание таблицы пользователей
            statement.executeUpdate("""
                CREATE TABLE public.users (
                    id SERIAL PRIMARY KEY,                         
                    names VARCHAR(100) NOT NULL,                    
                    email VARCHAR(150) UNIQUE NOT NULL,            
                    status VARCHAR(20) DEFAULT 'active',           
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
                )
            """);

            // 3. Создание таблицы заказов
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

            // 4. Наполнение тестовыми данными
            statement.executeUpdate("""
                INSERT INTO public.users (names, email, status, created_at) VALUES
                ('Алексей Иванов', 'alex@example.com', 'active', NOW() - INTERVAL '10 days'),
                ('Мария Петрова', 'maria@example.com', 'active', NOW() - INTERVAL '5 days'),
                ('Иван Сидоров', 'ivan@example.com', 'suspended', NOW() - INTERVAL '1 day')
            """);

            statement.executeUpdate("""
                INSERT INTO public.orders (user_id, amount, status, created_at) VALUES
                (1, 1500.00, 'paid', NOW() - INTERVAL '9 days'),
                (2, 3200.00, 'pending', NOW() - INTERVAL '3 days')
            """);

            connection.commit(); // Фиксируем изменения
            System.out.println("Инициализация успешно завершена!");

        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true); // Возвращаем в дефолтное состояние
        }
    }
}


