package ar.soft;

import ar.soft.modelPage.InspectSidebarPage;
import ar.soft.runner.BaseTest;
import org.testng.annotations.Test;

public class InspectSidebarTest extends BaseTest {

    @Test(priority = 1,
            description = "создать новую инспекцию")
    public void createInspect() {
         new InspectSidebarPage(getDriver())
                 .project()
                 .inspectSidebarClick()
                 .createInspectClick()
                 .inspectName()
                 .btncreateInspectClick()
                 .inspectTypesWork();
    }

    @Test(priority = 2,
            description = "переименовать инспекцию")
    public void renameInspect() {
        new InspectSidebarPage(getDriver())
                .project()
                .inspectSidebarClick()
                .inspectRename();

    }
}
