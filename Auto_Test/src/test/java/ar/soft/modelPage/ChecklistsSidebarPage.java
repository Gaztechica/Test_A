package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChecklistsSidebarPage extends BasePage {

    public ChecklistsSidebarPage(WebDriver driver) {
        super(driver);
    }

    @Name("кнопка добавить")
    public ChecklistsSidebarPage btnAddChecklists() {
        getDriver().findElement(By.xpath("//*[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();
        return this;
    }

    @Name("ввод имени чек-листа")
    public ChecklistsSidebarPage inputNameChecklists() {
        getDriver().findElement(By.xpath("//*[@class='ant-input-affix-wrapper primaryInput  not-entered']/input")).sendKeys(" Система отопления");
        return this;
    }

    @Name("кнопка чекбокса")
    public ChecklistsSidebarPage btnCheckboxChecklists() {
        getDriver().findElement(By.xpath("(//*[@role='dialog']//*[@class='CheckboxComponent__square-check'])[2]")).click();
//        getDriver().findElement(By.xpath("(//*[@class='ant-table-tbody']//*[@id='CheckboxComponent-check'])[2]")).click();
        return this;
    }

    @Name("кнопка чекбокса")
    public ChecklistsSidebarPage btnCheckboxChecklists2() {
        getDriver().findElement(By.xpath("//*[@class='ant-table-tbody']//*[@id='CheckboxComponent-check']")).click();
        return this;
    }

    @Name("кнопка поиск чек-листа в проекте")
    public ChecklistsSidebarPage btnSearchChecklists() {
        getDriver().findElement(By.xpath("//*[@class='ant-input-affix-wrapper searchBoxInput  not-entered']")).click();
        return this;
    }

    @Name("поле ввода в поиск чек-листа в проекте")
    public ChecklistsSidebarPage inputSearchChecklists() {
        getDriver().findElement(By.xpath("//*[@class='ant-input']")).sendKeys("Система отопления");
        return this;
    }

    @Name("кнопка добавить")
    public ChecklistsSidebarPage btnAddNewChecklists() {
        getDriver().findElement(By.xpath("//*[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();
        return this;
    }

    @Name("кнопка удалить чек-лист из проекта")
    public ChecklistsSidebarPage btnDeleteChecklists() {
        getDriver().findElement(By.xpath("//*[@class='buttonSimple  scheduleSettings__btn']")).click();
        return this;
    }

    @Name("кнопка отменить удалить чек-лист из проекта")
    public ChecklistsSidebarPage btnDeleteCancelChecklists() {
        getDriver().findElement(By.xpath("//*[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']")).click();
        return this;
    }

    @Name("кнопка подтвердить удалить чек-лист из проекта")
    public ChecklistsSidebarPage btnDeleteСonfirmChecklists() {
        getDriver().findElement(By.xpath("//*[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(., 'Подтвердить')]")).click();
        return this;
    }

    @Name("название чек-листа в Проекте")
    public String newChecklistsText() {
        return getDriver().findElement(By.xpath("//*[@class='ant-dropdown-trigger']")).getText();
    }
}
