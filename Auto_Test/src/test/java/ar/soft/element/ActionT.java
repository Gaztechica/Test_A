package ar.soft.element;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.util.List;

import static ar.soft.driver.WebDriverSetup.getDriverInstance;
import static org.openqa.selenium.Keys.*;
import static org.openqa.selenium.Keys.DELETE;

public class ActionT {

    static Logger log = LoggerFactory.getLogger(ActionT.class);

    protected static Actions actions;

    /** Инициализация действий, используется только один раз в TestBase */
    public static void initActions() {
        actions = new Actions(getDriverInstance());
    }

    /** Одиночный клик на элемент */
    public static class OneClick {

        /** Одиночный клик на элемент */
        @Step("Одиночный клик на элементе")
        public static void click(String locator) {
            log.info("Клик на элементе > " + locator);
            WaitT.elementToBeClickable(locator);
            actions.moveToElement(getDriverInstance().findElement(By.xpath(locator))).click().perform();
        }

        /** Одиночный клик на элемент */
        @Step("Одиночный клик на элементе")
        public static void click(WebElement webElement) {
            log.info("Клик на элементе > " + webElement.toString());
            WaitT.elementToBeClickable(webElement);
            webElement.click();
        }

        /** Одиночный клик на элемент */
        @Step("Одиночный клик на элементе")
        public static void click(By elementXpath) {
//            while (TurboNavigation.isMaskClickable())
                WaitT.visibilityOfElementLocated(elementXpath);
            WaitT.elementToBeClickable(elementXpath);
            getDriverInstance().findElement(elementXpath).click();
        }

        /** Одиночный клик на элемент и удержание */
        @Step("Нажатие и удерживание на элементе")
        public static void clickAndHold(By locator) {
            log.info("Клик на элементе --> " + locator);
            WaitT.elementToBeClickable(locator);
            actions.moveToElement(getDriverInstance().findElement(locator)).clickAndHold().perform();
        }

        /** Одиночный клик на элемент и удержание */
        @Step("Нажатие и удерживание на элементе")
        public static void clickAndHold(WebElement webElement) {
            log.info("Клик на элементе --> " + webElement);
            WaitT.elementToBeClickable(webElement);
            actions.moveToElement(webElement).clickAndHold().perform();
        }

        /** Одиночный клик на элементе правой кнопкой мыши */
        @Step("Клик правой кнопкой мыши на элементе")
        public static void rightMouseClick(String locator) {
            log.info("Клик правой кнопкой мыши на элементе --> " + locator);
            WaitT.elementToBeClickable(locator);
            actions.moveToElement(getDriverInstance().findElement(By.xpath(locator))).contextClick().perform();
        }
        /** Одиночный клик на элементе правой кнопкой мыши */
        @Step("Клик правой кнопкой мыши на элементе")
        public static void rightMouseClick(WebElement webElement) {
            log.info("Клик правой кнопкой мыши на элементе --> " + webElement);
            //WaitT.elementToBeClickable(webElement);
            actions.moveToElement(webElement).contextClick().perform();
        }

        /** Одиночный клик на элемент и ввод текста */
        @Step("Клик на элементе, очистка поля и ввод текста")
        public static void clickClearEnterText(By locator, String text) {
            WaitT.elementToBeClickable(locator);
            getDriverInstance().findElement(locator).click();
            getDriverInstance().findElement(locator).clear();
            getDriverInstance().findElement(locator).sendKeys(text);
        }

        /** Одиночный клик на элемент и ввод текста */
        @Step("Клик на элементе, очистка поля и ввод текста")
        public static void clickClearEnterText(WebElement webElement, String text) {
            WaitT.elementToBeClickable(webElement);
            webElement.click();
            webElement.clear();
            webElement.sendKeys(text);
        }


        @Step("Клик на элементе, очистка поля и ввод текста")
        public static void clickClearEnterText2(By locator, String text) {
            WaitT.elementToBeClickable(locator);
            getDriverInstance().findElement(locator).click();
            getDriverInstance().findElement(locator).clear();
            clickToHeader();
            getDriverInstance().findElement(locator).click();
            getDriverInstance().findElement(locator).sendKeys(text);
        }

        /** Одиночный клик на элемент и очистка поля */
        @Step("Клик на элементе, очистка поля")
        public static void clickClearField(String locator) {
            log.info("Клик на элементе, очистка поля");
            WaitT.elementToBeClickable(locator);
            getDriverInstance().findElement(By.xpath(locator)).click();
            getDriverInstance().findElement(By.xpath(locator)).sendKeys(CONTROL + "a");
            getDriverInstance().findElement(By.xpath(locator)).sendKeys(DELETE);
        }

