package ar.soft.AT.UI.tests.baseTest;

import ar.soft.AT.UI.config.ConfigReader;
import ar.soft.AT.UI.steps.authSteps.AuthSteps;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class SelenideBaseTest {
    // Если используете TestNG, импортируйте org.testng.annotations.BeforeMethod
// Если используете JUnit 5, импортируйте org.junit.jupiter.api.BeforeEach

    @BeforeAll // или @BeforeClass для TestNG (ваш текущий метод настройки браузера)
    public static void globalSetup() {
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
        Configuration.holdBrowserOpen = true;
    }

    // НОВЫЙ МЕТОД: будет запускаться строго ПЕРЕД КАЖДЫМ @Test
    @BeforeEach
    public void setUpLogin() {
        open(ConfigReader.get("arSelenide.url"));

        AuthSteps steps = new AuthSteps();
        steps.login(
                ConfigReader.get("arSelenide.email"),
                ConfigReader.get("arSelenide.password")
        );
    }
}
