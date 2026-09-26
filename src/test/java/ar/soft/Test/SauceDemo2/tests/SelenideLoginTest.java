package ar.soft.Test.SauceDemo2.tests;

import ar.soft.Test.SauceDemo2.baseTest.SelenideBaseTest;
import ar.soft.Test.SauceDemo2.pages.SelenideLoginPage;
import org.junit.jupiter.api.Test;

public class SelenideLoginTest extends SelenideBaseTest {

    @Test
    public void testSuccessfulLoginRedirect() {
        loginAsStandardUser();

        SelenideLoginPage loginPage = new SelenideLoginPage();
        loginPage.verifySuccessfulLogin();
    }
}
