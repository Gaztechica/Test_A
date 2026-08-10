package ar.soft.AT.UI.FileTest;

import ar.soft.modelPage.FileSPage.FilePage;
import ar.soft.modelPage.ProjectSettingsPage.SettingsUsersPage;
import ar.soft.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileTest extends BaseTest {

    public final static String REMOVE_FOLDER = "Переименовал папку";

    @Test(priority = 1,
            description = "создать ")
    public void createFolderTest() throws InterruptedException {
        String filePage = new FilePage(getDriver())
                .project()
                .fileSidebarClick()
                .folderAdd()
                .folderSelect()
                .folderName("новая папка")
                .folderAdd2()
                .checkCreateFolder();

        Assert.assertEquals(filePage, "новая папка");
    }

    @Test(priority = 2,
            description = "переименовать папку")
    public void removeFolderTest() throws InterruptedException {
        String filePage2 = new FilePage(getDriver())
                .project()
                .fileSidebarClick()
                .btnRemovePRMFolderClick()
                .btnRename()
                .folderRename(REMOVE_FOLDER)
                .btnSave()
                .checkCreateFolder();

        Assert.assertEquals(filePage2, REMOVE_FOLDER);
    }

    @Test(priority = 3,
            description = "Добавление пользователя в проект")
    public void createUsersProject() throws InterruptedException {
        String filePage = new FilePage(getDriver())
                .project()
                .fileSidebarClick()
                .btnDeletePRMFolderClick()
                .btnDelete()
                .btnConfirm()
                .mecConfirm();

        Assert.assertEquals(filePage, "Папка успешно удалена из проекта");

    }
}
