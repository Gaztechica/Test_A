package ar.soft.browsers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Chrome {

    /** Возвращает экземпляр вебдрайвера для запуска Google Chrome */
    public static RemoteWebDriver getDriver() {

        // инициализация нужной версии вебдрайвера в зависимости от установленной версии браузера
        //WebDriverManager.chromedriver().setup();

        // установка состояния браузера
        var options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        options.addArguments("--incognito");
        options.addArguments("--ignore-ssl-errors");
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NORMAL);

        // установка аргументов запуска
        //options.addArguments("--headless");
        //options.addArguments("--disable-dev-shm-usage");

        var capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("screenResolution", "1920x1080x24");
        capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        return new ChromeDriver();
    }
}
