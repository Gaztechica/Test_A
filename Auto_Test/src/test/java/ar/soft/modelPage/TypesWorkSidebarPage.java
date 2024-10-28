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

    @Name("кнопка Новый вид работ")
    public TypesWorkSidebarPage btnCreateTypesWorkClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();

        return this;
    }

    @Name("поле ввода названия вида работ")
    public TypesWorkSidebarPage inputNameTypesWorkClick() {
        getDriver().findElement(By.id("CreateTypeOfWorkModal_name")).sendKeys("CreateTypeOfWork");

        return this;
    }
    @Name("поле единицы измерения вида работ")
    public TypesWorkSidebarPage unitMeasurementClick() {
        getDriver().findElement(By.id("CreateTypeOfWorkModal_unit")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

        return this;
    }
    @Name("кнопка Добавить")
    public TypesWorkSidebarPage btnSubmitTypesWorkClick() {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();

        return this;
    }

    @Name("кнопка добавить вид работ в проект")
    public TypesWorkSidebarPage btnAddTypesWorkClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default secondaryButton big colorPrimary ']")).click();

        return this;
    }
    @Name("чек бокс вид работ")
    public TypesWorkSidebarPage btnCheckboxTypesWorkClick() {
        getDriver().findElement(By.xpath("(//div[@id='CheckboxComponent-check'])[2]")).click();

        return this;
    }
    @Name("")
    public TypesWorkSidebarPage btnAddWorkClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();

        return this;
    }
    @Name("созданный вид работ")
    public String getNewWorkText() {
        return getDriver().findElement(By.xpath("(//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'])[2]")).getText();
    }

    @Name("ввод в поиск вид работ")
    public TypesWorkSidebarPage searchWorkText() {
        getDriver().findElement(By.xpath("//input[@class='ant-input']")).sendKeys("владимир");
        return this;
    }
}
