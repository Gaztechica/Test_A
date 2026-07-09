package ar.soft.AT.UI;

import ar.soft.modelPage.LogFilePage;
import ar.soft.runner.BaseTest;
//import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogFileTest extends BaseTest {

    @Test(priority = 1,
            description = "Лог файл - отмена удаления")
    public void cancelLogDelTest() {
        new LogFilePage(driver)
                .btnLogFile()
                .iconDeleteLogFile()
                .btnCanselDeleteLogFile();
    }

    @Test(priority = 2,
            description = "Лог файл - удаление")
    public void logDelTest() throws InterruptedException {
        new LogFilePage(driver)
                .btnLogFile()
                .iconDeleteLogFile()
                .btnDeleteLogFile();
    }

    @Test(priority = 3,
            description = "Лог файл - поиск")
    public void logSearchTest() {
        String logSearch = new LogFilePage(driver)
                .btnLogFile()
                .searchLogFile()
                .logNameText();

        Assert.assertEquals(logSearch, EMAIL);
    }

// провeрка добавления записи на страницу, по времени
}
