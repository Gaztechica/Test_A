package ar.soft;

import ar.soft.runner.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class UserSidebarTest extends BaseTest {

// удаление отмена адд выор организации выбор организации в адд поиск в адд
    @Test
    public void addUserTest() {
        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'1Новый проект')]")).click();
        driver.findElement(By.xpath("//span[@class='ant-menu-title-content'][contains(.,'Пользователи')]")).click();
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();
        driver.findElement(By.xpath("//div[@id='CheckboxComponent-check']")).click();
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();
    }

//    === сделать сортровку по организациям и удалить================================
    @Test
    public void deleteUserTest() {
        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'1Новый проект')]")).click();
        driver.findElement(By.xpath("//span[@class='ant-menu-title-content'][contains(.,'Пользователи')]")).click();
        driver.findElement(By.xpath("//td[@class='ant-table-cell'][contains(.,'a123EvgenTest')]")).click();

        driver.findElement(By.xpath("//div[@class='ContentProjectUsers__iconBlock']")).click();

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(.,'Подтвердить')]")).click();

    }


}
