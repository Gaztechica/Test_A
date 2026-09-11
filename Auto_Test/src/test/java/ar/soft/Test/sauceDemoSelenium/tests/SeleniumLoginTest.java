package ar.soft.Test.sauceDemoSelenium.tests;

import org.junit.jupiter.api.Test;
import sauceDemoSelenium.baseTest.SeleniumBaseTest;
import sauceDemoSelenium.steps.SauceDemoSteps;

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

