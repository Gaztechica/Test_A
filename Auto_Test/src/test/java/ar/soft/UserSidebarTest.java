package ar.soft;

import ar.soft.runner.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class UserSidebarTest extends BaseTest {

// удаление отмена адд выор организации выбор организации в адд поиск в адд
    @Test
    public void addUserTest() {
        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'1Новый проект')]")).click();
        driver.findElement(By.xpath("//a[@href='/projects/338/users']")).click();
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();
        driver.findElement(By.xpath("//div[@id='CheckboxComponent-check']")).click();
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();

    }
}
