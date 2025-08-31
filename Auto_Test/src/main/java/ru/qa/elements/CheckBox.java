package ru.qa.elements;

import io.qameta.allure.Allure;
import org.openqa.selenium.interactions.Actions;
import ru.qa.methods.WaitT;

import static ru.qa.driver.WebDriverSetup.getDriverInstance;


public class CheckBox extends BaseElement {

    private final Actions actions = new Actions(getDriverInstance());

    public CheckBox(String typeElement) {
        super(typeElement);
    }

    // Установка флажка
    public CheckBox enableCheckBox() {
        if (!isChecked()){
            Allure.step("Клик по чек-боксу '" + getName() + "'");
            WaitT.elementToBeClickable(this.getWrappedElement());
            this.getWrappedElement().click();
        }
        return this;
    }

    public CheckBox disableClickCheckBox() {
        if (isChecked()){
            Allure.step("Клик по чек-боксу '" + getName() + "'");
            WaitT.elementToBeClickable(this.getWrappedElement());
            this.getWrappedElement().click();
        }
        return this;
    }

    public CheckBox moveToElement() {
        Allure.step("Навести курсор на '" + getName() + "'");
        WaitT.elementToBeClickable(this.getWrappedElement());
        actions.moveToElement(this.getWrappedElement()).perform();
        return this;
    }

    // Проверка, что флажок установлен
    public boolean isChecked() {
        return getWrappedElement().isSelected();
    }
}
