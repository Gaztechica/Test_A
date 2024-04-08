package ar.soft;

import ar.soft.modelPage.UserPage;
import ar.soft.runner.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class LogFileTest extends BaseTest {



    @Test
    public void cancelLogDelTest()throws InterruptedException {
        new UserPage(driver)
                .login();
        driver.findElement(By.xpath("//a[@href='/logfiles']")).click();
        driver.findElement(By.xpath("//img[@src='/static/media/Basket.8774715cc0eccb962b78054dc111a9a8.svg']")).click();
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']")).click();
    }


    @Test
    public void logDelTest()throws InterruptedException {
        new UserPage(driver)
                .login();
        driver.findElement(By.xpath("//a[@href='/logfiles']")).click();
        driver.findElement(By.xpath("//img[@src='/static/media/Basket.8774715cc0eccb962b78054dc111a9a8.svg']")).click();
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();
    }

//    ================= не работает поиск по организац=========================
    @Test
    public void logSerchTest() throws InterruptedException{
        new UserPage(driver)
                .login();
        driver.findElement(By.xpath("//a[@href='/logfiles']")).click();

//        driver.findElement(By.xpath("//span[@class='ant-select-selection-item']")).click();
//        driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'Все пользователи')]")).click();
        driver.findElement(By.xpath("//div[@class='ant-select-item ant-select-item-option ant-select-item-option-selected']")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//        driver.findElement(By.xpath("//input[@id='rc_select_148']")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
    }
}
