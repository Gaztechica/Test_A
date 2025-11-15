package ar.soft;

import ar.soft.modelPage.TypesWorkLibraryPage;
import ar.soft.runner.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.testng.Assert;
import org.testng.annotations.Test;

import static ar.soft.AT.ProjectSettingsTest.TypesWorkSidebarTest.*;

public class TypesWorkAdminTest extends BaseTest {

    @Test(priority = 1,
            description = "создание вида работ")
    @DisplayName("создание вида работ")
    public void createTypesWorkAdmin() throws InterruptedException {
        String Work2 = new TypesWorkLibraryPage(getDriver())
                .libraryClick()
                .typesWorkLibraryClick()
                .btnCreateTypesWorkClick()
                .inputNameTypesWorkClick(NAME_TYPES_WORK)
                .unitMeasurementClick()
                .btnSubmitTypesWorkClick()
                .getNewWorkText();

        Assert.assertEquals(Work2, NAME_TYPES_WORK);
    }

    @Test(priority = 2,
            description = "удалить вид работ")
    public void deleteTypesWork() throws InterruptedException {
//        new TypesWorkSidebarPage(getDriver())
        String delWork = new TypesWorkLibraryPage(getDriver())
                .libraryClick()
                .typesWorkLibraryClick()
                .btnRemoveTypesWorkClick()
                .dropDeleteTypesWorkClick()
                .btnSetDeleteTypesWorkClick()
                .getMessageDeleteWorkText();

        Assert.assertEquals(delWork, "Вид работ успешно удален из проекта");
    }
    @Test(priority = 3,
            description = "создание 2 вида работ")
    public void createTypesWorkAdmin2() throws InterruptedException {
        String Work2 = new TypesWorkLibraryPage(getDriver())
                .libraryClick()
                .typesWorkLibraryClick()
                .btnCreateTypesWorkClick()
                .inputNameTypesWorkClick(NAME_TYPES_WORK)
                .unitMeasurementClick()
                .btnSubmitTypesWorkClick()
                .getNewWorkText();

        Assert.assertEquals(Work2, NAME_TYPES_WORK);
    }

    @Test(priority = 4,
            description = "удалить ПКМ вид работ")
    public void deletePKMTypesWork() throws InterruptedException {
//        new TypesWorkSidebarPage(getDriver())
        String delWork = new TypesWorkLibraryPage(getDriver())
                .libraryClick()
                .typesWorkLibraryClick()
                .dropDeletePKMTypesWorkClick()
                .selectDeleteTypesWorkClick()
                .btnSetDeleteTypesWorkClick()
                .getMessageDeleteWorkText();

        Assert.assertEquals(delWork, "Вид работ успешно удален из проекта");
    }

    @Test(priority = 5,
            description = "создание 3 вида работ")
    public void createTypesWorkAdmin3() throws InterruptedException {
        String Work2 = new TypesWorkLibraryPage(getDriver())
                .libraryClick()
                .typesWorkLibraryClick()
                .btnCreateTypesWorkClick()
                .inputNameTypesWorkClick(NAME_TYPES_WORK)
                .unitMeasurementClick()
                .btnSubmitTypesWorkClick()
                .getNewWorkText();

        Assert.assertEquals(Work2, NAME_TYPES_WORK);
    }

    @Test(priority = 6,
            description = "создание 4 вида работ")
    public void createTypesWorkAdmin4() throws InterruptedException {
        String Work2 = new TypesWorkLibraryPage(getDriver())
                .libraryClick()
                .typesWorkLibraryClick()
                .btnCreateTypesWorkClick()
                .inputNameTypesWorkClick(NAME_TYPES_WORK)
                .unitMeasurementClick()
                .btnSubmitTypesWorkClick()
                .getNewWorkText();

        Assert.assertEquals(Work2, NAME_TYPES_WORK);
    }