        /** Одиночный клик на элемент и очистка поля */
        @Step("Клик на элементе, очистка поля")
        public static void clickClearField(WebElement webElement) {
            log.info("Клик на элементе, очистка поля");
            WaitT.elementToBeClickable(webElement);
            webElement.click();
            webElement.sendKeys(CONTROL + "a");
            webElement.sendKeys(DELETE);
        }

        /** Одиночный клик на заголовок формы */
        @Step("Клик на залоговок формы")
        public static void clickToHeader() {
            String locator = "//*[contains(@data-testid, 'Header')]//span/span";
//            while (TurboNavigation.isMaskClickable())
                WaitT.elementToBeClickable(locator);
            getDriverInstance().findElement(By.xpath(locator)).click();
        }

        /** Одиночный клик на элемент и ввод текста */
        @Step("Кликнуть на поле и ввести текст: '{text}'")
        public static void clickAndEnterText(By elementLocator, String text) {
            log.info("Нажать на поле и ввести текст " + text);
            click(elementLocator);
            SendAction.selectText(elementLocator);
            WaitT.littleWait(200);
            getDriverInstance().findElement(elementLocator).sendKeys(text);
        }

        /** Одиночный клик на элемент и ввод текста */
        @Step("Кликнуть на поле и ввести текст: '{text}'")
        public static void clickAndEnterText(WebElement webElement, String text) {
            log.info("Нажать на поле и ввести текст " + text);
            webElement.click();
            SendAction.selectText(webElement);
            WaitT.littleWait(500);
            webElement.sendKeys(text + Keys.ENTER);
        }

        /** Одиночный клик на элемент и ввод текста */
        @Step("Кликнуть на поле и ввести текст: '{text}'")
        public static void clickAndEnterTextLineBreak(By elementLocator, String text) {
            log.info("Нажать на поле и ввести текст " + text);
            click(elementLocator);
            SendAction.selectText(elementLocator);
            WaitT.littleWait(200);
            for (int i = 0; i < 5; i++) {
                getDriverInstance().findElement(elementLocator).sendKeys(text);
                getDriverInstance().findElement(elementLocator).sendKeys(SHIFT, ENTER);
                getDriverInstance().findElement(elementLocator).sendKeys(RETURN);
            }
        }

        @Step("Кликнуть на поле и ввести текст: '{text}'")
        public static void clickAndEnterTextLineBreak(WebElement webElement, String text) {
            log.info("Нажать на поле и ввести текст " + text);
            webElement.click();
            SendAction.selectText(webElement);
            WaitT.littleWait(200);
            for (int i = 0; i < 5; i++) {
                webElement.sendKeys(text);
                webElement.sendKeys(SHIFT, ENTER);
                webElement.sendKeys(RETURN);
            }
        }
    }

    /** Двойной клик на элемент */
    public static class DoubleClick {

        /** Двойной клик на элемент */
        @Step("Двойной клик на элементе")
        public static void doubleClick(String locator) {
            WaitT.elementToBeClickable(locator);
            actions.moveToElement(getDriverInstance().findElement(By.xpath(locator))).doubleClick().build().perform();
        }

        /** Двойной клик на элемент */
        @Step("Двойной клик на элементе")
        public static void doubleClick(WebElement webElement) {
            log.info("Двойной Клик на элементе > " + webElement.toString());
            WaitT.elementToBeClickable(webElement);
            actions.moveToElement(webElement).doubleClick().build().perform();
        }

        /** Двойной клик на элемент и удаление данных из поля */
        @Step("Двойной клик, удаление данных из поля + ENTER")
        public static void clickAndClear(String locator) {
            doubleClick(locator);
            getDriverInstance().findElement(By.xpath(locator)).clear();
            getDriverInstance().findElement(By.xpath(locator)).sendKeys(ENTER);
            WaitT.littleWait(300);
        }

        /** Двойной клик на элемент */
        @Step("Двойной клик, удаление данных из поля + ENTER")
        public static void clickElement(String locator) {
            doubleClick(locator);
            getDriverInstance().findElement(By.xpath(locator)).sendKeys(ENTER);
            WaitT.littleWait(300);
        }

        /** Двойной клик на элемент  */
        @Step("Двойной клик, удаление данных из поля + ENTER")
        public static void clickElement(WebElement webElement) {
            doubleClick(webElement);
            webElement.sendKeys(ENTER);
            WaitT.littleWait(300);
        }

        /** Двойной клик на элемент и удаление данных из поля */
        @Step("Двойной клик, удаление данных из поля + ENTER")
        public static void clickAndClear(WebElement webElement) {
            doubleClick(webElement);
            webElement.clear();
            webElement.sendKeys(ENTER);
            WaitT.littleWait(300);
        }

