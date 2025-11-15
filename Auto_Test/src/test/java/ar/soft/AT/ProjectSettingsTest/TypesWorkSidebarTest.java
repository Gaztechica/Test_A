package ar.soft.AT.ProjectSettingsTest;

import ar.soft.modelPage.ProjectSettingsPage.TypesWorkSidebarPage;
import ar.soft.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TypesWorkSidebarTest extends BaseTest {

    //добавить тесты вид работ создан, изменен .....
//         сортировка смена цвета стрелки и смена значений

    public final static String NAME_TYPES_WORK = "новый вид работ";
    public final static String RENAME_TYPES_WORK = "переименованный вид работ";
    public final static String NAME_TYPES_WORK2 = "вид работ";
    public final static String NAME_TYPES_WORK3 = "создание вида работ";

    @Test(priority = 1,
            description = "добавление вида работ")
    public void addCheckboxTypesWork() throws InterruptedException {
        String Work = new TypesWorkSidebarPage(getDriver())
                .project()
                .settingsSidebarClick()
                .typesWorkSidebarClick()
                .btnAddTypesWorkClick()
                .btnCheckboxAddTypesWorkClick()
                .btnSubmitTypesWorkClick()
                .getNewWorkText();

        Assert.assertEquals(Work, NAME_TYPES_WORK);
    }

    @Test(priority = 2,
            description = "отменить удалить вид работ")
    public void cancelDeleteTypesWork() throws InterruptedException {
//        new TypesWorkSidebarPage(getDriver())
        String delWork = new TypesWorkSidebarPage(getDriver())
                .project()
                .settingsSidebarClick()
                .typesWorkSidebarClick()
                .btnRemoveTypesWorkClick()
                .dropDeleteTypesWorkClick()
                .btnCancelDeleteTypesWorkClick()
                .getNewWorkText();

        Assert.assertEquals(delWork, NAME_TYPES_WORK);
    }

    @Test(priority = 3,
            description = "редактировать вид работ")
    public void removeTypesWork() throws InterruptedException {
        String newNameWork = new TypesWorkSidebarPage(getDriver())
                .project()
                .settingsSidebarClick()
                .typesWorkSidebarClick()
                .btnRemoveTypesWorkClick()
                .dropRemoveTypesWorkClick()
                .clearNameTypesWorkClick()
                .inputNewNameTypesWorkClick()
                .unitRemoveMeasurementClick(RENAME_TYPES_WORK)
                .getRenameWorkText();

        Assert.assertEquals(newNameWork, RENAME_TYPES_WORK);
    }

        @Test(priority = 4,
            description = "удалить ПКМ вид работ")
    public void deletePKMTypesWork() throws InterruptedException {
//        new TypesWorkSidebarPage(getDriver())
        String delWork = new TypesWorkSidebarPage(getDriver())
                .project()
                .settingsSidebarClick()
                .typesWorkSidebarClick()
                .dropDeletePKMTypesWorkClick()
                .selectDeleteTypesWorkClick()
                .btnSetDeleteTypesWorkClick()
                .getMessageDeleteWorkText();

        Assert.assertEquals(delWork, "Вид работ успешно удален из проекта");
    }

    @Test(priority = 5,
            description = "добавление вида работ в проект через поиск")
    public void addTypesWork() throws InterruptedException {

        String Work = new TypesWorkSidebarPage(getDriver())
                .project()
                .settingsSidebarClick()
                .typesWorkSidebarClick()
                .btnAddTypesWorkClick()
                .searchWorkText(NAME_TYPES_WORK3)
                .btnCheckboxTypesWorkClick()
                .btnSubmitTypesWorkClick()
                .getNewWorkText3();

        Assert.assertEquals(Work, NAME_TYPES_WORK3);
    }

    @Test(priority = 6,
            description = "редактировать ПКМ вид работ")
    public void removePKMTypesWork() throws InterruptedException {
//        new TypesWorkSidebarPage(getDriver())
        String delWork = new TypesWorkSidebarPage(getDriver())
                .project()
                .settingsSidebarClick()
                .typesWorkSidebarClick()
                .btnRemovePRMTypesWorkClick()
                .dropRemoveTypesWorkClick()
                .newNameTypesWorkClick(NAME_TYPES_WORK)
                .getNewWorkText();

        Assert.assertEquals(delWork, NAME_TYPES_WORK);
    }

    @Test(priority = 7,
            description = "удалить вид работ")
    public void deleteTypesWork() throws InterruptedException {
//        new TypesWorkSidebarPage(getDriver())
        String delWork = new TypesWorkSidebarPage(getDriver())
                .project()
                .settingsSidebarClick()
                .typesWorkSidebarClick()
                .btnRemoveTypesWorkClick()
                .dropDeleteTypesWorkClick()
                .btnSetDeleteTypesWorkClick()
                .getMessageDeleteWorkText();

        Assert.assertEquals(delWork, "Вид работ успешно удален из проекта");
    }

    @Test(priority = 8,
            description = "множественное добавление вида работ в проект через поиск")
    public void pluralTypesWork() throws InterruptedException {
//        new TypesWorkSidebarPage(getDriver())
        String Work = new TypesWorkSidebarPage(getDriver())
                .project()
                .settingsSidebarClick()
                .typesWorkSidebarClick()
                .btnAddTypesWorkClick()
                .pluralTypesWorkClick()
                .btnAddWorkClick()
                .getNewWorkText();

        Assert.assertEquals(Work, NAME_TYPES_WORK);
    }

    @Test(priority = 9,
            description = "поиск вида работ")
    public void searchTypesWork() throws InterruptedException {
//        new TypesWorkSidebarPage(getDriver())
        String Work = new TypesWorkSidebarPage(getDriver())
                .project()
                .settingsSidebarClick()
                .typesWorkSidebarClick()
                .search(NAME_TYPES_WORK)
                .getNewWorkText();

        Assert.assertEquals(Work, NAME_TYPES_WORK);
    }

    @Test(priority = 10,
            description = "множественное удаление через кнопку корзина вид работ")
    public void deleteBasketTypesWork() throws InterruptedException {
//        new TypesWorkSidebarPage(getDriver())
        String delWork = new TypesWorkSidebarPage(getDriver())
                .project()
                .settingsSidebarClick()
                .typesWorkSidebarClick()
                .pluralTypesWorkClick()
                .deleteBasketTypesWorkClick()
                .btnSetDeleteTypesWorkClick()
                .getMessageDeleteWorkText();

        Assert.assertEquals(delWork, "Вид работ успешно удален из проекта");
    }




}
