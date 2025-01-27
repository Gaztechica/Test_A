package ar.soft;

import ar.soft.modelPage.ChecklistsSidebarPage;
import ar.soft.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChecklistsSidebarTest extends BaseTest {

    @Test(priority = 1,
            description = "добавить чек-лист в проект")
    public void removeProjectTest() {
        String newChecklistsText = new ChecklistsSidebarPage(getDriver())
                .project()
                .ChecklistsClick()
                .btnAddChecklists()
                .inputNameChecklists()
                .btnCheckboxChecklists()
                .btnAddNewChecklists()
                .newChecklistsText();

        Assert.assertEquals(newChecklistsText, "ЧЛ/021 - Система отопления");
    }
}
