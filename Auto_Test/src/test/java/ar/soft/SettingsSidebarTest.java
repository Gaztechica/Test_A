package ar.soft;

import ar.soft.modelPage.SettingsSidebarPage;
import ar.soft.modelPage.base.BasePage;
import ar.soft.runner.BaseTest;
import org.testng.Assert;
//import org.junit.Assert;
import org.testng.annotations.Test;

public class SettingsSidebarTest extends BaseTest {

    @Test
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
    @Test
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

    @Test
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