        /** Двойной клик на элемент и ввод данных в поле, нажатие ENTER */
        @Step("Двойной клик, ввод данных: '{data}' в поле + ENTER")
        public static void doubleClickSendKeysAndEnter(String locator, String data) {
            clickAndClear(locator);
            getDriverInstance().findElement(By.xpath(locator)).sendKeys(HOME + data, Keys.ENTER);
            WaitT.littleWait(300);
        }

        /** Двойной клик на элемент без очистки поля и ввод данных в поле, нажатие ENTER */
        @Step("Двойной клик, ввод данных: '{data}' в поле + ENTER")
        public static void doubleClickSendKeysAndEnterNoClear(String locator, String data) {
            clickElement(locator);
            getDriverInstance().findElement(By.xpath(locator)).sendKeys(HOME + data, Keys.ENTER);
            WaitT.littleWait(300);
        }

        @Step("Двойной клик, ввод данных: '{data}' в поле + ENTER")
        public static void doubleClickSendKeysAndEnterNoClear(WebElement webElement, String data) {
            clickElement(webElement);
            webElement.sendKeys(HOME + data, Keys.ENTER);
            WaitT.littleWait(300);
        }

        @Step("Двойной клик без очистки поля, ввод данных: '{data}' в поле + ENTER")
        public static void doubleClickSendKeysAndEnter(WebElement webElement, String data) {
            clickAndClear(webElement);
            webElement.sendKeys(HOME + data, Keys.ENTER);
            WaitT.littleWait(300);
        }


        /** Двойной клик на элемент и ввод данных в поле */
        @Step("Двойной клик, ввод данных '{data}' в поле")
        public static void doubleClickAndSendKeys(String locator, String data) {
            clickAndClear(locator);
            getDriverInstance().findElement(By.xpath(locator)).sendKeys(HOME + data);
            WaitT.littleWait(300);
        }

        /** Двойной клик на элемент и ввод данных в поле */
        @Step("Двойной клик, ввод данных '{data}' в поле")
        public static void doubleClickAndSendKeys(WebElement webElement, String data) {
            clickAndClear(webElement);
            webElement.sendKeys(HOME + data);
            WaitT.littleWait(300);
        }

        /** Двойной клик на элемент и ввод данных в поле */
        @Step("Двойной клик, ввод данных '{data}' в поле")
        public static void doubleClickAndSendKeysWithoutEnter(WebElement webElement, String data) {
            doubleClick(webElement);
            webElement.sendKeys(HOME + data);
            WaitT.littleWait(300);
        }

        /** Двойной клик на элемент и удаление данных из поля и ввод новых */
        @Step("Двойной клик очистка поля и ввод текста '{text}'")
        public static void doubleClickClearEnterText(String locator, String text) {
            log.info("[Ввод данных: " + text + "] --> [В поле: " + locator + "]");
            WaitT.elementToBeClickable(locator);
            doubleClick(locator);
            getDriverInstance().findElement(By.xpath(locator)).clear();
            getDriverInstance().findElement(By.xpath(locator)).sendKeys(HOME + text);
        }

        /** Двойной клик по координатам элемента */
        @Step("Двойной клик по координатам элемента")
        public static void doubleClickFromCoordinateElement(String locator, int x, int y){
            WebElement ele = getDriverInstance().findElement(By.xpath(locator));
            Actions action = new Actions(getDriverInstance());
            action.moveToElement(ele, x, y).doubleClick().build().perform();
        }

        /** Двойной клик по координатам элемента */
        @Step("Двойной клик по координатам элемента")
        public static void doubleClickFromCoordinateElement(WebElement webElement, int x, int y){
            Actions action = new Actions(getDriverInstance());
            action.moveToElement(webElement, x, y).doubleClick().build().perform();
        }
    }

    /** Различные манипуляции с элементами */
    public static class SendAction {

        /** Нажатие ENTER */
        @Step("Нажать ENTER")
        public static void pressEnter(String locator) {
            WaitT.elementToBeClickable(locator);
            getDriverInstance().findElement(By.xpath(locator)).sendKeys(ENTER);
        }

        /** Нажатие ENTER */
        @Step("Нажать ENTER")
        public static void doubleClickPressDelete(String locator) {
            OneClick.click(locator);
            getDriverInstance().findElement(By.xpath(locator)).sendKeys(DELETE);
        }

        /** Клик на поле и выделение текста */
        @Step("Клик на поле и выделение текста")
        public static void clickAndSelectText(String locator) {
            OneClick.click(locator);
            getDriverInstance().findElement(By.xpath(locator)).sendKeys(Keys.CONTROL + "a");
        }

