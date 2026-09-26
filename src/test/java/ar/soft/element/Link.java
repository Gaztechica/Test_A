//package ar.soft.element;
//
//import io.qameta.allure.Allure;
//import io.qameta.allure.Step;
//import org.openqa.selenium.interactions.Actions;
//
//public class Link extends BaseElement {
//
//    private final Actions actions = new Actions(getDriverInstance());
//
//
//    public Link clickElement() {
//        Allure.step("Клик на ссылку '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        this.getWrappedElement().click();
//        return this;
//    }
//
//    public Link doubleClick() {
//        Allure.step("Двойной клик на ссылку '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.moveToElement(this.getWrappedElement()).doubleClick().build().perform();
//        return this;
//    }
//
//    @Step("Ожидание {time} миллисекунд")
//    public Link littleWait(int time) {
//        WaitT.littleWait(time);
//        return this;
//    }
//
//    public Link moveToElement() {
//        Allure.step("Навести курсор на ссылку '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.moveToElement(this.getWrappedElement()).perform();
//        return this;
//    }
//
//    public Link rightMouseClickTextBox() {
//        Allure.step("Клик правой кнопкой мыши по ссылку '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.contextClick(this.getWrappedElement()).perform();
//        return this;
//    }
//}
