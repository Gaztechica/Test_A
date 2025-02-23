package ar.soft;

import ar.soft.modelPage.InspectSidebarPage;
import ar.soft.runner.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class InspectSidebarTest extends BaseTest {

    @Test(priority = 1,
            description = "создать новую инспекцию")
    public void createInspect() {
         new InspectSidebarPage(getDriver())
                 .project()
                 .inspectSidebarClick()
                 .createInspectClick()
                 .inspectName()
                 .btncreateInspectClick()
                 .inspectTypesWork();
    }

    @Test(priority = 2,
            description = "переименовать инспекцию")
    public void renameInspect() {
        new InspectSidebarPage(getDriver())
                .project()
                .inspectSidebarClick()
                .inspectRename();

    }

    @Test(priority = 2,
            description = "переименовать инспекцию")
    public void renameInspect2() {
        new InspectSidebarPage(getDriver())
                .project()
                .inspectSidebarClick()
                .inspectRename();

    }
}
