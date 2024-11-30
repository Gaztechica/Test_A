package ar.soft.browsers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FireFox {

    /**
     * Возвращает экземпляр вебдрайвера для запуска FireFox
     */
    public static RemoteWebDriver getDriver() {

        // установка состояния браузера
        var options = new FirefoxOptions();
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NORMAL);

        // установка аргументов запуска
        options.addArguments("-private");

        var capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "firefox");
        capabilities.setCapability("screenResolution", "1920x1080x24");
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        return new FirefoxDriver(options);
    }
}
