package ar.soft;

import ar.soft.modelPage.TypesWorkSidebarPage;
import ar.soft.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static ar.soft.TypesWorkSidebarTest.NAME_TYPES_WORK;

public class TypesWorkAdminTest extends BaseTest {

    @Test(priority = 1,
            description = "создание вида работ")
    public void createTypesWorkAdmin() throws InterruptedException {
        String Work = new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick()
                .btnCreateTypesWorkClick()
                .inputNameTypesWorkClick(NAME_TYPES_WORK)
                .unitMeasurementClick()
                .btnSubmitTypesWorkClick()
                .getNewWorkText();

        Assert.assertEquals(Work, NAME_TYPES_WORK);
    }
}
