package ru.qa.service;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.qa.driver.WebDriverSetup;
import ru.qa.methods.MethodT;
import ru.qa.property.turbo.StandAddress;

import java.nio.charset.StandardCharsets;

import static ru.qa.driver.TestBase.STAND;
import static ru.qa.driver.TestBase.USER;
import static ru.qa.service.AllureEnvironmentWriter.allureEnvironmentWriter;


@SuppressWarnings("UnusedReturnValue")
public class Attachment {
    /** прикрепляет текстовое сообщение в отчет */
    @io.qameta.allure.Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    /** прикрепляет скриншот в отчет */
    @io.qameta.allure.Attachment(value = "{attachName}", type = "image/png")
    public static byte[] attachScreenshot(String attachName) {
        return ((TakesScreenshot) WebDriverSetup.getDriverInstance()).getScreenshotAs(OutputType.BYTES);
    }

    /** прикрепляет исходный код страницы в отчет */
    @io.qameta.allure.Attachment(value = "Page source", type = "text/html")
    public static byte[] attachPageSource() {
        return WebDriverSetup.getDriverInstance().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    /** прикрепляет окружение в отчет */
    public static void getAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", WebDriverSetup.getDriverInstance().getCapabilities().getBrowserName().toUpperCase())
                        .put("Version", WebDriverSetup.getDriverInstance().getCapabilities().getBrowserVersion())
                        .put("Stand", STAND.toUpperCase())
                        .put("Stand URL", StandAddress.getStandUrl(STAND))
                        .put("Stand VERSION", MethodT.getElementTextValue(By.xpath("//*[contains(@class,'version')]")))
                        .put("User", USER.toUpperCase())
                        .put("Screen Resolution", WebDriverSetup.getDriverInstance().manage().window().getSize().toString())
                        .build());
    }
}
