//package ar.soft.element;
//
//import io.qameta.allure.Allure;
//
//public class RadioButton extends BaseElement {
//
//    // Установка переключателя
//    public RadioButton clickRadioButton(boolean value) {
//        if (value != isSelected()) {
//            Allure.step("Клик по переключателю '" + getName() + "'");
//            WaitT.elementToBeClickable(this.getWrappedElement());
//            this.getWrappedElement().click();
//        }
//        return this;
//    }
//    // Проверка, что переключатель установлен
//    public boolean isSelected() {
//        return getWrappedElement().isSelected();
//    }
//}
