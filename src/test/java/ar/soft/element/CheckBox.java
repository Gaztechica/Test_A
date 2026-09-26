//package ar.soft.element;
//
//import io.qameta.allure.Allure;
//import org.openqa.selenium.interactions.Actions;
//
//import static ar.soft.driver.WebDriverSetup.getDriverInstance;
//
//public class CheckBox extends BaseElement {
//
//    private final Actions actions = new Actions(getDriverInstance());
//
//    // Установка флажка
//    public CheckBox enableCheckBox() {
//        if (!isChecked()){
//            Allure.step("Клик по чек-боксу '" + getName() + "'");
//            WaitT.elementToBeClickable(this.getWrappedElement());
//            this.getWrappedElement().click();
//        }
//        return this;
//    }
//
//    public CheckBox disableClickCheckBox() {
//        if (isChecked()){
//            Allure.step("Клик по чек-боксу '" + getName() + "'");
//            WaitT.elementToBeClickable(this.getWrappedElement());
//            this.getWrappedElement().click();
//        }
//        return this;
//    }
//
//    public CheckBox moveToElement() {
//        Allure.step("Навести курсор на '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.moveToElement(this.getWrappedElement()).perform();
//        return this;
//    }
//
//    // Проверка, что флажок установлен
//    public boolean isChecked() {
//        return getWrappedElement().isSelected();
//    }
//}
