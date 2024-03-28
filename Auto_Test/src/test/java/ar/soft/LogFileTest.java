package ar.soft;

import ar.soft.modelPage.UserPage;
import ar.soft.runner.BaseTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogFileTest extends BaseTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void logDeleteTest()throws InterruptedException {

        new UserPage(driver)
                .URL();
    }
}
