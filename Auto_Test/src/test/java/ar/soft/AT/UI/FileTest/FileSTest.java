package ar.soft.AT.UI.FileTest;

import ar.soft.modelPage.FileSPage.FileSPage;
import ar.soft.runner.SelenideBaseTest;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.Test;
import ru.qa.methods.WaitT;

public class FileSTest extends SelenideBaseTest {

    @Test(priority = 1,
            description = "создать ")
    public void createFolderTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

//        new FilePage(getDriver())
//        var page = new FileSPage(getDriver());
        FileSPage page = new FileSPage();
        page.projectS.click();
        page.fileSidebarS.click();
        page.folderAddS.click();
        page.folderSelectS.click();
        page.folderNameS.sendKeys("новая папка");
        page.fileAddButton.click();
        WaitT.littleWait(500);
    }
}
