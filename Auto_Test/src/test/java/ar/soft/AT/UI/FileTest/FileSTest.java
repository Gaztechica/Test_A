//package ar.soft.AT.UI.FileTest;
//
//import ar.soft.modelPage.FileSPage.FileSPage;
//import ar.soft.runner.BaseTest;
//import com.codeborne.selenide.logevents.SelenideLogger;
//import io.qameta.allure.selenide.AllureSelenide;
//import org.testng.annotations.Test;
//import ru.qa.methods.WaitT;
//
//
//public class FileSTest extends BaseTest {
//
//    @Test(priority = 1,
//            description = "создать ")
//    public void createFolderTest() throws InterruptedException {
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
////        new FilePage(getDriver())
////        var page = new FileSPage(getDriver());
//        FileSPage page = new FileSPage(getDriver());
//        page.projectS.click();
//        page.fileSidebarS.click();
//        page.folderAddS.click();
//        page.folderSelectS.click();
//        page.folderNameS.sendKeys("новая папка");
//        page.fileAddButton.click();
//        WaitT.littleWait(500);
//    }
//}
