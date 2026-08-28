package ar.soft.AT.UI.FileTest;

import ar.soft.modelPage.FileSPage.FilePage;
import ar.soft.runner.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class FileTest extends BaseTest {

    public final static String NEW_FOLDER = "Новая папка";
    public final static String REMOVE_FOLDER = "Переименовал папку";

    @Story("Добавление новой папки в реестр")
    @Description("Добавление новой папки в реестр")
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

        assertEquals(filePage, NEW_FOLDER);
    }

    @Story("Добавление новой папки")
    @Description("Добавление новой папки")
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

        assertEquals(filePage, "Папка успешно добавлена в проект");
    }

    @Story("Переименовать папку через контекстное меню")
    @Description("Переименовать папку через контекстное меню")
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

        assertEquals(filePage2, "Название папки успешно изменено");
    }

    @Story("Открытие папки через выпадающее меню")
    @Description("Открытие папки через выпадающее меню")
    @Test(priority = 4,
            description = "Открытие папки через выпадающее меню")
    public void openFolderTest() throws InterruptedException {
        String fileOpen = new FilePage(getDriver())
                .project()
                .fileSidebarClick()
                .btnPRMFolderClick()
                .btnOpen()
                .mecOpenFolder();

        assertEquals(fileOpen, "Нет данных");
    }

    @Story("удаление папки через контекстное меню без файлов внутри")
    @Description("удаление папки через контекстное меню без файлов внутри")
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

        assertEquals(filePage, "Папка успешно удалена из проекта");
    }

    @Story("Проверить кнопки в контекстном меню")
    @Description("Проверить кнопки в контекстном меню")
    @Test(priority = 6,
            description = "Проверить кнопки в контекстном меню")
    public void checkButtonTest() {
        final List<String> expectedListBar = List.of(
                "Открыть",
                "Переименовать",
                "Переместить",
                "Удалить");
        new FilePage(getDriver())
                .project()
                .fileSidebarClick();

        List<String> tabBarList = new FilePage(getDriver())
                .btnPRMClick()
                .getNameButtonText();

        assertEquals(tabBarList, expectedListBar);
    }

    @Story("Проверить кнопки в троеточие")
    @Description("Проверить кнопки в троеточие")
    @Test(priority = 7,
            description = "Проверить кнопки в троеточие")
    public void checkButtonEllipsisTest() {
        final List<String> expectedListTabBar = List.of(
                "Открыть", "Переименовать", "Переместить", "Удалить");
        new FilePage(getDriver())
                .project()
                .fileSidebarClick();

        List<String> tabBarList = new FilePage(getDriver())
                .ellipsisButton()
                .getNameButtonEllipsisText();

        assertEquals(tabBarList, expectedListTabBar);
    }

//    @Test
//    public void testVerify7ItemsSidePanelDetailsPage() {
//        final List<String> itemsExpected = new ArrayList<>(Arrays.asList("Status", "Changes", "Workspace", "Build Now", "Configure", "Delete Project", "Rename"));
//
//        TestUtils.createFreestyleProject(this, PROJECT_NAME, true);
//
//        List<String> itemsActual = new HomePage(getDriver())
//                .clickJobByName(PROJECT_NAME, new FreestyleProjectDetailsPage(getDriver()))
//                .getTextItemsSidePanel();
//
//        assertEquals(itemsActual, itemsExpected);
//    }

//    @Test(priority = 6,
//            description = "Перемещение папки в родительскую папку через контекстное меню")
//    public void movingTheParentFolderTest() throws InterruptedException {
//        String folderMoving = new FilePage(getDriver())
//                .project()
//                .fileSidebarClick()
//                .clickAndCheckSortColumn(new FilePage());
//
//        Assert.assertEquals(folderMoving, "Папка успешно перемещена");
//    }



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

//    Открытие папки через троеточие, удаление, удаление с файлами внутри, переименование, перемещение в родит, перемещ в корневую,
//    сортировка, поиск, добавление файлов, перемещение файлов, удаление файлов
}
