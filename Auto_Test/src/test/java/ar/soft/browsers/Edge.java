package ar.soft.browsers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Edge {

    /**
     * Возвращает экземпляр вебдрайвера для запуска Microsoft Edge
     */
    public static RemoteWebDriver getDriver() {

        // установка состояния браузера
        var options = new EdgeOptions();
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NORMAL);

        // установка аргументов запуска
        options.addArguments("--incognito");

        var capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "edge");
        capabilities.setCapability("screenResolution", "1920x1080x24");
        capabilities.setCapability(EdgeOptions.CAPABILITY, options);

        return new EdgeDriver(options);
    }
}

