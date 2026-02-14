package ar.soft.AT.FileTest;

import ar.soft.modelPage.FileSPage.FilePage;
import ar.soft.modelPage.FileSPage.FileSPage;
import ar.soft.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.methods.WaitT;


public class FileTest extends BaseTest {

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

//                .folderAdd()
//                .folderSelect()
//                .folderName("новая папка")
//                .folderAdd2()
                .checkCreateFolder();

        Assert.assertEquals(filePage2, "новая папка");
    }
}
