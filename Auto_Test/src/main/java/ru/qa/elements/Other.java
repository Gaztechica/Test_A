package ru.qa.elements;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import ru.qa.methods.WaitT;

import static ru.qa.driver.WebDriverSetup.getDriverInstance;


/**
 * @author Slava Solodov
 * @created 04/04/2023 - 16:07
 * @email vsolodov@cbgr.ru
 */

public class Other extends BaseElement {
    private final Actions actions = new Actions(getDriverInstance());

    public Other(String typeElement) {
        super(typeElement);
    }


    public Other clickElement() {
        Allure.step("Клик на элемент '" + getName() + "'");
        WaitT.elementToBeClickable(this.getWrappedElement());
        this.getWrappedElement().click();
        return this;
    }

    public Other doubleClick() {
        Allure.step("Двойной клик на элемент '" + getName() + "'");
        WaitT.elementToBeClickable(this.getWrappedElement());
        actions.moveToElement(this.getWrappedElement()).doubleClick().build().perform();
        return this;
    }

    @Step("Ожидание {time} миллисекунд")
    public Other littleWait(int time) {
        WaitT.littleWait(time);
        return this;
    }

    public Other moveToElement() {
        Allure.step("Навести курсор на элемент '" + getName() + "'");
        //WaitT.elementToBeClickable(this.getWrappedElement());
        actions.moveToElement(this.getWrappedElement()).perform();
        return this;
    }

    public Other rightMouseClickTextBox() {
        Allure.step("Клик правой кнопкой мыши по элемент '" + getName() + "'");
        WaitT.elementToBeClickable(this.getWrappedElement());
        actions.contextClick(this.getWrappedElement()).perform();
        return this;
    }
}
