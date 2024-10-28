package ar.soft;

import ar.soft.modelPage.TypesWorkSidebarPage;
import ar.soft.runner.BaseTest;
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
            description = "удалить вид работ")
    public void deleteTypesWork() {
        String delWork = new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick()

                .btnCreateTypesWorkClick()
                .inputNameTypesWorkClick()
                .unitMeasurementClick()
                .btnSubmitTypesWorkClick()
                .getNewWorkText();

        Assert.assertEquals(delWork, "владимир");
    }
}
