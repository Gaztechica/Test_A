//package ar.soft.element;
//
//import io.qameta.allure.Allure;
//import io.qameta.allure.Step;
//import org.openqa.selenium.interactions.Actions;
//import ru.cbgr.qa.methods.ru.qa.WaitT;
//import ru.cbgr.qa.service.ru.qa.TurboNavigation;
//import io.qameta.allure.Allure;
//import io.qameta.allure.Step;
//import org.openqa.selenium.interactions.Actions;
//
//import static ar.soft.driver.WebDriverSetup.getDriverInstance;
//
//public class Other extends BaseElement {
//
//    private final Actions actions = new Actions(getDriverInstance());
//
//
//    public Other clickElement() {
//        Allure.step("Клик на элемент '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        this.getWrappedElement().click();
//        return this;
//    }
//
//    public Other doubleClick() {
//        Allure.step("Двойной клик на элемент '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.moveToElement(this.getWrappedElement()).doubleClick().build().perform();
//        return this;
//    }
//
//    @Step("Ожидание {time} миллисекунд")
//    public Other littleWait(int time) {
//        WaitT.littleWait(time);
//        return this;
//    }
//
//    public Other moveToElement() {
//        Allure.step("Навести курсор на элемент '" + getName() + "'");
//        //WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.moveToElement(this.getWrappedElement()).perform();
//        return this;
//    }
//
//    public Other rightMouseClickTextBox() {
//        Allure.step("Клик правой кнопкой мыши по элемент '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.contextClick(this.getWrappedElement()).perform();
//        return this;
//    }
//}
