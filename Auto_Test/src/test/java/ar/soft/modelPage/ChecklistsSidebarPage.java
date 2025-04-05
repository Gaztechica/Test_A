package ar.soft.modelPage;

import ar.soft.element.WaitT;
import ar.soft.modelPage.base.BasePage;
import io.qameta.allure.Allure;
import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Character.getName;

public class ChecklistsSidebarPage extends BasePage {

    String nameChecklists = "новый чек-лист";

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

    @Name("кнопка редактировать троеточие вид работ")
    public ChecklistsSidebarPage btnRemoveChecklistsClick() {
        getDriver().findElement(By.xpath("//div[@class='ProjectСhecklist__content-iconBlock']")).click();

        return this;
    }

    @Name("drop удалить")
    public ChecklistsSidebarPage dropDeleteChecklistsClick() {
        getDriver().findElement(By.xpath("//div[@class='ant-dropdown Dropdown undefined ant-dropdown-placement-leftTop ']//div[contains(.,'Удалить')]")).click();

        return this;
    }

    @Name("кнопка отменить удалить вид работ")
    public ChecklistsSidebarPage btnCancelDeleteChecklistsClick() throws InterruptedException {
        Thread.sleep(100);
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']/span[contains(.,'Отменить')]")).click();

        return this;
    }

    @Name("кнопка редактировать ПKM вид работ")
    public ChecklistsSidebarPage btnRemovePRMChecklistsClick() {
        Actions actions = new Actions(getDriver());
        WebElement btnElement = getDriver().findElement(By.xpath("//div[@class='ant-dropdown-trigger'][contains(., '"+ nameChecklists +" Remove Name')]"));
        actions.contextClick(btnElement)
                .perform();
        return this;
    }
//    @Name("drop удалить")
//    public ChecklistsSidebarPage dropDeleteChecklistsClick() {
//        getDriver().findElement(By.xpath("//div[@class='ant-dropdown Dropdown undefined ant-dropdown-placement-leftTop ']//div[contains(.,'Удалить')]")).click();
//
//        return this;
//    }

    @Name("drop ПKM удалить")
    public ChecklistsSidebarPage dropDeletePKMChecklistsClick() {
        Actions actions = new Actions(getDriver());
        WebElement btnElement = getDriver().findElement(By.xpath("//div[@class='ant-dropdown-trigger'][contains(., '" + nameChecklists + "')]"));
        actions.contextClick(btnElement)
                .perform();

        return this;
    }

    @Name("select удалить")
    public ChecklistsSidebarPage selectDeleteChecklistsClick() {
        getDriver().findElement(By.xpath("(//*[@class='ant-dropdown-menu-item ant-dropdown-menu-item-only-child'])[2]")).click();

        return this;
    }

    @Name("кнопка удалить корзина")
    public ChecklistsSidebarPage deleteBasketChecklistsClick() {
        getDriver().findElement(By.xpath("//*[@class='buttonSimple  scheduleSettings__btn']")).click();

        return this;
    }

    @Name("drop редактировать")
    public ChecklistsSidebarPage dropRemoveChecklistsClick() {
        getDriver().findElement(By.xpath("//li[@class='ant-dropdown-menu-item ant-dropdown-menu-item-only-child']")).click();
//        getDriver().findElement(By.xpath("(//*[@class='ant-typography p_r'][contains(.,'Редактировать')])[2]")).click();

        return this;
    }

//    @Name("кнопка отменить удалить вид работ")
//    public ChecklistsSidebarPage btnCancelDeleteChecklistsClick() throws InterruptedException {
//        Thread.sleep(100);
//        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']/span[contains(.,'Отменить')]")).click();
//
//        return this;
//    }

    @Name("кнопка подтвердить удалить вид работ")
    public ChecklistsSidebarPage btnSetDeleteChecklistsClick() throws InterruptedException {
        Thread.sleep(300);
        getDriver().findElement(By.xpath("//button[@type='button']/span[contains(.,'Подтвердить')]/..")).click();

        return this;
    }

    @Name("кнопка поиска вида работ")
    public ChecklistsSidebarPage search(String text) {
        getDriver().findElement(By.xpath("//*[@class='ant-input-prefix']")).click();
        getDriver().findElement(By.xpath("//*[@class='ant-input']")).sendKeys(text);
        return this;
    }

//    @Name("поле ввода поиска вида работ")
//    public TypesWorkSidebarPage searchInput() {
//
//
//        return this;
//    }

    @Name("поле ввода названия вида работ")
    public ChecklistsSidebarPage inputNameChecklistsClick(String name) {
        getDriver().findElement(By.id("CreateTypeOfWorkModal_name")).sendKeys(name);

        return this;
    }

