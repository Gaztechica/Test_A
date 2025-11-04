package ar.soft;

import ar.soft.modelPage.InspectSidebarPage;
import ar.soft.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class InspectSidebarTest extends BaseTest {

    public final static String NAME_DRAFT_INSPECT = "черновик инспекции";
    public final static String NAME_DRAFT_INSPECT_FILLED = "черновик инспекции заполнены все поля";
    public final static String NAME_OT_INSPECT_FILLED = "ОТ, ПБ и ООС";
    public final static String NAME_RENAME_INSPECT = "переименовал инспекцию ";
    public final static String TAPE_WORK_INSPECT = "новый вид работ";
    public final static String ORGANIZATION_INSPECT = "TEST!1";

    @Test(priority = 1,
            description = "создать черновик инспекции")
    public void createDraftInspect() throws InterruptedException {
        String createDraftInspect = new InspectSidebarPage(getDriver())
                .project()
                .inspectSidebarClick()
                .createInspectClick()
                .inspectName(NAME_DRAFT_INSPECT)
                .btnCreateInspectClick()
                .getMessageCreateDraftInspectText();

        Assert.assertEquals(createDraftInspect, "Черновик успешно создан");
    }

    @Test(priority = 2,
            description = "переименовать черновик инспекции")
    public void renameInspect() throws InterruptedException {
        String renameInspects = new InspectSidebarPage(getDriver())
                .project()
                .inspectSidebarClick()
                .selectInspect()
                .inspectRename(NAME_RENAME_INSPECT + LocalDate.now())
                .getRenameDraftInspectText();

        Assert.assertEquals(renameInspects, NAME_RENAME_INSPECT + LocalDate.now());
    }

    @Test(priority = 3,
            description = "создать черновик инспекции со всеми заполненными обязательными полями")
    public void createInspect() throws InterruptedException {
        String createInspect = new InspectSidebarPage(getDriver())
                .project()
                .inspectSidebarClick()
                .createInspectClick()
                .inspectName(NAME_DRAFT_INSPECT_FILLED)
                .btnCreateInspectClick()
                .inspectTypesWork(TAPE_WORK_INSPECT)
                .inspectOrganization(ORGANIZATION_INSPECT)
                .inspectTypeControl()
                .addChecklistClick()
                .checkChecklistClick()
                .addLocationClick()
                .getRenameDraftInspectText();

        Assert.assertEquals(createInspect, NAME_DRAFT_INSPECT);
    }

    @Test(priority = 4,
            description = "удалить черновик инспекции")
    public void deleteInspect() throws InterruptedException {
        new InspectSidebarPage(getDriver())
                .project()
                .inspectSidebarClick()
                .selectInspect()
                .btnDeleteInspectClick()
                .btnSetDeleteInspectClick();
    }

    @Test(priority = 5,
            description = "опубликовать черновик инспекции")
    public void filledInspect() throws InterruptedException {
        String createDraftInspect = new InspectSidebarPage(getDriver())
                .project()
                .inspectSidebarClick()
                .filledInspect(NAME_DRAFT_INSPECT_FILLED)
                .btnFilledInspect()

                .getMessageFilledDraftInspectText();

        Assert.assertEquals(createDraftInspect, "Черновик успешно создан");
    }

    @Test(priority = 6,
            description = "Завершить инспекцию")
    public void filledDraftInspect() throws InterruptedException {
        String createDraftInspect = new InspectSidebarPage(getDriver())
                .project()
                .inspectSidebarClick()
                .selectCompleteInspect(NAME_OT_INSPECT_FILLED)
                .btnCompleteInspect()
                .getMessageFilledInspectText();

        Assert.assertEquals(createDraftInspect, "Инспекция завершена");
    }

    @Test(priority = 7,
            description = "Вернуть в работу инспекцию")
    public void backWorkInspect() throws InterruptedException {
        String createDraftInspect = new InspectSidebarPage(getDriver())
                .project()
                .inspectSidebarClick()
                .selectCompleteInspect(NAME_OT_INSPECT_FILLED)
                .btnBackWorkInspect()
                .getMessageFilledInspectsText();

        Assert.assertEquals(createDraftInspect, "Завершить");
    }
}
