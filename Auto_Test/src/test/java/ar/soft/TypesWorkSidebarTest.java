package ar.soft;

import ar.soft.modelPage.TypesWorkSidebarPage;
import ar.soft.runner.BaseTest;
import org.testng.annotations.Test;

public class TypesWorkSidebarTest extends BaseTest {

    @Test
    public void CreateTypesWork() {
        new TypesWorkSidebarPage(getDriver())
                .progect()
                .typesWorkSidebarClick()
                .btnTypesWorkClick()
                .inputNameTypesWorkClick()
                .unitMeasurementClick()
                .btnSubmitTypesWorkClick();

    }
}
