package ar.soft.AT.UI.modelPage.authorization;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AuthorizationSPage {

    private final SelenideElement usernameField = $(By.xpath("//input[@data-test-id='login-page-mail-input']"));
    private final SelenideElement passwordField = $(By.xpath("//input[@type='password']"));
    private final SelenideElement loginButton = $(By.xpath("//button[@type='submit']"));
    private final SelenideElement btnCheckbox = $(By.xpath("//*[@id='CheckboxComponent-check']"));

    public void enterUsername(String username) { usernameField.setValue(username); }
    public void enterPassword(String password) { passwordField.setValue(password); }
    public void clickLogin() { loginButton.click(); }
    public void clickBtnCheckbox() { btnCheckbox.click(); }
}
