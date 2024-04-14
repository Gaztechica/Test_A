package ar.soft;

import ar.soft.runner.BaseTest;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DashboardsSidebarTest extends BaseTest {

    // ================================== Дашборды =====================================================
    @Test
    public void dashboardsTest() {
        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'1Новый проект')]")).click();
        driver.findElement(By.xpath("//a[@style='color: inherit;'][contains(.,'Дашборды')]")).click();

        driver.findElement(By.xpath("//label[@class='ant-radio-wrapper RadioButton__input RingDiagramRemarks__checkbox-item']")).click();
        driver.findElement(By.xpath("//input[@class='ant-radio-input']")).click();
    }

    @Test
    public void cumulativeTest() throws InterruptedException{
        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'1Новый проект')]")).click();
        driver.findElement(By.xpath("//a[@style='color: inherit;'][contains(.,'Дашборды')]")).click();
        driver.findElement(By.xpath("//span[@class='ant-radio-button ant-radio-button-checked']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//label[@class='ant-radio-button-wrapper RadioButton__button MapDiagramRemarks__filterDates-item'][contains(.,'Месяц')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//label[@class='ant-radio-button-wrapper RadioButton__button MapDiagramRemarks__filterDates-item'][contains(.,'3 Месяц')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//label[@class='ant-radio-button-wrapper RadioButton__button MapDiagramRemarks__filterDates-item'][contains(.,'6 Месяц')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//label[@class='ant-radio-button-wrapper RadioButton__button MapDiagramRemarks__filterDates-item'][contains(.,'Год')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//label[@class='ant-radio-button-wrapper RadioButton__button MapDiagramRemarks__filterDates-item'][contains(.,'Все время')]")).click();

//        driver.findElement(By.xpath("//input[@id='rc_select_7']")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }
}
