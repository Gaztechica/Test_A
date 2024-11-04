package ar.soft;

import ar.soft.modelPage.SettingsSidebarPage;
import ar.soft.modelPage.base.BasePage;
import ar.soft.runner.BaseTest;
import org.testng.Assert;
//import org.junit.Assert;
import org.testng.annotations.Test;

public class SettingsSidebarTest extends BaseTest {

    @Test(priority = 1,
            description = "изменить проект")
    public void removeProjectTest() {
       String messege = new SettingsSidebarPage(getDriver())
                .project()
                .settingsSidebarClick()
                .openProjectSettings()
                .inputNameProjectSettings()
                .btnCancelSettingsClick()
                .inputNameStritProjectSettings()
                .btnlSaveSettingsClick()
                .getMessageAddNoticeText();

        Assert.assertEquals(messege, "Проект успешно изменен");
    }
    @Test(priority = 2,
            description = "отмена удалить проект")
    public void cancelDeleteProjectTest() {
        new BasePage(getDriver())
                .project()
                .settingsSidebarClick()
                .openProjectSettings()
                .inputNameProjectSettings()
                .inputNameStritProjectSettings()
                .btnDeleteSettingsClick()
                .btnCancelDeleteSettingsClick();
    }

    @Test(priority = 3,
            description = "удалить проект")
    public void deleteProgectTest() {
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
