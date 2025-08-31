package ru.qa.elements;

import io.qameta.allure.Allure;
import ru.qa.methods.WaitT;


public class RadioButton extends BaseElement {

    public RadioButton(String typeElement) {
        super(typeElement);
    }

    // Установка переключателя
    public RadioButton clickRadioButton(boolean value) {
        if (value != isSelected()) {
            Allure.step("Клик по переключателю '" + getName() + "'");
            WaitT.elementToBeClickable(this.getWrappedElement());
            this.getWrappedElement().click();
        }
        return this;
    }
    // Проверка, что переключатель установлен
    public boolean isSelected() {
        return getWrappedElement().isSelected();
    }
}
