package ru.qa.elements;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import ru.qa.methods.WaitT;

import static ru.qa.driver.WebDriverSetup.getDriverInstance;


/**
 * @author Slava Solodov
 * @created 04/04/2023 - 16:30
 * @email vsolodov@cbgr.ru
 */

public class Calendar extends BaseElement {

    private final Actions actions = new Actions(getDriverInstance());

    public Calendar(String typeElement) {
        super(typeElement);
    }


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
