package ru.qa.browsers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;



/**
 * @author Slava Solodov
 * @created 09/03/2023 - 11:45
 * @email vsolodov@cbgr.ru
 */

public class FireFox {
    /**
     * Возвращает экземпляр вебдрайвера для запуска FireFox
     */
    public static RemoteWebDriver getDriver() {
        // Установка состояния браузера
        var options = new FirefoxOptions();

        // Включение headless-режима
        options.addArguments("--headless");

        // Другие настройки
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--private"); // Режим инкогнито
        options.addArguments("--no-sandbox");
        options.addArguments("--width=1920");
        options.addArguments("--height=1080");

        // Настройка стратегии загрузки страницы
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NORMAL);

//        browserOptions = options.toString();

        // Создание экземпляра драйвера
        return new FirefoxDriver(options);
    }
}