package ar.soft;

import ar.soft.modelPage.TypesWorkSidebarPage;
import ar.soft.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TypesWorkSidebarTest extends BaseTest {

    //добавить тесты вид работ создан, изменен .....
//         сортировка смена цвета стрелки и смена значений

    String nameTypesWork = "новый вид работ";
    @Test(priority = 2,
            description = "создание вида работ")
    public void createTypesWork() throws InterruptedException {
        String Work = new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick()
                .btnCreateTypesWorkClick()
                .inputNameTypesWorkClick(nameTypesWork)
                .unitMeasurementClick()
                .btnSubmitTypesWorkClick()
                .getNewWorkText();

        Assert.assertEquals(Work, nameTypesWork);
    }

    @Test(priority = 1,
            description = "добавление вида работ в проект через поиск")
    public void addTypesWork() throws InterruptedException {

        String Work = new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick()
                .btnAddTypesWorkClick()
                .searchWorkText(nameTypesWork)
                .btnCheckboxTypesWorkClick()
                .btnAddWorkClick()
                .getNewWorkText();

        Assert.assertEquals(Work, nameTypesWork);
    }

    @Test(priority = 3,
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

    @Test(priority = 4,
            description = "редактировать вид работ")
    public void removeTypesWork() throws InterruptedException {
        String newNameWork = new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick()
                .btnRemoveTypesWorkClick()
                .dropRemoveTypesWorkClick()
                .clearNameTypesWorkClick()
                .inputNewNameTypesWorkClick()
                .unitRemoveMeasurementClick()
                .btnSubmitTypesWorkClick()
                .getNewWorkText();

        Assert.assertEquals(newNameWork, nameTypesWork + " Remove Name");
    }

    @Test(priority = 7,
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
            description = "множественное добавление вида работ в проект через поиск")
    public void pluralTypesWork() throws InterruptedException {
//        new TypesWorkSidebarPage(getDriver())
        String Work = new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick()
                .btnAddTypesWorkClick()
                .pluralTypesWorkClick()
                .btnAddWorkClick()
                .getNewWorkText();

        Assert.assertEquals(Work, nameTypesWork);
    }

    @Test(priority = 5,
            description = "редактировать ПКМ вид работ")
    public void removePKMTypesWork() throws InterruptedException {
//        new TypesWorkSidebarPage(getDriver())
        String delWork = new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick()
                .btnRemovePRMTypesWorkClick()
                .dropRemoveTypesWorkClick()
                .newNameTypesWorkClick(nameTypesWork)
                .getNewWorkText();

        Assert.assertEquals(delWork, nameTypesWork);
    }

    @Test(priority = 10,
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

    @Test(priority = 9,
            description = "множественное удаление через кнопку корзина вид работ")
    public void deleteBasketTypesWork() throws InterruptedException {
//        new TypesWorkSidebarPage(getDriver())
        String delWork = new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick()
                .pluralTypesWorkClick()
                .deleteBasketTypesWorkClick()
                .btnSetDeleteTypesWorkClick()
                .getMessageDeleteWorkText();

        Assert.assertEquals(delWork, "Вид работ успешно удалены из проекта");
    }

    @Test(priority = 7,
            description = "поиск вида работ")
    public void searchTypesWork() throws InterruptedException {
//        new TypesWorkSidebarPage(getDriver())
        String Work = new TypesWorkSidebarPage(getDriver())
                .project()
                .typesWorkSidebarClick()
                .search(nameTypesWork)
                .getNewWorkText();

        Assert.assertEquals(Work, nameTypesWork);
    }


}
