package ar.soft;

import ar.soft.modelPage.HomePage;
import ar.soft.runner.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutorisaitionTest extends BaseTest {

    WebDriver driver = new ChromeDriver();

    private final By getErrorText = By.xpath("//div[@style='text-align: center; margin-bottom: 20px; color: rgb(255, 0, 0);']");
    private final By getPaswordText = By.xpath("//h2[@class='ant-typography h2_m RestorePassword__sendSuccess-text'][contains(.,'Мы отправили по адресу')]");
    public static final String NEGA_EMAIL = "dfghjkluytr@mail.ru";

//=============================== регистрация нового пользователя ====================================

//  рамдомные почтовые ящ и создавать/удалять пользователей?  регистрация
    @Test
    public void restorePasswordTest () throws InterruptedException {

        driver.get(URL);
        Thread.sleep(2000);

//        driver.findElement(By.xpath("//h2[@class='ant-typography h2_m Login__restore-text']")).click();
        new HomePage(driver).clickRega();
        Thread.sleep(2000);
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(2000);

        String getPasError = driver.findElement(getPaswordText).getText();

        Assert.assertEquals(getPasError,"Мы отправили по адресу n-k-65@list.ru ссылку для восстановления доступа");
        driver.quit();
    }

    @Test
    public void regNegaTest() throws InterruptedException {

        driver.get(URL);

        Thread.sleep(2000);
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(NEGA_EMAIL);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(2000);

        String getError = driver.findElement(getErrorText).getText();

        Assert.assertEquals(getError,"Неправильный логин или пароль");
        driver.quit();
    }

//    @Test
//    public void removePaswordTest() throws InterruptedException {
//
//        driver.get(URL);
//
//        Thread.sleep(2000);
//        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
//        driver.findElement(By.xpath(BTN_PASSWORD)).click();
//        Thread.sleep(2000);

//        String getError = driver.findElement(getErrorText).getText();
//
//        Assert.assertEquals(getError,"Неправильный логин или пароль");
//        driver.quit();
//    }


//    добавить куки почты и вводить полученное письмо для замены пароля
    @Test
    public void regCoogiTest() throws InterruptedException {

        driver.get(URL);

        Thread.sleep(2000);
        Cookie getCookie = new Cookie("_ga", "GA1.2");
//        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(NEGA_EMAIL);
//        driver.findElement(By.xpath(BTN_PASSWORD)).click();
//        Thread.sleep(2000);
//
//        String getError = driver.findElement(getErrorText).getText();
//
//        Assert.assertEquals(getError,"Неправильный логин или пароль");
//        driver.quit();
    }

    //      ======  добавить проверку ===


}