    @Test(priority = 7,
            description = "редактировать вид работ")
    public void removeTypesWork() throws InterruptedException {
        String newNameWork = new TypesWorkLibraryPage(getDriver())
                .libraryClick()
                .typesWorkLibraryClick()
                .btnRemoveTypesWorkClick()
                .dropRemoveTypesWorkClick()
                .newNameTypesWorkClick("Remove Name")
                .inputNewNameTypesWorkClick()
                .unitRemoveMeasurementClick()
                .btnSubmitTypesWorkClick()
                .getRemoveWorkText();

        Assert.assertEquals(newNameWork,  "Remove Name");
    }

    @Test(priority = 8,
            description = "редактировать ПКМ вид работ")
    public void removePKMTypesWork() throws InterruptedException {
//        new TypesWorkSidebarPage(getDriver())
        String delWork = new TypesWorkLibraryPage(getDriver())
                .libraryClick()
                .typesWorkLibraryClick()
                .btnRemovePRMTypesWorkClick()
                .dropRemoveTypesWorkClick()
                .newNameTypesWorkClick(NAME_TYPES_WORK2)
                .getNewWorkText2();

        Assert.assertEquals(delWork, NAME_TYPES_WORK2);
    }

    @Test(priority = 9,
            description = "создание 5 вида работ")
    public void createTypesWorkAdmin5() throws InterruptedException {
        String Work2 = new TypesWorkLibraryPage(getDriver())
                .libraryClick()
                .typesWorkLibraryClick()
                .btnCreateTypesWorkClick()
                .inputNameTypesWorkClick(NAME_TYPES_WORK3)
                .unitMeasurementClick()
                .btnSubmitTypesWorkClick()
                .getNewWorkText();

        Assert.assertEquals(Work2, NAME_TYPES_WORK3);
    }

    @Test(priority = 10,
            description = "поиск вида работ")
    public void searchTypesWork() throws InterruptedException {
//        new TypesWorkSidebarPage(getDriver())
        String Work = new TypesWorkLibraryPage(getDriver())
                .libraryClick()
                .typesWorkLibraryClick()
                .search(NAME_TYPES_WORK3)
                .getNewWorkText3();

        Assert.assertEquals(Work, NAME_TYPES_WORK3);
    }

    @Test(priority = 11,
            description = "множественное удаление через кнопку корзина вид работ")
    public void deleteBasketTypesWork() throws InterruptedException {
//        new TypesWorkSidebarPage(getDriver())
        String delWork = new TypesWorkLibraryPage(getDriver())
                .libraryClick()
                .typesWorkLibraryClick()
                .pluralTypesWorkClick()
                .deleteBasketTypesWorkClick()
                .btnSetDeleteTypesWorkClick()
                .getMessageDeleteWorkText();

        Assert.assertEquals(delWork, "Вид работ успешно удалены из проекта");
    }

    @Test(priority = 12,
            description = "перебор поля единицы измерения вида работ")
    public void createTypesWorkAdmin6() throws InterruptedException {
        String Work2 = new TypesWorkLibraryPage(getDriver())
                .libraryClick()
                .typesWorkLibraryClick()
                .btnCreateTypesWorkClick()
                .inputNameTypesWorkClick(NAME_TYPES_WORK3)
                .unitMeasurementClick()
                .btnSubmitTypesWorkClick()
                .getNewWorkText();

        Assert.assertEquals(Work2, NAME_TYPES_WORK3);
    }



//    @Test(priority = 1,
//            description = "создание вида работ")
//    public void createTypesWorkAdmin() throws InterruptedException {
//        String Work = new TypesWorkSidebarPage(getDriver())
//                .project()
//                .typesWorkSidebarClick()
//                .btnCreateTypesWorkClick()
//                .inputNameTypesWorkClick(NAME_TYPES_WORK)
//                .unitMeasurementClick()
//                .btnSubmitTypesWorkClick()
//                .getNewWorkText();
//
//        Assert.assertEquals(Work, NAME_TYPES_WORK);
//    }
}
