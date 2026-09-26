package ru.qa.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qa.elements.Button;
import ru.qa.elements.CheckBox;
import ru.qa.elements.Other;
import ru.qa.elements.TextBox;
import ru.qa.methods.ActionT;
import ru.qa.methods.WaitT;
import ru.qa.service.TurboNavigation;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

import static ru.qa.driver.WebDriverSetup.getDriverInstance;


public class LoginPage {

    @Name("ЛОГИН")
    //@FindBy(xpath = "//*[@data-testid='user']")
    @FindBy(xpath = "//*[@name='username']")
    TextBox loginUser;

    @Name("Роль")
    @FindBy(xpath = "//*[@name='rolename']")
    TextBox loginRole;

    @Name("Роль из выпадающего списка - Полный доступ")
    @FindBy(xpath = "//li//*[text()='Полный доступ']")
    Other roleFullAccessFromDropDownList;

    @Name("ВХОД")
    //@FindBy(xpath = "//*[@data-testid='button_caption']")
    @FindBy(xpath = "//*[@class='text button primarybutton button-login']")
    Button loginButton;

    @Name("Отключить пользователя и продолжить")
    //@FindBy(xpath = "//input[@class='checkbox__control']")
    @FindBy(xpath = "//input[@id='Disconnect']")
    CheckBox checkBoxLogin;

    String loginButtonLocator = "//*[@data-testid='button_caption']";
    String OkButton = "//span[contains(@data-testid,'button_caption') and contains(text(),'Готово')]";


    public LoginPage() {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(getDriverInstance())), this);
    }

    public LoginPage clickToLoginInAuthPage(String LOGIN) {
        var loginPage = new LoginPage();

        loginPage.loginUser.clickElement().enterTextFromTextBox(LOGIN);
        loginPage.loginButton.clickElement();

        while (TurboNavigation.isMaskClickable()) {}

        if(TurboNavigation.isElementPresent(By.xpath(OkButton))) {
            ActionT.OneClick.click(OkButton);
        }
        WaitT.littleWait(1000);

        //loginPage.loginRole.clickElement().enterTextFromTextBox("Полный доступ");
        loginPage.loginRole.clickElement();
        loginPage.roleFullAccessFromDropDownList.clickElement();
        loginPage.loginButton.clickElement();
        WaitT.littleWait(1000);

        if (isElementFoundDisplayedEnabled(By.xpath("//*[contains(text(),'Отключить пользователя и продолжить')]"))) {
            loginPage.checkBoxLogin.enableCheckBox();
            loginPage.loginButton.clickElement();
            while (TurboNavigation.isMaskClickable()) {}
        }
        WaitT.littleWait(1000);
        if(TurboNavigation.isElementPresent(By.xpath(OkButton))) {
            ActionT.OneClick.click(OkButton);
        }
        WaitT.littleWait(1000);
        return new LoginPage();
    }

    public LoginPage clickToLoginInAuthPageNoRole(String LOGIN) {
        var loginPage = new LoginPage();

        loginPage.loginUser.clickElement().enterTextFromTextBox(LOGIN);
        loginPage.loginButton.clickElement();

        while (TurboNavigation.isMaskClickable()) {}

        if(TurboNavigation.isElementPresent(By.xpath(OkButton))) {
            ActionT.OneClick.click(OkButton);
        }
        WaitT.littleWait(1000);

        //loginPage.loginRole.clickElement().enterTextFromTextBox("Полный доступ");
//        loginPage.loginRole.clickElement();
//        loginPage.roleFullAccessFromDropDownList.clickElement();
//        loginPage.loginButton.clickElement();
//        WaitT.littleWait(1000);

        if (isElementFoundDisplayedEnabled(By.xpath("//*[contains(text(),'Отключить пользователя и продолжить')]"))) {
            loginPage.checkBoxLogin.enableCheckBox();
            loginPage.loginButton.clickElement();
            while (TurboNavigation.isMaskClickable()) {}
        }
        WaitT.littleWait(1000);
        if(TurboNavigation.isElementPresent(By.xpath(OkButton))) {
            ActionT.OneClick.click(OkButton);
        }
        WaitT.littleWait(1000);
        return new LoginPage();
    }

    /** Если элемент отображается и чекбокс не нажат, вернуть true, иначе false */
    private static boolean isElementFoundDisplayedEnabled(By by) {
        try {
            List<WebElement> e = getDriverInstance().findElements(by);
            return !e.isEmpty() && e.get(e.size() - 1).isDisplayed() && e.get(e.size() - 1).isEnabled();
        } catch (Exception ignored) {}
        return false;
    }
}
