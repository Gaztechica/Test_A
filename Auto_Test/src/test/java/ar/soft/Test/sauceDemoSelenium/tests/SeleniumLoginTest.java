package ar.soft.Test.sauceDemoSelenium.tests;

import ar.soft.Test.sauceDemo.steps.SauceDemoSteps;
import ar.soft.Test.sauceDemoSelenium.baseTest.SeleniumBaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumLoginTest extends SeleniumBaseTest {

    @Test
    public void testSuccessfulLoginRedirect() {
        SauceDemoSteps steps = new SauceDemoSteps(driver);

        steps.openLoginPage();
        steps.loginAsStandardUser();

        assertTrue(steps.isUserOnCatalogPage(), "Пользователь не перенаправлен на страницу каталога товаров!");
        assertTrue(steps.getCurrentPageUrl().contains("/inventory.html"), "URL страницы не соответствует ожидаемому каталогу!");
    }
}

