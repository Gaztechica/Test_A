package ar.soft;

import ar.soft.modelPage.InspectSidebarPage;
import ar.soft.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class InspectSidebarTest extends BaseTest {

    public final static String NAME_DRAFT_INSPECT = "черновик инспекции";
    public final static String NAME_RENAME_INSPECT = "переименовал инспекцию ";
    public final static String TAPE_WORK_INSPECT = "новый вид работ";
    public final static String TAPE_WORK_INSPECT2 = "А-1 Монтаж системы отопления";
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
            description = "переименовать инспекцию")
    public void renameInspect() throws InterruptedException {
        String renameInspects = new InspectSidebarPage(getDriver())
                .project()
                .inspectSidebarClick()
                .selectInspect()
                .inspectRename(NAME_RENAME_INSPECT + LocalDate.now())
                .getMessageCreateDraftInspectText();

        Assert.assertEquals(renameInspects, NAME_RENAME_INSPECT + LocalDate.now());
    }

    @Test(priority = 3,
            description = "создать черновик инспекции со всеми заполненными обязательными полями")
    public void createInspect() throws InterruptedException {
        String createInspect = new InspectSidebarPage(getDriver())
                .project()
                .inspectSidebarClick()
                .createInspectClick()
                .inspectName(NAME_DRAFT_INSPECT)
                .btnCreateInspectClick()
                .addLocationClick()
                .inspectTypesWork(TAPE_WORK_INSPECT)
                .inspectOrganization(ORGANIZATION_INSPECT)
                .addChecklistClick()
                .checkChecklistClick()
                .getMessageCreateDraftInspectText();

        Assert.assertEquals(createInspect, "Черновик успешно создан");
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

}
