package ar.soft.modelPage.base;

import ar.soft.modelPage.*;
import ar.soft.modelPage.ProjectSettingsPage.ChecklistsSidebarPage;
import ar.soft.modelPage.ProjectSettingsPage.SettingsSidebarPage;
import ar.soft.modelPage.ProjectSettingsPage.TypesWorkSidebarPage;
import jdk.jfr.Name;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;
import static ar.soft.runner.BaseTest.*;

public class BasePage extends BaseModel {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Name("открыть проект-11AAНовый проект")
//    @FindBy(xpath = "//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'1Новый проект')]")
    @FindBy(xpath = "//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'11AAНовый проект')]")
    private WebElement project;

    @Name("открыть Замечания")
    @FindBy(xpath = "//span[@class='ant-menu-title-content'][contains(.,'Замечания')]")
    private WebElement remark;

    @Name("открыть проект-1Новый проект")
    public BasePage project() {
        project.click();

        return this;
    }

    @Name("открыть Замечания")
    public RemarkSidebarPage remarkSidebarClick() {
        remark.click();

        return new RemarkSidebarPage(getDriver());
    }

    /**
     * поменял из-за пароля
     */

//    @Name("Электронная почта")
//    public BasePage inputMail(String mail) {
////    public BasePage inputMail() {
//        getDriver().findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']")).sendKeys(mail);
//
////        return new AutorisaitionPege(getDriver());
//        return this;
//    }

    @Name("Электронная почта")
    public AuthorizationPege inputMail(String mail) {
//    public BasePage inputMail() {
        getDriver().findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']")).sendKeys(mail);

//        return new AutorisaitionPege(getDriver());
        return new AuthorizationPege(getDriver());
    }

    @Name("иконка ARMobile")
    public BasePage iconRegistrationClick() {
        getDriver().findElement(By.xpath("//div[@class='AuthLayout__preview-logoBlock']")).click();

        return this;
    }

    @Name("Нажать ссылку “Загрузите в appstore”")
    public BasePage appstoreClick() {
        getDriver().findElement(By.xpath("(//div[@class='DownloadAppLink__content'])[3]")).click();

        return this;
    }

    @Name("Нажать ссылку “Загрузите на Google Play”")
    public BasePage googlePlayClick() {
        getDriver().findElement(By.xpath("(//div[@class='DownloadAppLink__content'])[4]")).click();

        return this;
    }

    @Name("Пароль")
    public AuthorizationPege inputPassword(String password) {
//    public AuthorizationPege inputPassword() {
        getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys(password);

        return new AuthorizationPege(getDriver());
    }



    @Name("открыть Инспекции")
    public InspectSidebarPage inspectSidebarClick() {
        getDriver().findElement(By.xpath("//span[@class='ant-menu-title-content'][contains(.,'Инспекции')]")).click();

        return new InspectSidebarPage(getDriver());
    }

    @Name("открыть Чек-листы")
    public ChecklistsSidebarPage сhecklistsClick() {
        getDriver().findElement(By.xpath("//*[@class='ant-tabs-tab-btn'][contains(.,'Чек-листы')]")).click();

        return new ChecklistsSidebarPage(getDriver());
    }

    @Name("открыть Виды работ")
    public TypesWorkSidebarPage typesWorkSidebarClick() {
        getDriver().findElement(By.xpath("//div[@class='ant-tabs-tab'][contains(.,'Виды работ')]")).click();

        return new TypesWorkSidebarPage(getDriver());
    }

    @Name("открыть Виды работ в библиотеке")
    public TypesWorkLibraryPage typesWorkLibraryClick() {
//        ActionT.OneClick.click("//*[@role='tab'][contains(.,'Виды работ')]");
        getDriver().findElement(By.xpath("//*[@role='tab'][contains(.,'Виды работ')]")).click();

        return new TypesWorkLibraryPage(getDriver());
    }

    @Name("открыть Виды библиотеку")
    public LibraryPage libraryClick() {
        getDriver().findElement(By.xpath("//span[@class='ant-menu-title-content'][contains(.,'Библиотека')]")).click();

        return new LibraryPage(getDriver());

    }

    @Name("открыть Пользователи")
    public UserSidebarPage userSidebarClick() {
        getDriver().findElement(By.xpath("//span[@class='ant-menu-title-content'][contains(.,'Пользователи')]")).click();

        return new UserSidebarPage(getDriver());
    }

    @Name("открыть Дашборды")
    public BasePage dashboardsSidebarClick() {
        getDriver().findElement(By.xpath("//a[@style='color: inherit;'][contains(.,'Дашборды')]")).click();

        return this;
    }

    @Name("открыть Настройки")
    public SettingsSidebarPage settingsSidebarClick() throws InterruptedException {
        Thread.sleep(200);
        getDriver().findElement(By.xpath("//a[@style='color: inherit;'][contains(.,'Настройки')] | //a[@style='color: inherit;']//*[contains(.,'Настройки')]")).click();

        return new SettingsSidebarPage(getDriver());
    }

    @Name("название Проекта - в сайтбаре")
    public ProjectPage sidebarProject() {
        getDriver().findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_m']"));

        return new ProjectPage(getDriver());
    }

    @Name("троеточие Проекта")
    public ProjectPage ellipsisProject() {
        getDriver().findElement(By.xpath("//*[@class='ant-table-row ant-table-row-level-0'][contains(.,'11AAНовый проект')]//*[@class='Checklists__info-iconBlock']")).click();

        return new ProjectPage(getDriver());
    }


    @Name("Пользователь не найден, попробуйте снова")
    public String getRegistrationText() {
        return getDriver().findElement(By.xpath("//h3[@class='ant-typography h3_sb Login__title-text']")).getText();
    }

    @Name("Попробуйте бесплатно в течении 7 дней")
    public String trialText() {
        return getDriver().findElement(By.xpath("//h2[@class='ant-typography h2_m Registration__title-subtitleText']")).getText();
    }


//    protected WebDriver getDriver() {
//        return driver;
//    }

//    @FindBy(xpath = "http://23.105.246.172:5000/login")
//    private WebElement URL_Amr;
//
//    @FindBy(xpath = "//input[@class='ant-input']")
//    private WebElement INPUT_EMAIL;
//
//    @FindBy(xpath = "//input[@class='ant-input']")
//    private WebElement INPUT_PASSWORD;
//
//    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default authButton big colorPrimary ']")
//    private WebElement BTN_PASSWORD;
//    public static final String EMAIL = "n@list.ru";
//    public static final String PASSWORD = "    ";

//    public void goHome() {
//        getDriver().findElement(By.xpath("//img[@scr='http://23.105.246.172:5000/ac5efbd8-e0c6-4eae-acb2-85d8ac88a3e5']"));
//
//    }




    public BasePage login()throws InterruptedException {
//        URL.click();
//        INPUT_EMAIL.sendKeys(EMAIL);
//        INPUT_PASSWORD.sendKeys(PASSWORD);
//        BTN_PASSWORD.click();
        getDriver().get(URL);
        getDriver().manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        getDriver().manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        getDriver().manage().window().setSize(new Dimension(1920,1080));
        getDriver().findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        getDriver().findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        getDriver().findElement(By.xpath(BTN_PASSWORD)).click();

        return this;
    }

//    @AfterMethod
//    public void into() {
//        getDriver().quit();
//    }


}
