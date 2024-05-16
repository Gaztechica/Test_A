package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TypesWorkSidebarPage extends BasePage {

    public TypesWorkSidebarPage(WebDriver driver) {
        super(driver);
    }

    public TypesWorkSidebarPage btnTypesWorkClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();

        return this;
    }

    public TypesWorkSidebarPage inputNameTypesWorkClick() {
        getDriver().findElement(By.id("CreateTypeOfWorkModal_name")).sendKeys("CreateTypeOfWorkModal_name");

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

//    public TypesWorkSidebarPage btnTypesWorkClick() {
//        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).sendKeys(Keys.ENTER);
//
//        return this;
//    }
//
//    public TypesWorkSidebarPage btnTypesWorkClick() {
//        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).sendKeys(Keys.ENTER);
//
//        return this;
//    }
//
//    public TypesWorkSidebarPage btnTypesWorkClick() {
//        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).sendKeys(Keys.ENTER);
//
//        return this;
//    }
}
