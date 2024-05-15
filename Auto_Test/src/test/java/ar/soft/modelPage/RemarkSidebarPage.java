package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.Key;

public class RemarkSidebarPage extends BasePage {

    public RemarkSidebarPage(WebDriver driver) {
        super(driver);
    }

    public static final String NEW_REMARK = "//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'Замечаниe')]";



    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")
    private WebElement btnAddRemark;

    @FindBy(xpath = "//input[@class='ant-input primaryInput  not-entered']")
    private WebElement inputNameRemark;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary '][contains(.,'Создать')]")
    private WebElement btnAddNameRemark;

    @FindBy(xpath = "//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r']")
    private WebElement newRemark;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default iconButton small colorPrimary RemarkDrawer__desc-btn']")
    private WebElement btnDescription;

    @FindBy(xpath = "//textarea[@class='ant-input TextArea__input RemarkDrawer__editInput-desc']")
    private WebElement inputDescription;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary '][contains(.,'Сохранить')]")
    private WebElement btnSaveDescription;

//    @FindBy(xpath = "//input[@aria-activedescendant='rc_select_1_list_0']")
//    private WebElement inputWork;

//    @FindBy(xpath = "")
//    private WebElement ;
//
//    @FindBy(xpath = "")
//    private WebElement ;
//
//    @FindBy(xpath = "")
//    private WebElement ;

//    @FindBy(xpath = "")
//    private WebElement ;






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

    public RemarkSidebarPage newRemark() {
        newRemark.click();
        return this;
    }

    public RemarkSidebarPage btnDescription() {
        btnDescription.click();
        return this;
    }

    public RemarkSidebarPage inputDescription() {
        inputDescription.sendKeys("inputDescription");
        return this;
    }

    public RemarkSidebarPage btnSaveDescription() {
        btnSaveDescription.click();
        return this;
    }

    public RemarkSidebarPage inputWork() {
        getDriver().findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'4')]")).click();

//        getDriver().findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'4')]")).click();

//        inputWork.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        return this;
    }

    public RemarkSidebarPage control() {
        getDriver().findElement(By.xpath("//input[@aria-activedescendant='rc_select_2_list_0']")).click();

//        getDriver().findElement(By.xpath("//input[@aria-activedescendant='rc_select_2_list_0']")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        return this;
    }

    public RemarkSidebarPage inspection() {
        getDriver().findElement(By.xpath("//input[@aria-activedescendant='rc_select_4_list_0']")).sendKeys(Keys.ENTER);



        return this;
    }

    public RemarkSidebarPage priority() {
        getDriver().findElement(By.xpath("//input[@aria-activedescendant='rc_select_5_list_0']")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        return this;
    }

    public RemarkSidebarPage executor() {
        getDriver().findElement(By.xpath("//input[@aria-activedescendant='rc_select_5_list_0']")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        return this;
    }

    public RemarkSidebarPage basis() {
        getDriver().findElement(By.xpath("//input[@aria-activedescendant='rc_select_5_list_0']")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        return this;
    }
}
