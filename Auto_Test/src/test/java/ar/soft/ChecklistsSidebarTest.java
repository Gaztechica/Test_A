package ar.soft;

import ar.soft.modelPage.ChecklistsSidebarPage;
import ar.soft.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChecklistsSidebarTest extends BaseTest {

    // сообщение нет шага подтверждения удаления
    String nameChecklists = "новый чек-лист";


    @Test(priority = 1,
            description = "добавить чек-лист в проект")
    public void removeChecklistsProjectTest() {
        String newChecklistsText = new ChecklistsSidebarPage(getDriver())
                .project()
                .сhecklistsClick()
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
                .сhecklistsClick()
                .btnSearchChecklists()
                .inputSearchChecklists()
                .newChecklistsText();

        Assert.assertEquals(newsearchChecklistsText, "ЧЛ/021 - Система отопления");
    }

    @Test(priority = 4,
            description = "удалить чек-лист из проекта")
    public void deleteChecklistsProjectTest() throws InterruptedException {
        String delWork = new ChecklistsSidebarPage(getDriver())
                .project()
                .сhecklistsClick()
                .btnRemoveChecklistsClick()
                .selectDeleteChecklistsClick()
                .btnDeleteСonfirmChecklists()
                .getMessageDeleteChecklistsText();

        Assert.assertEquals(delWork, "Чек-лист успешно удален из проекта");
    }

    @Test(priority = 3,
            description = "отменить удалить Чек-лист")
    public void cancelDeleteChecklistsProjectTest() throws InterruptedException {
        new ChecklistsSidebarPage(getDriver())
//        String delWork = new ChecklistsSidebarPage(getDriver())
                .project()
                .сhecklistsClick()
                .btnRemoveChecklistsClick()
                .selectDeleteChecklistsClick()
                .btnDeleteCancelChecklists();

//        Assert.assertEquals(delWork, "владимир");
    }

    @Test(priority = 5,
            description = "редактировать Чек-лист")
    public void removeChecklistsProjectTest2() throws InterruptedException {
        String newNameChecklistsText = new ChecklistsSidebarPage(getDriver())
//        ChecklistsSidebarPage checklistsSidebarPage = new ChecklistsSidebarPage(getDriver())

//        checklistsSidebarPage.driver.referenceField.enterTextFromTextBox("12");

                .project()
                .сhecklistsClick()
                .btnRemoveChecklistsClick()
                .dropRemoveChecklistsClick()
                .newNameChecklistsClick(nameChecklists)
                .inputNewNameChecklistsClick()
                .categoryItemNameClick("Соответствие проектной документации")
                .btnSaveChecklistsClick()
                .getNewChecklistsText();

        Assert.assertEquals(newNameChecklistsText, nameChecklists + " Remove Name");
    }

//    @Test(priority = 8,
//            description = "удалить Чек-лист")
//    public void deleteChecklistsProjectTest2() throws InterruptedException {
////        new TypesWorkSidebarPage(getDriver())
//        String delChecklistsText = new ChecklistsSidebarPage(getDriver())
//                .project()
//                .сhecklistsClick()
//                .btnRemoveChecklistsClick()
//                .dropDeleteChecklistsClick()
//                .btnSetDeleteChecklistsClick()
//                .getMessageDeleteChecklistsText();
//
//        Assert.assertEquals(delChecklistsText, "Чек-лист успешно удален из проекта");
//    }

    @Test(priority = 7,
            description = "множественное добавление Чек-лист в проект через поиск")
    public void pluralChecklistsProjectTest() throws InterruptedException {
//        new TypesWorkSidebarPage(getDriver())
        String Work = new ChecklistsSidebarPage(getDriver())
                .project()
                .сhecklistsClick()
                .btnAddChecklists()
                .pluralChecklistsClick()
                .btnAddChecklistsClick()
                .getNewChecklistsText();

        Assert.assertEquals(Work, nameChecklists);
    }

    @Test(priority = 5,
            description = "редактировать ПКМ Чек-лист")
    public void removePKMChecklistsProjectTest() throws InterruptedException {
//        new TypesWorkSidebarPage(getDriver())
        String delChecklistsText = new ChecklistsSidebarPage(getDriver())
                .project()
                .сhecklistsClick()
                .btnRemovePRMChecklistsClick()
                .dropRemoveChecklistsClick()
                .newNameChecklistsClick(nameChecklists)
                .getNewChecklistsText();

        Assert.assertEquals(delChecklistsText, nameChecklists);
    }

    @Test(priority = 10,
            description = "удалить ПКМ Чек-лист")
    public void deletePKMChecklistsProjectTest() throws InterruptedException {
//        new TypesWorkSidebarPage(getDriver())
        String delChecklistsText = new ChecklistsSidebarPage(getDriver())
                .project()
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
//        new TypesWorkSidebarPage(getDriver())
        String delChecklistsText = new ChecklistsSidebarPage(getDriver())
                .project()
                .сhecklistsClick()
                .pluralChecklistsClick()
                .deleteBasketChecklistsClick()
                .btnSetDeleteChecklistsClick()
                .getMessageDeleteChecklistsText();

        Assert.assertEquals(delChecklistsText, "Чек-лист успешно удален из проекта");
    }

    @Test(priority = 7,
            description = "поиск Чек-лист")
    public void searchChecklistsProjectTest2() throws InterruptedException {
//        new TypesWorkSidebarPage(getDriver())
        String Work = new ChecklistsSidebarPage(getDriver())
                .project()
                .сhecklistsClick()
                .search(nameChecklists)
                .getNewChecklistsText();

        Assert.assertEquals(Work, nameChecklists);
    }
}
