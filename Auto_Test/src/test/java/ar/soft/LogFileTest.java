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
