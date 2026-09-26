package ar.soft.AT.UI.steps;


import ar.soft.Test.sauceDemo.SauceDemoSelenide.pages.CartPage;
import ar.soft.Test.sauceDemo.SauceDemoSelenide.pages.CheckoutPage;
import ar.soft.Test.sauceDemo.SauceDemoSelenide.pages.ProductsPage;
import ar.soft.Test.sauceDemo.SauceDemoSelenide.pages.SelenideLoginPage;

public class SauceDemoSteps {
    private final SelenideLoginPage loginPage = new SelenideLoginPage();
    private final ProductsPage productsPage = new ProductsPage();
    private final CartPage cartPage = new CartPage();
    private final CheckoutPage checkoutPage = new CheckoutPage();



    public void addTwoItemsToCartAndGoToCart() {
        productsPage.addBackpackToCart();
        productsPage.addBikeLightToCart();
        productsPage.clickCart();
    }

    public void proceedToCheckout() {
        cartPage.clickCheckout();
    }

    public void fillCheckoutDataAndFinish(String firstName, String lastName, String zip) {
        checkoutPage.enterFirstName(firstName);
        checkoutPage.enterLastName(lastName);
        checkoutPage.enterPostalCode(zip);
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();
    }
}
