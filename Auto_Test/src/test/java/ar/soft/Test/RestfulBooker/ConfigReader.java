package ar.soft.Test.RestfulBooker;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Не удалось найти файл config.properties в папке resources");
            }
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Ошибка при чтении файла конфигурации", ex);
        }
    }

    // Ваш универсальный метод остается на месте
    public static String get(String key) {
        return properties.getProperty(key);
    }

    // --- НОВЫЕ УДОБНЫЕ МЕТОДЫ ДЛЯ ВАШИХ ПАРАМЕТРОВ ---

    public static String getBaseUri() {
        return get("base.uri");
    }

    public static String getUsername() {
        return get("auth.username");
    }

    public static String getPassword() {
        return get("auth.password");
    }
}


