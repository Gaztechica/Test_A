package ar.soft.modelPage.ProjectSettingsPage;

import ar.soft.modelPage.base.BasePage;
import jdk.jfr.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static ar.soft.AT.ProjectSettingsTest.SettingsUsersTest.NAME_USER;

public class SettingsUsersPage extends BasePage {

    public SettingsUsersPage(WebDriver driver) {
        super(driver);
    }

    @Name("Настройка проекта пользователи")
    @FindBy(xpath = "//div[@class='ant-tabs-tab'][contains(.,'Пользователи')]")
    public WebElement usersClick;

    @Name("кнопка добавить пользователя")
    @FindBy(xpath = "//*[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(.,'Добавить')]")
    public WebElement addButtonClick;

    @Name("поиск пользователя")
    @FindBy(xpath = "//*[@placeholder='Найти пользователя']")
    public WebElement searchUsersClick;

    @Name("чек бокс выбора пользователя")
    @FindBy(xpath = "(//*[@class='CheckboxComponent__square-check'])[2]")
    public WebElement checkUsersClick;

    @Name("кнопка добавить")
    @FindBy(xpath = "//*[@class='ant-btn ant-btn-primary primaryButton big colorPrimary '][contains(.,'Добавить')]")
    public WebElement btnButtonClick;

    @Name("кнопка Удалить из проекта")
    @FindBy(xpath = "//*[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(., 'Удалить из проекта')]")
    public WebElement btnButtonDeleteClick;

    @Name("Пользователь отображается в проекте")
    @FindBy(xpath = "//*[@class='ant-table-cell'][contains(.,'"+ NAME_USER+"')]")
    public WebElement newUsersCheck;

    @Name("иконка корзины")
    @FindBy(xpath = "//*[@class='ant-table-row ant-table-row-level-0'][contains(., '"+ NAME_USER+"')]//*[@class='ContentProjectUsers__iconBlock']")
    public WebElement newUsersCheck2;

    @Name("message Пользователь успешно удален из проекта")
    @FindBy(xpath = "//*[@class='ant-message-custom-content ant-message-success'][contains(., 'Пользователь успешно удален из проекта')]")
    public WebElement messageCheck;



}
