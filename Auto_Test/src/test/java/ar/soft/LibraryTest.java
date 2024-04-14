package ar.soft;

import ar.soft.modelPage.LibraryPage;
import ar.soft.runner.BaseTest;
import org.junit.Assert;
//import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LibraryTest extends BaseTest {

    private By normativeDocText = By.xpath("//div[@class='ant-dropdown-trigger'][contains(.,'Не задано')]");



    @Test
    public void libraryChecListCreate() {
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
    }

    @Test
    public void libraryChecListImport() {
        new LibraryPage(driver)
                .libraryClick()
                .buttonChecklistRemove();

        WebElement input = driver.findElement(By.id("title"));
        input.click();
        input.sendKeys("id=title");
        input.sendKeys(Keys.ENTER);

        WebElement inputCategory = driver.findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']"));
        inputCategory.click();
        inputCategory.sendKeys("inputCategory");
//        inputCategory.sendKeys(Keys.ENTER);



        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();
        driver.findElement(By.xpath("//div[@class='ant-typography p_r'][contains(.,'Редактировать')]")).click();


//

//        driver.quit();
    }

    @Test
    public void libraryChecListDelete() {
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
    }



    @Test
    public void libraryChecListRemove() {
        new LibraryPage(driver)
                .libraryClick();
//                .buttonChecklistRemove();

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default secondaryButton " +
                "big colorPrimary Checklists__extraButtonChecklict-import']")).click();


        WebElement input = driver.findElement(By.id("title"));
        input.click();
        input.sendKeys("id=title");
        input.sendKeys(Keys.ENTER);

        WebElement inputCategory = driver.findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']"));
        inputCategory.click();
        inputCategory.sendKeys("inputCategory");
//        inputCategory.sendKeys(Keys.ENTER);



        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();


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

//        driver.quit();
    }



    @Test
    public void dashboardsTest() {

//        getWait5().until(ExpectedCondition.visibilityOfElementLocated(By.xpath("//a[@href='/library']"))).click();
//        WebElement actualdMessageText =  wait.until(ExpectedCondition.visi ((By.xpath("//a[@href='/library']")).click();
        driver.findElement(By.xpath("//a[@href='/library']")).click();

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary checklists__extraButtonChecklict-create']")).click();

        driver.findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']")).sendKeys("Название чеклиста");


        driver.findElement(By.xpath("//div[@class='CheckboxComponent__round-check']")).click();
        driver.findElement(By.xpath("//button[@class='CreateChecklist__addCategoryButton']")).click();



        driver.findElement(By.xpath("//textarea[@class='ant-input primaryInput  not-entered']")).sendKeys("Все организации");


        driver.findElement(By.xpath("//textarea[@class='ant-input primaryInput createCategoryModal__input not-entered']")).sendKeys("Все организации2");

        WebElement userRolesc2 = driver.findElement(By.xpath("//div[@class='createCategoryModal__buttonsPanel']//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary '][contains(.,'Отменить')]"));
        userRolesc2.click();

//        driver.findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']")).sendKeys("Название чеклиста");
//
//        driver.findElement(By.xpath("//div[@class='CheckboxComponent__round-check']")).click();
        driver.findElement(By.xpath("//button[@class='CreateChecklist__addCategoryButton']")).click();



        driver.findElement(By.xpath("//textarea[@class='ant-input primaryInput  not-entered']")).sendKeys("Все организации3");


        driver.findElement(By.xpath("//textarea[@class='ant-input primaryInput createCategoryModal__input not-entered']")).sendKeys("Все организации4");


//        WebElement userR2 = driver.findElement(By.xpath("//textarea[@class='ant-input primaryInput createCategoryModal__input not-entered']"));
//        userR2.click();

        driver.findElement(By.xpath("//div[@class='createCategoryModal__buttonsPanel']//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary '][contains(.,'Добавить')]")).click();
    }

    @Test
    public void normativeDocDeleteTest() {
        new LibraryPage(driver)
                .libraryClick();
        driver.findElement(By.xpath("//div[@id='rc-tabs-0-tab-3']")).click();
        driver.findElement(By.xpath("//img[@class='ant-dropdown-trigger Documentation__info-dropdownImg']")).click();
        driver.findElement(By.xpath("//div[@class='ant-typography p_r'][contains(.,'Удалить')]")).click();

        String normativeDoc = driver.findElement(normativeDocText).getText();

        Assert.assertEquals("Не задано", normativeDoc);
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();
    }
}
