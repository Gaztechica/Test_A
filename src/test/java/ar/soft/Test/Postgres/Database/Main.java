package ar.soft.Test.Postgres.Database;

import ar.soft.Test.Postgres.PostgresUser.DatabaseInitializer;
import ar.soft.Test.Postgres.PostgresUser.Order;
import ar.soft.Test.Postgres.PostgresUser.User;
import ar.soft.Test.Postgres.PostgresUser.UserOrderDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5432/your_database_name";
    private static final String USER = "postgres";
    private static final String PASSWORD = "your_password";


        public static void main(String[] args) {
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

                // Инициализируем базу данных
                DatabaseInitializer.initialize(connection);

                // Получаем список объектов из DAO
                ar.soft.Test.Postgres.PostgresUser.UserOrderDao reportDao = new UserOrderDao(connection);
                List<ar.soft.Test.Postgres.PostgresUser.User> users = reportDao.getAllUsersWithOrders();

                // Пример работы "Бизнес-логики" с полученными объектами:
                System.out.println("\n=== ОБРАБОТКА ДАННЫХ В БИЗНЕС-ЛОГИКЕ ===");
                for (User user : users) {
                    System.out.println("Клиент: " + user.name() + " (" + user.email() + ")");

                    if (user.orders().isEmpty()) {
                        System.out.println("  -> Еще не совершал заказов.");
                    } else {
                        System.out.println("  -> Список заказов:");
                        for (Order order : user.orders()) {
                            System.out.printf("     [Заказ №%d] Сумма: %.2f руб. Статус: %s\n",
                                    order.id(), order.amount(), order.status());
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


