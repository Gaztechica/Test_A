package ar.soft;

import ar.soft.modelPage.UserPage;
import ar.soft.runner.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BibliotekaTest extends BaseTest {

        WebDriver driver = new ChromeDriver();
    // ================================== библиотека =====================================================
    @Test
    public void BibliotekaTest() throws InterruptedException {
//        Wait<WebDriver> wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        new UserPage(driver)
                .login();
//        driver.get(URL);
//        driver.manage().window().setSize(new Dimension(1820,1080));
//        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
//        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
//        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

//        getWait5().until(ExpectedCondition.visibilityOfElementLocated(By.xpath("//a[@href='/library']"))).click();
//        WebElement actualdMessageText =  wait.until(ExpectedCondition.visi ((By.xpath("//a[@href='/library']")).click();
        driver.findElement(By.xpath("//a[@href='/library']")).click();

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary checklists__extraButtonChecklict-create']")).click();

        driver.findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']")).sendKeys("Название чеклиста");


        driver.findElement(By.xpath("//div[@class='CheckboxComponent__round-check']")).click();
        driver.findElement(By.xpath("//button[@class='CreateChecklist__addCategoryButton']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//textarea[@class='ant-input primaryInput  not-entered']")).sendKeys("Все организации");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@class='ant-input primaryInput createCategoryModal__input not-entered']")).sendKeys("Все организации2");
        Thread.sleep(2000);
        WebElement userRolesc2 = driver.findElement(By.xpath("//div[@class='createCategoryModal__buttonsPanel']//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary '][contains(.,'Отменить')]"));
        userRolesc2.click();
        Thread.sleep(2000);
//        driver.findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']")).sendKeys("Название чеклиста");
//
//        driver.findElement(By.xpath("//div[@class='CheckboxComponent__round-check']")).click();
         driver.findElement(By.xpath("//button[@class='CreateChecklist__addCategoryButton']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//textarea[@class='ant-input primaryInput  not-entered']")).sendKeys("Все организации3");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@class='ant-input primaryInput createCategoryModal__input not-entered']")).sendKeys("Все организации4");

        Thread.sleep(2000);
//        WebElement userR2 = driver.findElement(By.xpath("//textarea[@class='ant-input primaryInput createCategoryModal__input not-entered']"));
//        userR2.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='createCategoryModal__buttonsPanel']//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary '][contains(.,'Добавить')]")).click();



//        Thread.sleep(2000);
        driver.quit();
    }
}
