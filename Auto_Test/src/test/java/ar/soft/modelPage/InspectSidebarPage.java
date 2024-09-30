package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InspectSidebarPage extends BasePage {

    public InspectSidebarPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "")
    private WebElement createI;

    @Name("кнопка создать новую инспекцию")
    @FindBy(xpath="//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")
    private WebElement createInspectClick;

    @Name("название инспекции")
    public InspectSidebarPage inspectName() {
        getDriver().findElement(By.xpath("//input[@id='CreateDraftInspectionModal_name']")).sendKeys("новая инспекция");

        return this;
    }

    @Name("кнопка создать инспекцию")
    public InspectSidebarPage btncreateInspectClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();

        return this;
    }

    @Name("переименование инспекции")
    public InspectSidebarPage inspectRename() {
        getDriver().findElement(By.xpath("//input[@id='CreateDraftInspectionModal_name']")).sendKeys("inspectName");

        return this;
    }

    @Name("Вид работ в инспекции")
    public InspectSidebarPage inspectTypesWork() {
        getDriver().findElement(By.xpath("//input[@id='rc_select_3']")).sendKeys("А-1 Монтаж системы отопления" + Keys.ENTER);

        return this;
    }

    @Name("Чек лист в инспекции")
    public InspectSidebarPage inspectChecklists() {
        getDriver().findElement(By.xpath("//input[@id='rc_select_11']")).sendKeys("А-1 Монтаж системы отопления" + Keys.ENTER);

        return this;
    }

    @Name("кнопка создать новую инспекцию")
    public InspectSidebarPage createInspectClick() {
        createInspectClick.click();
        return this;
    }
}
