package ru.qa.browsers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author Slava Solodov
 * @created 09/03/2023 - 11:43
 * @email vsolodov@cbgr.ru
 */

public class Chrome {

    /** Возвращает экземпляр вебдрайвера для запуска Google Chrome */
    public static RemoteWebDriver getDriver() {

        // инициализация нужной версии вебдрайвера в зависимости от установленной версии браузера
        //WebDriverManager.chromedriver().setup();

        // установка состояния браузера
        var options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
//        options.addArguments("--incognito");
        options.addArguments("--ignore-ssl-errors");
        options.addArguments("--no-sandbox");
//        options.addArguments("--window-size=1920,1080");
//        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        //options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NORMAL);

        var capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("screenResolution", "1920x1080x24");
        capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        return new ChromeDriver(options);
    }
}
