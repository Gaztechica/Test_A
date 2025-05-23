package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TypesWorkSidebarPage extends BasePage {

    String nameTypesWork = "новый вид работ";

    public TypesWorkSidebarPage(WebDriver driver) {
        super(driver);
    }

    @Name("кнопка создать")
    public TypesWorkSidebarPage btnCreateTypesWorkClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default secondaryButton big colorPrimary ']")).click();

        return this;
    }

    @Name("кнопка редактировать троеточие вид работ")
    public TypesWorkSidebarPage btnRemoveTypesWorkClick() {
        getDriver().findElement(By.xpath("//div[@class='ContentTypesOfWork__iconBlock']")).click();

        return this;
    }

    @Name("кнопка редактировать ПKM вид работ")
    public TypesWorkSidebarPage btnRemovePRMTypesWorkClick() {
        Actions actions = new Actions(getDriver());
        WebElement btnElement = getDriver().findElement(By.xpath("//div[@class='ant-dropdown-trigger'][contains(., '"+ nameTypesWork +" Remove Name')]"));
        actions.contextClick(btnElement)
                .perform();
        return this;
    }
    @Name("drop удалить")
    public TypesWorkSidebarPage dropDeleteTypesWorkClick() {
        getDriver().findElement(By.xpath("//div[@class='ant-dropdown Dropdown undefined ant-dropdown-placement-leftTop ']//div[contains(.,'Удалить')]")).click();

        return this;
    }

    @Name("drop ПKM удалить")
    public TypesWorkSidebarPage dropDeletePKMTypesWorkClick() {
        Actions actions = new Actions(getDriver());
        WebElement btnElement = getDriver().findElement(By.xpath("//div[@class='ant-dropdown-trigger'][contains(., '" + nameTypesWork + "')]"));
        actions.contextClick(btnElement)
                .perform();

        return this;
    }

    @Name("select удалить")
    public TypesWorkSidebarPage selectDeleteTypesWorkClick() {
        getDriver().findElement(By.xpath("(//*[@class='ant-dropdown-menu-item ant-dropdown-menu-item-only-child'])[2]")).click();

        return this;
    }

    @Name("кнопка удалить корзина")
    public TypesWorkSidebarPage deleteBasketTypesWorkClick() {
        getDriver().findElement(By.xpath("//*[@class='buttonSimple  scheduleSettings__btn']")).click();

        return this;
    }

    @Name("drop редактировать")
    public TypesWorkSidebarPage dropRemoveTypesWorkClick() {
        getDriver().findElement(By.xpath("//li[@class='ant-dropdown-menu-item ant-dropdown-menu-item-only-child']")).click();
//        getDriver().findElement(By.xpath("(//*[@class='ant-typography p_r'][contains(.,'Редактировать')])[2]")).click();

        return this;
    }

    @Name("кнопка отменить удалить вид работ")
    public TypesWorkSidebarPage btnCancelDeleteTypesWorkClick() throws InterruptedException {
        Thread.sleep(100);
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']/span[contains(.,'Отменить')]")).click();

        return this;
    }

    @Name("кнопка подтвердить удалить вид работ")
    public TypesWorkSidebarPage btnSetDeleteTypesWorkClick() throws InterruptedException {
        Thread.sleep(300);
        getDriver().findElement(By.xpath("//button[@type='button']/span[contains(.,'Подтвердить')]/..")).click();

        return this;
    }

    @Name("кнопка поиска вида работ")
    public TypesWorkSidebarPage search(String text) {
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
    public TypesWorkSidebarPage inputNameTypesWorkClick(String name) {
        getDriver().findElement(By.id("CreateTypeOfWorkModal_name")).sendKeys(name);

        return this;
    }

    @Name("очистка поля ввода названия вида работ")
    public TypesWorkSidebarPage clearNameTypesWorkClick() {
        getDriver().findElement(By.xpath("//input[@id='EditTypesOfWorkModal_name']")).clear();

        return this;
    }

    @Name("поле ввода названия вида работ")
    public TypesWorkSidebarPage newNameTypesWorkClick(String text) {
        getDriver().findElement(By.xpath("//input[@id='EditTypesOfWorkModal_name']")).sendKeys(Keys.CONTROL + "A");
        getDriver().findElement(By.xpath("//input[@id='EditTypesOfWorkModal_name']")).sendKeys(text);
        getDriver().findElement(By.xpath("//input[@id='EditTypesOfWorkModal_name']")).sendKeys(Keys.ENTER);

        return this;
    }

    @Name("поле ввода названия вида работ")
    public TypesWorkSidebarPage inputNewNameTypesWorkClick() {
        getDriver().findElement(By.xpath("//input[@id='EditTypesOfWorkModal_name']")).sendKeys(" Remove Name");

        return this;
    }

    @Name("поле единицы измерения вида работ")
    public TypesWorkSidebarPage unitMeasurementClick() {
        getDriver().findElement(By.id("CreateTypeOfWorkModal_unit")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

        return this;
    }

    @Name("поле единицы измерения вида работ")
    public TypesWorkSidebarPage unitRemoveMeasurementClick() {
        getDriver().findElement(By.xpath("//input[@id='EditTypesOfWorkModal_name']")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);

        return this;
    }
    @Name("кнопка Добавить")
    public TypesWorkSidebarPage btnSubmitTypesWorkClick() {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();

        return this;
    }

    @Name("кнопка добавить вид работ в проект")
    public TypesWorkSidebarPage btnAddTypesWorkClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();

        return this;
    }
    @Name("чек бокс вид работ")
    public TypesWorkSidebarPage btnCheckboxTypesWorkClick() throws InterruptedException {
        Thread.sleep(300);
        getDriver().findElement(By.xpath("//*[@class='ant-table-tbody']/*[contains(.,'" + nameTypesWork + "')]/.//*[@id='CheckboxComponent'] | (//*[@class='ant-table-tbody']/*[contains(.,'" + nameTypesWork + "')]/.//*[@id='CheckboxComponent'])[2] | (//*[@class='ant-table-tbody']/*[contains(.,'" + nameTypesWork + "')]/.//*[@id='CheckboxComponent'])[3]")).click();

        return this;
    }

    @Name("чек бокс множественное добавление вид работ")
    public TypesWorkSidebarPage pluralTypesWorkClick() throws InterruptedException {
        Thread.sleep(300);
        getDriver().findElement(By.xpath("(//*[@class='ant-table-tbody']/.//*[@id='CheckboxComponent'])[3]")).click();
        getDriver().findElement(By.xpath("(//*[@class='ant-table-tbody']/.//*[@id='CheckboxComponent'])[4]")).click();

        return this;
    }

    @Name("кнопка добавить")
    public TypesWorkSidebarPage btnAddWorkClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();

        return this;
    }
    @Name("созданный вид работ")
    public String getNewWorkText() throws InterruptedException {
        Thread.sleep(300);
        return getDriver().findElement(By.xpath("(//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'])[contains(., '" + nameTypesWork + "')]")).getText();

    }

    @Name("message удалить вид работ")
    public String getMessageDeleteWorkText() throws InterruptedException {
        Thread.sleep(300);
        return getDriver().findElement(By.xpath("//*[@class='ant-message-custom-content ant-message-success']")).getText();

    }

    @Name("ввод в поиск вид работ")
    public TypesWorkSidebarPage searchWorkText(String name) {
        getDriver().findElement(By.xpath("(//input[@class='ant-input'])[2]")).click();
        getDriver().findElement(By.xpath("(//input[@class='ant-input'])[2]")).sendKeys(name);
        return this;
    }
}
