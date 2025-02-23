package ar.soft.element;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;

import static ar.soft.driver.WebDriverSetup.getDriverInstance;

public class Calendar extends BaseElement {

    private final Actions actions = new Actions(getDriverInstance());


    public Calendar clickElement() {
        Allure.step("Клик на календарь '" + getName() + "'");
        WaitT.elementToBeClickable(this.getWrappedElement());
        this.getWrappedElement().click();
        return this;
    }

    public Calendar doubleClick() {
        Allure.step("Двойной клик на календарь '" + getName() + "'");
        WaitT.elementToBeClickable(this.getWrappedElement());
        actions.moveToElement(this.getWrappedElement()).doubleClick().build().perform();
        return this;
    }

    @Step("Ожидание {time} миллисекунд")
    public Calendar littleWait(int time) {
        WaitT.littleWait(time);
        return this;
    }

    public Calendar moveToElement() {
        Allure.step("Навести курсор на календарь '" + getName() + "'");
        WaitT.elementToBeClickable(this.getWrappedElement());
        actions.moveToElement(this.getWrappedElement()).perform();
        return this;
    }

    public Calendar rightMouseClickTextBox() {
        Allure.step("Клик правой кнопкой мыши по календарь '" + getName() + "'");
        WaitT.elementToBeClickable(this.getWrappedElement());
        actions.contextClick(this.getWrappedElement()).perform();
        return this;
    }
}
