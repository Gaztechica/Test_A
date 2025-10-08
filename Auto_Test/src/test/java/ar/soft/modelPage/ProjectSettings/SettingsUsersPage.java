package ar.soft.modelPage.ProjectSettings;

import ar.soft.modelPage.TypesWorkLibraryPage;
import ar.soft.modelPage.base.BasePage;
import jdk.jfr.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import static ar.soft.TypesWorkSidebarTest.NAME_TYPES_WORK;

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

    @Name("Пользователь отображается в проекте")
    @FindBy(xpath = "//*[@class='ant-table-cell'][contains(.,'Администраторов')]")
    public WebElement newUsersCheck;

    @Name("Пользователь отображается в проекте")
    @FindBy(xpath = "//*[@class='ant-table-row ant-table-row-level-0']//*[@data-testid='Text'][contains(.,'наблюдатель')]" + "//*[@class='ContentProjectUsers__iconBlock']")
    public WebElement newUsersCheck2;



}
