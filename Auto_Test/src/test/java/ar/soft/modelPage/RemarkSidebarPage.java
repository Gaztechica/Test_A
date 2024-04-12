package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RemarkSidebarPage extends BasePage {

    public RemarkSidebarPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'1Новый проект')]")
    private WebElement progect;

    @FindBy(xpath = "//span[@class='ant-menu-title-content'][contains(.,'Замечания')]")
    private WebElement remark;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")
    private WebElement btnAddRemark;

    @FindBy(xpath = "//input[@class='ant-input primaryInput  not-entered']")
    private WebElement inputNameRemark;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary '][contains(.,'Создать')]")
    private WebElement btnAddNameRemark;

    public RemarkSidebarPage progect() {
        progect.click();
        return this;
    }

    public RemarkSidebarPage remark() {
        remark.click();
        return this;
    }

    public RemarkSidebarPage btnAddRemark() {
        btnAddRemark.click();
        return this;
    }

    public RemarkSidebarPage inputNameRemark() {
        inputNameRemark.sendKeys("Замечаниe");
        return this;
    }

    public RemarkSidebarPage btnAddNameRemark() {
        btnAddNameRemark.click();
        return this;
    }





}
