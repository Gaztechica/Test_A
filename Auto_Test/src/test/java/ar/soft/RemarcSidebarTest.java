package ar.soft;

import ar.soft.modelPage.RemarkSidebarPage;
import ar.soft.runner.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemarcSidebarTest extends BaseTest {

    private static final By GET_ERROR = By.xpath("//div[@style='text-align: center; margin-bottom: 20px; color: rgb(255, 0, 0);']");



    @Test
    public void remarkTest() {
        new RemarkSidebarPage(driver)
                .progect()
                .remark()
                .btnAddRemark()
                .inputNameRemark()
                .btnAddNameRemark();

//        String getError = getDriver().findElement(By.xpath(
//        "//div[@class='ant-typography ant-typography-ellipsis
//        ant-typography-single-line ant-typography-ellipsis-single-line
//        p_r']")).getText();

        Assert.assertEquals(getDriver().
                findElement(By.xpath("//div[@class='ant-typography " +
                        "ant-typography-ellipsis ant-typography-single-line " +
                        "ant-typography-ellipsis-single-line p_r']")).getText(),"Замечаниe");
    }


}
