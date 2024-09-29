package ar.soft;

import ar.soft.modelPage.InspectSidebarPage;
import ar.soft.runner.BaseTest;
import org.testng.annotations.Test;

public class InspectSidebarTest extends BaseTest {

    @Test(priority = 1,
            description = "создание пользователя с ролью админ")
    public void createInspect() {
         new InspectSidebarPage(getDriver())
                 .project()
                 .inspectSidebarClick()
                 .createInspectClick()
                 .inspectName()
                 .btncreateInspectClick();
    }


}
