//package ar.soft.element;
//
//import io.qameta.allure.Allure;
//import io.qameta.allure.Step;
//import org.openqa.selenium.interactions.Actions;
//
//import static ar.soft.driver.WebDriverSetup.getDriverInstance;
//
//public class TableCell extends BaseElement {
//
//    private final Actions actions = new Actions(getDriverInstance());
//
//
//    public TableCell clickElement() {
//        Allure.step("Клик на ячейку таблицы '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        this.getWrappedElement().click();
//        return this;
//    }
//
//    public TableCell doubleClick() {
//        Allure.step("Двойной клик на ячейку таблицы '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.moveToElement(this.getWrappedElement()).doubleClick().build().perform();
//        return this;
//    }
//
//    @Step("Ожидание {time} миллисекунд")
//    public TableCell littleWait(int time) {
//        WaitT.littleWait(time);
//        return this;
//    }
//
//    public TableCell moveToElement() {
//        Allure.step("Навести курсор на ячейку таблицы '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.moveToElement(this.getWrappedElement()).perform();
//        return this;
//    }
//
//    public TableCell rightMouseClickTextBox() {
//        Allure.step("Клик правой кнопкой мыши по ячейку таблицы '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.contextClick(this.getWrappedElement()).perform();
//        return this;
//    }
//    public TableCell sendKeysTableCell(String string) {
//        while (TurboNavigation.isMaskClickable()) {}
//        Allure.step("Ввод значений в ячейку таблицы '" + getName() + "'");
//        this.getWrappedElement().sendKeys(string);
//        return this;
//    }
//
//    public TableCell clearAndSendKeysTableCell(String string) {
//        while (TurboNavigation.isMaskClickable()) {}
//        Allure.step("Ввод значений в ячейку таблицы '" + getName() + "'");
//        this.getWrappedElement().clear();
//        this.getWrappedElement().sendKeys(string);
//        return this;
//    }
//}
