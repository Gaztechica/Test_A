package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TypesWorkSidebarPage extends BasePage {

    public TypesWorkSidebarPage(WebDriver driver) {
        super(driver);
    }

    @Name("")
    public TypesWorkSidebarPage btnCreateTypesWorkClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();

        return this;
    }

    public TypesWorkSidebarPage inputNameTypesWorkClick() {
        getDriver().findElement(By.id("CreateTypeOfWorkModal_name")).sendKeys("CreateTypeOfWork");

        return this;
    }

    public TypesWorkSidebarPage unitMeasurementClick() {
        getDriver().findElement(By.id("CreateTypeOfWorkModal_unit")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

        return this;
    }

    public TypesWorkSidebarPage btnSubmitTypesWorkClick() {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();

        return this;
    }


    public TypesWorkSidebarPage btnAddTypesWorkClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default secondaryButton big colorPrimary ']")).click();

        return this;
    }

    public TypesWorkSidebarPage btnCheckboxTypesWorkClick() {
        getDriver().findElement(By.xpath("(//div[@id='CheckboxComponent-check'])[2]")).click();

        return this;
    }

    public TypesWorkSidebarPage btnAddWorkClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();

        return this;
    }

    public String getNewWorkText() {
        return getDriver().findElement(By.xpath("(//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'])[2]")).getText();
    }
}
