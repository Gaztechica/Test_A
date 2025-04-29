//package ar.soft.element;
//
//import io.qameta.allure.Allure;
//import io.qameta.allure.Step;
//import org.openqa.selenium.interactions.Actions;
//
//public class DateCell extends BaseElement {
//
//
//    /**
//     * @author Slava Solodov
//     * @created 04/04/2023 - 16:20
//     * @email vsolodov@cbgr.ru
//     */
//
//
//
//        private final Actions actions = new Actions(getDriverInstance());
//
//
//        public DateCell clickElement() {
//            Allure.step("Клик на поле даты '" + getName() + "'");
//            WaitT.elementToBeClickable(this.getWrappedElement());
//            this.getWrappedElement().click();
//            return this;
//        }
//
//        public DateCell doubleClick() {
//            Allure.step("Двойной клик на поле даты '" + getName() + "'");
//            WaitT.elementToBeClickable(this.getWrappedElement());
//            actions.moveToElement(this.getWrappedElement()).doubleClick().build().perform();
//            return this;
//        }
//
//        @Step("Ожидание {time} миллисекунд")
//        public DateCell littleWait(int time) {
//            WaitT.littleWait(time);
//            return this;
//        }
//
//        public DateCell moveToElement() {
//            Allure.step("Навести курсор на поле даты '" + getName() + "'");
//            WaitT.elementToBeClickable(this.getWrappedElement());
//            actions.moveToElement(this.getWrappedElement()).perform();
//            return this;
//        }
//
//        public DateCell rightMouseClickTextBox() {
//            Allure.step("Клик правой кнопкой мыши по поле даты '" + getName() + "'");
//            WaitT.elementToBeClickable(this.getWrappedElement());
//            actions.contextClick(this.getWrappedElement()).perform();
//            return this;
//        }
//
//        public DateCell enterTextFromDateCell(String value) {
//            Allure.step("Ввод значения  '"  + value + "' в поле даты " + getName());
//            WaitT.elementToBeClickable(this.getWrappedElement());
//            this.getWrappedElement().sendKeys(value);
//            return this;
//        }
//
//        /**удаление данных из поля */
//        public DateCell clearDateCell() {
//            Allure.step("отчистка поля даты - '" + getName() + "'");
//            this.getWrappedElement().clear();
//            return this;
//        }
//    }
//
//}
