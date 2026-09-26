package ar.soft.Test.RestfulBooker2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();

    static {
        // Загружаем файл из папки ресурсов (класспаса)
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Не удалось найти файл config.properties в папке resources");
            }
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Ошибка при чтении файла конфигурации", ex);
        }
    }

    // Метод для получения значения по ключу
    public static String get(String key) {
        return properties.getProperty(key);
    }
}

