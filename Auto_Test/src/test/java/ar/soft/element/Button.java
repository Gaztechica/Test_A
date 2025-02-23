//package ar.soft.element;
//
//import io.qameta.allure.Allure;
//import io.qameta.allure.Step;
//import org.openqa.selenium.interactions.Actions;
//
//import static ar.soft.driver.WebDriverSetup.getDriverInstance;
//
//public class Button extends BaseElement {
////    public Button() {
////        super("кнопку", Button.class);
////    }
//
//    private final Actions actions = new Actions(getDriverInstance());
//
//
//    public Button clickElement() {
//        Allure.step("Клик на кнопку '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        this.getWrappedElement().click();
//        return this;
//    }
//
//    public Button doubleClick() {
//        Allure.step("Двойной клик на '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.moveToElement(this.getWrappedElement()).doubleClick().build().perform();
//        return this;
//    }
//
//    @Step("Ожидание {time} миллисекунд")
//    public Button littleWait(int time) {
//        WaitT.littleWait(time);
//        return this;
//    }
//
//    public Button moveToElement() {
//        Allure.step("Навести курсор на '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.moveToElement(this.getWrappedElement()).perform();
//        return this;
//    }
//
//    public Button rightMouseClickTextBox() {
//        Allure.step("Клик правой кнопкой мыши по '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.contextClick(this.getWrappedElement()).perform();
//        return this;
//    }
//}
