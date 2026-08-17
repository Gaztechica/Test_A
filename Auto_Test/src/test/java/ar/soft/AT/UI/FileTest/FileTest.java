package ar.soft.AT.UI.FileTest;

import ar.soft.modelPage.FileSPage.FilePage;
import ar.soft.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileTest extends BaseTest {

    public final static String NEW_FOLDER = "Новая папка";
    public final static String REMOVE_FOLDER = "Переименовал папку";

    @Test(priority = 1,
            description = "Добавление новой папки в реестр")
    public void addFolderTest() throws InterruptedException {
        String filePage = new FilePage(getDriver())
                .project()
                .fileSidebarClick()
                .folderAdd()
                .folderSelect()
                .folderName(NEW_FOLDER)
                .folderAdd2()
                .checkCreateFolder();

        Assert.assertEquals(filePage, NEW_FOLDER);
    }

    @Test(priority = 2,
            description = "Добавление новой папки")
    public void createFolderTest() throws InterruptedException {
        String filePage = new FilePage(getDriver())
                .project()
                .fileSidebarClick()
                .folderAdd()
                .folderSelect()
                .folderName(NEW_FOLDER)
                .folderAdd2()
                .mecConfirm();

        Assert.assertEquals(filePage, "Папка успешно добавлена в проект");
    }

        @Test(priority = 3,
            description = "Переименовать папку через контекстное меню")
    public void removeFolderTest() throws InterruptedException {
        String filePage2 = new FilePage(getDriver())
                .project()
                .fileSidebarClick()
                .btnRemovePRMFolderClick()
                .btnRename()
                .folderRename(REMOVE_FOLDER)
                .btnSave()
                .mecConfirm();

        Assert.assertEquals(filePage2, "Название папки успешно изменено");
    }

    @Test(priority = 4,
            description = "Открытие папки через выпадающее меню")
    public void openFolderTest() throws InterruptedException {
        String fileOpen = new FilePage(getDriver())
                .project()
                .fileSidebarClick()
                .btnPRMFolderClick()
                .btnOpen()
                .mecOpenFolder();

        Assert.assertEquals(fileOpen, "Нет данных");
    }

    @Test(priority = 5,
            description = "удаление папки через контекстное меню без файлов внутри")
    public void deleteFolderTest() throws InterruptedException {
        String filePage = new FilePage(getDriver())
                .project()
                .fileSidebarClick()
                .btnPRMFolderClick()
                .btnDelete()
                .btnConfirm()
                .mecConfirm();

        Assert.assertEquals(filePage, "Папка успешно удалена из проекта");
    }

    @Test(priority = 6,
            description = "Перемещение папки в родительскую папку через контекстное меню")
    public void movingTheParentFolderTest() throws InterruptedException {
        String folderMoving = new FilePage(getDriver())
                .project()
                .fileSidebarClick()
                .btnRemovePRMFolderClick()
                .btnMoving()
                .folderMoving()
                .btnMovingSave()
                .mecConfirm();

        Assert.assertEquals(folderMoving, "Папка успешно перемещена");
    }

//    @Test(priority = 7,
//            description = "Перемещение папки в корневую папку через контекстное меню")
//    public void parentTheMovingFolderTest() throws InterruptedException {
//        String folderMoving = new FilePage(getDriver())
//                .project()
//                .fileSidebarClick()
//                .btnRemovePRMFolderClick()
//                .btnMoving()
//                .folderMoving()
//                .btnMovingSave()
//                .mecConfirm();

//        Assert.assertEquals(folderMoving, "Папка успешно перемещена");
//    }

//    Открытие папки через троеточие, удаление, удаление с файлами внутри, переименование, перемещение в родит, перемещ в корневую
//    проверить список контекстное меню, сортировка, поиск, добавление файлов, перемещение файлов, удаление файлов
}
