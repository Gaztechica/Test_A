package ar.soft.Test.SauceDemoSelenide.baseTest;

import ar.soft.Test.SauceDemoSelenide.pages.SeleniumLoginPage;
import ar.soft.Test.SauceDemoSelenide.utils.ConfigReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBaseTest {
    protected WebDriver driver;
    private static final String URL = "https://saucedemo.com";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * Общий метод авторизации для всех наследников
     */
    protected void loginAsStandardUser() {
        driver.get(URL);
        SeleniumLoginPage loginPage = new SeleniumLoginPage(driver);
        String user = ConfigReader.get("saucedemo.username");
        String pass = ConfigReader.get("saucedemo.password");

        loginPage.login(user, pass);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