    @Name("очистка поля ввода названия вида работ")
    public ChecklistsSidebarPage clearNameChecklistsClick() {
        getDriver().findElement(By.xpath("//input[@class='ant-input']")).click();
        getDriver().findElement(By.xpath("//input[@class='ant-input']")).sendKeys();

        return this;
    }

    @Name("поле ввода названия вида работ")
    public ChecklistsSidebarPage newNameChecklistsClick(String text) {
//        getDriver().findElement(By.xpath("//input[@class='ant-input']")).getAttribute("value"), text;
//        getDriver().findElement(By.xpath("//input[@class='ant-input']")).sendKeys(Keys.CONTROL + "A");
//        getDriver().findElement(By.xpath("//input[@class='ant-input']")).sendKeys(text);
//        getDriver().findElement(By.xpath("//input[@class='ant-input']")).sendKeys(Keys.ENTER);

        return this;
    }

//    public ChecklistsSidebarPage  enterTextFromTextBox(String value) {
//        Allure.step("Ввод значения  '"  + value + "' в текстовое поле " + getName());
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        WaitT.littleWait(1000);
//        this.getWrappedElement().sendKeys(value);
//        return this;
//    }

    @Name("поле ввода названия вида работ")
    public ChecklistsSidebarPage inputNewNameChecklistsClick() {
        getDriver().findElement(By.xpath("//input[@class='ant-input']")).sendKeys(" Remove Name");

        return this;
    }

    @Name("поле единицы измерения вида работ")
    public ChecklistsSidebarPage unitMeasurementClick() {
        getDriver().findElement(By.id("CreateTypeOfWorkModal_unit")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

        return this;
    }

    @Name("поле Добавить категорию")
    public ChecklistsSidebarPage categoryItemNameClick(String name) {
        getDriver().findElement(By.xpath("//*[@class='EditProjectCheckList__categoryItemName']")).click();
        getDriver().findElement(By.xpath("//*[@class='ant-input primaryInput  not-entered']")).sendKeys(name);
        getDriver().findElement(By.xpath("//*[@class='ant-input primaryInput createCategoryModal__input not-entered']")).sendKeys(name);
        getDriver().findElement(By.xpath("(//*[@class='ant-btn ant-btn-default primaryButton big colorPrimary '])[2]")).click();

        return this;
    }
    @Name("кнопка Добавить")
    public ChecklistsSidebarPage btnSaveChecklistsClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();

        return this;
    }

    @Name("кнопка добавить вид работ в проект")
    public ChecklistsSidebarPage btnAddChecklistsClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();

        return this;
    }
    @Name("чек бокс вид работ")
    public ChecklistsSidebarPage btnCheckboxChecklistsClick() throws InterruptedException {
        Thread.sleep(300);
        getDriver().findElement(By.xpath("//*[@class='ant-table-tbody']/*[contains(.,'" + nameChecklists + "')]/.//*[@id='CheckboxComponent'] | (//*[@class='ant-table-tbody']/*[contains(.,'" + nameChecklists + "')]/.//*[@id='CheckboxComponent'])[2] | (//*[@class='ant-table-tbody']/*[contains(.,'" + nameChecklists + "')]/.//*[@id='CheckboxComponent'])[3]")).click();

        return this;
    }

    @Name("чек бокс множественное добавление вид работ")
    public ChecklistsSidebarPage pluralChecklistsClick() throws InterruptedException {
        Thread.sleep(300);
        getDriver().findElement(By.xpath("(//*[@class='ant-table-tbody']/.//*[@id='CheckboxComponent'])[3]")).click();
        getDriver().findElement(By.xpath("(//*[@class='ant-table-tbody']/.//*[@id='CheckboxComponent'])[4]")).click();

        return this;
    }

//    @Name("кнопка добавить")
//    public ChecklistsSidebarPage btnAddChecklistsClick() {
//        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();
//
//        return this;
//    }
    @Name("созданный вид работ")
    public String getNewChecklistsText() throws InterruptedException {
        Thread.sleep(300);
        return getDriver().findElement(By.xpath("(//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'])[contains(., '" + nameChecklists + "')]")).getText();

    }

    @Name("message удалить вид работ")
    public String getMessageDeleteChecklistsText() throws InterruptedException {
        Thread.sleep(300);
        return getDriver().findElement(By.xpath("//*[@class='ant-message-custom-content ant-message-success']")).getText();

    }

    @Name("ввод в поиск вид работ")
    public ChecklistsSidebarPage searchChecklists(String name) {
        getDriver().findElement(By.xpath("(//input[@class='ant-input'])[2]")).click();
        getDriver().findElement(By.xpath("(//input[@class='ant-input'])[2]")).sendKeys(name);
        return this;
    }
}
