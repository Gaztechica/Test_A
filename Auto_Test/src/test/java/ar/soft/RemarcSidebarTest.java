package ar.soft;

import ar.soft.modelPage.RemarkSidebarPage;
import ar.soft.runner.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static ar.soft.modelPage.RemarkSidebarPage.NEW_REMARK;

public class RemarcSidebarTest extends BaseTest {

//    public static final By NEW_REMARK = By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'Замечания')]");



    @Test
    public void addRemarkTest() {
        new RemarkSidebarPage(driver)
                .progect()
                .remark()
                .btnAddRemark()
                .inputNameRemark()
                .btnAddNameRemark();

//        String getError = driver.findElement(By.xpath(NEW_REMARK)).getText();
        Assert.assertEquals(NEW_REMARK, "Замечаниe");
    }

    @Test
    public void remarkTest() {
        new RemarkSidebarPage(driver)
                .progect()
                .remark()
                .newRemark()
                .btnDescription()
                .inputDescription()
                .btnSaveDescription();

    }
}
