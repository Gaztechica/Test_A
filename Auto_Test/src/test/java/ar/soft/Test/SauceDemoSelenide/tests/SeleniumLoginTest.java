package ar.soft.Test.SauceDemoSelenide.tests;

import ar.soft.Test.SauceDemoSelenide.baseTest.SeleniumBaseTest;
import ar.soft.Test.SauceDemoSelenide.pages.SeleniumLoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumLoginTest extends SeleniumBaseTest {

    @Test
    public void testSuccessfulLoginRedirect() {
        loginAsStandardUser();

        SeleniumLoginPage loginPage = new SeleniumLoginPage(driver);
        assertTrue(loginPage.isProductsTitleDisplayed());
        assertTrue(loginPage.getCurrentUrl().contains("/inventory.html"));
    }
}
