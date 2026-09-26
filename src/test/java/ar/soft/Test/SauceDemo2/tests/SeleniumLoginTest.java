package ar.soft.Test.SauceDemo2.tests;

import ar.soft.Test.SauceDemo2.baseTest.SeleniumBaseTest;
import ar.soft.Test.SauceDemo2.pages.SeleniumLoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class SeleniumLoginTest extends SeleniumBaseTest {

    @Test
    public void testSuccessfulLoginRedirect() {
        loginAsStandardUser();

        SeleniumLoginPage loginPage = new SeleniumLoginPage(driver);
        assertTrue(loginPage.isProductsTitleDisplayed());
        assertTrue(loginPage.getCurrentUrl().contains("/inventory.html"));
    }
}
