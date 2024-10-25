package ar.soft;

import ar.soft.modelPage.ProjctPage;
import ar.soft.runner.BaseTest;
import org.junit.Assert;
//import org.junit.Test;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    private final By NEW_PROJEСT_NAME_TEXT = By.xpath("//div[@class='Sidebar__project-name'][contains(.,'11AAНовый проект')]");


    // ============================== Проект создание/удаление ==================================

    @Test(priority = 1,
            description = "Проект - создание")
    public void createProgect() {
        new ProjctPage(driver)
                .btnCreateProgect();
        driver.findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']")).sendKeys("11AAНовый проект");
        driver.findElement(By.xpath("//input[@id='CreateProjectForm_city']")).sendKeys("Самара");
        driver.findElement(By.xpath("//input[@id='CreateProjectForm_country']")).sendKeys("РФ");
        driver.findElement(By.xpath("//textarea[@id='CreateProjectForm_street']")).sendKeys("Победы");
        driver.findElement(By.xpath("//input[@id='CreateProjectForm_postalCode']")).sendKeys("444444");
        driver.findElement(By.xpath("//input[@id='CreateProjectForm_code']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@id='CreateProjectForm_building']")).sendKeys("121");
        driver.findElement(By.xpath("//input[@id='CreateProjectForm_office']")).sendKeys("117");
        driver.findElement(By.xpath("//input[@id='CreateProjectForm_startDate']")).click();

        WebElement NewData = driver.findElement(By.xpath("//a[@class='ant-picker-today-btn']"));
        NewData.click();

        WebElement EndData = driver.findElement(By.xpath("//input[@id='CreateProjectForm_endDate']"));
        EndData.sendKeys("26-11-2024");
        EndData.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();

        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r']")).click();

//       кнопка отмены
//        WebElement textBoxAside = driver.findElement(By.xpath("//button[@class='Sidebar__collapsibleBtn']"));
//        textBoxAside.click();

        WebElement textSection = driver.findElement(By.xpath("//a[@style='color: inherit;'][contains(.,'Настройки')]"));
        textSection.click();

        String newProgectName = driver.findElement(NEW_PROJEСT_NAME_TEXT).getText();

        Assert.assertEquals("11AAНовый проект", newProgectName);

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorRed ']")).click();
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(.,'Подтвердить')]")).click();
    }

    @Test(priority = 2,
            description = "Проект - отмена создания")
    public void cancelCreateProgectTest() {
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();
        driver.findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']")).sendKeys("11AAНовый проект");
        driver.findElement(By.xpath("//input[@id='CreateProjectForm_city']")).sendKeys("Самара");
        driver.findElement(By.xpath("//input[@id='CreateProjectForm_country']")).sendKeys("РФ");
        driver.findElement(By.xpath("//textarea[@id='CreateProjectForm_street']")).sendKeys("Победы");
        driver.findElement(By.xpath("//input[@id='CreateProjectForm_postalCode']")).sendKeys("444444");
        driver.findElement(By.xpath("//input[@id='CreateProjectForm_code']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@id='CreateProjectForm_building']")).sendKeys("121");
        driver.findElement(By.xpath("//input[@id='CreateProjectForm_office']")).sendKeys("117");
        driver.findElement(By.xpath("//input[@id='CreateProjectForm_startDate']")).click();
        driver.findElement(By.xpath("//a[@class='ant-picker-today-btn']")).click();

        WebElement EndData = driver.findElement(By.xpath("//input[@id='CreateProjectForm_endDate']"));
        EndData.sendKeys("26-09-2024");
        EndData.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary '][contains(.,'Отменить')]")).click();
    }

    @Test(priority = 3,
            description = "Проект - создание")
    public void sidebarProgect() {
        new ProjctPage(driver)
                .btnCreateProgect();
        driver.findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']")).sendKeys("11AAНовый проект");
        driver.findElement(By.xpath("//input[@id='CreateProjectForm_city']")).sendKeys("Самара");
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary '][contains(.,'Отменить')]")).click();

        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r']")).click();
        driver.findElement(By.xpath("//button[@class='Sidebar__collapsibleBtn']")).click();

        driver.findElement(By.xpath("//div[@class='Sidebar__admin']")).click();
        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r']")).click();
        driver.findElement(By.xpath("//button[@class='Sidebar__collapsibleBtn']")).click();

        driver.findElement(By.xpath("//div[@class='Sidebar__project']//button[@class='ant-btn ant-btn-default iconButton small colorPrimary ']")).click();
        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r']")).click();
        driver.findElement(By.xpath("//div[@class='CustomLogo']")).click();
    }

    @Test(priority = 4,
            description = "Проект - переименование проекта")
    public void removeProgect() {
        new ProjctPage(driver)
                .btnCreateProgect();
        driver.findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']")).sendKeys("1Новый проект");
        driver.findElement(By.xpath("//input[@id='CreateProjectForm_city']")).sendKeys("Самара");
//
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary '][contains(.,'Отменить')]")).click();

//        driver.findElement(By.xpath("(//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'])[2]")).click();
//        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r']")).click();
//        driver.findElement(NEW_PROJEСT_NAME_TEXT).click();
//        driver.findElement(By.xpath("//div[@class='CustomLogo']")).click();


        driver.findElement(By.xpath("//*[@id=\"CreateProjectForm_country\"]")).sendKeys("РФ");
        driver.findElement(By.xpath("//*[@id=\"CreateProjectForm_street\"]")).sendKeys("Победы");
        driver.findElement(By.xpath("//*[@id=\"CreateProjectForm_postalCode\"]")).sendKeys("444444");
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();

//        driver.findElement(By.xpath("//div[@class='Sidebar__admin']")).click();
//        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r']")).click();
//        driver.findElement(By.xpath("//button[@class='Sidebar__collapsibleBtn']")).click();
//        driver.findElement(By.xpath("//div[@class='Sidebar__project']//button[@class='ant-btn ant-btn-default iconButton small colorPrimary ']")).click();
    }



    //     редактирование/удаление


    // ================================== пагинация =====================================================

    // нет изменения кол-ва строк на странице
