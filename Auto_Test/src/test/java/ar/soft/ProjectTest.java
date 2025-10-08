package ar.soft;

import ar.soft.modelPage.ProjectPage;
import ar.soft.runner.BaseTest;
//import org.junit.Assert;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.qa.elements.Button;
import ru.qa.methods.WaitT;

import static java.lang.Character.getName;


public class ProjectTest extends BaseTest {

    private final By NEW_PROJEСT_NAME_TEXT = By.xpath("//div[@class='Sidebar__project-name'][contains(.,'11AAНовый проект')]");

    @Test(priority = 1,
            description = "Проект - создание")
    public void createProject() {
        String newProgectName = new ProjectPage(driver)
                .logoProject()
                .btnCreateProject()
                .inputNameProject()
                .inputCityProject()
                .inputCountryProject()
                .inputStreetProject()
                .inputPostalCodeProject()
                .inputCodeProject()
                .inputBuildingProject()
                .inputOfficeProject()
                .inputStartDateProject()
                .inputEndDateProject()
                .addProject()
                .addProjectText();

        Assert.assertEquals("Проект успешно создан", newProgectName);
    }

    @Test(//retryAnalyzer = RetryAnalyzer.class,
            priority = 2,
            description = "Проект - отмена создания")
    public void cancelCreateProjectTest() {
        new ProjectPage(driver)
                .logoProject()
                .btnCreateProject()
                .inputNameProject()
                .inputCityProject()
                .inputCountryProject()
                .inputStreetProject()
                .inputPostalCodeProject()
                .inputCodeProject()
                .inputBuildingProject()
                .inputOfficeProject()
                .inputStartDateProject()
                .inputEndDateProject()
                .cancelProject();
    }

//        String newProgectName = driver.findElement(NEW_PROJEСT_NAME_TEXT).getText();

    @Test(priority = 3,
            description = "Проект - переименование проекта")
    public void removeProject() {
        new ProjectPage(driver)
                .btnCreateProject();

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

    @Test(priority = 5,
            description = "Проект - проверка открытие проекта")
    public void openProject() {
        String proj = new ProjectPage(getDriver())
                .project()
                .sidebarProject()
                .sidebarProjectText();

        org.testng.Assert.assertEquals(proj, "11AAНовый проект");
    }

    @Test(priority = 6,
            description = "Завершение Проекта")
    public void completedProject() {

        String sendProject = new ProjectPage(getDriver())
//                .project()
                .ellipsisProject()
                .ellipsisProjectClick()
                .inputPasswordProject()
                .sendProjectText();

        Assert.assertEquals(sendProject, "Проект успешно завершен");
    }

    @Test(priority = 7,
            description = "Восстановить Проект")
    public void restoreProject() throws InterruptedException {

        String sendProject = new ProjectPage(getDriver())
                .restoreProjectClick()
                .ellipsisProject()
                .ellipsisProjectClick()
                .ellipsisProjectClick2()
                .sendProjectText2();

        Assert.assertEquals(sendProject, "Проект успешно восстановлен");
    }

    @Test(priority = 8,
            description = "Завершение Проекта ПКМ")
    public void completedPKMProject() {

        String sendProject = new ProjectPage(getDriver())
//                .project()
//                .ellipsisProject()
                .restorePKMProjectClick()
                .ellipsisProjectClick()
                .inputPasswordProject()
                .sendProjectText();

        Assert.assertEquals(sendProject, "Проект успешно завершен");
    }

    @Test(priority = 9,
            description = "Восстановить Проект ПКМ")
    public void restorePKMProject() throws InterruptedException {

        String sendProject = new ProjectPage(getDriver())
                .restoreProjectClick()
                .ellipsisPKMProjectClick()
                .ellipsisProjectClick()
                .ellipsisProjectClick2()
                .sendProjectText2();

        Assert.assertEquals(sendProject, "Проект успешно восстановлен");
    }

    @Test(priority = 22,
            description = "Проект - поиск проекта")
    public void searcherProject() {
        String projl = new ProjectPage(getDriver())
                .logoProject()
//                .searchProject()
                .selectCompletedClick()
                .inputSearchNameProject()
                .searchProjectText();


        Assert.assertEquals(projl, "админ");
    }

//    @Test(priority = 7,
//            description = "Проект - поиск проекта")
//    public void selectCompletedProject() {
//        ProjectPage projectPage = new ProjectPage(getDriver());
//        projectPage.selectCompletedClick.
////                ActionT.OneClick.clickClearEnterValue2(iTableComponentPropertiesPage.blueEditorTextBox, "10");
//        projectPage.selectCompletedClick.clickElement();
//
////        Assert.assertEquals(projl, "админ");
//    }




    //     редактирование/удаление\цвет кнопки \ цвет строки при наведении \

//    @Test(priority = 3,
//            description = "Проект - создание")
//    public void sidebarProject() {
//        new ProjectPage(driver)
//                .logoProject()
//                .btnCreateProject();
//        driver.findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']")).sendKeys("11AAНовый проект");
//        driver.findElement(By.xpath("//input[@id='CreateProjectForm_city']")).sendKeys("Самара");
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary '][contains(.,'Отменить')]")).click();
//
//        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r']")).click();
//        driver.findElement(By.xpath("//button[@class='Sidebar__collapsibleBtn']")).click();
//
//        driver.findElement(By.xpath("//div[@class='Sidebar__admin']")).click();
//        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r']")).click();
//        driver.findElement(By.xpath("//button[@class='Sidebar__collapsibleBtn']")).click();
//
//        driver.findElement(By.xpath("//div[@class='Sidebar__project']//button[@class='ant-btn ant-btn-default iconButton small colorPrimary ']")).click();
//        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r']")).click();
//        driver.findElement(By.xpath("//div[@class='CustomLogo']")).click();
//    }

//    driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorRed ']")).click();
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(.,'Подтвердить')]")).click();
// driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r']")).click();

//       кнопка отмены
//        WebElement textBoxAside = driver.findElement(By.xpath("//button[@class='Sidebar__collapsibleBtn']"));
//        textBoxAside.click();

//    WebElement textSection = driver.findElement(By.xpath("//a[@style='color: inherit;'][contains(.,'Настройки')]"));
//        textSection.click();
//        WebElement NewData = driver.findElement(By.xpath("//a[@class='ant-picker-today-btn']"));
//        NewData.click();
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



}
