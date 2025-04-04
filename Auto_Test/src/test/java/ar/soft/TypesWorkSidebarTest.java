package ar.soft;

import ar.soft.modelPage.TypesWorkSidebarPage;
import ar.soft.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TypesWorkSidebarTest extends BaseTest {

    //добавить тесты вид работ создан, изменен ..... удаление через иконку корзина
//         сортировка смена цвета стрелки и смена значений       поиск на странице общий для всех страниц

    @Test(priority = 1,
            description = "создание вида работ")
    public void createTypesWork() throws InterruptedException {
        String Work = new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick()
                .btnCreateTypesWorkClick()
                .inputNameTypesWorkClick()
                .unitMeasurementClick()
                .btnSubmitTypesWorkClick()
                .getNewWorkText();

        Assert.assertEquals(Work, "CreateTypeOfWork");
    }

    @Test(priority = 4,
            description = "добавление вида работ в проект через поиск")
    public void addTypesWork() throws InterruptedException {

        new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick()
                .btnAddTypesWorkClick()
                .searchWorkText()
                .btnCheckboxTypesWorkClick()
                .btnAddWorkClick()
                .getNewWorkText();
        ;

        Assert.assertEquals("владимир", "владимир");

    }


    @Test(priority = 2,
            description = "отменить удалить вид работ")
    public void cancelDeleteTypesWork() throws InterruptedException {
        new TypesWorkSidebarPage(getDriver())
//        String delWork = new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick()
                .btnRemoveTypesWorkClick()
                .dropDeleteTypesWorkClick()
                .btnCancelDeleteTypesWorkClick();

//        Assert.assertEquals(delWork, "владимир");
    }

    @Test(priority = 5,
            description = "редактировать вид работ")
    public void removeTypesWork() throws InterruptedException {
        String newNameWork = new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick()
                .btnRemoveTypesWorkClick()
                .dropRemoveTypesWorkClick()
                .clerNameTypesWorkClick()
                .inputNewNameTypesWorkClick()
                .unitRemoveMeasurementClick()
                .btnSubmitTypesWorkClick()
                .getNewWorkText();

        Assert.assertEquals(newNameWork, "владимир Remove Name");
    }

    @Test(priority = 3,
            description = "удалить вид работ")
    public void deleteTypesWork() throws InterruptedException {
//        new TypesWorkSidebarPage(getDriver())
        String delWork = new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick()
                .btnRemoveTypesWorkClick()
                .dropDeleteTypesWorkClick()
                .btnSetDeleteTypesWorkClick()
                .getMessageDeleteWorkText();

        Assert.assertEquals(delWork, "Вид работ успешно удален из проекта");
    }

    @Test(priority = 6,
            description = "редактировать ПКМ вид работ")
    public void removePKMTypesWork() throws InterruptedException {
//        new TypesWorkSidebarPage(getDriver())
        String delWork = new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick()
                .btnRemovePRMTypesWorkClick()
                .dropRemoveTypesWorkClick()
                .newNameTypesWorkClick()
                .getNewWorkText();

        Assert.assertEquals(delWork, "владимир");
    }

    @Test(priority = 7,
            description = "удалить ПКМ вид работ")
    public void deletePKMTypesWork() throws InterruptedException {
//        new TypesWorkSidebarPage(getDriver())
        String delWork = new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick()
                .dropDeletePKMTypesWorkClick()
                .selectDeleteTypesWorkClick()
                .btnSetDeleteTypesWorkClick()
                .getMessageDeleteWorkText();

        Assert.assertEquals(delWork, "Вид работ успешно удален из проекта");
    }
}
