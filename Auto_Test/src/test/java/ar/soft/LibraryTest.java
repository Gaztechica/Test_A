//package ar.soft;
//
//import ar.soft.modelPage.LibraryPage;
//import ar.soft.runner.BaseTest;
//import org.junit.Test;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class LibraryTest extends BaseTest {
//
//    WebDriver driver = new ChromeDriver();
//
//    @Test
//    public void libraryChecListCreate() throws InterruptedException {
//        new LibraryPage(driver)
//                .login();
//        new LibraryPage(driver)
//                .libraryClick()
//                .buttonChecListCreateClick()
//                .inputChecListNameClick()
//                .inputChecListNameSent()
//                .buttonChecklistAddCategory()
//                .inputChecListPrimaryClick()
//                .inputChecListPrimarySent()
//                .createCategoryChecList()
//                .createCategoryChecListSent()
//                .primaryButtonChecListCreateClick()
//                .buttonChecklistSubcategory()
//                .inputChecklistSubcateName()
//                .inputChecklistSubcateSent()
//                .inputChecklistCategorySubcateClick()
//                .inputChecklistCategorySubcateNameSent()
//                .buttonChecklistCategory()
//                .buttonChecklistAdd();
//
//        driver.quit();
//    }
//
//    @Test
//    public void libraryChecListDelete() throws InterruptedException {
//
//        new LibraryPage(driver)
//                .login();
//        new LibraryPage(driver)
//                .libraryClick()
//                .buttonChecListCreateClick()
//                .inputChecListNameClick()
//                .inputChecListNameSent()
//                .buttonChecklistAddCategory()
//                .inputChecListPrimaryClick()
//                .inputChecListPrimarySent()
//                .createCategoryChecList()
//                .createCategoryChecListSent()
//                .primaryButtonChecListCreateClick()
//                .buttonChecklistCategoryDelete()
//                .buttonChecklistCategoryDeleteClick();
////                .buttonChecklistSubcategory();
//
////                .buttonChecklistAdd();
//
////        driver.quit();
//    }
//
//    @Test
//    public void libraryChecListRemove() throws InterruptedException {
//
//        new LibraryPage(driver)
//                .login();
//        new LibraryPage(driver)
//                .libraryClick()
////        Thread.sleep(5000);
////        new  LibraryPage(driver)
//                .buttonChecklistRemove();
////        Thread.sleep(5000);
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default secondaryButton " +
//                "big colorPrimary Checklists__extraButtonChecklict-import']")).click();
//
////
////        Thread.sleep(3000);
//
//        WebElement input = driver.findElement(By.id("title"));
//        input.click();
//        input.sendKeys("id=title");
//        input.sendKeys(Keys.ENTER);
//
//        WebElement inputCategory = driver.findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']"));
//        inputCategory.click();
//        inputCategory.sendKeys("inputCategory");
////        inputCategory.sendKeys(Keys.ENTER);
//
////        Thread.sleep(3000);
//
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();
//
//
////                .buttonChecListCreateClick()
////                .inputChecListNameClick()
////                .inputChecListNameSent()
////                .buttonChecklistAddCategory()
////                .inputChecListPrimaryClick()
////                .inputChecListPrimarySent()
////                .createCategoryChecList()
////                .createCategoryChecListSent()
////                .primaryButtonChecListCreateClick()
////                .buttonChecklistSubcategory()
////                .inputChecklistSubcateName()
////                .inputChecklistSubcateSent()
////                .inputChecklistCategorySubcateClick()
////                .inputChecklistCategorySubcateNameSent()
////                .buttonChecklistCategory()
////                .buttonChecklistAdd();
//
////        driver.quit();
//    }
//
//    @Test
//    public void libraryChecListImport() throws InterruptedException {
//
//        new LibraryPage(driver)
//                .login();
////      Thread.sleep(11500);
//
//        new LibraryPage(driver)
//                .libraryClick();
//        Thread.sleep(5000);
//        new  LibraryPage(driver)
//                .buttonChecklistRemove();
//
//        Thread.sleep(3000);
//
//        WebElement input = driver.findElement(By.id("title"));
//        input.click();
//        input.sendKeys("id=title");
//        input.sendKeys(Keys.ENTER);
//
//        WebElement inputCategory = driver.findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']"));
//        inputCategory.click();
//        inputCategory.sendKeys("inputCategory");
////        inputCategory.sendKeys(Keys.ENTER);
//
//        Thread.sleep(3000);
//
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();
//        driver.findElement(By.xpath("//div[@class='ant-typography p_r'][contains(.,'Редактировать')]")).click();
//
//
////
//
////        driver.quit();
//    }
//
//
//}
