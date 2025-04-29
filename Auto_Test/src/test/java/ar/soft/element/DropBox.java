//package ar.soft.element;
//
//import io.qameta.allure.Allure;
//import io.qameta.allure.Step;
//import org.openqa.selenium.interactions.Actions;
//
//public class DropBox extends BaseElement{
//
//    private final Actions actions = new Actions(getDriverInstance());
//
//
//    public DropBox clickElement() {
//        Allure.step("Клик на выпадающий список '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        this.getWrappedElement().click();
//        return this;
//    }
//
//    public DropBox doubleClick() {
//        Allure.step("Двойной клик на выпадающий список '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.moveToElement(this.getWrappedElement()).doubleClick().build().perform();
//        return this;
//    }
//
//    @Step("Ожидание {time} миллисекунд")
//    public DropBox littleWait(int time) {
//        WaitT.littleWait(time);
//        return this;
//    }
//
//    public DropBox moveToElement() {
//        Allure.step("Навести курсор на выпадающий список '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.moveToElement(this.getWrappedElement()).perform();
//        return this;
//    }
//
//    public DropBox rightMouseClickTextBox() {
//        Allure.step("Клик правой кнопкой мыши по выпадающий список '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.contextClick(this.getWrappedElement()).perform();
//        return this;
//    }
//}
