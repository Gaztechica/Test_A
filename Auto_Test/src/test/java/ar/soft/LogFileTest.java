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



    @Test
    public void cancelLogDelTest()throws InterruptedException {
        new UserPage(driver)
                .login();


    }


    @Test
    public void logDelTest()throws InterruptedException {
        new UserPage(driver)
                .login();
        driver.findElement(By.xpath("//img[@src='/static/media/Basket.8774715cc0eccb962b78054dc111a9a8.svg']")).click();

    }








}
