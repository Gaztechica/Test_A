package ar.soft;

import ar.soft.modelPage.UserSidebarPage;
import ar.soft.runner.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class UserSidebarTest extends BaseTest {

// удаление, отмена add, выбор организации выбор организации в адд поиск в адд
@Test(priority = 1,
        description = "создание пользователя с ролью наблюдатель и новой организацией")
    public void addUserToProjectTest() {
        new UserSidebarPage(getDriver())
                .project()
                .userSidebarClick()
                .btnAddUserClick()
                .btnCheckboxUserClick()
                .checkboxComponentClick()
                .btnCprimaryButtonClik();
//        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'1Новый проект')]")).click();
//        driver.findElement(By.xpath("//span[@class='ant-menu-title-content'][contains(.,'Пользователи')]")).click();
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();
//        driver.findElement(By.xpath("//div[@id='CheckboxComponent-check']")).click();
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();
    }

//    === сделать сортровку по организациям и удалить ================================
    @Test
    public void deleteUserFromProjectTest() {
        new UserSidebarPage(getDriver())
                .project()
                .userSidebarClick();
//        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'1Новый проект')]")).click();
//        driver.findElement(By.xpath("//span[@class='ant-menu-title-content'][contains(.,'Пользователи')]")).click();
        driver.findElement(By.xpath("//td[@class='ant-table-cell'][contains(.,'a123EvgenTest')]")).click();

        driver.findElement(By.xpath("//div[@class='ContentProjectUsers__iconBlock']")).click();

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(.,'Подтвердить')]")).click();

    }

    @Test
    public void cancelDeleteUserFromProjectTest() {
        new UserSidebarPage(getDriver())
                .project()
                .userSidebarClick();

        driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][@title='10']")).click();
        driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'50')]")).click();


//        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'1Новый проект')]")).click();
//        driver.findElement(By.xpath("//span[@class='ant-menu-title-content'][contains(.,'Пользователи')]")).click();
        driver.findElement(By.xpath("//td[@class='ant-table-cell'][contains(.,'aaa123EvgenTest')]")).click();

        driver.findElement(By.xpath("//div[@class='ContentProjectUsers__iconBlock']")).click();

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary '][contains(.,'Отменить')]")).click();

    }
}
