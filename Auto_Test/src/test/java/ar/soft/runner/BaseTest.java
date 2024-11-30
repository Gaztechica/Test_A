package ar.soft.runner;

//import arSoft.runner.FilterForTest.FilterForTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//@Liisteners({FilterForTests.class})
public abstract class BaseTest {

//    public void XRBP() {
//        String URL = "http://31.129.103.215:3000/login";
//
//    }
//
//    public void Armw() {
//    final String URL = "http://23.105.246.172:5000/login";
//    }
    public static final String URL = "http://23.105.246.201:5000/login";                 //stage
//    public static final String URL_REGISTRATION = "http://23.105.246.201:5000/registration";                 //stage
//    public static final String URL = "http://23.105.246.172:5000/login";               // test
    public static final String URL_REGISTRATION = "http://23.105.246.172:5000/registration";               // test
//    public static final String URL_XRBP = "http://31.129.103.215:3000/login";

    public static final String INPUT_PASSWORD = "//input[@class='ant-input']";
    public static final String INPUT_EMAIL = "//input[@class='ant-input primaryInput  not-entered']";
    public static final String BTN_PASSWORD = "//button[@class='ant-btn ant-btn-default authButton big colorPrimary ']";
    public static final String EMAIL = "f.ff.1980@list.ru";                          // test
//    public static final String EMAIL = "jartestaw@bk.ru";                          // stage
    public static final String NOT_EMAIL = "";
//    public static final String EMAIL = "akhilgov@spgr.ru";                          // stage
    public static final String PASSWORD = "012345678";                                 // test
    public static final String NOT_PASSWORD = "";
//    public static final String PASSWORD = "qwerty123";                                // stage

    public final static String USER = "//input[@class='ant-input']";
    public static final String CHECKBOX = "//div[@id='CheckboxComponent']";
    private final By GET_POLITIC = By.xpath("//h1[@class='page-header-title clr']");
    private final By LOGO = By.xpath("//div[@class='ant-typography p_m AdminMenu__link']");
    private final By GET_POLITIC_USER = By.xpath("//span[@style='font-size: 19px;'][contains(.,'Предмет пользовательского соглашения')]");
    private final By GET_BOT = By.xpath("//span[@dir='auto']");
    private final By GET_SUPPORT = By.xpath("//h1[@variant='display-3']");

    public WebDriver driver = new ChromeDriver();

    @BeforeMethod
    protected void beforeMethod(Method method) {
//        для пакетного прогона тестов
//       driver = new ChromeDriver();
        getDriver().get(URL);
        getDriver().manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        getDriver().manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        getDriver().manage().window().setSize(new Dimension(1920,1080));
    }

//    public void log() {
//        getDriver().findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
//        getDriver().findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
//        getDriver().findElement(By.xpath(BTN_PASSWORD)).click();
//    }

