package ar.soft;

import ar.soft.modelPage.HomePage;
import ar.soft.runner.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutorisaitionTest extends BaseTest {

    WebDriver driver = new ChromeDriver();

    private final By getErrorText = By.xpath("//div[@style='text-align: center; margin-bottom: 20px; color: rgb(255, 0, 0);']");
    public static final String NEGA_EMAIL = "dfghjkluytr@mail.ru";

//=============================== регистрация нового пользователя ====================================

//  рамдомные почтовые ящ и создавать/удалять пользователей? востановление пароля регистрация
    @Test
    public void AutorisationTest () throws InterruptedException {

        driver.get(URL);
        Thread.sleep(2000);
//        driver.findElement(By.xpath("//h2[@class='ant-typography h2_m Login__restore-text']")).click();
        new HomePage(driver).clickRega();
        Thread.sleep(2000);
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(2000);
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

    @Test
    public void removePaswordTest() throws InterruptedException {

        driver.get(URL);

        Thread.sleep(2000);
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(NEGA_EMAIL);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(2000);

        String getError = driver.findElement(getErrorText).getText();

        Assert.assertEquals(getError,"Неправильный логин или пароль");
        driver.quit();
    }

    //      ======  добавить проверку ===


}
