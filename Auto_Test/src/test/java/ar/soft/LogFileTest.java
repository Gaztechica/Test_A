package ar.soft;

import ar.soft.modelPage.LogFilePage;
import ar.soft.modelPage.UserPage;
import ar.soft.runner.BaseTest;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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
    public void logDelTest() {
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

        Assert.assertEquals(logSearch, "d8q2s@fthcapital.com");
    }

// провeрка добавления записи на страницу, по времени
}
