package ar.soft;

import ar.soft.modelPage.RemarkSidebarPage;
import ar.soft.runner.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RemarcSidebarTest extends BaseTest {

    private static final By GET_ERROR = By.xpath("//div[@style='text-align: center; margin-bottom: 20px; color: rgb(255, 0, 0);']");



    @Test
    public void remarcTest() {
        new RemarkSidebarPage(driver)
                .homePage();
        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'1Новый проект')]")).click();
        driver.findElement(By.xpath("//span[@class='ant-menu-title-content'][contains(.,'Замечания')]")).click();
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();

        driver.findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']")).sendKeys("Замечаниe");

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary '][contains(.,'Создать')]")).click();
//        driver.findElement(By.xpath("//span[@class='ant-menu-title-content'][contains(.,'Замечания')]")).click();
//        driver.findElement(By.xpath("//span[@class='ant-menu-title-content'][contains(.,'Замечания')]")).click();
//        getDriver().findElement(By.xpath(INPUT_EMAIL)).sendKeys("yyyyyyyyyy@mail.xx");
//        getDriver().findElement(By.xpath(BTN_PASSWORD)).click();
//
//        String getError = getDriver().findElement(GET_ERROR).getText();
//
//        Assert.assertEquals(getError,"Неправильный логин или пароль");
    }


}
