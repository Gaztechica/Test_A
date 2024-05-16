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
        getDriver().findElement(By.xpath("//input[@id='EditProjectForm_name']")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE, "1Новый проект");

        return this;
    }

    public SettingsSidebarPage btnCancelSettingsClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']")).click();


        return this;
    }

    public SettingsSidebarPage inputNameStritProjectSettings() {
        getDriver().findElement(By.xpath("//textarea[@id='EditProjectForm_street']")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE, "Настройки");

        return this;
    }

    public SettingsSidebarPage btnlSaveSettingsClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();

        return this;
    }

    public SettingsSidebarPage DeleteSettingsClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(.,'Подтвердить')]")).click();

        return this;
    }

    public SettingsSidebarPage btnDeleteSettingsClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorRed ']")).click();

        return this;
    }
    public SettingsSidebarPage btnCancelDeleteSettingsClick() {
        getDriver().findElement(By.xpath("//div[@class='DeleteModal__buttonsPanel']//button[@type='button'][contains(.,'Отменить')]")).click();

        return this;
    }

    public String getMessageAddNoticeText() {
        return getDriver().findElement(By.xpath("//div[@class='ant-message-notice-content'][contains(.,'Проект успешно изменен')]")).getText();
    }

    public String getMessageDeleteNoticeText() {
        return getDriver().findElement(By.xpath("//div[@class='ant-message-notice-content'][contains(.,'Проект успешно удален')]")).getText();
    }
}
