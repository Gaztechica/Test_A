package ar.soft.runner;

//import arSoft.runner.FilterForTest.FilterForTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;

//@Liisteners({FilterForTests.class})
public abstract class BaseTest {


    public static final String URL = "http:";
    public static final String INPUT_PASSWORD = "//input[@class='ant-input']";
    public static final String INPUT_EMAIL = "//input[@class='ant-input primaryInput  not-entered']";
    public static final String BTN_PASSWORD = "//button[@class='ant-btn ant-btn-default authButton big colorPrimary ']";
    public static final String EMAIL = "@mail.ru";
    public static final String PASSWORD = "5";

    //    public static final String DESCRIPTION = "Test description";

    private static WebDriver driver;

//    private Wait<WebDriver> wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    private WebDriverWait wait2;
    private WebDriverWait wait5;
    private WebDriverWait wait10;

private void startDriver() {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    driver.manage().timeouts().getPageLoadTimeout();
}
      static void login() {
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
    }

//    private void closeDriver() {
//        if (driver != null) {
//            driver.quit();
//
//            driver = null;
//            wait2 = null;
//            wait5 = null;
//            wait10 = null;
//
//            ProjectUtils.log("Browser closed");
//        }
//    }


    @BeforeMethod
    protected void beforeMethod(Method method) {
        driver = new ChromeDriver(ProjectUtils.chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    protected void afterMethod(Method method, ITestResult testResult) {
        driver.quit();
    }


    protected WebDriver getDriver() {
        return driver;
    }

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
}
