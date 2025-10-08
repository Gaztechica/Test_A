package ar.soft.AT.ProjectSettings;

import ar.soft.modelPage.SettingsSidebarPage;
import ar.soft.modelPage.base.BasePage;
import ar.soft.runner.BaseTest;
import org.testng.Assert;
//import org.junit.Assert;
import org.testng.annotations.Test;

public class SettingsProjectTest extends BaseTest {

    @Test(priority = 1,
            description = "изменить проект")
    public void removeProjectTest() throws InterruptedException {
       String messege = new SettingsSidebarPage(getDriver())
                .project()
                .settingsSidebarClick()
                .inputNameProjectSettings()
                .inputCityProjectSettings()
                .inputCountryProjectSettings()
                .inputBuildingProjectSettings()
                .inputCodeProjectSettings()
                .inputOfficeProjectSettings()
                .inputStreetProjectSettings()
                .inputEndDateProjectSettings()
                .inputStartDateProjectSettings()
                .inputPostalCodeProjectSettings()
                .btnlSaveSettingsClick()
                .getMessageAddNoticeText();

        Assert.assertEquals(messege, "Проект успешно изменен");
    }
    @Test(priority = 2,
            description = "отмена удалить проект")
    public void cancelDeleteProjectTest() throws InterruptedException {
        new BasePage(getDriver())
                .project()
                .settingsSidebarClick()
                .openProjectSettings()
                .inputNameProjectSettings()
                .inputStreetProjectSettings()
                .btnDeleteSettingsClick()
                .btnCancelDeleteSettingsClick();
    }

    @Test(priority = 3,
            description = "удалить проект")
    public void deleteProgectTest() throws InterruptedException {
       String getMessageDelete = new BasePage(getDriver())
                .project()
                .settingsSidebarClick()
                .openProjectSettings()
                .btnDeleteSettingsClick()
                .DeleteSettingsClick()
               .getMessageDeleteNoticeText();

        Assert.assertEquals(getMessageDelete, "Проект успешно удален");
    }

}
