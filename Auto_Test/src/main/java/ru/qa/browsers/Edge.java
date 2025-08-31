package ru.qa.browsers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



/**
 * @author Slava Solodov
 * @created 09/03/2023 - 13:48
 * @email vsolodov@cbgr.ru
 */

public class Edge {

    /**
     * Возвращает экземпляр вебдрайвера для запуска Microsoft Edge
     */
    public static RemoteWebDriver getDriver() {

        // установка состояния браузера
        var options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*", "--ignore-certificate-errors");
        options.addArguments("--inprivate"); // Режим инкогнито
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless=new"); // Для запуска в headless-режиме
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NORMAL);

        var capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "MicrosoftEdge");
        capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        capabilities.setCapability(EdgeOptions.CAPABILITY, options);

//        browserOptions = options.toString();

        return new EdgeDriver(options);
    }
}
