package ar.soft;

import ar.soft.modelPage.LibraryPage;
import ar.soft.modelPage.UserPage;
import ar.soft.runner.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class LibraryTest extends BaseTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void libraryClick() throws InterruptedException {

        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(5000);

        new LibraryPage(driver)
                .libraryClick();

//                .createUserClick()
//                .userName("админ проекта")
//                .userLastName("FamilyTest")
//                .userEmail("mikha-g@bk.ru")
//                .userEmailClick()
//                .userTimezoneClick()
//                .userTime("UTC + 00:00")
//                .userTimeEnter()
//                .userRolesClick()
//                .userRoles()
//                .userPassword("zxcvbnm123")
//                .userPasswordClick()
//                .buttonSave();
        Thread.sleep(5000);
        driver.quit();
    }

}
