package ar.soft;

import ar.soft.modelPage.TypesWorkSidebarPage;
import ar.soft.runner.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TypesWorkSidebarTest extends BaseTest {

    @Test(priority = 1,
            description = "создание вида работ")
    public void createTypesWork() {
        String Work = new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick()
                .btnCreateTypesWorkClick()
                .inputNameTypesWorkClick()
                .unitMeasurementClick()
                .btnSubmitTypesWorkClick()
                .getNewWorkText();

        Assert.assertEquals(Work, "CreateTypeOfWork");
    }

    @Test(priority = 2,
            description = "добавление вида работ в проект через поиск")
    public void addTypesWork() {

        new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick()
                .btnAddTypesWorkClick()
                .searchWorkText()
                .btnCheckboxTypesWorkClick()
                .btnAddWorkClick()
                .getNewWorkText();;

        Assert.assertEquals("владимир", "владимир");

    }

//    удалить редактиров поиск при добавление

    @Test(priority = 3,
            description = "отменить удалить вид работ")
    public void cancelDeleteTypesWork() {
       new TypesWorkSidebarPage(getDriver())
//        String delWork = new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick()
                .btnRemoveTypesWorkClick()
                .dropDeleteTypesWorkClick()
                .btnCancelDeleteTypesWorkClick();

//        Assert.assertEquals(delWork, "владимир");
    }

    @Test(priority = 4,
            description = "редактировать вид работ")
    public void removeTypesWork() {
        String newNameWork = new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick()
                .btnRemoveTypesWorkClick()
                .dropRemoveTypesWorkClick()
                .clerNameTypesWorkClick()
                .inputNewNameTypesWorkClick()
                .unitRemoveMeasurementClick()
                .btnSubmitTypesWorkClick()
                .getNewWorkText();

        Assert.assertEquals(newNameWork, "владимир Remove Name");
    }

    @Test(priority = 5,
            description = "удалить вид работ")
    public void deleteTypesWork() {
        new TypesWorkSidebarPage(getDriver())
//        String delWork = new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick()
                .btnRemoveTypesWorkClick()
                .dropDeleteTypesWorkClick()
                .btnSetDeleteTypesWorkClick();

//        Assert.assertEquals(delWork, "владимир");
    }

    @Test(priority = 6,
            description = "удалить ПКМ вид работ")
    public void deletePKMTypesWork() {
        new TypesWorkSidebarPage(getDriver())
//        String delWork = new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick();
//                .btnRemovePRMTypesWorkClick();
//        actions.contextClick(btnElement).perform();
        new Actions(getDriver()).contextClick((WebElement) By.xpath("//div[@class='ant-dropdown-trigger'][contains(., '1')]")).perform();

//        new Actions(driver).contextClick(driver.findElement(By.xpath("//div[@class='ant-dropdown-trigger'][contains(., '1')]"));
        new TypesWorkSidebarPage(getDriver())
                .dropDeletePKMTypesWorkClick()
                .btnSetDeleteTypesWorkClick();

//        Assert.assertEquals(delWork, "владимир");
    }
}
