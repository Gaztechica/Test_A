package ar.soft.Test.sauceDemoSelenide.baseTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import sauceDemoSelenide.steps.SauceDemoSteps;
import sauceDemoSelenide.utils.ConfigReader;

public class SelenideBaseTest {
    @BeforeAll
    public static void globalSetup() {
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
        Configuration.holdBrowserOpen = true; // для отладки
    }

    @BeforeEach
    public void setUpLogin() {
        open(ConfigReader.get("saucedemo.url"));

        SauceDemoSteps steps = new SauceDemoSteps();
        steps.login(
                ConfigReader.get("saucedemo.username"),
                ConfigReader.get("saucedemo.password")
        );
    }
}
