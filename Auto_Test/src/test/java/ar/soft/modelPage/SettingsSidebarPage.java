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
        getDriver().findElement(By.xpath("//div[@class='Sidebar__project-name'][contains(.,'1Новый проект')]")).sendKeys(Keys.ENTER);

        return this;
    }

    public SettingsSidebarPage inputNameProjectSettings() {
        getDriver().findElement(By.xpath("//input[@id='EditProjectForm_name']")).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "Настройки");

        return this;
    }

    public SettingsSidebarPage btnSaveSettingsClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']")).click();


        return this;
    }

    public SettingsSidebarPage inspecton() {
        getDriver().findElement(By.xpath("//input[@aria-activedescendant='rc_select_4_list_0']")).sendKeys(Keys.ENTER);

        return this;
    }

    public SettingsSidebarPage inspetion() {
        getDriver().findElement(By.xpath("//input[@aria-activedescendant='rc_select_4_list_0']")).sendKeys(Keys.ENTER);

        return this;
    }
}
