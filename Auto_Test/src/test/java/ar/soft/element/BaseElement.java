package ar.soft.element;

import ru.yandex.qatools.htmlelements.element.HtmlElement;

public abstract class BaseElement extends HtmlElement {
//    private final String typeElement;
//
//    private final Actions actions = new Actions(getDriverInstance());
//
//    public BaseElement(String typeElement) {
//        this.typeElement = typeElement;
//    }
//
//    public BaseElement clickElement() {
//        Allure.step("Клик на " + typeElement + " " + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        this.getWrappedElement().click();
//        return this;
//    }
//
//    public BaseElement doubleClick() {
//        Allure.step("Двойной клик на " + typeElement + " " + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.moveToElement(this.getWrappedElement()).doubleClick().build().perform();
//        return this;
//    }
//
//    //?????????
//    public BaseElement doubleClickAndSendKeys(String data) {
//        Allure.step("Двойной клик, ввод данных в " + typeElement + " " + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.doubleClick(this.getWrappedElement());
//        this.getWrappedElement().clear();
//        WaitT.littleWait(300);
//        this.getWrappedElement().sendKeys(HOME + data);
//        WaitT.littleWait(300);
//        return this;
//    }
//
//    @Step("Ожидание {time} миллисекунд")
//    public BaseElement littleWait(int time) {
//        WaitT.littleWait(time);
//        return this;
//    }
//
//    public BaseElement moveToElement() {
//        Allure.step("Навести курсор на " + typeElement + " " + getName());
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.moveToElement(this.getWrappedElement()).perform();
//        return this;
//    }
//
//    public BaseElement rightMouseClickTextBox() {
//        Allure.step("Клик правой кнопкой мыши по " + typeElement + getName());
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.contextClick(this.getWrappedElement()).perform();
//        return this;
//    }
}
