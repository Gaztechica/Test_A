package ar.soft.Test.Postgres;

import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseMain {

        private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
        private static final String USER = "postgres";
        private static final String PASSWORD = "Postgres";

//    protected static final String URL = "jdbc:postgresql://localhost:5432/postgres";
//    protected static final String USER = "postgres";
//    protected static final String PASSWORD = "Postgres";

        public static void main(String[] args) {
            // Открываем одно общее соединение в блоке try-with-resources
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

                // 1. Вызываем первый класс (создание и наполнение)
                DatabaseInitializer.initialize(connection);

                // 2. Создаем второй класс для чтения данных
                DataUserOrderDao reportDao = new DataUserOrderDao(connection);

                // 3. Вызываем метод чтения
                reportDao.printUsersWithOrders();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


}
