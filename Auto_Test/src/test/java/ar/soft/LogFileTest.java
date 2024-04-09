package ar.soft;

import ar.soft.modelPage.UserPage;
import ar.soft.runner.BaseTest;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogFileTest extends BaseTest {

    @Test
    public void cancelLogDelTest() {
        driver.findElement(By.xpath("//a[@href='/logfiles']")).click();
        driver.findElement(By.xpath("//img[@src='/static/media/Basket.8774715cc0eccb962b78054dc111a9a8.svg']")).click();
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']")).click();
    }

    @Test
    public void logDelTest()throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='/logfiles']")).click();
        driver.findElement(By.xpath("//img[@src='/static/media/Basket.8774715cc0eccb962b78054dc111a9a8.svg']")).click();
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();
    }

    @Test
    public void logSerchTest() {
        driver.findElement(By.xpath("//a[@href='/logfiles']")).click();
        driver.findElement(By.xpath("//input[@id='rc_select_2']")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
    }
}