        /** Выделение текста в поле */
        @Step("Выделение текста в поле")
        public static void selectText(By locator) {
            getDriverInstance().findElement(locator).sendKeys(Keys.CONTROL + "a");
        }

        /** Выделение текста в поле */
        @Step("Выделение текста в поле")
        public static void selectText(WebElement webElement) {
            webElement.sendKeys(Keys.CONTROL + "a");
        }

        /** Отправка изображения в поле ввода <input> */
        @Step("Отправка изображения в поле ввода <input>")
        public static void sendImage(By locator, String imagePath) {
            WebElement element = getDriverInstance().findElement(locator);
            element.sendKeys(imagePath);
        }
    }

    public static class Move {

        @Step("Перемещение элемента на другой веб-элемент")
        public static void dragAndDropElement(String locator, WebElement element) {
            WaitT.elementToBeClickable(locator);
            actions.clickAndHold(getDriverInstance().findElement(By.xpath(locator))).moveToElement(element).build().perform();
        }

        @Step("Перемещение элемента на другой веб-элемент")
        public static void dragAndDropElement(WebElement element1, WebElement element2) {
            WaitT.elementToBeClickable(element1);
            actions.clickAndHold(element1).moveToElement(element2).build().perform();
        }

        @Step("Перемещение элемента на: x-{x}, y-{y}")
        public static void dragElement(String locator, int x, int y) {
            WaitT.elementToBeClickable(locator);
            actions.clickAndHold(getDriverInstance().findElement(By.xpath(locator))).moveByOffset(x, y).build().perform();
        }

        @Step("Перемещение элемента на: x-{x}, y-{y}")
        public static void dragElement(WebElement webElement, int x, int y) {
            WaitT.elementToBeClickable(webElement);
            actions.clickAndHold(webElement).moveByOffset(x, y).build().perform();
        }

        @Step("Перемещение элемента на: x-{x}, y-{y}")
        public static void moveTo(int x, int y) {
            actions.moveByOffset(x, y).build().perform();
        }

        @Step("Наведение курсора на элемент")
        public static void moveToElement(String locator) {
            WaitT.elementToBeClickable(locator);
            actions.moveToElement(getDriverInstance().findElement(By.xpath(locator))).perform();
        }

        @Step("Наведение курсора на элемент")
        public static void moveToElement(WebElement locator) {
            WaitT.elementToBeClickable(locator);
            actions.moveToElement(locator).perform();
        }

        @Step("Наведение курсора на элемент")
        public static void moveToElement(By locator) {
            WaitT.elementToBeClickable(locator);
            actions.moveToElement(getDriverInstance().findElement(locator)).perform();
        }

        @Step("Наведение курсора на элемент и клик")
        public static void moveToElementAndClick(String locator) {
            WaitT.elementToBeClickable(locator);
            actions.moveToElement(getDriverInstance().findElement(By.xpath(locator))).click().build().perform();
            WaitT.littleWait(300);
        }
    }

    public static class ListElement {

        @Step("Клик по последнему элементу списка")
        public static String getTextFromLastItemAndClick(String locatorListLi) {
//            WaitT.elementToBeClickable(locatorListLi);
            List<WebElement> list = getDriverInstance().findElements(By.xpath(locatorListLi));
            String lastListText = list.get(list.size() - 1).getText();
            log.info("Текст в последнем элементе списка --> " + lastListText);
            WaitT.littleWait(300);
            actions.moveToElement(list.get(list.size() - 1)).click().build().perform();
            WaitT.littleWait(300);
            return lastListText;
        }

        @Step("Получить текст и клик по последнему элементу списка")
        public static String getTextFromLastItemAndClick(By elementXpath) {
            WaitT.presenceOfElementLocated(elementXpath);
            WaitT.elementToBeClickable(elementXpath);
            List<WebElement> list = getDriverInstance().findElements(elementXpath);
            String lastListText = list.get(list.size() - 1).getText();
            log.info("Текст в последнем элементе списка --> " + lastListText);
            actions.moveToElement(list.get(list.size() - 1)).click().build().perform();
            return lastListText;
        }

        @Step("Получить текст и клик по последнему элементу списка")
        public static String getTextFromLastItemAndClick(List<WebElement> list) {
            String lastListText = list.get(list.size() - 1).getText();
            log.info("Текст в последнем элементе списка --> " + lastListText);
            actions.moveToElement(list.get(list.size() - 1)).click().build().perform();
            return lastListText;
        }

