package ar.soft;

import ar.soft.modelPage.RemarkSidebarPage;
import ar.soft.runner.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RemarcSidebarTest extends BaseTest {

//    public static final By NEW_REMARK = By.xpath("//div[@data-testid='Text'][contains(.,'Замечаниe')]");
    public static final By NEW_REMARK = By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'Замечания')]");



    @Test(priority = 1,
            description = "создать новое Замечаниe")
    public void addRemarkTest() {
        new RemarkSidebarPage(getDriver())
                .project()
                .remarkSidebarClick()
                .btnAddRemark()
                .inputNameRemark()
                .btnAddNameRemark();

//        String getError = driver.findElement(By.xpath(NEW_REMARK)).getText();
//        Assert.assertEquals(NEW_REMARK,"Замечаниe");
    }

    @Test
    public void remarkTest() {
        new RemarkSidebarPage(getDriver())
                .project()
                .remarkSidebarClick()
                .newRemark()
                .btnDescription()
                .inputDescription()
                .btnSaveDescription()
                .inputWork()
                .control()
                .priority()
                .executor()
                .basis();

    }
}
