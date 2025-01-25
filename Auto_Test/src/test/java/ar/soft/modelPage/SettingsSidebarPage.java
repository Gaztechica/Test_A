package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SettingsSidebarPage extends BasePage {
    public SettingsSidebarPage(WebDriver driver) {
        super(driver);
    }

    public SettingsSidebarPage openProjectSettings() {
        getDriver().findElement(By.xpath("//div[@class='Sidebar__project-name'][contains(.,'11AAНовый проект')]")).click();

        return this;
    }

    public SettingsSidebarPage inputNameProjectSettings() {
        getDriver().findElement(By.xpath("//input[@id='EditProjectForm_name']")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        getDriver().findElement(By.xpath("//input[@id='EditProjectForm_name']")).sendKeys( "11AAНовый проект");

        return this;
    }

    public SettingsSidebarPage btnCancelSettingsClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']")).click();


        return this;
    }

//    public SettingsSidebarPage inputNameStritProjectSettings() {
//        getDriver().findElement(By.xpath("//textarea[@id='EditProjectForm_street']")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE, "Гагарина");
//
//        return this;
//    }

    @Name("Город Проекта")
    public SettingsSidebarPage inputCityProjectSettings() {
        getDriver().findElement(By.xpath("//*[@id='EditProjectForm_city']")).sendKeys(Keys.CONTROL + "a", Keys.DELETE, "Куйбышев");
        return this;
    }

    @Name("Страна Проекта")
    public SettingsSidebarPage inputCountryProjectSettings() {
        getDriver().findElement(By.xpath("//*[@id='EditProjectForm_country']")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE, "Русь");
        return this;
    }

    @Name("улица Проекта")
    public SettingsSidebarPage inputStreetProjectSettings() {
        getDriver().findElement(By.xpath("//textarea[@id='EditProjectForm_street']")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE, "Победы");
        return this;
    }

    @Name("Почтовый индекс Проекта")
    public SettingsSidebarPage inputPostalCodeProjectSettings() {
        getDriver().findElement(By.xpath("//*[@id='EditProjectForm_postalCode']")).sendKeys( "00");
        return this;
    }

    @Name("Код проекта Проекта")
    public SettingsSidebarPage inputCodeProjectSettings() {
        getDriver().findElement(By.xpath("//*[@id='EditProjectForm_code']")).sendKeys( "10");
        return this;
    }

    @Name("Дом Проекта")
    public SettingsSidebarPage inputBuildingProjectSettings() {
        getDriver().findElement(By.xpath("//*[@id='EditProjectForm_building']")).sendKeys( "a");
        return this;
    }

    @Name("Офис Проекта")
    public SettingsSidebarPage inputOfficeProjectSettings() {
        getDriver().findElement(By.xpath("//*[@id='EditProjectForm_office']")).sendKeys( "a");
        return this;
    }

    @Name("Дата начала Проекта")
    public SettingsSidebarPage inputStartDateProjectSettings() {
        getDriver().findElement(By.xpath("//*[@id='EditProjectForm_startDate']")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        getDriver().findElement(By.xpath("//*[@id='EditProjectForm_startDate']")).sendKeys("01-11-2024", Keys.ENTER);
        return this;
    }

    @Name("Дата окончания Проекта")
    public SettingsSidebarPage inputEndDateProjectSettings() {
        getDriver().findElement(By.xpath("//*[@id='EditProjectForm_endDate']")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        getDriver().findElement(By.xpath("//*[@id='EditProjectForm_endDate']")).sendKeys( "26-11-2025", Keys.ENTER);
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
        return getDriver().findElement(By.xpath("//div[@class='ant-message-notice-content']//span[contains(.,'Проект успешно изменен')] | //div[@class='ant-message-notice-content'][contains(.,'Проект успешно изменен')]")).getText();
//        return getDriver().findElement(By.xpath("//div[@class='ant-message-notice-content'][contains(.,'Проект успешно изменен')]")).getText();
    }

    public String getMessageDeleteNoticeText() {
        return getDriver().findElement(By.xpath("//div[@class='ant-message-notice-content']//span[contains(.,'Проект успешно удален')] |//div[@class='ant-message-notice-content'][contains(.,'Проект успешно удален')]")).getText();
//        return getDriver().findElement(By.xpath("//div[@class='ant-message-notice-content'][contains(.,'Проект успешно удален')]")).getText();
    }
}
