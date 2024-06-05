package ar.soft;

import ar.soft.modelPage.RemarkSidebarPage;
import ar.soft.runner.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemarcSidebarTest extends BaseTest {

//    public static final By NEW_REMARK = By.xpath("//div[@data-testid='Text'][contains(.,'Замечаниe')]");
    public static final By NEW_REMARK = By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'Замечания')]");



    @Test
    public void addRemarkTest() {
        new RemarkSidebarPage(getDriver())
                .progect()
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
                .progect()
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
