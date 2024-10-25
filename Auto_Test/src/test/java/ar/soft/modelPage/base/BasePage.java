package ar.soft.modelPage.base;

import ar.soft.modelPage.*;
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

    @Name("открыть Инспекции")
    public InspectSidebarPage inspectSidebarClick() {
        getDriver().findElement(By.xpath("//span[@class='ant-menu-title-content'][contains(.,'Инспекции')]")).click();

        return new InspectSidebarPage(getDriver());
    }

    @Name("открыть Виды работ")
    public TypesWorkSidebarPage typesWorkSidebarClick() {
        getDriver().findElement(By.xpath("//span[@class='ant-menu-title-content'][contains(.,'Виды работ')]")).click();

        return new TypesWorkSidebarPage(getDriver());
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
    public SettingsSidebarPage settingsSidebarClick() {
        getDriver().findElement(By.xpath("//a[@style='color: inherit;'][contains(.,'Настройки')]")).click();

        return new SettingsSidebarPage(getDriver());
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
