package ar.soft.AT.UI.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigReader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("arSelenide.properties")) {
            if (input == null) {
                throw new RuntimeException("Не удалось найти файл arSelenide.properties в папке ресурсов!");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла arSelenide.properties", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}



