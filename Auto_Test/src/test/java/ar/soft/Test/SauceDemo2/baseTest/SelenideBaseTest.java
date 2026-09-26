package ar.soft.Test.SauceDemo2.baseTest;

import ar.soft.Test.SauceDemo2.pages.SelenideLoginPage;
import ar.soft.Test.SauceDemo2.utils.ConfigReader;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class SelenideBaseTest {

    private static final String URL = "https://saucedemo.com";

    @BeforeAll
    public static void globalSetup() {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true; // для отладки
    }

    /**
     * Общий метод авторизации для тестов Selenide
     */
    protected void loginAsStandardUser() {
        open(URL);
        SelenideLoginPage loginPage = new SelenideLoginPage();
        String user = ConfigReader.get("saucedemo.username");
        String pass = ConfigReader.get("saucedemo.password");

        loginPage.login(user, pass);
    }
}
