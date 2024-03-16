package ar.soft;

import ar.soft.modelPage.LibraryPage;
import ar.soft.runner.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LibraryTest extends BaseTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void libraryChecListCreate() throws InterruptedException {

        driver.get(URL);
        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(10500);

        new LibraryPage(driver)
                .libraryClick()
                .buttonChecListCreateClick()
                .inputChecListNameClick()
                .inputChecListNameSent()
                .buttonChecklistAddCategory()
                .inputChecListPrimaryClick()
                .inputChecListPrimarySent()
                .createCategoryChecList()
                .createCategoryChecListSent()
                .primaryButtonChecListCreateClick()
                .buttonChecklistSubcategory()
                .inputChecklistSubcateName()
                .inputChecklistSubcateSent()
                .inputChecklistCategorySubcateClick()
                .inputChecklistCategorySubcateNameSent()
                .buttonChecklistCategory()
                .buttonChecklistAdd();

        driver.quit();
    }

    @Test
    public void libraryChecListDelete() throws InterruptedException {

        driver.get(URL);
        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(10500);

        new LibraryPage(driver)
                .libraryClick()
                .buttonChecListCreateClick()
                .inputChecListNameClick()
                .inputChecListNameSent()
                .buttonChecklistAddCategory()
                .inputChecListPrimaryClick()
                .inputChecListPrimarySent()
                .createCategoryChecList()
                .createCategoryChecListSent()
                .primaryButtonChecListCreateClick()
                .buttonChecklistCategoryDelete()
                .buttonChecklistCategoryDeleteClick();
//                .buttonChecklistSubcategory();



//                .buttonChecklistAdd();

//        driver.quit();
    }


}
