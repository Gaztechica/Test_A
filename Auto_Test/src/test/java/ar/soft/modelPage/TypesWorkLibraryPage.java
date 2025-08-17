package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static ar.soft.TypesWorkSidebarTest.NAME_TYPES_WORK3;
import static org.openqa.selenium.By.xpath;

public class TypesWorkLibraryPage extends BasePage {

    public TypesWorkLibraryPage(WebDriver driver) {
        super(driver);
    }

    public final static String NAME_TYPES_WORK = "новый вид работ";
    String nameTypesWork = "новый вид работ";
    String nameTypesWork2 = "вид работ";


    @Name("кнопка создать")
    public TypesWorkLibraryPage btnCreateTypesWorkClick() {
        getDriver().findElement(xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();

        return this;
    }

    @Name("кнопка редактировать троеточие вид работ")
    public TypesWorkLibraryPage btnRemoveTypesWorkClick() {
        getDriver().findElement(xpath("//*[@class='ant-table-row ant-table-row-level-0'][contains(., '"+ nameTypesWork +"')]//*[@class='Checklists__info-iconBlock']")).click();
//        getDriver().findElement(By.xpath("//div[@class='ContentTypesOfWork__iconBlock']")).click();

        return this;
    }

    @Name("кнопка редактировать ПKM вид работ")
    public TypesWorkLibraryPage btnRemovePRMTypesWorkClick() {
        Actions actions = new Actions(getDriver());
        WebElement btnElement = getDriver().findElement(xpath("//div[@class='ant-dropdown-trigger'][contains(., '"+ nameTypesWork +"')]"));
//        WebElement btnElement = getDriver().findElement(xpath("//div[@class='ant-dropdown-trigger'][contains(., '"+ nameTypesWork +" Remove Name')]"));
        actions.contextClick(btnElement)
                .perform();
        return this;
    }
    @Name("drop удалить")
    public TypesWorkLibraryPage dropDeleteTypesWorkClick() {
        getDriver().findElement(xpath("//*[@class='ant-dropdown-menu-title-content']//div[contains(.,'Удалить')]")).click();

        return this;
    }

    @Name("drop ПKM удалить")
    public TypesWorkLibraryPage dropDeletePKMTypesWorkClick() {
        Actions actions = new Actions(getDriver());
        WebElement btnElement = getDriver().findElement(xpath("//div[@class='ant-dropdown-trigger'][contains(., '"+ nameTypesWork +"')]"));
        actions.contextClick(btnElement)
                .perform();

        return this;
    }

    @Name("select удалить")
    public TypesWorkLibraryPage selectDeleteTypesWorkClick() {
        getDriver().findElement(xpath("(//*[@class='ant-dropdown-menu-item ant-dropdown-menu-item-only-child'])[2]")).click();

        return this;
    }

    @Name("кнопка удалить корзина")
    public TypesWorkLibraryPage deleteBasketTypesWorkClick() {
        getDriver().findElement(xpath("//*[@class='buttonSimple  scheduleSettings__btn']")).click();

        return this;
    }

    @Name("drop редактировать")
    public TypesWorkLibraryPage dropRemoveTypesWorkClick() {
        getDriver().findElement(xpath("//div[@class='ant-typography p_r'][contains(.,'Редактировать')]")).click();
//        getDriver().findElement(By.xpath("(//*[@class='ant-typography p_r'][contains(.,'Редактировать')])[2]")).click();

        return this;
    }

    @Name("кнопка отменить удалить вид работ")
    public TypesWorkLibraryPage btnCancelDeleteTypesWorkClick() throws InterruptedException {
        Thread.sleep(100);
        getDriver().findElement(xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']/span[contains(.,'Отменить')]")).click();

        return this;
    }

    @Name("кнопка подтвердить удалить вид работ")
    public TypesWorkLibraryPage btnSetDeleteTypesWorkClick() throws InterruptedException {
        Thread.sleep(300);
        getDriver().findElement(xpath("//button[@type='button']/span[contains(.,'Подтвердить')]/..")).click();

        return this;
    }

    @Name("кнопка поиска вида работ")
    public TypesWorkLibraryPage search(String text) {
        getDriver().findElement(xpath("//*[@class='ant-input-prefix']")).click();
        getDriver().findElement(xpath("//*[@class='ant-input']")).sendKeys(text);
        return this;
    }

//    @Name("поле ввода поиска вида работ")
//    public TypesWorkLibraryPage searchInput() {
//
//
//        return this;
//    }

    @Name("поле ввода названия вида работ")
    public TypesWorkLibraryPage inputNameTypesWorkClick(String name) {
        getDriver().findElement(By.id("CreateTypeOfWorkModal_name")).sendKeys(name);

        return this;
    }

    @Name("очистка поля ввода названия вида работ")
    public TypesWorkLibraryPage clearNameTypesWorkClick() {
        getDriver().findElement(xpath("//input[@id='CreateTypeOfWorkModal_name']")).clear();

        return this;
    }

    @Name("поле ввода названия вида работ")
    public TypesWorkLibraryPage newNameTypesWorkClick(String text) {
        getDriver().findElement(xpath("//input[@id='CreateTypeOfWorkModal_name']")).sendKeys(Keys.CONTROL + "A");
        getDriver().findElement(xpath("//input[@id='CreateTypeOfWorkModal_name']")).sendKeys(text);
        getDriver().findElement(xpath("//input[@id='CreateTypeOfWorkModal_name']")).sendKeys(Keys.ENTER);

        return this;
    }

    @Name("поле ввода названия вида работ")
    public TypesWorkLibraryPage inputNewNameTypesWorkClick() {
        getDriver().findElement(xpath("//input[@id='CreateTypeOfWorkModal_name']")).sendKeys(" Remove Name");

        return this;
    }

    @Name("поле единицы измерения вида работ")
    public TypesWorkLibraryPage unitMeasurementClick() {
        getDriver().findElement(By.id("CreateTypeOfWorkModal_unit")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

        return this;
    }

    @Name("поле единицы измерения вида работ")
    public TypesWorkLibraryPage unitRemoveMeasurementClick() {
        getDriver().findElement(xpath("//input[@id='CreateTypeOfWorkModal_name']")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);

        return this;
    }
    @Name("кнопка Добавить")
    public TypesWorkLibraryPage btnSubmitTypesWorkClick() {
        getDriver().findElement(xpath("//button[@type='submit']")).click();

        return this;
    }

    @Name("кнопка добавить вид работ в проект")
    public TypesWorkLibraryPage btnAddTypesWorkClick() {
        getDriver().findElement(xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();

        return this;
    }
    @Name("чек бокс вид работ")
    public TypesWorkLibraryPage btnCheckboxTypesWorkClick() throws InterruptedException {
        Thread.sleep(300);
        getDriver().findElement(xpath("//*[@class='ant-table-tbody']/*[contains(.,'" + nameTypesWork + "')]/.//*[@id='CheckboxComponent'] | (//*[@class='ant-table-tbody']/*[contains(.,'" + nameTypesWork + "')]/.//*[@id='CheckboxComponent'])[2] | (//*[@class='ant-table-tbody']/*[contains(.,'" + nameTypesWork + "')]/.//*[@id='CheckboxComponent'])[3]")).click();

        return this;
    }

    @Name("чек бокс множественное добавление вид работ")
    public TypesWorkLibraryPage pluralTypesWorkClick() throws InterruptedException {
        Thread.sleep(300);
//
        getDriver().findElement(xpath("//*[@class='ant-table-row ant-table-row-level-0'][contains(., 'Remove Name')]//*[@id='CheckboxComponent-check']")).click();
        getDriver().findElement(xpath("//*[@class='ant-table-row ant-table-row-level-0'][contains(., '" + nameTypesWork2 + "')]//*[@id='CheckboxComponent-check']")).click();
//

        return this;
    }

    @Name("кнопка добавить")
    public TypesWorkLibraryPage btnAddWorkClick() {
        getDriver().findElement(xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();

        return this;
    }
    @Name("созданный вид работ")
    public String getNewWorkText() throws InterruptedException {
        Thread.sleep(300);
        return getDriver().findElement(xpath("(//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'])[contains(., '" + nameTypesWork + "')]")).getText();

    }

    @Name("созданный вид работ")
    public String getNewWorkText3() throws InterruptedException {
        Thread.sleep(300);
        return getDriver().findElement(xpath("(//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'])[contains(., '" + NAME_TYPES_WORK3 + "')]")).getText();

    }

    @Name("созданный вид работ")
    public String getNewWorkText2() throws InterruptedException {
        Thread.sleep(300);
        return getDriver().findElement(xpath("(//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'])[contains(., '" + nameTypesWork2 + "')]")).getText();

    }

    @Name("Remove Name вид работ")
    public String getRemoveWorkText() throws InterruptedException {
        Thread.sleep(300);
        return getDriver().findElement(xpath("(//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'])[contains(., 'Remove Name')]")).getText();

    }

    @Name("message удалить вид работ")
    public String getMessageDeleteWorkText() throws InterruptedException {
        Thread.sleep(100);
        return getDriver().findElement(xpath("//*[@class='ant-message-custom-content ant-message-success']")).getText();

    }

    @Name("ввод в поиск вид работ")
    public TypesWorkLibraryPage searchWorkText(String name) {
        getDriver().findElement(xpath("(//input[@class='ant-input'])[2]")).click();
        getDriver().findElement(xpath("(//input[@class='ant-input'])[2]")).sendKeys(name);
        return this;
    }
}
