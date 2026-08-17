package ar.soft.modelPage.ProjectSettingsPage;

import ar.soft.modelPage.base.BasePage;
import jdk.jfr.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static ar.soft.AT.UI.ProjectSettingsTest.SettingsUsersTest.NAME_USER;

public class SettingsUsersPage extends BasePage {

    public SettingsUsersPage(WebDriver driver) {
        super(driver);
    }

    @Name("Настройка проекта пользователи")
    @FindBy(xpath = "//div[@class='ant-tabs-tab'][contains(.,'Пользователи')]")
    public WebElement usersClick;



    @Name("Настройка проекта пользователи")
    @FindBy(xpath = "//a[@style='color: inherit;'][contains(.,'Настройки')] | //a[@style='color: inherit;']//*[contains(.,'Настройки')]")
    public WebElement settingsSidebarClick;

    @Name("кнопка добавить пользователя")
    @FindBy(xpath = "//*[@data-test-id='button'][contains(.,'Добавить')]")
    public WebElement addButtonClick;

    @Name("поиск пользователя")
    @FindBy(xpath = "//*[@placeholder='Найти пользователя']")
    public WebElement searchUsersClick;

    @Name("чек бокс выбора пользователя")
    @FindBy(xpath = "(//*[@class='CheckboxComponent__square-check'])[6]")
    public WebElement checkUsersClick;

    @Name("чек бокс выбора пользователя")
    @FindBy(xpath = "(//*[@class='CheckboxComponent__square-check'])[7]")
    public WebElement checkUserClick;

    @Name("кнопка добавить")
    @FindBy(xpath = "(//*[@data-test-id='button'][contains(.,'Добавить')])[2]")
    public WebElement btnButtonClick;

    @Name("кнопка Удалить из проекта")
    @FindBy(xpath = "//*[@data-test-id='project-users-content-modal-3-button'][contains(., 'Удалить из проекта')]")
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
