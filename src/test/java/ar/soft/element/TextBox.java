//package ar.soft.element;
//
//import io.qameta.allure.Allure;
//import io.qameta.allure.Step;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.interactions.Actions;
//
//import static ar.soft.driver.WebDriverSetup.getDriverInstance;
//import static java.lang.Character.getName;
//
//public class TextBox extends BaseElement {
//    private final Actions actions = new Actions(getDriverInstance());
//
//    public TextBox clickElement() {
//        Allure.step("Клик на поле ввода '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        this.getWrappedElement().click();
//        return this;
//    }
//
//    public TextBox doubleClick() {
//        Allure.step("Двойной клик на поле ввода '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.moveToElement(this.getWrappedElement()).doubleClick().build().perform();
//        return this;
//    }
//
//    @Step("Ожидание {time} миллисекунд")
//    public TextBox littleWait(int time) {
//        WaitT.littleWait(time);
//        return this;
//    }
//
//    public TextBox moveToElement() {
//        Allure.step("Навести курсор на поле ввода '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.moveToElement(this.getWrappedElement()).perform();
//        return this;
//    }
//
//    public TextBox rightMouseClickTextBox() {
//        Allure.step("Клик правой кнопкой мыши по поле ввода '" + getName() + "'");
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        actions.contextClick(this.getWrappedElement()).perform();
//        return this;
//    }
//    // Ввод значения в текстовое поле
//    public TextBox clickAndEnterTextFromTextBox(String value) {
//        Allure.step("Ввод значения  '"  + value + "' в текстовое поле " + getName());
////        WaitT.elementToBeClickable(this.getWrappedElement());
//        this.getWrappedElement().click();
//        this.getWrappedElement().clear();
//        this.getWrappedElement().sendKeys(value);
//        return this;
//    }
//
//    public TextBox clickAndEnterTextFromTextBox2(String value) {
//        Allure.step("Ввод значения  '"  + value + "' в текстовое поле " + getName());
////        WaitT.elementToBeClickable(this.getWrappedElement());
//        this.getWrappedElement().click();
//        this.getWrappedElement().sendKeys(Keys.DELETE);
//        this.getWrappedElement().sendKeys(value);
//        return this;
//    }
//
//    public TextBox doubleClickAndEnterTextFromTextBox(String value) {
//        Allure.step("дабл-клик и Ввод значения  '"  + value + "' в текстовое поле " + getName());
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        this.getWrappedElement().click();
//        WaitT.littleWait(1000);
//        this.getWrappedElement().click();
//        this.getWrappedElement().sendKeys(value);
//        return this;
//    }
//
//
//    public TextBox enterTextFromTextBox(String value) {
//        Allure.step("Ввод значения  '"  + value + "' в текстовое поле " + getName());
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        WaitT.littleWait(1000);
//        this.getWrappedElement().sendKeys(value);
//        return this;
//    }
//
//    public TextBox clearTextBox() {
//        Allure.step("Отчистка текстового поля " + getName());
//        WaitT.elementToBeClickable(this.getWrappedElement());
//        this.getWrappedElement().sendKeys(Keys.CONTROL + "a");
//        this.getWrappedElement().sendKeys(Keys.BACK_SPACE);
//        return this;
//    }
//
//    public TextBox selectText() {
//        Allure.step("Выделение текста в поле " + getName());
//        this.getWrappedElement().sendKeys(Keys.CONTROL + "a");
//        return this;
//    }
//
//
//}
