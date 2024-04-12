package ar.soft.modelPage;

import ar.soft.runner.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RemarkSidebarPage extends BaseTest {

    @FindBy(xpath = "//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'1Новый проект')]")
    private WebElement homePage;

    public RemarkSidebarPage(WebDriver driver) {
        super(driver);
    }

    public RemarkSidebarPage homePage() {
        homePage.click();
        return this;

    }


}
