package ar.soft.Test.sauceDemoSelenium.steps;

import ar.soft.Test.sauceDemo.utils.ConfigReader;
import ar.soft.Test.sauceDemoSelenium.pages.SeleniumLoginPage;
import org.openqa.selenium.WebDriver;

public class SauceDemoSteps {
    private final WebDriver driver;
    private final SeleniumLoginPage loginPage;

    public SauceDemoSteps(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new SeleniumLoginPage(driver);
    }

    public void openLoginPage() {
        driver.get(ConfigReader.get("saucedemo.url"));
    }

    public void loginAsStandardUser() {
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

