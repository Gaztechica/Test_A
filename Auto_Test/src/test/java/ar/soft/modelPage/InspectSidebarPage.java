package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InspectSidebarPage extends BasePage {

    public InspectSidebarPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "")
    private WebElement createI;

    public InspectSidebarPage createInspectClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();

        return this;
    }

    public InspectSidebarPage inspectName() {
        getDriver().findElement(By.xpath("//input[@id='CreateDraftInspectionModal_name']")).sendKeys("inspectName");

        return this;
    }

    public InspectSidebarPage btncreateInspectClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();

        return this;
    }


}
