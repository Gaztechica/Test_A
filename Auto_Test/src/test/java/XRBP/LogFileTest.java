package XRBP;

//import org.junit.Test;

import org.testng.annotations.Test;
import XRBP.modelPage.LogFilePage;
import XRBP.runner.BaseTest;

public class LogFileTest extends BaseTest {

    @Test
    public void cancelLogDelTest() {
        new LogFilePage(driver)
                .btnLogFile()
                .iconDeleteLogFile()
                .btnCanselDeleteLogFile();
    }

    @Test
    public void logDelTest() {
        new LogFilePage(driver)
                .btnLogFile()
                .iconDeleteLogFile()
                .btnDeleteLogFile();
    }

    @Test
    public void logSearchTest() {
        new LogFilePage(driver)
                .btnLogFile()
                .searchLogFile();
    }

// провeрка добавления записи на страницу, количество элементов, пагинация
}
