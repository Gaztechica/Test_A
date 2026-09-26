package ar.soft.Test.sauceDemo.steps;

import ar.soft.Test.sauceDemo.pages.SeleniumLoginPage;
import ar.soft.Test.sauceDemo.utils.ConfigReader;
import org.openqa.selenium.WebDriver;

public class SauceDemoSteps {
    private final WebDriver driver;
    private final SeleniumLoginPage loginPage;

    public SauceDemoSteps(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new SeleniumLoginPage(driver);
    }

    public void openLoginPage() {
        // Динамическое чтение URL из конфига
        driver.get(ConfigReader.get("saucedemo.url"));
    }

    public void loginAsStandardUser() {
        // Динамическое чтение кредов из конфига и инкапсулированный ввод
        loginPage.enterUsername(ConfigReader.get("saucedemo.username"));
        loginPage.enterPassword(ConfigReader.get("saucedemo.password"));
        loginPage.clickLoginButton();
    }

    public boolean isUserOnCatalogPage() {
        return loginPage.isProductsTitleDisplayed();
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }
}

