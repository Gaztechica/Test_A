package ar.soft.Test.SauceDemo2.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class SelenideLoginPage {

    private final SelenideElement usernameField = $("#user-name");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement loginButton = $("#login-button");
    private final SelenideElement productsTitle = $(".title");

    public void login(String username, String password) {
        usernameField.setValue(username);
        passwordField.setValue(password);
        loginButton.click();
    }

    public void verifySuccessfulLogin() {
        productsTitle.shouldBe(Condition.visible);
        webdriver().shouldHave(urlContaining("/inventory.html"));
    }
}

