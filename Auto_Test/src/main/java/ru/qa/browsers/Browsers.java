package ru.qa.browsers;

/**
 * @author Slava Solodov
 * @created 09/03/2023 - 14:01
 * @email vsolodov@cbgr.ru
 */

public enum Browsers {

    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge");

    private final String browserName;

    Browsers(String browserName) {
        this.browserName = browserName;
    }

    /**
     * Получить имя браузера в виде строки
     */
    @Override
    public String toString() {
        return String.valueOf(this.browserName);
    }

    /**
     * Возврат значения константы по строковому значению константы
     */
    public static Browsers fromString(String browserName) {
        if (browserName != null) {
            for (Browsers browser : Browsers.values()) {
                if (browserName.equalsIgnoreCase(browser.browserName)) {
                    return browser;
                }
            }
        }
        return null;
    }

    /**
     * Получить имя браузера
     */
    public String getBrowserName() {
        return this.browserName;
    }
}
