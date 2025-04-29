//package ar.soft.element;
//
//import io.qameta.allure.Allure;
//import io.qameta.allure.Step;
//import org.openqa.selenium.interactions.Actions;
//
//public class GraphicElement extends BaseElement {
//
//    private final Actions actions = new Actions(getDriverInstance());
//
//
//    public GraphicElement clickElement() {
//        Allure.step("Клик на элемент графика '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        this.getWrappedElement().click();
//        return this;
//    }
//
//    public GraphicElement doubleClick() {
//        Allure.step("Двойной клик на элемент графика '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.moveToElement(this.getWrappedElement()).doubleClick().build().perform();
//        return this;
//    }
//
//    @Step("Ожидание {time} миллисекунд")
//    public GraphicElement littleWait(int time) {
//        WaitT.littleWait(time);
//        return this;
//    }
//
//    public GraphicElement moveToElement() {
//        Allure.step("Навести курсор на элемент графика '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.moveToElement(this.getWrappedElement()).perform();
//        return this;
//    }
//
//    public GraphicElement rightMouseClickTextBox() {
//        Allure.step("Клик правой кнопкой мыши по элемент графика '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.contextClick(this.getWrappedElement()).perform();
//        return this;
//    }
//}