        //@Deprecated
        @Step("Клик по последнему элементу списка")
        public static void clickToLastItemInList(List<WebElement> list) {
            //todo костыль для выпадающих списков в которых есть прокрутка
            //
            // для работы нужно добавить аргумент (String locatorListLi)
//            WaitT.elementToBeClickable(locatorListLi);
            actions.moveToElement(list.get(list.size() - 1)).click().build().perform();
        }

        @Step("Выбрать элемент из списка по его имени: {elementName}")
        public static void selectElementFromListByName(String elementName) {
            String listLocator = "//div[contains(@class, 'ScrollbarsCustom')]//li//p";
            WaitT.visibilityOfElementLocated(By.xpath(listLocator));
            WebElement dropdown = getDriverInstance().findElement(By.xpath(listLocator));
            List<WebElement> options = dropdown.findElements(By.xpath("//div[contains(@class, 'ScrollbarsCustom')]//li//p"));
            for (WebElement option : options) {
                Move.moveToElement(option);
                if (option.getText().equals(elementName)) {
                    option.click();
                    break;
                }
            }
        }

        @Step("Выбрать элемент из списка по его имени: {elementName}")
        public static void selectElementFromListByNameSelectFromDataTitle(String elementName) {
            //List<WebElement> options = getDriverInstance().findElements(By.xpath("//div[contains(@class, 'drop-down')]//ul//li"));
            List<WebElement> options = getDriverInstance().findElements(By.xpath("//div[contains(@class, 'ScrollbarsCustom-Content')]/li/p"));

            WaitT.littleWait(1000);
            for (WebElement option : options) {
                Move.moveToElement(option);
                //if (option.getAttribute("data-title").equals(elementName)) {
                if (option.getText().equals(elementName)) {
                    option.click();
                    break;
                }
            }
        }
    }

    public static class Frame {

        @Step("Переход на фрейм")
        public static void switchToFrame(String locatorFrame) {
//            while (TurboNavigation.isMaskClickable()) {}
            WaitT.elementToBeClickable(locatorFrame);
            getDriverInstance().switchTo().frame(getDriverInstance().findElement(By.xpath(locatorFrame)));
        }

        @Step("Переход на фрейм")
        public static void switchToFrame(WebElement webElement) {
//            while (TurboNavigation.isMaskClickable()) {}
            WaitT.elementToBeClickable(webElement);
            getDriverInstance().switchTo().frame(webElement);
        }

        // переход во фрейм для поиска элемента в DOM
        @Step("Переход на фрейм")
        public static void switchToFrameSearchElementFromDOM(String locatorFrame) {
            //while (TurboNavigation.isMaskClickable()) {}
            getDriverInstance().switchTo().frame(getDriverInstance().findElement(By.xpath(locatorFrame)));
        }

        // переход во фрейм для поиска элемента в DOM
        @Step("Переход на фрейм")
        public static void switchToFrameSearchElementFromDOM(WebElement webElement) {
            //while (TurboNavigation.isMaskClickable()) {}
            getDriverInstance().switchTo().frame(webElement);
        }

        @Step("Выход из фрейма")
        public static void exitFrame() {
            getDriverInstance().switchTo().defaultContent();
        }
    }

    public static class Service {

        @Step("Кликнуть закрыть подформу")
        public static void closeSubformIfOpen() {
            String locator = "//div[@data-testid='Cmd:Close']";
//            if (AssertionT.Element.isElementsMoreThanOne(By.xpath(locator))) {
                getDriverInstance().findElement(By.xpath(locator)).click();
            }

        }

        @Step("Кликнуть закрыть подформу")
        public static void closeSubformIfOpen(String locator) {
            WaitT.littleWait(1000);
//            if (AssertionT.Element.isElementsMoreThanOne(By.xpath(locator))) {
                getDriverInstance().findElement(By.xpath(locator)).click();
            }
        }

//    }

//    public static class Window {
//
//        @Step("Перезагрузить страницу")
//        public static void refreshWindow() {
//            getDriverInstance().navigate().refresh();
//        }
//
//        @Step("Установить размер окна")
//        public static void setSizeWindow(int widht, int height) {
//            Dimension newDimension = new Dimension(widht, height);
//            getDriverInstance().manage().window().setSize(newDimension );
//        }
//
//        @Step("Установить размер окна - максимум")
//        public static void setSizeWindowMax() {
//            getDriverInstance().manage().window().fullscreen();
//        }
//    }
//
//    public static class Screenshot {
//        @Step("Сделать скриншот")
//        public static BufferedImage makeScreenshot(){
//            return new AShot()
//                    .takeScreenshot(getDriverInstance()).getImage();
//        }
//    }
//}
