package ar.soft.AT.UI.tests.fileTest;

import ar.soft.AT.UI.modelPage.FileSPage.FileSPage;
import ar.soft.AT.UI.tests.baseTest.SelenideBaseTest;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;


public class FileSTest extends SelenideBaseTest {

    @Test
    @Story("Добавление новой папки")
    @Description("Тест проверяет, что после клика на кнопку Добавить новой папки появляется в реестре на странице")
    @Severity(SeverityLevel.CRITICAL)
    public void createFolderTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
//        var fileSPage = new FileSPage()
         new FileSPage()
                .openProjectsAndFiles()
                .createNewFolder("новая папка")
                .mecConfirm("Папка успешно добавлена в проект");












//        String actualText = fileSPage.mecConfirm();
//        assertEquals("Папка успешно добавлена в проект", actualText);
//        ;



    }

    //        new FilePage(getDriver())
//        var page = new FileSPage(getDriver());
//    FileSPage page = new FileSPage();
//        page.projectS.click();
//        page.fileSidebarS.click();
//        page.folderAddS.click();
//        page.folderSelectS.click();
//        page.folderNameS.sendKeys("новая папка");
//        page.fileAddButton.click();
//        WaitT.littleWait(500);

}
