package ar.soft;

import ar.soft.modelPage.ChecklistsSidebarPage;
import ar.soft.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChecklistsSidebarTest extends BaseTest {

    // сообщение нет шага подтверждения удаления
    @Test(priority = 1,
            description = "добавить чек-лист в проект")
    public void removeChecklistsProjectTest() {
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

    @Test(priority = 2,
            description = "поиск чек-листа в проекте")
    public void searchChecklistsProjectTest() {
        String newsearchChecklistsText = new ChecklistsSidebarPage(getDriver())
                .project()
                .ChecklistsClick()
                .btnSearchChecklists()
                .inputSearchChecklists()
                .newChecklistsText();

        Assert.assertEquals(newsearchChecklistsText, "ЧЛ/021 - Система отопления");
    }

    @Test(priority = 3,
            description = "удалить чек-лист из проекта")
    public void deleteChecklistsProjectTest() {
        String newChecklistsText = new ChecklistsSidebarPage(getDriver())
                .project()
                .ChecklistsClick()
                .btnSearchChecklists()
                .inputSearchChecklists()
                .btnCheckboxChecklists2()
                .btnDeleteChecklists()
                .newChecklistsText();

        Assert.assertEquals(newChecklistsText, "ЧЛ/021 - Система отопления");
    }
}
