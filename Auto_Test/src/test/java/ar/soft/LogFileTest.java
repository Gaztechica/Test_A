package ar.soft;

import ar.soft.modelPage.UserPage;
import ar.soft.runner.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class LogFileTest extends BaseTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void fghjkl()throws InterruptedException {

        new UserPage(driver)
                .URL();


    }


    @Test
    public void logDelTest()throws InterruptedException {

        new UserPage(driver)
                .URL();

        driver.quit();
    }

    public static final String URL = "http://23.105.246.172:5000/login";
//    public static final String INPUT_PASSWORD = "//input[@class='ant-input']";
    public static final String INPUT_EMAIL = "//input[@class='ant-input primaryInput  not-entered']";
    public static final String BTN_PASSWORD = "//button[@class='ant-btn ant-btn-default authButton big colorPrimary ']";
    public static final String EMAIL = "n-k-65@list.ru";
    private final By getPaswordText = By.xpath("//h2[@class='ant-typography h2_m RestorePassword__sendSuccess-text'][contains(.,'Мы отправили по адресу')]");

    private final By getErrorText = By.xpath("//div[@style='text-align: center; margin-bottom: 20px; color: rgb(255, 0, 0);']");



    @BeforeTest
    public void initWebDriver() {
//        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1820,1080));
    }

    @AfterTest
    public void closeWebDriver() {
        driver.quit();
    }
    @org.testng.annotations.Test
    public void removePaswordTest() throws InterruptedException {

        driver.get(URL);

        Thread.sleep(1000);

        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys("yyyyyyyyyy@mail.xx");

        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(1000);

        String getError = driver.findElement(getErrorText).getText();

        Assert.assertEquals(getError,"Неправильный логин или пароль");

    }

    @org.testng.annotations.Test
    public void regaTest() throws InterruptedException {

        driver.get(URL);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//h2[@class='ant-typography h2_m Login__restore-text']")).click();

        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);

        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(1000);

        String getPasError = driver.findElement(getPaswordText).getText();

        Assert.assertEquals(getPasError,"Мы отправили по адресу n-k-65@list.ru ссылку для восстановления доступа");

    }
}
