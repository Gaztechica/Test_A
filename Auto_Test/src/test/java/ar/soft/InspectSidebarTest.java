package ar.soft;

import ar.soft.modelPage.InspectSidebarPage;
import ar.soft.runner.BaseTest;
import org.testng.annotations.Test;

public class InspectSidebarTest extends BaseTest {

    @Test
    public void createInspect() {
         new InspectSidebarPage(getDriver())
                 .progect()
                 .inspectSidebarClick()
                 .createInspectClick()
                 .inspectName()
                 .btncreateInspectClick();
    }


}
