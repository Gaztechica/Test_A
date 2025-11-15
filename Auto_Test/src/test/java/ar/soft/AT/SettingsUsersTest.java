package ar.soft.AT;

import ar.soft.modelPage.ProjectSettingsPage.SettingsUsersPage;
import ar.soft.runner.BaseTest;
import org.testng.annotations.Test;
import ru.qa.methods.AssertionT;

public class SettingsUsersTest extends BaseTest {

    public final static String NAME_USER = "a123EvgenTest";

    @Test(priority = 1,
            description = "приглашение пользователя в проект")
    public void createUsersProject() throws InterruptedException {
        new SettingsUsersPage(getDriver())
                .project()
                .settingsSidebarClick();
        SettingsUsersPage settingsUsersPage = new SettingsUsersPage(getDriver());
        settingsUsersPage.usersClick.click();
        settingsUsersPage.addButtonClick.click();
        settingsUsersPage.searchUsersClick.sendKeys(NAME_USER);
        settingsUsersPage.checkUsersClick.click();
        settingsUsersPage.btnButtonClick.click();
        Thread.sleep(300);

        AssertionT.Element.elementDisplayed(settingsUsersPage.newUsersCheck);
    }

    @Test(priority = 2,
            description = "удаление пользователя из проекта")
    public void deleteUsersProject() throws InterruptedException {
        new SettingsUsersPage(getDriver())
                .project()
                .settingsSidebarClick();
        SettingsUsersPage settingsUsersPage = new SettingsUsersPage(getDriver());
        settingsUsersPage.usersClick.click();
        settingsUsersPage.newUsersCheck2.click();
        Thread.sleep(800);
        settingsUsersPage.btnButtonDeleteClick.click();

        AssertionT.Element.elementDisplayed(settingsUsersPage.messageCheck);
//        Thread.sleep(500);
//        AssertionT.Element.elementNotAttachedToPage(settingsUsersPage.newUsersCheck);
    }

    @Test(priority = 3,
            description = "множественное приглашение пользователя в проект")
    public void addUsersProject() throws InterruptedException {
        new SettingsUsersPage(getDriver())
                .project()
                .settingsSidebarClick();
        SettingsUsersPage settingsUsersPage = new SettingsUsersPage(getDriver());
        settingsUsersPage.usersClick.click();
        settingsUsersPage.addButtonClick.click();
        settingsUsersPage.searchUsersClick.sendKeys("Наблюдательный");
        settingsUsersPage.checkUsersClick.click();
        settingsUsersPage.btnButtonClick.click();
        Thread.sleep(300);

        AssertionT.Element.elementDisplayed(settingsUsersPage.newUsersCheck);
    }
}
