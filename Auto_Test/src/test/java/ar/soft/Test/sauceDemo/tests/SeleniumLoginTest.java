package ar.soft.Test.sauceDemo.tests;

import ar.soft.Test.sauceDemo.baseTest.SeleniumBaseTest;
import ar.soft.Test.sauceDemo.steps.SauceDemoSteps;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class SeleniumLoginTest extends SeleniumBaseTest {

    @Test
    public void testSuccessfulLoginRedirect() {
        // Оркестрация через Steps
        SauceDemoSteps steps = new SauceDemoSteps(driver);

        steps.openLoginPage();
        steps.loginAsStandardUser();

        // Бизнес-ассерты (проверки возвращают простые boolean/String типы)
        assertTrue(steps.isUserOnCatalogPage(), "Пользователь не перенаправлен на страницу каталога товаров!");
        assertTrue(steps.getCurrentPageUrl().contains("/inventory.html"), "URL страницы не соответствует ожидаемому каталогу!");
    }
}

