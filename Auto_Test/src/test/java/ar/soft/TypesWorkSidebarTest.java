package ar.soft;

import ar.soft.modelPage.TypesWorkSidebarPage;
import ar.soft.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TypesWorkSidebarTest extends BaseTest {

    @Test
    public void CreateTypesWork() {
        String Work = new TypesWorkSidebarPage(getDriver())
                .progect()
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
//        String AddWork =
        new TypesWorkSidebarPage(getDriver())
                .progect()
                .typesWorkSidebarClick()
                .btnAddTypesWorkClick()
                .btnCheckboxTypesWorkClick()
                .btnAddWorkClick();
    }

//    удалить редактиров поиск при добавление
}
