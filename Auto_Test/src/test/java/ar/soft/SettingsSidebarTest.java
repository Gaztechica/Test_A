package ar.soft;

import ar.soft.runner.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
//import org.junit.Assert;
import org.testng.annotations.Test;

public class SettingsSidebarTest extends BaseTest {

    @Test
    public void removeProgectTest() {
        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'1Новый проект')]")).click();
        driver.findElement(By.xpath("//a[@style='color: inherit;'][contains(.,'Настройки')]")).click();
        driver.findElement(By.xpath("//div[@class='Sidebar__project-name'][contains(.,'1Новый проект')]")).click();
        driver.findElement(By.xpath("//input[@id='EditProjectForm_name']")).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "Настройки");
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']")).click();
        driver.findElement(By.xpath("//div[@class='Sidebar__project-name'][contains(.,'1Новый проект')]")).click();
        driver.findElement(By.xpath("//textarea[@id='EditProjectForm_street']")).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "1Новый проект");
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();

        Assert.assertEquals(getDriver().findElement(By.xpath("//div[@class='ant-message-notice-content'][contains(.,'Проект успешно изменен')]")).getText(), "Проект успешно изменен");
    }
    @Test
    public void cancelDeleteProgectTest() {
        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'1Новый проект')]")).click();
        driver.findElement(By.xpath("//a[@style='color: inherit;'][contains(.,'Настройки')]")).click();
        driver.findElement(By.xpath("//div[@class='Sidebar__project-name'][contains(.,'1Новый проект')]")).click();
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorRed ']")).click();
        driver.findElement(By.xpath("//div[@class='DeleteModal__buttonsPanel'][contains(.,'Отменить')]")).click();
    }

    @Test
    public void deleteProgectTest() {
        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'1Новый проект')]")).click();
        driver.findElement(By.xpath("//a[@style='color: inherit;'][contains(.,'Настройки')]")).click();
        driver.findElement(By.xpath("//div[@class='Sidebar__project-name'][contains(.,'1Новый проект')]")).click();
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorRed ']")).click();
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(.,'Подтвердить')]")).click();

        Assert.assertEquals(getDriver().findElement(By.xpath("//div[@class='ant-message-notice-content'][contains(.,'Проект успешно удален')]")).getText(), "Проект успешно удален");
    }
}