//    @Test
//    public void projectTest() {

//        Select simpl = new Select(selectWithoutMultiple);
//        simpl.selectByValue("two");
//        String newValue = selectWithoutMultiple.getAttribute("value");


//        elemPage.sendKeys(Keys.ARROW_DOWN);
//        elemPage.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//        elemPage.sendKeys(Keys.ENTER);

//         WebElement elemPage2 = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][@title='50']"));
//
//         elemPage2.click();
//
//         Thread.sleep(1000);

//         WebElement elemPagve = driver.findElement(By.xpath("//span[@class='ant-select-selection-search']"));
//
//         elemPagve.click();
//
//         Thread.sleep(1000);
//
//         WebElement elemPageFift = driver.findElement(By.xpath("//span[@class='ant-select-arrow']"));
//
//         elemPageFift.click();
//
//         Thread.sleep(1000);

//         WebElement elemPageFifty = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'10')]"));
//
//         elemPageFifty.click();
//
//         Thread.sleep(8000);

//         WebElement elemPageOne = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'50')]"));
//
//         elemPageOne.click();
//
//         Thread.sleep(1000);
//
//         WebElement elemPageOneN = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'10')]"));
//
//         elemPageOneN.click();
//
//         Thread.sleep(1000);
//         WebElement textBoxCountry = driver.findElement(By.xpath("//*[@id=\"CreateProjectForm_country\"]"));
//
//         textBoxCountry.sendKeys("РФ");
//
//
//         WebElement textBoxStreet = driver.findElement(By.xpath("//*[@id=\"CreateProjectForm_street\"]"));
//
//         textBoxStreet.sendKeys("Победы");
//
//         WebElement textBoxPostalCode = driver.findElement(By.xpath("//*[@id=\"CreateProjectForm_postalCode\"]"));
//
//         textBoxPostalCode.sendKeys("444444");
//
//         WebElement submitButtonCreateProject = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']"));
//
//         submitButtonCreateProject.click();
//         driver.quit();
//         Thread.sleep(5000);
//    }



//=============================================================



//    ========================================   =======================================
//

//


}
