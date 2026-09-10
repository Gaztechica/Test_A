package ar.soft.Test.SauceDemoSelenide.baseTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class SelenideBaseTest {
    @BeforeAll
    public static void globalSetup() {
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
        Configuration.holdBrowserOpen = true; // для отладки
    }
}
