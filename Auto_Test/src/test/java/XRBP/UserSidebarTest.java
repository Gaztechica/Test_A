package XRBP;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import XRBP.runner.BaseTest;

public class UserSidebarTest extends BaseTest {

// удаление, отмена add, выбор организации выбор организации в адд поиск в адд
    @Test
    public void addUserTest() {
        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'1Новый проект')]")).click();
        driver.findElement(By.xpath("//span[@class='ant-menu-title-content'][contains(.,'Пользователи')]")).click();
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();
        driver.findElement(By.xpath("//div[@id='CheckboxComponent-check']")).click();
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();
    }

//    === сделать сортровку по организациям и удалить ================================
    @Test
    public void deleteUserTest() {
        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'1Новый проект')]")).click();
        driver.findElement(By.xpath("//span[@class='ant-menu-title-content'][contains(.,'Пользователи')]")).click();
        driver.findElement(By.xpath("//td[@class='ant-table-cell'][contains(.,'a123EvgenTest')]")).click();

        driver.findElement(By.xpath("//div[@class='ContentProjectUsers__iconBlock']")).click();

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(.,'Подтвердить')]")).click();

    }

    @Test
    public void deleteTest() {
        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'1Новый проект')]")).click();
        driver.findElement(By.xpath("//span[@class='ant-menu-title-content'][contains(.,'Пользователи')]")).click();
        driver.findElement(By.xpath("//td[@class='ant-table-cell'][contains(.,'a123EvgenTest')]")).click();

        driver.findElement(By.xpath("//div[@class='ContentProjectUsers__iconBlock']")).click();

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(.,'Подтвердить')]")).click();

    }
}
