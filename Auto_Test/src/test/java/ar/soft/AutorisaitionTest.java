package ar.soft;

import ar.soft.modelPage.HomePage;
import ar.soft.runner.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutorisaitionTest extends BaseTest {

    WebDriver driver = new ChromeDriver();

//=============================== регистрация нового пользователя ====================================

//  рамдомные почтовые ящ и создавать/удалять пользователей?
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
}
