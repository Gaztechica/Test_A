package ar.soft;

import ar.soft.modelPage.TypesWorkSidebarPage;
import ar.soft.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TypesWorkSidebarTest extends BaseTest {

    @Test
    public void CreateTypesWork() {
        String Work = new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick()
                .btnCreateTypesWorkClick()
                .inputNameTypesWorkClick()
                .unitMeasurementClick()
                .btnSubmitTypesWorkClick()
                .getNewWorkText();

        Assert.assertEquals(Work, "CreateTypeOfWorkModal_name");
    }

    @Test
    public void AddTypesWork() {
//        String AddWork = new TypesWorkSidebarPage(getDriver())
        new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick()
                .btnAddTypesWorkClick()
                .btnCheckboxTypesWorkClick()
                .btnAddWorkClick();

//        Assert.assertEquals(AddWork, "CreateTypeOfWorkModal_name");

    }

//    удалить редактиров поиск при добавление
}
