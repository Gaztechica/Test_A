package ar.soft.modelPage;

//import ar.soft.element.WaitT;
import ar.soft.modelPage.ProjectSettingsPage.TypesWorkSidebarPage;
import ar.soft.modelPage.base.BasePage;
import io.qameta.allure.Step;
import jdk.jfr.Name;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.qa.methods.WaitT;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static ar.soft.AT.Inspection.InspectSidebarTest.*;
//import static ar.soft.driver.WebDriverSetup.getDriverInstance;
import static org.openqa.selenium.By.xpath;
import static ru.qa.driver.WebDriverSetup.getDriverInstance;

public class InspectSidebarPage extends BasePage {

    public InspectSidebarPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "")
    private WebElement createI;

    @Name("кнопка создать новую инспекцию")
    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")
    private WebElement createInspectClick;

    @Name("название инспекции")
    public InspectSidebarPage inspectName(String name) {
        getDriver().findElement(By.xpath("//input[@id='CreateDraftInspectionModal_name']")).sendKeys(name);

        return this;
    }

    @Name("кнопка опубликовать инспекцию")
    public InspectSidebarPage btnFilledInspect() {
        getDriver().findElement(By.xpath("//*[@class='ant-btn ant-btn-primary primaryButton big colorPrimary '][contains(., 'Опубликовать')]/..")).click();

        return this;
    }

    @Name("кнопка Завершить инспекцию")
    public InspectSidebarPage btnCompleteInspect() {
        getDriver().findElement(By.xpath("//*[@type='button']//*[contains(., 'Завершить')]")).click();
//        WebElement submitButton2 = getDriver().findElement(xpath("//*[@type='button']//*[contains(., 'Завершить')]"));
//        JavascriptExecutor js = (JavascriptExecutor) getDriver();
//        js.executeScript("arguments[0].click();", submitButton2);
        return this;
    }

    @Name("кнопка Завершить инспекцию")
    public InspectSidebarPage btnCompleteInspect2() {
        getDriver().findElement(By.xpath("//*[@type='button']//*[contains(., 'Завершить')]")).click();

        return this;
    }

    @Name("кнопка Вернуть в работу инспекцию")
    public InspectSidebarPage btnBackWorkInspect() {
        getDriver().findElement(By.xpath("//*[@type='button']//*[contains(., 'Вернуть в работу')]")).click();

        return this;
    }

    @Name("Заполнить поле Дата начала инспекции")
    public InspectSidebarPage btnDataStartInspect() {
        getDriver().findElement(By.xpath("//*[@class='ant-picker-input']//*[@data-test-id='date-picker']")).click();
        getDriver().findElement(By.xpath("//*[@class='ant-picker-today-btn']")).click();

        return this;
    }

    @Name("Заполнить поле Дата окончания инспекции")
    public InspectSidebarPage btnDateEbdInspect() {
        getDriver().findElement(By.xpath("(//*[@class='ant-picker-input']//*[@data-test-id='date-picker'])[2]")).click();
        WaitT.littleWait(200);
        getDriver().findElement(By.xpath("(//*[@class='ant-picker-today-btn'])[2]")).click();

        return this;
    }

    @Name("Заполнить поле Доп. поле инспекции")
    public InspectSidebarPage btnAdditionalInspect(String name) {
        getDriver().findElement(By.xpath("//*[@class='RemarkDrawer__itemEdit']//*[@data-test-id='input']")).sendKeys(name);

        return this;
    }

    @Name("выбрать в таблице инспекцию")
    public InspectSidebarPage filledInspect(String name) {
        getDriver().findElement(By.xpath("//*[@class='ant-dropdown-trigger'][contains(., '" + NAME_DRAFT_INSPECT_FILLED_REQUIRED + "')]/..")).click();

        return this;
    }

    @Name("выбрать в таблице Завершенную инспекцию")
    public InspectSidebarPage selectCompleteInspect(String name) {
        getDriver().findElement(By.xpath("//*[@class='ant-dropdown-trigger'][contains(., '" + NAME_DRAFT_INSPECT_FILLED_REQUIRED + "')]/..")).click();

        return this;
    }

    @Name("ввод названия инспекции")
    public InspectSidebarPage inspectRename(String name) {
        getDriver().findElement(By.xpath("//*[@class='ant-input primaryInput InspectionDrawer__editInput-title not-entered']")).sendKeys(Keys.CONTROL + "A");
        getDriver().findElement(By.xpath("//*[@class='ant-input primaryInput InspectionDrawer__editInput-title not-entered']")).sendKeys(Keys.DELETE);
        getDriver().findElement(By.xpath("//*[@class='ant-input primaryInput InspectionDrawer__editInput-title not-entered']")).sendKeys(name);

        return this;
    }

    @Name("кнопка создать инспекцию")
    public InspectSidebarPage btnCreateInspectClick() {
        WaitT.littleWait(300);
                getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();

        return this;
    }

    @Name("кнопка удалить инспекцию")
    public InspectSidebarPage btnDeleteInspectClick() {
        getDriver().findElement(By.xpath("//*[@class='ant-btn ant-btn-default primaryButton big colorRed ']")).click();

        return this;
    }

    @Name("кнопка подтвердить удалить вид работ")
    public InspectSidebarPage btnSetDeleteInspectClick() throws InterruptedException {
        Thread.sleep(300);
        getDriver().findElement(By.xpath("//button[@type='button']/span[contains(.,'Подтвердить')]/..")).click();

        return this;
    }

    @Name("чек бокс инспекции")
    public InspectSidebarPage btnCheckboxChecklistsClick() throws InterruptedException {
        Thread.sleep(300);
        getDriver().findElement(By.xpath("//*[@class='ant-table-tbody']/*[contains(.,'" + NAME_DRAFT_INSPECT + "')]/.//*[@id='CheckboxComponent'] " +
                "| (//*[@class='ant-table-tbody']/*[contains(.,'" + NAME_DRAFT_INSPECT + "')]/.//*[@id='CheckboxComponent'])[2] " +
                "| (//*[@class='ant-table-tbody']/*[contains(.,'" + NAME_DRAFT_INSPECT + "')]/.//*[@id='CheckboxComponent'])[3]")).click();

        return this;
    }

    @Name("выбор инспекции")
    public InspectSidebarPage selectInspect() {
        getDriver().findElement(By.xpath("//*[@class='ant-dropdown-trigger'][contains(.,'" + NAME_DRAFT_INSPECT + "')]")).click();
//        getDriver().findElement(By.xpath("//*[@class='ant-dropdown-trigger'][contains(.,'"+ NAME_DRAFT_INSPECT+"')]")).sendKeys(name);

        return this;
    }

    @Name("выбор инспекции")
    public InspectSidebarPage selectAllFieldInspect() {
        getDriver().findElement(By.xpath("//*[@class='ant-dropdown-trigger'][contains(.,'" + NAME_RENAME_INSPECT + LocalDate.now() + "')]")).click();
//        getDriver().findElement(By.xpath("//*[@class='ant-dropdown-trigger'][contains(.,'"+ NAME_DRAFT_INSPECT+"')]")).sendKeys(name);

        return this;
    }

    @Name("Организация в инспекции")
    public InspectSidebarPage inspectOrganization(String name) {
        WaitT.littleWait(300);
        getDriver().findElement(By.xpath("(//*[@class='buttonSimple  RemarkDrawer__btn'])[2]")).click();
        getDriver().findElement(By.xpath("//*[@placeholder='Найти организацию']")).sendKeys(name);
        getDriver().findElement(By.xpath("//*[@class='ant-table-cell AddListModal__cell']//*[@data-test-id='text'][contains(., 'TEST!1')]")).click();
        getDriver().findElement(By.xpath("(//*[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(., 'Добавить')])[2]")).click();

        return this;
    }

    @Name("Организация в инспекции в новом окне")
    public InspectSidebarPage inspectNewOrganization(String name) {
        WaitT.littleWait(1000);
//        getDriver().findElement(By.xpath("(//*[@class='buttonSimple  RemarkDrawer__btn'])[2]")).click();
        getDriver().findElement(By.xpath("//*[@placeholder='Найти организацию']")).sendKeys(name);
        getDriver().findElement(By.xpath("//*[@class='ant-table-cell AddListModal__cell']//*[@data-test-id='text'][contains(., 'TEST!1')]")).click();
        getDriver().findElement(By.xpath("//*[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(., 'Добавить')]")).click();

        return this;
    }

    @Name("кнопка Добавить")
    public InspectSidebarPage inspectNewOrganization2() {
        // Находим элемент кнопки "submit"
        WebElement submitButton = getDriver().findElement(By.xpath("(//*[@class='buttonSimple  RemarkDrawer__btn'])[2]"));

        // Используем JavascriptExecutor для клика по элементу
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", submitButton);

        // Находим элемент "Добавить" и также нажимаем на него с помощью JavascriptExecutor
//        WebElement addButton = getDriver().findElement(By.xpath("//*[@class='AddTypesOfWorkModal__buttons'][contains(., 'Добавить')]"));
//        js.executeScript("arguments[0].click();", addButton);

        return this;
    }

    @Name("кнопка вложение Добавить '+")
    public InspectSidebarPage btnAddMediaClick() {
        getDriver().findElement(By.xpath("//*[@class='InspectionDrawer__media-header']//*[@type='button']")).click();

        return this;
    }

    @Name("кнопка в новом окне")
    public InspectSidebarPage btnNewClick() {
        getDriver().findElement(By.xpath("(//*[@class='InspectionDrawer__header-buttons']//*[@class='ant-btn ant-btn-default iconButton small colorPrimary '])[2]")).click();

        return this;
    }

    @Name("Добавить чек лист'+")
    public InspectSidebarPage addChecklistClick() {
        WaitT.littleWait(500);
        getDriver().findElement(By.xpath("//*[@class='InspectionDrawer__checklist-header']//*[@type='button']")).click();
        getDriver().findElement(By.xpath("//*[@data-test-id='text'][contains(., 'новый чек-лист')]")).click();

        return this;
    }

    @Name("Добавить чек лист'+")
    public InspectSidebarPage addChecklistNewClick() {
        WaitT.littleWait(500);
        getDriver().findElement(By.xpath("//*[@class='InspectionDrawer__checklist-header']//*[@type='button']//*[@xmlns='http://www.w3.org/2000/svg']")).click();
        getDriver().findElement(By.xpath("//*[@data-test-id='text'][contains(., 'новый чек-лист')]")).click();

        return this;
    }

    @Name("Проверить чек лист'+")
    public InspectSidebarPage checkChecklistClick() {
        getDriver().findElement(By.xpath("//*[@class='CheckboxDropdownItem__header'][contains(., '02')]//*[@class='CheckboxDropdownItem__icon']")).click();
//        getDriver().findElement(By.xpath("//*[@class='CheckboxDropdownItem__header'][contains(., '12Соответствие проектной документации')]//*[@class='CheckboxDropdownItem__icon']")).click();

        return this;
    }

    @Name("Добавить местоположение '+")
    public InspectSidebarPage addLocationClick() {
        getDriver().findElement(By.xpath("//*[@class='InspectionDrawer__locations-header']//*[@type='button']")).click();
        WebElement submitButton2 = getDriver().findElement(xpath("//button[contains(., 'Местоположение')]"));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", submitButton2);
        WaitT.littleWait(300);
//        getDriver().findElement(By.xpath("//*[@class='buttonSimple  InspectionDrawer__btn'][contains(., 'Местоположение')]")).click();
        getDriver().findElement(By.xpath("//*[@class='ant-typography p_r'][contains(., 'подвал')] | //*[@class='ant-typography p_r'][contains(., 'подвал')]/.. " +
                "| //*[@class='ant-typography p_r'][contains(., 'подвал')]/../../..//*")).click();
        getDriver().findElement(By.xpath("(//*[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(., 'Добавить')])[3]")).click();

        return this;
    }

    @Name("Добавить местоположение '+")
    public InspectSidebarPage addLocationsClick() {
        getDriver().findElement(By.xpath("//*[@class='InspectionDrawer__locations-header']//*[@type='button']")).click();
        WebElement submitButton2 = getDriver().findElement(xpath("//button[contains(., 'Местоположение')]"));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", submitButton2);
        WaitT.littleWait(300);
//        getDriver().findElement(By.xpath("//*[@class='buttonSimple  InspectionDrawer__btn'][contains(., 'Местоположение')]")).click();
        getDriver().findElement(By.xpath("//*[@class='ant-typography p_r'][contains(., 'подвал')] | //*[@class='ant-typography p_r'][contains(., 'подвал')]/.. " +
                "| //*[@class='ant-typography p_r'][contains(., 'подвал')]/../../..//*")).click();
        getDriver().findElement(By.xpath("(//*[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(., 'Добавить')])")).click();

        return this;
    }

    @Name("Добавить План")
    public InspectSidebarPage addPlanClick() {
        getDriver().findElement(By.xpath("//*[@class='buttonSimple  InspectionDrawer__btn'][contains(., 'План')]")).click();
        getDriver().findElement(By.xpath("//*[@class='PlanCard__img']")).click();
        getDriver().findElement(By.xpath("(//*[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(., 'Добавить')])")).click();

       return this;
    }

    @Name("Добавить метку")
    public InspectSidebarPage addLabelClick() {
        getDriver().findElement(By.xpath("//*[@class='ant-btn ant-btn-default iconSecondaryButton big colorPrimary ']")).click();
        getDriver().findElement(By.xpath("//*[@class='Plan__addMark']")).click();
        getDriver().findElement(By.xpath("//*[@class='RndComponent__button ok']")).click();
        getDriver().findElement(By.xpath("//*[@class='RndComponent__save']")).click();

       return this;
    }

    @Name("Вид работ в инспекции")
    public InspectSidebarPage inspectTypesWork(String name) {
        getDriver().findElement(By.xpath("//*[@class='buttonSimple  RemarkDrawer__btn']")).sendKeys(name );
        WaitT.littleWait(500);
        getDriver().findElement(By.xpath("//*[@class='ant-table-cell AddListModal__cell']//*[@data-test-id='text'][contains(., 'новый вид работ')]")).click();
        getDriver().findElement(By.xpath("(//*[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(., 'Добавить')])")).click();

        return this;
    }

    @Name("Вид контроля в инспекции")
    public InspectSidebarPage inspectTypeControl() {
        getDriver().findElement(By.xpath("(//*[@class='ant-select-selection-search-input'])[3]")).click();
        getDriver().findElement(By.xpath("//*[@title='ОТ, ПБ и ООС'][contains(., 'ОТ, ПБ и ООС')]")).click();
//        getDriver().findElement(By.xpath("//*[@class='buttonSimple  RemarkDrawer__btn']")).sendKeys(name );
//                getDriver().findElement(By.xpath("//*[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(., 'Добавить')]")).click();

        return this;
    }

    @Name("Вид контроля в инспекции")
    public InspectSidebarPage inspectTypeNewControl() {
        WaitT.littleWait(500);
                getDriver().findElement(By.xpath("//*[@class='ant-select-selection-search-input']")).click();
        getDriver().findElement(By.xpath("//*[@title='ОТ, ПБ и ООС'][contains(., 'ОТ, ПБ и ООС')]")).click();

        return this;
    }

    @Name("message Черновик успешно создан")
    public String getMessageCreateDraftInspectText() throws InterruptedException {
        WaitT.littleWait(500);

        return getDriver().findElement(xpath("//*[@class='ant-message-custom-content ant-message-success']")).getText();
    }

    @Name("message инспекция опубликована")
    public String getMessageFilledDraftInspectText() throws InterruptedException {
        WaitT.littleWait(500);

        return getDriver().findElement(xpath("//*[@class='ant-message-custom-content ant-message-success']")).getText();
    }

    @Name("message инспекция опубликована")
    public String getMessageFilledInspectText() throws InterruptedException {
        WaitT.littleWait(500);

        return getDriver().findElement(xpath("//*[@class='InspectionContent__finished'][contains(., 'Инспекция завершена')]")).getText();
    }

    @Name("message инспекция опубликована")
    public String getMessageFilledInspectsText() throws InterruptedException {
        WaitT.littleWait(500);
        return getDriver().findElement(xpath("//*[@type='button']//*[contains(., 'Завершить')]/..")).getText();
    }

    @Name("переименован Черновик успешно")
    public String getRenameDraftInspectText() throws InterruptedException {
        WaitT.littleWait(500);
        return getDriver().findElement(xpath("//*[@class='ant-input primaryInput InspectionDrawer__editInput-title entered']")).getText();
    }

    @Name("Опубликовать Черновик успешно")
    public String getFilledDraftInspectText() throws InterruptedException {
        Thread.sleep(100);
        return getDriver().findElement(xpath("//*[@type='button'][contains(., 'Опубликовать')]//*")).getText();
    }

    @Name("message Черновик успешно создан")
    public String getMessageCreateDraftInspectText2() throws InterruptedException {
        Thread.sleep(100);
        return getDriver().findElement(xpath("//*[@class='ant-message-custom-content ant-message-success']")).getText();
    }

    @Name("отображение Черновика в таблице")
    public String getCreateDraftInspectText() throws InterruptedException {
        Thread.sleep(100);
        return getDriver().findElement(xpath("//*[@class='ant-dropdown-trigger'][contains(.,'" + NAME_RENAME_INSPECT + LocalDate.now() + "')]")).getText();
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

    @Step("Проверка выпадающего списка на эквивалентность эталону")
    public static void checkList2(List<String> elementsList) {
        WaitT.littleWait(1000); //проскакивает пустая строка
        WaitT.visibilityOfElementLocated(By.xpath("//button[@class='ant-btn ant-btn-default iconButton big colorPrimary FilterUsers__filter-btn']"));
        WaitT.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'ScrollbarsCustom')]//li//p"));
        String listLocator = "//div[contains(@class, 'ScrollbarsCustom')]//li//p";
        List<WebElement> listMonthW = getDriverInstance().findElements(By.xpath(listLocator));
        List<String> listMonthS = new ArrayList<>();
        for (WebElement webElement : listMonthW) {
            Actions act = new Actions(getDriverInstance());
            act.moveToElement(webElement).perform();
            listMonthS.add(webElement.getText());
        }
        Assert.assertEquals(elementsList, listMonthS, "Выпадающий список эквивалентен эталону");
    }
}
