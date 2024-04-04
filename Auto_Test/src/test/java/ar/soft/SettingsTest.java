package ar.soft;

import ar.soft.modelPage.ProgectPage;
import ar.soft.modelPage.UserPage;
import ar.soft.runner.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class SettingsTest extends BaseTest {

    @Test
    public void settingsTest() throws InterruptedException {
        new UserPage(driver)
                .login();
        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'1Новый проект')]")).click();
        driver.findElement(By.xpath("//a[@style='color: inherit;'][contains(.,'Настройки')]")).click();
        driver.findElement(By.xpath("//div[@class='Sidebar__project-name'][contains(.,'1Новый проект')]")).click();
        driver.findElement(By.xpath("//input[@id='EditProjectForm_name']")).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "Настройки");
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']")).click();

    }
}