    @AfterMethod
    protected void afterMethod(Method method) {
        //        для пакетного прогона тестов

//        driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }

    //    private Wait<WebDriver> wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    private WebDriverWait wait2;
    private WebDriverWait wait5;
    private WebDriverWait wait10;

//    public void login() {
//        WebDriverManager.chromedriver().setup();
//        getDriver().get(URL);
//        getDriver().manage().window().setSize(new Dimension(1920,1080));
//
////        Configuration.browserSize = "1920*1080";
//    }
//    private void startDriver() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().getPageLoadTimeout();
//    }
//      static void login() {
//        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
//        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
//        driver.findElement(By.xpath(BTN_PASSWORD)).click();
//    }

    private void closeDriver() {
        if (driver != null) {
            driver.quit();

            driver = null;
            wait2 = null;
            wait5 = null;
            wait10 = null;

            ProjectUtils.log("Browser closed");
        }
    }


    @BeforeMethod
    public void initDriver() {
//        driver = new ChromeDriver();
        getDriver().get(URL);
        getDriver().manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        getDriver().manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        getDriver().manage().window().setSize(new Dimension(1920, 1080));
        getDriver().findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        getDriver().findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        getDriver().findElement(By.xpath(CHECKBOX)).click();
        getDriver().findElement(By.xpath(BTN_PASSWORD)).click();
//        driver.quit();
//         ===================== смена языка ===================
//        driver.findElement(By.xpath("//h2[@class='ant-typography h2_sb']")).click();
//        driver.findElement(By.xpath("//div[@class='ant-typography p_r Profile__item'][contains(.,'Профиль')]")).click();
//        driver.findElement(By.xpath("//input[@id='editedUser_lang']")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//        driver.findElement(By.xpath("//h1[@class='ant-typography h1_sb HeaderMain__link']")).click();
    }
////    protected void beforeMethod(Method method) {
////        driver = new ChromeDriver(ProjectUtils.chromeOptions);
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
////}
//    }


//    @AfterMethod
//    protected void afterMethod(Method method, ITestResult testResult) {
//        driver.quit();
//    }


    protected WebDriverWait getWait2() {
        if (wait2 == null) {
            wait2 = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        }

        return wait2;
    }

    protected WebDriverWait getWait5() {
        if (wait5 == null) {
            wait5 = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        }

        return wait5;
    }

    protected WebDriverWait getWait10() {
        if (wait10 == null) {
            wait10 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        }

        return wait10;

    }


    // ================================== общие тесты =====================================================

//    @Test(priority = 1,
//            description = "клик по лого")
//    public void logoTest() {
//        driver.findElement(By.xpath("//div[@class='Logo__container']")).click();
//        Assert.assertEquals("Проекты", driver.findElement(LOGO).getText());
//    }
//
//    @Test(priority = 2,
//            description = "пагинация")
//    public void poginacyaTest() {
//        driver.findElement(By.xpath("//a[@rel='nofollow'][contains(.,'2')]")).click();
//        driver.findElement(By.xpath("//button[@class='ant-pagination-item-link']/span[@aria-label='left']")).click();
//        driver.findElement(By.xpath("//a[@rel='nofollow'][contains(.,'2')]")).click();
//        driver.findElement(By.xpath("//a[@rel='nofollow'][contains(.,'1')]")).click();
//    }
//
//    @Test(priority = 3,
//            description = "элементов на странице")
//    public void elementPageTest() {
//        driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][@title='10']")).click();
//        driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'50')]")).click();
//        driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][@title='50']")).click();
//        driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'40')]")).click();
//        driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][@title='40']")).click();
//        driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'30')]")).click();
//        driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][@title='30']")).click();
//        driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'20')]")).click();
//        driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][@title='20']")).click();
//        driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'10')]")).click();
//    }
//
//
//    // ================================== ссылки =====================================================
//
//    @Test(priority = 4,
//            description = "Политика обработки персональных данных")
//    public void hrefPolitic() {
//        driver.findElement(By.xpath("//a[@href='https://vr-arsoft.com/personal-data-processing-policy/']")).click();
//
//        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(newTab.get(1));
//
//        Assert.assertEquals("Политика обработки персональных данных", driver.findElement(GET_POLITIC).getText());
//    }

//    @Test(priority = 4,
////            description = "Политика обработки персональных данных")  2 вариант
//    public void testHrefPolitiCopi() {
//
//        getWait15().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://vr-arsoft.com/personal-data-processing-policy/']"))).click();
//        driver.findElement(By.xpath("//a[@href='https://vr-arsoft.com/personal-data-processing-policy/']")).click();
//
//        Set<String> handles = getDriver().getWindowHandles();
//        handles.remove(getDriver().getWindowHandle());
//        getDriver().switchTo().window(handles.iterator().next());
//
//        Assert.assertEquals(getDriver().findElement(GET_POLITIC).getText(), "Политика обработки персональных данных");
//    }


//    @Test(priority = 5,
//            description = "Предмет пользовательского соглашения")
//    public void hrefPoliticUser() {
//        driver.findElement(By.xpath("//a[@href='https://vr-arsoft.com/user-agreement-armobail/']")).click();
//
//        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(newTab.get(1));
//
//        String getPoliticaUser = driver.findElement(GET_POLITIC_USER).getText();
//
//        Assert.assertEquals("Предмет пользовательского соглашения", getPoliticaUser);
//    }
//
//
//    @Test(priority = 6,
//            description = "телеграм бот")
//    public void hrefBot() {
//        driver.findElement(By.xpath("//span[@class='ant-typography span_r ant-dropdown-trigger Footer__links-text TabLink']")).click();
//        driver.findElement(By.xpath("//a[@href='https://t.me/arsoft_support_bot']")).click();
//
//        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(newTab.get(1));
//        String getBot = driver.findElement(GET_BOT).getText();
//
//        Assert.assertEquals("AR SOFT support", getBot);
//    }
//
//    @Test(priority = 7,
//            description = "Техническая поддержка АР СОФТ")
//    public void hrefSupport() {
//        driver.findElement(By.xpath("//span[@class='ant-typography span_r ant-dropdown-trigger Footer__links-text TabLink']")).click();
//        driver.findElement(By.xpath("//a[@href='https://forms.yandex.ru/cloud/66d960a043f74ffb1efdbae2/']")).click();
//
//        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(newTab.get(1));
//        String getSupport = driver.findElement(GET_SUPPORT).getText();
//
//        Assert.assertEquals("Техническая поддержка АР СОФТ", getSupport);
//    }
}
