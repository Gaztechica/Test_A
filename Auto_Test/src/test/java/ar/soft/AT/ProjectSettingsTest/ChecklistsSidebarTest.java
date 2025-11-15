package ar.soft.AT.ProjectSettingsTest;

import ar.soft.element.ActionT;
import ar.soft.modelPage.ProjectSettingsPage.ChecklistsSidebarPage;
import ar.soft.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static ar.soft.element.ActionT.OneClick.clickAndHold;

public class ChecklistsSidebarTest extends BaseTest {

    // сообщение нет шага подтверждения удаления
    String nameChecklists = "новый чек-лист";
    String checklists = "ЧЛ/021 - Система отопления";

    @Test(priority = 1,
            description = "добавить чек-лист в проект")
    public void removeChecklistsProjectTest() throws InterruptedException {
        String newChecklistsText = new ChecklistsSidebarPage(getDriver())
                .project()
                .settingsSidebarClick()
                .сhecklistsClick()
                .btnAddChecklists()
                .inputNameChecklists(checklists)
                .btnCheckboxChecklists()
                .btnAddNewChecklists()
                .newChecklistsText();

        Assert.assertEquals(newChecklistsText, checklists);
    }

    @Test(priority = 3,
            description = "поиск чек-листа в проекте")
    public void searchChecklistsProjectTest() throws InterruptedException {
        String newsearchChecklistsText = new ChecklistsSidebarPage(getDriver())
                .project()
                .settingsSidebarClick()
                .сhecklistsClick()
                .btnSearchChecklists()
                .inputSearchChecklists()
                .newChecklistsText();

        Assert.assertEquals(newsearchChecklistsText, checklists);
    }

    @Test(priority = 6,
            description = "удалить чек-лист из проекта")
    public void deleteChecklistsProjectTest() throws InterruptedException {
        String delWork = new ChecklistsSidebarPage(getDriver())
                .project()
                .settingsSidebarClick()
                .сhecklistsClick()
                .btnRemoveChecklistsClick()
                .selectDeleteChecklistsClick()
                .btnDeleteСonfirmChecklists()
                .getMessageDeleteChecklistsText();

        Assert.assertEquals(delWork, "Чек-лист успешно удален из проекта");
    }

    @Test(priority = 2,
            description = "отменить удалить Чек-лист")
    public void cancelDeleteChecklistsProjectTest() throws InterruptedException {
        new ChecklistsSidebarPage(getDriver())
//        String delWork = new ChecklistsSidebarPage(getDriver())
                .project()
                .settingsSidebarClick()
                .сhecklistsClick()
                .btnRemoveChecklistsClick()
                .selectDeleteChecklistsClick()
                .btnDeleteCancelChecklists();

//        Assert.assertEquals(delWork, "владимир");
    }

    @Test(priority = 4,
            description = "редактировать Чек-лист")
    public void removeChecklistsProjectTest3() throws InterruptedException {
        new ChecklistsSidebarPage(getDriver())
                .project()
                .settingsSidebarClick()
                .сhecklistsClick()
                .btnRemoveChecklistsClick()
                .dropRemoveChecklistsClick();
        ChecklistsSidebarPage checklistsSidebarPage = new ChecklistsSidebarPage(getDriver());
        ActionT.OneClick.clickAndEnterTextDeleteLineBreak(checklistsSidebarPage.newNameChecklistsClick2, nameChecklists + " Remove Name");
        String delWork = new ChecklistsSidebarPage(getDriver())
                .categoryItemNameClick("Соответствие проектной документации")
                .btnSaveChecklistsClick()
                .getNewChecklistsText();

        Assert.assertEquals(delWork, nameChecklists + " Remove Name");
    }


    @Test(priority = 7,
            description = "множественное добавление Чек-лист в проект через поиск")
    public void pluralChecklistsProjectTest() throws InterruptedException {
        String Work = new ChecklistsSidebarPage(getDriver())
                .project()
                .settingsSidebarClick()
                .сhecklistsClick()
                .btnAddChecklists()
                .pluralChecklistsClick()
                .btnAddChecklistsClick()
                .getMessageDeleteChecklistsText();

        Assert.assertEquals(Work, "Чек-листы успешно удалены в проект");
    }

    @Test(priority = 5,
            description = "редактировать ПКМ Чек-лист")
    public void removePKMChecklistsProjectTest() throws InterruptedException {
        new ChecklistsSidebarPage(getDriver())
                .project()
                .settingsSidebarClick()
                .сhecklistsClick()
                .btnRemovePRMChecklistsClick()
                .dropRemoveChecklistsClick();
        ChecklistsSidebarPage checklistsSidebarPage = new ChecklistsSidebarPage(getDriver());
        ActionT.OneClick.clickAndEnterTextDeleteLineBreak(checklistsSidebarPage.newNameChecklistsClick2, nameChecklists + " Remove Name");
        String delWork = new ChecklistsSidebarPage(getDriver())
                .btnSaveChecklistsClick()
                .getNewChecklistsText();

        Assert.assertEquals(delWork, nameChecklists + " Remove Name");
    }

    @Test(priority = 10,
            description = "удалить ПКМ Чек-лист")
    public void deletePKMChecklistsProjectTest() throws InterruptedException {
        String delChecklistsText = new ChecklistsSidebarPage(getDriver())
                .project()
                .settingsSidebarClick()
                .сhecklistsClick()
                .dropDeletePKMChecklistsClick()
                .selectDeleteChecklistsClick()
                .btnSetDeleteChecklistsClick()
                .getMessageDeleteChecklistsText();

        Assert.assertEquals(delChecklistsText, "Чек-лист успешно удален из проекта");
    }

    @Test(priority = 9,
            description = "множественное удаление через кнопку корзина Чек-лист")
    public void deleteBasketChecklistsProjectTest() throws InterruptedException {
        String delChecklistsText = new ChecklistsSidebarPage(getDriver())
                .project()
                .settingsSidebarClick()
                .сhecklistsClick()
                .pluralChecklistsClick()
                .deleteBasketChecklistsClick()
                .btnSetDeleteChecklistsClick()
                .getMessageDeleteChecklistsText();

        Assert.assertEquals(delChecklistsText, "Чек-листы успешно удалены из проекта");
    }

    @Test(priority = 8,
            description = "поиск Чек-лист")
    public void searchChecklistsProjectTest2() throws InterruptedException {
        String Work = new ChecklistsSidebarPage(getDriver())
                .project()
                .settingsSidebarClick()
                .сhecklistsClick()
                .search(nameChecklists + " Remove Name")
                .getNewChecklistsText();

        Assert.assertEquals(Work, nameChecklists + " Remove Name");
    }
}
