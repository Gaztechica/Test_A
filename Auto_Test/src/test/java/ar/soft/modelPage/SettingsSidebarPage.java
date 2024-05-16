package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SettingsSidebarPage extends BasePage {
    public SettingsSidebarPage(WebDriver driver) {
        super(driver);
    }

    public SettingsSidebarPage openProjectSettings() {
        getDriver().findElement(By.xpath("//div[@class='Sidebar__project-name'][contains(.,'1Новый проект')]")).click();

        return this;
    }

    public SettingsSidebarPage inputNameProjectSettings() {
//        getDriver().findElement(By.xpath("//input[@id='EditProjectForm_name']")).sendKeys(Keys.CLEAR);
        getDriver().findElement(By.xpath("//input[@id='EditProjectForm_name']")).click();

        getDriver().findElement(By.xpath("//input[@id='EditProjectForm_name']")).clear();

        getDriver().findElement(By.xpath("//input[@id='EditProjectForm_name']")).sendKeys(  "Настр");

        return this;
    }

    public SettingsSidebarPage btnCancelSettingsClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']")).click();


        return this;
    }

    public SettingsSidebarPage inputNameStritProjectSettings() {
        getDriver().findElement(By.xpath("//textarea[@id='EditProjectForm_street']")).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "Настройки");

        return this;
    }

    public SettingsSidebarPage btnlDeleteSettingsClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();

        return this;
    }

    public SettingsSidebarPage btnCancelDeleteSettingsClick() {
        getDriver().findElement(By.xpath("//div[@class='DeleteModal__buttonsPanel'][contains(.,'Отменить')]")).click();

        return this;
    }
}
