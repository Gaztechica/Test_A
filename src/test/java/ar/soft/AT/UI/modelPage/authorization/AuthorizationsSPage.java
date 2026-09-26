package ar.soft.AT.UI.modelPage.authorization;

import ar.soft.AT.UI.config.ConfigReader;
import ar.soft.AT.UI.modelPage.HomePage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationsSPage {

    private final SelenideElement usernameField = $("[data-test-id='login-page-mail-input']");
    private final SelenideElement passwordField = $("[type='password']");
    private final SelenideElement loginButton = $("button[type='submit']");
    private final SelenideElement btnCheckbox = $("[id='CheckboxComponent-check']"); // или просто $("#CheckboxComponent-check")

    // Статический метод открытия страницы
    @Step("Открыть страницу авторизации")
    public static AuthorizationsSPage openPage() {
        open(ConfigReader.get("arSelenide.url"));
        return new AuthorizationsSPage();
    }

//     Методы шагов пишем с аннотациями @Step и возвращаем 'this' для Fluent API цепочек
    @Step("Выполнить вход в систему с логином: '{username}'")
    public HomePage login(String username, String password) {
        usernameField.setValue(username);
        passwordField.setValue(password);
        btnCheckbox.click();
        loginButton.click();

        // Возвращаем объект СЛЕДУЮЩЕЙ страницы, на которую попадет юзер
        return new HomePage();
    }
}


