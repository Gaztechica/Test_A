//package ar.soft.element;
//
//import io.qameta.allure.Step;
//import org.openqa.selenium.*;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.Assert;
//
//import java.awt.image.BufferedImage;
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class AssertionT {
//
//    private static final Logger log = LoggerFactory.getLogger(AssertionT.class);
//
//    /**
//     * Все проверки, связанные с цветами
//     */
//    public static class Color {
//
//        @Step("Ожидание изменения цвета border-(bottom, left, right, top)-color у элемента")
//        public static void checkBorderColor(String locator, String borderColor) {
//            assertThat(WaitT.isAttributeContainsText(By.xpath(locator), "border-bottom-color", borderColor)).
//                    as("Ожидание изменения цвета border-bottom-color у элемента --> " + locator).isTrue();
//            assertThat(WaitT.isAttributeContainsText(By.xpath(locator), "border-left-color", borderColor)).
//                    as("Ожидание изменения цвета border-bottom-color у элемента --> " + locator).isTrue();
//            assertThat(WaitT.isAttributeContainsText(By.xpath(locator), "border-right-color", borderColor)).
//                    as("Ожидание изменения цвета border-bottom-color у элемента --> " + locator).isTrue();
//            assertThat(WaitT.isAttributeContainsText(By.xpath(locator), "border-top-color", borderColor)).
//                    as("Ожидание изменения цвета border-bottom-color у элемента --> " + locator).isTrue();
//        }
//
//        @Step("Ожидание изменения цвета border-(bottom, left, right, top)-color у элемента")
//        public static void checkBorderColor(WebElement webElement, String borderColor) {
//            System.out.println("border-bottom-color " + webElement.getCssValue("border-bottom-color"));
//            assertThat(WaitT.isAttributeContainsText(webElement, "border-bottom-color", borderColor)).
//                    as("Ожидание изменения цвета border-bottom-color у элемента --> " + webElement.getText()).isTrue();
//            assertThat(WaitT.isAttributeContainsText(webElement, "border-left-color", borderColor)).
//                    as("Ожидание изменения цвета border-bottom-color у элемента --> " + webElement.getText()).isTrue();
//            assertThat(WaitT.isAttributeContainsText(webElement, "border-right-color", borderColor)).
//                    as("Ожидание изменения цвета border-bottom-color у элемента --> " + webElement.getText()).isTrue();
//            assertThat(WaitT.isAttributeContainsText(webElement, "border-top-color", borderColor)).
//                    as("Ожидание изменения цвета border-bottom-color у элемента --> " + webElement.getText()).isTrue();
//        }
//
//        @Step("Проверка цвета border-color у элемента")
//        public static void checkCSSBorderColor(WebElement webElement, String borderColor) {
//            WaitT.littleWait(500);
//            Assert.assertEquals(webElement.getCssValue("border-bottom-color"), borderColor);
//            Assert.assertEquals(webElement.getCssValue("border-left-color"), borderColor);
//            Assert.assertEquals(webElement.getCssValue("border-right-color"), borderColor);
//            Assert.assertEquals(webElement.getCssValue("border-top-color"), borderColor);
//            WaitT.littleWait(500);
//        }
//
//        @Step("Проверка что элемент имеет цвет {searchedColor}")
//        public static void moveAndCheckBorderColor(By locator, String searchedColor) {
//            WaitT.presenceOfElementLocated(locator);
//            WaitT.elementToBeClickable(locator);
//            ActionT.Move.moveToElement(locator);
//            assertThat(WaitT.isAttributeContainsText(locator, "border-bottom-color", searchedColor)).
//                    as("Неверный атрибут").isTrue();
//            assertThat(WaitT.isAttributeContainsText(locator, "border-left-color", searchedColor)).
//                    as("Неверный атрибут").isTrue();
//            assertThat(WaitT.isAttributeContainsText(locator, "border-right-color", searchedColor)).
//                    as("Неверный атрибут").isTrue();
//            assertThat(WaitT.isAttributeContainsText(locator, "border-top-color", searchedColor)).
//                    as("Неверный атрибут").isTrue();
//        }
//
//        @Step("Проверка что элемент имеет цвет {searchedColor}")
//        public static void moveAndCheckBorderColor(WebElement webElement, String searchedColor) {
//            WaitT.elementToBeClickable(webElement);
//            ActionT.Move.moveToElement(webElement);
//            System.out.println("border-bottom-color " + webElement.getCssValue("border-bottom-color"));
//            assertThat(WaitT.isAttributeContainsText(webElement, "border-bottom-color", searchedColor)).
//                    as("Неверный атрибут").isTrue();
//            assertThat(WaitT.isAttributeContainsText(webElement, "border-left-color", searchedColor)).
//                    as("Неверный атрибут").isTrue();
//            assertThat(WaitT.isAttributeContainsText(webElement, "border-right-color", searchedColor)).
//                    as("Неверный атрибут").isTrue();
//            assertThat(WaitT.isAttributeContainsText(webElement, "border-top-color", searchedColor)).
//                    as("Неверный атрибут").isTrue();
//        }
//
//        @Step("Нажать на элемент и проверить обводку")
//        public static void clickToElementAndCheckBorderColor(By locator, String searchedColor) {
//            WaitT.presenceOfElementLocated(locator);
//            WaitT.elementToBeClickable(locator);
//            ActionT.OneClick.click(locator);
//            System.out.println("border-bottom-color " +
//                    getDriverInstance().findElement(locator).getCssValue("border-bottom-color"));
//            assertThat(WaitT.isAttributeContainsText(locator, "border-bottom-color", searchedColor)).
//                    as("Неверный атрибут").isTrue();
//            assertThat(WaitT.isAttributeContainsText(locator, "border-left-color", searchedColor)).
//                    as("Неверный атрибут").isTrue();
//            assertThat(WaitT.isAttributeContainsText(locator, "border-right-color", searchedColor)).
//                    as("Неверный атрибут").isTrue();
//            assertThat(WaitT.isAttributeContainsText(locator, "border-top-color", searchedColor)).
//                    as("Неверный атрибут").isTrue();
//
//
//        }
//
//        @Step("Нажать на элемент и проверить обводку")
//        public static void clickToElementAndCheckBorderColor(WebElement webElement, String searchedColor) {
//            WaitT.elementToBeClickable(webElement);
//            webElement.click();
//            System.out.println("border-bottom-color " + webElement.getCssValue("border-bottom-color"));
//            assertThat(WaitT.isAttributeContainsText(webElement, "border-bottom-color", searchedColor)).
//                    as("Неверный атрибут").isTrue();
//            assertThat(WaitT.isAttributeContainsText(webElement, "border-left-color", searchedColor)).
//                    as("Неверный атрибут").isTrue();
//            assertThat(WaitT.isAttributeContainsText(webElement, "border-right-color", searchedColor)).
//                    as("Неверный атрибут").isTrue();
//            assertThat(WaitT.isAttributeContainsText(webElement, "border-top-color", searchedColor)).
//                    as("Неверный атрибут").isTrue();
//        }
//
//        @Step("Проверить фоновый цвет")
//        public static void checkBackgroundColor(By locator, String searchedColor) {
//            WaitT.presenceOfElementLocated(locator);
//            WaitT.elementToBeClickable(locator);
//            ActionT.Move.moveToElement(locator);
//            assertThat(WaitT.isAttributeContainsText(locator, "background-color", searchedColor)).
//                    as("Неверный атрибут").isTrue();
//        }
//
//        @Step("Проверить фоновый цвет")
//        public static void checkBackgroundColor(WebElement webElement, String searchedColor) {
//            WaitT.elementToBeClickable(webElement);
//            ActionT.Move.moveToElement(webElement);
//            System.out.println("background-color " + webElement.getCssValue("background-color"));
//            assertThat(WaitT.isAttributeContainsText(webElement, "background-color", searchedColor)).
//                    as("Неверный атрибут").isTrue();
//        }
//
//        @Step("Проверить фоновый цвет при клике")
//        public static void checkBackgroundColorClick(WebElement webElement, String searchedColor) {
//            ActionT.OneClick.click(webElement);
//            ActionT.Move.moveToElement(webElement);
//            System.out.println("background-color " + webElement.getCssValue("background-color"));
//            assertThat(WaitT.isAttributeContainsText(webElement, "background-color", searchedColor)).
//                    as("Неверный атрибут").isTrue();
//        }
//
//        @Step("Проверить фоновый цвет")
//        public static void clickToElementAndCheckBackgroundColor(WebElement webElement, String searchedColor) {
//            WaitT.elementToBeClickable(webElement);
//            ActionT.OneClick.click(webElement);
//            System.out.println(webElement.getCssValue("background-color"));
//            assertThat(WaitT.isAttributeContainsText(webElement, "background-color", searchedColor)).
//                    as("Неверный атрибут").isTrue();
//        }
//
//        @Step("Проверяем изменение цвета background-color при наведении у каждого элемента списка")
//        public static void checkColorInDropDownList(String locatorListLi, String controlBorderColor) {
//            WebDriverWait wait = new WebDriverWait(getDriverInstance(), Duration.ofSeconds(5));
//            Wait.visibilityElementLocatedWait(locatorListLi);
//            List<WebElement> list = getDriverInstance().findElements(By.xpath(locatorListLi));
//            for (WebElement webElement : list) {
//                Actions act = new Actions(getDriverInstance());
//                act.moveToElement(webElement).perform();
//                Assert.assertTrue(wait.until(ExpectedConditions.attributeContains(webElement, "background-color", controlBorderColor)), "Ожидание появления [атрибута: свойства] --> background-color: " + controlBorderColor + " у элемента --> " + webElement);
//            }
//        }
//
//        @Step("Проверяем изменение цвета background-color при наведении у каждого элемента списка")
//        public static void checkColorInDropDownList(List<WebElement> webElements, String controlBorderColor) {
//            WebDriverWait wait = new WebDriverWait(getDriverInstance(), Duration.ofSeconds(5));
//            for (WebElement webElement : webElements) {
//                Actions act = new Actions(getDriverInstance());
//                act.moveToElement(webElement).perform();
//                System.out.println(webElement.getCssValue("background-color"));
//                Assert.assertTrue(wait.until(ExpectedConditions.attributeContains(webElement, "background-color", controlBorderColor)), "Ожидание появления [атрибута: свойства] --> background-color: " + controlBorderColor + " у элемента --> " + webElement);
//            }
//        }
//
//        @Step("Изменение цветов [border-(bottom, left, right, top)-color: {colorBorder}] и [background-color: {colorBackground}] при даблклике")
//        public static void checkBackgroundAndBorderColorAfterDoubleClick(String locator, String colorBorder, String colorBackground) {
//            ActionT.DoubleClick.doubleClick(locator);
//            checkBorderColor(locator, colorBorder);
//            Wait.attributeToBeWait(locator, "background-color", colorBackground);
//        }
//
//        @Step("Изменение цветов [border-(bottom, left, right, top)-color: {colorBorder}] и [background-color: {colorBackground}] при даблклике")
//        public static void checkBackgroundAndBorderColorAfterDoubleClick(WebElement webElement, String colorBorder, String colorBackground) {
//            ActionT.DoubleClick.doubleClick(webElement);
//            checkBorderColor(webElement, colorBorder);
//            Wait.attributeToBeWait(webElement, "background-color", colorBackground);
//        }
//
//        @Step("Изменение цветов [border-(bottom, left, right, top)-color: {colorBorder}] и [background-color: {colorBackground}] при клике")
//        public static void checkBackgroundAndBorderColorAfterClick(String locator, String colorBorder, String colorBackground) {
//            ActionT.OneClick.click(locator);
//            checkBorderColor(locator, colorBorder);
//            Wait.attributeToBeWait(locator, "background-color", colorBackground);
//        }
//
//        @Step("Изменение цветов [border-(bottom, left, right, top)-color: {colorBorder}] и [background-color: {colorBackground}] при клике")
//        public static void checkBackgroundAndBorderColorAfterClick(WebElement webElement, String colorBorder, String colorBackground) {
//            ActionT.OneClick.click(webElement);
//            WaitT.littleWait(1000);
//            System.out.println("colorBorder " + webElement.getCssValue("border-color"));
//            checkBorderColor(webElement, colorBorder);
//            System.out.println("background-color " + webElement.getCssValue("background-color"));
//            Wait.attributeToBeWait(webElement, "background-color", colorBackground);
//        }
//
//        @Step("Изменение цветов [border-(bottom, left, right, top)-color: {colorBorder}] при наведении курсора")
//        public static void checkBorderColorAfterMoveToElement(String locator, String colorBorder) {
//            ActionT.Move.moveToElement(locator);
//            WaitT.littleWait(200);
//            checkBorderColor(locator, colorBorder);
//        }
//
//        @Step("Изменение цветов [border-(bottom, left, right, top)-color: {colorBorder}] при наведении курсора")
//        public static void checkBorderColorAfterMoveToElement(WebElement webElement, String colorBorder) {
//            ActionT.Move.moveToElement(webElement);
//            WaitT.littleWait(200);
//            checkBorderColor(webElement, colorBorder);
//        }
//    }
//
//    /**
//     * Проверки ожидания появления элементов
//     */
//    public static class Wait {
//        @Step("Ожидание появления текста у элемента")
//        public static void textToBePresentInElementWait(String locator, String text) {
//            assertThat(WaitT.isPresenceOfTextInElement(By.xpath(locator), text)).
//                    as("Элемент не содержит ожидаемый текст").isTrue();
//        }
//
//        @Step("Ожидание появления текста у элемента")
//        public static void textToBePresentInElementWait(WebElement webElement, String text) {
//            assertThat(WaitT.isPresenceOfTextInElement(webElement, text)).
//                    as("Элемент не содержит ожидаемый текст").isTrue();
//        }
//
//        @Step("Ожидание исчезновения/видимости элемента")
//        public static void invisibilityElementLocatedWait(String locator) {
//            assertThat(WaitT.isInvisibilityOfElement(By.xpath(locator))).
//                    as("Элемент не должен быть виден").isTrue();
//        }
//
//        @Step("Ожидание появления/видимости элемента")
//        public static void visibilityElementLocatedWait(String locator) {
//            assertThat(WaitT.isElementDisplayed(By.xpath(locator))).
//                    as("Элемент не отображается").isTrue();
//        }
//
//        @Step("Ожидание появления/видимости элемента")
//        public static void visibilityElementLocatedWait(WebElement webElement) {
//            assertThat(WaitT.isElementDisplayed(webElement)).
//                    as("Элемент не отображается").isTrue();
//        }
//
//        @Step("Ожидание появления/видимости элемента")
//        public static void invisibilityElementLocatedWait(WebElement webElement) {
//            assertThat(WaitT.isInvisibilityOfElement(webElement)).
//                    as("Элемент не отображается").isTrue();
//        }
//
//        @Step("Ожидание появления [атрибута: {attribute}] -> [свойства: {expectedProperty}] -> у элемента")
//        public static void attributeToBeWait(String locator, String attribute, String expectedProperty) {
//            log.info("Ожидание [" + attribute + ": " + expectedProperty + "]");
//            WaitT.elementToBeClickable(locator);
//            assertThat(WaitT.wait.until(ExpectedConditions.attributeToBe(By.xpath(locator), attribute, expectedProperty))).
//                    as("Ожидание появления [атрибута: свойства] --> " + attribute + ": " + expectedProperty + " у элемента --> " + locator).isTrue();
//        }
//
//        @Step("Ожидание появления [атрибута: {attribute}] -> [свойства: {expectedProperty}] -> у элемента")
//        public static void attributeToBeWait(WebElement webElement, String attribute, String expectedProperty) {
//            log.info("Ожидание [" + attribute + ": " + expectedProperty + "]");
//            WaitT.elementToBeClickable(webElement);
//            System.out.println("background-color " + webElement.getCssValue("background-color"));
//            assertThat(WaitT.wait.until(ExpectedConditions.attributeToBe(webElement, attribute, expectedProperty))).
//                    as("Ожидание появления [атрибута: свойства] --> " + attribute + ": " + expectedProperty + " у элемента --> " + webElement).isTrue();
//        }
//    }
//
//    public static class Sort {
//
//        @Step("Проверка что после сортировки порядок элементов не совпадает (сортируется)")
//        public static void clickListElementsIsNotEquals(String elementsList, String headerLocator) {
//            ArrayList<String> beforeSortList = new ArrayList<>();
//            ArrayList<String> afterSortList = new ArrayList<>();
//
//            for (WebElement element : getDriverInstance().findElements(By.xpath(elementsList))) {
//                beforeSortList.add(element.getText());
//            }
//
//            ActionT.OneClick.click(headerLocator);
//            WaitT.littleWait(3000);
//
//            for (WebElement element : getDriverInstance().findElements(By.xpath(elementsList))) {
//                afterSortList.add(element.getText());
//            }
//
//            assertThat(beforeSortList).as("Элементы расположенны в том же порядке, не изменили сортировку!").isNotEqualTo(afterSortList);
//        }
//
//        @Step("Проверка что после сортировки порядок элементов не совпадает (сортируется)")
//        public static void clickListElementsIsNotEquals(List<WebElement> webElementsList, WebElement header) {
//            ArrayList<String> beforeSortList = new ArrayList<>();
//            ArrayList<String> afterSortList = new ArrayList<>();
//
//            for (WebElement element : webElementsList) {
//                beforeSortList.add(element.getText());
//            }
//
//            ActionT.OneClick.click(header);
//            WaitT.littleWait(3000);
//
//            for (WebElement element : webElementsList) {
//                afterSortList.add(element.getText());
//            }
//
//            assertThat(beforeSortList).as("Элементы расположенны в том же порядке, не изменили сортировку!").isNotEqualTo(afterSortList);
//        }
//
//        @Step("Проверка что после сортировки порядок элементов не совпадает (сортируется)")
//        public static void twoClickListElementsIsNotEquals(String elementsList, String headerLocator) {
//            ArrayList<String> beforeSortList = new ArrayList<>();
//            ArrayList<String> afterSortList = new ArrayList<>();
//
//            for (WebElement element : getDriverInstance().findElements(By.xpath(elementsList))) {
//                beforeSortList.add(element.getText());
//            }
//
//            ActionT.OneClick.click(headerLocator);
//            WaitT.littleWait(2000);
//            ActionT.OneClick.click(headerLocator);
//            WaitT.littleWait(3000);
//
//            for (WebElement element : getDriverInstance().findElements(By.xpath(elementsList))) {
//                afterSortList.add(element.getText());
//            }
//
//            assertThat(beforeSortList).as("Элементы расположенны в том же порядке, не изменили сортировку!").isNotEqualTo(afterSortList);
//        }
//
//        @Step("Проверка что после сортировки порядок элементов не совпадает (сортируется)")
//        public static void doubleClickListElementsIsNotEquals(String elementsList, String headerLocator) {
//            ArrayList<String> beforeSortList = new ArrayList<>();
//            ArrayList<String> afterSortList = new ArrayList<>();
//
//            for (WebElement element : getDriverInstance().findElements(By.xpath(elementsList))) {
//                beforeSortList.add(element.getText());
//            }
//
//            ActionT.DoubleClick.doubleClick(headerLocator);
////            ActionT.OneClick.click(headerLocator);
//            WaitT.littleWait(4000);
//
//            for (WebElement element : getDriverInstance().findElements(By.xpath(elementsList))) {
//                afterSortList.add(element.getText());
//            }
//
//            assertThat(beforeSortList).as("Элементы расположенны в том же порядке, не изменили сортировку!").isNotEqualTo(afterSortList);
//        }
//
//    }
//
//    /**
//     * Проверки элементов
//     */
//    public static class Element {
//
//        @Step("Проверка что элемент отображается на странице")
//        public static void elementDisplayed(By element) {
//            while (TurboNavigation.isMaskClickable()) {
//            }
//            boolean elementPresentOnPage = isElementDisplayed(element);
//            assertThat(elementPresentOnPage).as("Элемент с таким локатором не отображается").isTrue();
//            log.info("Элемент с таким локатором отображается на странице");
//        }
//
//        @Step("Проверка что элемент отображается на странице")
//        public static void elementDisplayed(WebElement webElement) {
//            while (TurboNavigation.isMaskClickable()) {
//            }
//            boolean elementPresentOnPage = isElementDisplayed(webElement);
//            assertThat(elementPresentOnPage).as("Элемент с таким локатором не отображается").isTrue();
//            log.info("Элемент с таким локатором отображается на странице");
//        }
//
//        @Step("Проверка что элемент не отображается на странице")
//        public static void elementNotDisplayed(WebElement element) {
//            while (TurboNavigation.isMaskClickable()) {
//            }
//            boolean elementPresentOnPage = isElementDisplayed(element);
//            assertThat(elementPresentOnPage).as("Элемент с таким локатором отображается").isFalse();
//            log.info("Элемент с таким локатором не отображается на странице");
//        }
//
//        @Step("Проверка что элемент не отображается на странице")
//        public static void elementNotDisplayed(By element) {
//            while (TurboNavigation.isMaskClickable()) {
//            }
//            boolean elementPresentOnPage = isElementDisplayed(element);
//            assertThat(elementPresentOnPage).as("Элемент с таким локатором отображается").isFalse();
//            log.info("Элемент с таким локатором не отображается на странице");
//        }
//
//        @Step("Проверка что элемент {attributeName} имеет css свойство {expectedAttributeValue}")
//        public static void elementHaveCSSValue(By elementXpath, String attributeName, String expectedAttributeValue) {
//            String actualAttribute = MethodT.getElementCssProperty(elementXpath, attributeName);
//            assertThat(actualAttribute).as("Неверный атрибут").isEqualTo(expectedAttributeValue);
//            log.info("Элемент " + attributeName + " имеет значение " + actualAttribute);
//        }
//
//        @Step("Проверка что элемент {attributeName} имеет css свойство {expectedAttributeValue}")
//        public static void elementHaveCSSValue(WebElement webElement, String attributeName, String expectedAttributeValue) {
//            String actualAttribute = MethodT.getElementCssProperty(webElement, attributeName);
//            System.out.println("grid-template-columns " + webElement.getCssValue("grid-template-columns"));
//            assertThat(actualAttribute).as("Неверный атрибут").isEqualTo(expectedAttributeValue);
//            log.info("Элемент " + attributeName + " имеет значение " + actualAttribute);
//        }
//
//        @Step("Проверка что элемент имеет атрибут '{attribute}'")
//        public static void elementPresentOnPageAndHaveAttribute(By elementLocator, String attribute, String elementHaveAttribute) {
//            String elementText = MethodT.getElementAttributeProperty(elementLocator, attribute);
//            assertThat(elementText).as("Элемент с таким атрибутом не найден").contains(elementHaveAttribute);
//            log.info("Атрибут " + attribute + " со значением '" + elementHaveAttribute + "'" + " присутствует на странице");
//        }
//
//        @Step("Проверка что элемент имеет атрибут '{attribute}'")
//        public static void elementPresentOnPageAndHaveAttribute(WebElement webElement, String attribute, String elementHaveAttribute) {
//            String elementText = MethodT.getElementAttributeProperty(webElement, attribute);
//            assertThat(elementText).as("Элемент с таким атрибутом не найден").contains(elementHaveAttribute);
//            log.info("Атрибут " + attribute + " со значением '" + elementHaveAttribute + "'" + " присутствует на странице");
//        }
//
//        @Step("Проверка что элемент имеет атрибут '{attribute}'")
//        public static void elementPresentOnPageAndHaveSize(WebElement webElement,  String elementHaveSize) {
//            String elemenSize = webElement.getSize().toString();
//            assertThat(elemenSize).as("Элемент имеет другой размер.").contains(elementHaveSize);
//            log.info("Размер элемента "+ elementHaveSize);
//        }
//
//        @Step("Проверка что элемент отсутствует на странице")
//        public static void elementIsInvisibilityOnPage(By element) {
//            try {
//                while (TurboNavigation.isMaskClickable()) {
//                }
//                Thread.sleep(500);
//                boolean elementNotPresent = WaitT.isInvisibilityOfElement(element);
//                assertThat(elementNotPresent).as("Элемент с таким именем присутствует на странице").isTrue();
//                log.info("Элемент отсутствует на странице");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Step("Проверка что элемент отсутствует на странице")
//        public static void elementIsInvisibilityOnPage(WebElement webElement) {
//            try {
//                while (TurboNavigation.isMaskClickable()) {
//                }
//                Thread.sleep(500);
//                boolean elementNotPresent = WaitT.isInvisibilityOfElement(webElement);
//                assertThat(elementNotPresent).as("Элемент с таким именем присутствует на странице").isTrue();
//                log.info("Элемент отсутствует на странице");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Step("Проверка что элемент присутствует на странице и содержит текст: '{elementHaveText}'")
//        public static void elementPresentOnPageAndContainText(By element, String elementHaveText) {
//            String elementText = MethodT.getElementTextValue(element);
//            assertThat(elementText).as("Элемент с таким именем не найден").contains(elementHaveText);
//            log.info("Элемент " + "'" + elementHaveText + "'" + " присутствует на странице");
//        }
//
//        @Step("Проверка что элемент присутствует на странице и содержит текст: '{elementHaveText}'")
//        public static void elementPresentOnPageAndContainText(WebElement webElement, String elementHaveText) {
//            String elementText = MethodT.getElementTextValue(webElement);
//            assertThat(elementText).as("Элемент с таким именем не найден").contains(elementHaveText);
//            log.info("Элемент " + "'" + elementHaveText + "'" + " присутствует на странице");
//        }
//
//        @Step("Проверка что элемент присутствует на странице и у него есть текст")
//        public static void elementPresentOnPageAndHaveText(By element) {
//            String elementText = MethodT.getElementTextValue(element);
//            assertThat(elementText).as("Элемент не содержит текста").isNotEmpty();
//            log.info("Элемент содержит текст: " + elementText);
//        }
//
//        @Step("Проверка что элемент присутствует на странице и у него есть текст")
//        public static void elementPresentOnPageAndHaveText(WebElement webElement) {
//            String elementText = MethodT.getElementTextValue(webElement);
//            assertThat(elementText).as("Элемент не содержит текста").isNotEmpty();
//            log.info("Элемент содержит текст: " + elementText);
//        }
//
//        @Step("Проверка что элемент присутствует на странице и у него есть текст")
//        public static void elementPresentOnPageAndHaveValue(WebElement webElement) {
//            Assert.assertFalse(webElement.getAttribute("value").isEmpty(), "Поле осталось пустым");
//        }
//
//        @Step("Проверка что элемент присутствует на странице и у него есть текст")
//        public static void elementPresentOnPageAndHaveStringValue(WebElement webElement, String value) {
//            Assert.assertEquals(value, webElement.getAttribute("value"),
//                    "Поле не содержит требуемый текст");
//        }
//
//        private static boolean isElementDisplayed(By locator) {
//            while (TurboNavigation.isMaskClickable()) {
//            }
//            if (getDriverInstance().findElement(locator).isDisplayed()) {
//                log.info("Элемент отображается на странице -> возврат true ");
//                return true;
//            } else {
//                log.info("Элемент не отображается на странице -> возврат false ");
//                return false;
//            }
//        }
//
//        @Step("Проверка что элемент присутствует на странице")
//        private static boolean isElementDisplayed(WebElement webElement) {
//            while (TurboNavigation.isMaskClickable()) {
//            }
//            if (webElement.isDisplayed()) {
//                log.info("Элемент отображается на странице -> возврат true ");
//                return true;
//            } else {
//                log.info("Элемент не отображается на странице -> возврат false ");
//                return false;
//            }
//        }
//
//        /**
//         * Вернет true, если хотя бы один элемент найден и false, если он не существует
//         */
//        public static boolean isElementsMoreThanOne(By locator) {
//            return getDriverInstance().findElements(locator).size() > 0;
//        }
//
//        /**
//         * Вернет true, если хотя бы один элемент найден и false, если он не существует
//         */
//        public static boolean isElementsMoreThanOne(List<WebElement> webElements) {
//            return webElements.size() > 0;
//        }
//
//
//        /**
//         * Метод возвращает true если срабатывает исключение что элементЫ НЕ НАЙДЕНЫ,
//         * таким образом мы проверяем, что элементы не отображаются
//         * иметь приватный доступ т.к. только возвращает true/false и должен использоваться в методе ассерта
//         */
//        private static boolean isElementNotVisibleOnPage(By locator) {
//            try {
//                while (TurboNavigation.isMaskClickable()) {
//                }
//                WaitT.visibilityOfAllElementLocated(locator);
//                log.error("Элемент найден на странице -> возврат false - тест должен быть остановлен");
//                return false;
//            } catch (TimeoutException e) {
//                log.info("Элемент не найден на странице, сработало исключение TimeoutException -> возврат true");
//                return true;
//            }
//        }
//
//        private static boolean isElementNotVisibleOnPage(WebElement webElement) {
//            try {
//                while (TurboNavigation.isMaskClickable()) {
//                }
//                WaitT.visibilityOfElement(webElement);
//                log.error("Элемент найден на странице -> возврат false - тест должен быть остановлен");
//                return false;
//            } catch (TimeoutException e) {
//                log.info("Элемент не найден на странице, сработало исключение TimeoutException -> возврат true");
//                return true;
//            }
//        }
//
//        @Step("Проверка что элементы с таким локатором отсутствуют на странице")
//        public static void elementNotAttachedToPage(By element) {
//            boolean elementPresentOnPage = isElementNotVisibleOnPage(element);
//            assertThat(elementPresentOnPage).as("Элемент с таким локатором не найден").isTrue();
//            log.info("Элементы с таким локатором отсутствуют на странице");
//        }
//
//        @Step("Проверка что элемент отсутствует на странице")
//        public static void elementNotAttachedToPage(WebElement webElement) {
//            boolean elementPresentOnPage = 	isElementNotVisibleOnPage(webElement);
//            assertThat(elementPresentOnPage).as("Элемент  не найден").isTrue();
//            log.info("Элемент отсутствует на странице");
//        }
//
//        @Step("Проверка отсутствия локатора элемента")
//        public static void someElementsNotPresentOnPage(String locator) {
//            Assert.assertFalse(getDriverInstance().findElements(By.xpath(locator)).size() > 0, "Элементы не должны существовать!");
//        }
//
//        @Step("Проверка отсутствия локатора элемента")
//        public static void someElementsNotPresentOnPage(List<WebElement> webElements) {
//            WaitT.littleWait(300);
//            Assert.assertFalse(webElements.size() > 0, "Элементы не должны существовать!");
//        }
//
//        @Step("Проверка наличия локатора элемента")
//        public static void someElementsPresentOnPage(String locator) {
//            WaitT.littleWait(300);
//            Assert.assertTrue(getDriverInstance().findElements(By.xpath(locator)).size() > 0, "Элементы не существуют!");
//        }
//
//        @Step("Проверка наличия веб элемента")
//        public static void someElementsPresentOnPage(List<WebElement> webElements) {
//            WaitT.littleWait(1500);
//            Assert.assertTrue(webElements.size() > 0, "Элементы не существуют!");
//        }
//
//        @Step("Проверка выпадающего списка на эквивалентность эталону")
//        public static void checkList(List<String> elementsList) {
//            WaitT.littleWait(1000); //проскакивает пустая строка
//            WaitT.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'ScrollbarsCustom')]//li//p"));
////            WaitT.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'ScrollbarsCustom')]/ul/li/div"));
//            String listLocator = "//div[contains(@class, 'ScrollbarsCustom')]//li//p";
////            String listLocator = "//div[contains(@class, 'ScrollbarsCustom')]/ul/li/div";
//            List<WebElement> listMonthW = getDriverInstance().findElements(By.xpath(listLocator));
//            List<String> listMonthS = new ArrayList<>();
//            for (WebElement webElement : listMonthW) {
//                Actions act = new Actions(getDriverInstance());
//                act.moveToElement(webElement).perform();
//                listMonthS.add(webElement.getText());
//            }
//            Assert.assertEquals(elementsList, listMonthS, "Выпадающий список эквивалентен эталону");
//        }
//
//        @Step("Проверка выпадающего списка на эквивалентность эталону")
//        public static void checkList2(List<String> elementsList) {
//            WaitT.littleWait(1000); //проскакивает пустая строка
//            WaitT.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'ScrollbarsCustom')]//li//p"));
//            String listLocator = "//div[contains(@class, 'ScrollbarsCustom')]//li//p";
//            List<WebElement> listMonthW = getDriverInstance().findElements(By.xpath(listLocator));
//            List<String> listMonthS = new ArrayList<>();
//            for (WebElement webElement : listMonthW) {
//                Actions act = new Actions(getDriverInstance());
//                act.moveToElement(webElement).perform();
//                listMonthS.add(webElement.getText());
//            }
//            Assert.assertEquals(elementsList, listMonthS, "Выпадающий список эквивалентен эталону");
//        }
//
//
//        @Step("Проверка выпадающего списка на эквивалентность эталону")
//        public static void checkListByTitle(List<String> elementsList) {
//            WaitT.littleWait(1000); //проскакивает пустая строка
//            WaitT.visibilityOfElementLocated(By.xpath("//div[@class ='ScrollbarsCustom-Scroller']//p"));
//            String listLocator = "//div[@class ='ScrollbarsCustom-Scroller']//p";
//            List<WebElement> listMonthW = getDriverInstance().findElements(By.xpath(listLocator));
//            List<String> listMonthS = new ArrayList<>();
//            for (WebElement webElement : listMonthW) {
//                Actions act = new Actions(getDriverInstance());
//                act.moveToElement(webElement).perform();
//                listMonthS.add(webElement.getAttribute("data-title"));
//            }
//            Assert.assertEquals(elementsList, listMonthS, "Выпадающий список эквивалентен эталону");
//        }
//
//        @Step("Проверка что поле содержит текст {expectedText}")
//        public static void elementHaveText(WebElement webElement, String expectedText) {
//            String actualTextValue = MethodT.getElementTextValue(webElement);
//            log.info("Поле содержит " + actualTextValue);
//            System.out.println("Поле содержит " + actualTextValue);
//            assertThat(actualTextValue).as("Элемент не имеет данный текст").contains(expectedText);
//        }
//
//        @Step("Проверка что JS элемент находящейся в DOM содержит текст {expectedText}")
//        public static void elementJsFromDomHaveText(String elementXpath, String expectedText) {
//            String actualTextValue = JavaScriptT.getTextJS(elementXpath);
//            log.info("Элемент содержит " + actualTextValue);
//            assertThat(actualTextValue).as("Элемент не имеет данный текст").contains(expectedText);
//        }
//
//        @Step("Проверка что JS элемент находящейся в DOM содержит текст {expectedText}")
//        public static void elementJsFromDomHaveText(WebElement webElement, String expectedText) {
//            String actualTextValue = JavaScriptT.getTextJS(webElement);
//            log.info("Элемент содержит " + actualTextValue);
//            assertThat(actualTextValue).as("Элемент не имеет данный текст").contains(expectedText);
//        }
//    }
//
//    /**
//     * Проверки календаря
//     */
//    public static class Calendar {
//
//        @Step("Проверить календарь")
//        public static void checkCalendar(WebElement dateBox, WebElement calendar) {
//            String locatorMonthPrev = "//button[@class='p-datepicker-prev p-link']";
//            String locatorMonthNext = "//button[@class='p-datepicker-next p-link']";
//            String locatorMonth = "//select[@class='p-datepicker-month']";
//            String locatorMonthOption = "//select[@class='p-datepicker-month']/option";
//            String locatorYear = "//select[@class='p-datepicker-year']";
//            String locatorYearOption = "//select[@class='p-datepicker-year']/option";
//            String locatorDay = "//td/span[text()='11']";
//            String headerForm = "//div[@class='tab-bar']";
//
//            log.info("Открыть календарь");
//            calendar.click();
//
//            log.info("Проверить месяцы");
//            checkMonthInList(By.xpath(locatorMonthOption));
//
//            log.info("Нажать предыдущий месяц");
//            checkMonthArrowPrev(locatorMonth, locatorMonthPrev);
//
//            log.info("Нажать следующий месяц");
//            checkMonthArrowNext(locatorMonth, locatorMonthNext);
//
//            lastItemClick("Кликаем на предпоследний месяц из списка", locatorMonth, locatorMonthOption);
//            lastItemClick("Кликаем на предпоследний год из списка", locatorYear, locatorYearOption);
//
//            log.info("Выбрать день");
//            ActionT.OneClick.click(By.xpath(locatorDay));
//
//            log.info("Нажать на заголовок формы");
//            ActionT.OneClick.clickToHeader();
//
//            log.info("Проверить сохранение даты");
//            //Element.elementPresentOnPageAndHaveAttribute(dateBox, "value", "11.11.2100");
//            Element.elementPresentOnPageAndHaveStringValue(dateBox,  "11.11.2123");
//        }
//
//
//        @Step("Проверить календарь")
//        public static void checkCalendar(String dateBoxLocator, String calendarLocator, String headerForm) {
//            String locatorMonthPrev = "//button[@class='p-datepicker-prev p-link']";
//            String locatorMonthNext = "//button[@class='p-datepicker-next p-link']";
//            String locatorMonth = "//select[@class='p-datepicker-month']";
//            String locatorMonthOption = "//select[@class='p-datepicker-month']/option";
//            String locatorYearOption = "//select[@class='p-datepicker-year']/option";
//            String locatorDay = "//td/span[text()='11']";
//
//            log.info("Открыть календарь");
//            ActionT.OneClick.click(By.xpath(calendarLocator));
//
//            log.info("Проверить месяцы");
//            checkMonthInList(By.xpath(locatorMonthOption));
//
//            log.info("Нажать предыдущий месяц");
//            checkMonthArrowPrev(locatorMonth, locatorMonthPrev);
//
//            log.info("Нажать следующий месяц");
//            checkMonthArrowNext(locatorMonth, locatorMonthNext);
//
//            lastItemClick("Кликаем на предпоследний месяц из списка", locatorMonthOption);
//
//            log.info("Открыть календарь");
//            ActionT.OneClick.click(By.xpath(calendarLocator));
//
//            lastItemClick("Кликаем на предпоследний год из списка", locatorYearOption);
//
//            log.info("Выбрать день");
//            ActionT.OneClick.click(By.xpath(locatorDay));
//
//            log.info("Нажать на заголовок формы");
//            ActionT.OneClick.click(By.xpath(headerForm));
//
//            log.info("Проверить сохранение даты");
//            Element.elementPresentOnPageAndHaveAttribute(By.xpath(dateBoxLocator), "value", "11.11.2100");
//        }
//
//        @Step("Проверить календарь")
//        public static void checkCalendar(WebElement dateBoxLocator, WebElement calendarLocator, WebElement headerForm) {
//            String locatorMonthPrev = "//button[@class='p-datepicker-prev p-link']";
//            String locatorMonthNext = "//button[@class='p-datepicker-next p-link']";
//            String locatorMonth = "//select[@class='p-datepicker-month']";
//            String locatorYear = "//select[@class='p-datepicker-year']";
//            String locatorMonthOption = "//select[@class='p-datepicker-month']/option";
//            String locatorYearOption = "//select[@class='p-datepicker-year']/option";
//            String locatorDay = "//td/span[text()='11']";
//
//            log.info("Открыть календарь");
//            ActionT.OneClick.click(calendarLocator);
//
//            log.info("Проверить месяцы");
//            checkMonthInList(By.xpath(locatorMonthOption), By.xpath(locatorMonth));
//
//            log.info("Нажать предыдущий месяц");
//            checkMonthArrowPrev(locatorMonth, locatorMonthPrev);
//
//            log.info("Нажать следующий месяц");
//            checkMonthArrowNext(locatorMonth, locatorMonthNext);
//
//            lastItemClick("Кликаем на предпоследний месяц из списка", locatorMonth, locatorMonthOption);
//
//            lastItemClick("Кликаем на предпоследний год из списка", locatorYear, locatorYearOption);
//
//            log.info("Выбрать день");
//            ActionT.OneClick.click(By.xpath(locatorDay));
//
//            log.info("Нажать на заголовок формы");
//            ActionT.OneClick.click(headerForm);
//
//            log.info("Проверить сохранение даты");
//
//            Element.elementPresentOnPageAndHaveAttribute(dateBoxLocator, "value", "11.11.2123");
//        }
//
//        @Step("Проверка выпадающего списка с месяцами на эквивалентность эталону")
//        private static void checkMonthList(By locator) {
//            List<String> month = Arrays.asList("январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь");
//            List<WebElement> listMonthW = getDriverInstance().findElements(locator);
//            List<String> listMonthS = new ArrayList<>();
//            for (WebElement e : listMonthW) {
//                listMonthS.add(e.getText());
//            }
//            Assert.assertEquals(month, listMonthS, "Выпадающий список с месяцами на эквивалентен эталону");
//        }
//
//        @Step("Проверка выпадающего списка с месяцами на эквивалентность эталону")
//        public static void checkMonthInList(By locator) {
//            List<String> month = Arrays.asList("январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь");
//            List<WebElement> listMonthW = getDriverInstance().findElements(locator);
//            List<String> listMonthS = new ArrayList<>();
//            for (WebElement e : listMonthW) {
//                listMonthS.add(e.getText());
//            }
//            //    listMonthS.forEach(System.out::println);
//            Assert.assertEquals(month, listMonthS, "Выпадающий список с месяцами на эквивалентен эталону");
//        }
//
//        @Step("Проверка выпадающего списка с месяцами на эквивалентность эталону")
//        public static void checkMonthInList(By locator, By monthLocator) {
//            List<String> month = Arrays.asList("январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь");
//            getDriverInstance().findElement(monthLocator).click();
//            List<WebElement> listMonthW = getDriverInstance().findElements(locator);
//            List<String> listMonthS = new ArrayList<>();
//            for (WebElement e : listMonthW) {
//                listMonthS.add(e.getText());
//            }
//            //    listMonthS.forEach(System.out::println);
//            Assert.assertEquals(month, listMonthS, "Выпадающий список с месяцами на эквивалентен эталону");
//        }
//
//        @Step("Проверка выпадающего списка с месяцами на эквивалентность эталону")
//        public static void checkMonthInList(List<WebElement> listMonthW) {
//            List<String> month = Arrays.asList("январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь");
//            List<String> listMonthS = new ArrayList<>();
//            for (WebElement e : listMonthW) {
//                listMonthS.add(e.getText());
//            }
//            Assert.assertEquals(month, listMonthS, "Выпадающий список с месяцами на эквивалентен эталону");
//        }
//
//        @Step("Проверка изменения месяца при клике на Лево")
//        public static void checkMonthArrowPrev(String locatorMonth, String locatorPrev) {
//            int i = Integer.parseInt(getDriverInstance().findElement(By.xpath(locatorMonth)).getAttribute("value"));
//            log.info("Индекс текущего месяца: " + i);
//            ActionT.OneClick.click(locatorPrev);
//            WaitT.littleWait(300);
//            int y = Integer.parseInt(getDriverInstance().findElement(By.xpath(locatorMonth)).getAttribute("value"));
//            log.info("Индекс месяца после клика на --> Лево: " + y);
//            if (i == 0) {
//                Assert.assertEquals(y, 11, "При клике на --> Лево индекс должен уменьшаться на единицу");
//            } else {
//                Assert.assertEquals(i - 1, y, "При клике на --> Лево индекс должен уменьшаться на единицу");
//            }
//        }
//
//        @Step("Проверка изменения месяца при клике на Лево")
//        public static void checkMonthArrowPrev(WebElement locatorMonth, WebElement locatorPrev) {
//            int i = Integer.parseInt(locatorMonth.getAttribute("value"));
//            log.info("Индекс текущего месяца: " + i);
//            ActionT.OneClick.click(locatorPrev);
//            WaitT.littleWait(300);
//            int y = Integer.parseInt(locatorMonth.getAttribute("value"));
//            log.info("Индекс месяца после клика на --> Лево: " + y);
//            if (i == 0) {
//                Assert.assertEquals(y, 11, "При клике на --> Лево индекс должен уменьшаться на единицу");
//            } else {
//                Assert.assertEquals(i - 1, y, "При клике на --> Лево индекс должен уменьшаться на единицу");
//            }
//        }
//
//        @Step("Проверка изменения месяца при клике на Право")
//        public static void checkMonthArrowNext(String locatorMonth, String locatorNext) {
//            int i = Integer.parseInt(getDriverInstance().findElement(By.xpath(locatorMonth)).getAttribute("value"));
//            log.info("Индекс текущего месяца: " + i);
//            ActionT.OneClick.click(locatorNext);
//            WaitT.littleWait(300);
//            int y = Integer.parseInt(getDriverInstance().findElement(By.xpath(locatorMonth)).getAttribute("value"));
//            log.info("Индекс месяца после клика на --> Право: " + y);
//            if (i == 11) {
//                Assert.assertEquals(y, 0, "При клике на --> Право индекс должен увеличиваться на единицу");
//            } else {
//                Assert.assertEquals(i + 1, y, "При клике на --> Право индекс должен увеличиваться на единицу");
//            }
//        }
//
//        @Step("Проверка изменения месяца при клике на Право")
//        public static void checkMonthArrowNext(WebElement locatorMonth, WebElement locatorNext) {
//            int i = Integer.parseInt(locatorMonth.getAttribute("value"));
//            log.info("Индекс текущего месяца: " + i);
//            ActionT.OneClick.click(locatorNext);
//            WaitT.littleWait(300);
//            int y = Integer.parseInt(locatorMonth.getAttribute("value"));
//            log.info("Индекс месяца после клика на --> Право: " + y);
//            if (i == 11) {
//                Assert.assertEquals(y, 0, "При клике на --> Право индекс должен увеличиваться на единицу");
//            } else {
//                Assert.assertEquals(i + 1, y, "При клике на --> Право индекс должен увеличиваться на единицу");
//            }
//        }
//
//        @Step("{stepName}")
//        public static void lastItemClick(String stepName, String locator) {
//            List<WebElement> list = getDriverInstance().findElements(By.xpath(locator));
//            String str = list.get(list.size() - 2).getText();
//            log.info(" --> " + str);
//            list.get(list.size() - 2).click();
//        }
//
//        @Step("{stepName}")
//        public static void lastItemClick(String stepName, String dropBoxLocator, String locator) {
//            getDriverInstance().findElement(By.xpath(dropBoxLocator)).click();
//            List<WebElement> list = getDriverInstance().findElements(By.xpath(locator));
//            String str = list.get(list.size() - 2).getText();
//            log.info(" --> " + str);
//            list.get(list.size() - 2).click();
//        }
//
//        @Step("{stepName}")
//        public static void lastItemClick(String stepName, List<WebElement> list) {
//            String str = list.get(list.size() - 2).getText();
//            log.info(" --> " + str);
//            list.get(list.size() - 2).click();
//        }
//
//        public static int getIntTime(String string) {
//            String firstSymbol = string.substring(0, 1);
//            String result = string;
//            if (firstSymbol.equals("0")) {
//                result = string.substring(1);
//            }
//            return Integer.parseInt(result);
//        }
//    }
//
//    /**
//     * Проверки открытия/закрытия
//     */
//    public static class OpenClose {
//
//        @Step("Проверка сокрытия/раскрытия фрейма при клике")
//        public static void frameOpenAndClose(String locatorFrame, String locatorWrap) {
//            WaitT.elementToBeClickable(locatorWrap);
//            boolean visibility = getDriverInstance().findElement(By.xpath(locatorFrame)).isDisplayed();
//            if (!visibility) {
//                log.info("Фрейм не виден --> фрейм открывается");
//                getDriverInstance().findElement(By.xpath(locatorWrap)).click();
//                WaitT.isElementDisplayed(By.xpath(locatorFrame));
//                boolean result = WaitT.isElementDisplayed(By.xpath(locatorFrame));
//                Assert.assertTrue(result, "Элемент должен быть виден");
//            } else {
//                log.info("Фрейм виден --> фрейм закрывается");
//                getDriverInstance().findElement(By.xpath(locatorWrap)).click();
//                boolean result = WaitT.isInvisibilityOfElement(By.xpath(locatorFrame));
//                Assert.assertTrue(result, "Элемент не должен быть виден");
//            }
//        }
//
//        @Step("Проверка сокрытия/раскрытия фрейма при клике")
//        public static void frameOpenAndClose(WebElement locatorFrame, WebElement locatorWrap) {
//            WaitT.elementToBeClickable(locatorWrap);
//            boolean visibility = locatorFrame.isDisplayed();
//            if (!visibility) {
//                log.info("Фрейм не виден --> фрейм открывается");
//                locatorWrap.click();
//                WaitT.isElementDisplayed(locatorFrame);
//                boolean result = WaitT.isElementDisplayed(locatorFrame);
//                Assert.assertTrue(result, "Элемент должен быть виден");
//            } else {
//                log.info("Фрейм виден --> фрейм закрывается");
//                locatorWrap.click();
//                boolean result = WaitT.isInvisibilityOfElement(locatorFrame);
//                Assert.assertTrue(result, "Элемент не должен быть виден");
//            }
//        }
//
//        @Step("Проверка сокрытия/раскрытия элемента при клике")
//        public static void elementOpenAndClose(String locatorElement, String locatorButton) {
//            String locatorFolderClose = "/img[contains(@src, 'Folder.svg')]";
//            String locatorFolderOpen = "/img[contains(@src, 'folder-open.svg')]";
//            while (TurboNavigation.isMaskClickable()) {
//            }
//            boolean visibility = getDriverInstance().findElements(By.xpath(locatorElement)).size() > 0;
//            if (visibility) {
//                log.info("Элемент виден --> " + locatorElement + "\n Элемент скрывается при клике на --> " + locatorButton + "\n");
//                Wait.visibilityElementLocatedWait(locatorButton + locatorFolderOpen);
//                getDriverInstance().findElement(By.xpath(locatorButton)).click();
//                Wait.visibilityElementLocatedWait(locatorButton + locatorFolderClose);
//                Wait.invisibilityElementLocatedWait(locatorElement);
//            }
//            if (!visibility) {
//                log.info("Элемент скрыт --> " + locatorElement + "\n Элемент раскрывается при клике на --> " + locatorButton + "\n");
//                Wait.visibilityElementLocatedWait(locatorButton + locatorFolderClose);
//                getDriverInstance().findElement(By.xpath(locatorButton)).click();
//                Wait.visibilityElementLocatedWait(locatorButton + locatorFolderOpen);
//                Wait.visibilityElementLocatedWait(locatorElement);
//            }
//        }
//
//        @Step("Проверка сокрытия/раскрытия элемента при клике")
//        public static void elementOpenAndClose(WebElement webElement, WebElement button,
//                                               WebElement folderOpen, WebElement folderClose) {
//
//            boolean visibility;
//
//            try {
//                visibility = webElement.isDisplayed();
//            } catch (NoSuchElementException e) {
//                visibility = false;
//            }
//            while (TurboNavigation.isMaskClickable()) {
//            }
//            if (visibility) {
//                Wait.visibilityElementLocatedWait(folderOpen);
//                button.click();
//                Wait.visibilityElementLocatedWait(folderClose);
//                Wait.invisibilityElementLocatedWait(webElement);
//            }
//            if (!visibility) {
//                Wait.visibilityElementLocatedWait(folderClose);
//                button.click();
//                Wait.visibilityElementLocatedWait(folderOpen);
//                Wait.visibilityElementLocatedWait(webElement);
//            }
//        }
//
//        @Step("Проверка сокрытия/раскрытия группы элементов при клике")
//        public static void groupElementsOpenAndClose(ArrayList<String> locatorElement, String locatorButton) {
//            String locatorFolderClose = "/img[contains(@src, 'Folder.svg')]";
//            String locatorFolderOpen = "/img[contains(@src, 'folder-open.svg')]";
//            while (TurboNavigation.isMaskClickable()) {
//            }
//            int y = 0;
//            for (String s : locatorElement) {
//                while (TurboNavigation.isMaskClickable()) {
//                }
//                boolean visibility = getDriverInstance().findElements(By.xpath(s)).size() > 0;
//                if (visibility) {
//                    y++;
//                }
//            }
//            log.info("Количество видимых элементов --> " + y);
//            if (y == locatorElement.size()) {
//                log.info("Элементы видны -->" + (Arrays.toString(locatorElement.toArray())) + "\nЭлементы скрываются при клике на --> " + locatorButton + "\n -----------------------");
//                Wait.visibilityElementLocatedWait(locatorButton + locatorFolderOpen);
//                ActionT.OneClick.click(locatorButton);
//                Wait.visibilityElementLocatedWait(locatorButton + locatorFolderClose);
//                for (String s : locatorElement) {
//                    Wait.invisibilityElementLocatedWait(s);
//                }
//            } else if (y == 0) {
//                log.info("Элементы не видны -->" + (Arrays.toString(locatorElement.toArray())) + "\n Элементы раскрываются при клике на --> " + locatorButton + "\n -----------------------");
//                Wait.visibilityElementLocatedWait(locatorButton + locatorFolderClose);
//                ActionT.OneClick.click(locatorButton);
//                Wait.visibilityElementLocatedWait(locatorButton + locatorFolderOpen);
//                for (String s : locatorElement) {
//                    Wait.visibilityElementLocatedWait(s);
//                }
//            } else {
//                Assert.fail("Часть элементов видна, а часть нет");
//            }
//        }
//
//        @Step("Проверка сокрытия/раскрытия группы элементов при клике")
//        public static void groupElementsOpenAndClose(List<WebElement> elements, WebElement button,
//                                                     WebElement folderOpen, WebElement folderClose) {
//            String locatorFolderClose = "/img[contains(@src, 'Folder.svg')]";
//            String locatorFolderOpen = "/img[contains(@src, 'folder-open.svg')]";
//            while (TurboNavigation.isMaskClickable()) {
//            }
//            int y = 0;
//            for (WebElement s : elements) {
//                while (TurboNavigation.isMaskClickable()) {
//                }
//                boolean visibility;
//
//                try {
//                    visibility = s.isDisplayed();
//                } catch (NoSuchElementException e) {
//                    visibility = false;
//                }
//
//                if (visibility) {
//                    y++;
//                }
//            }
//            log.info("Количество видимых элементов --> " + y);
//            if (y == elements.size()) {
//                Wait.visibilityElementLocatedWait(folderOpen);
//                ActionT.OneClick.click(button);
//                Wait.visibilityElementLocatedWait(folderClose);
//                for (WebElement s : elements) {
//                    Wait.invisibilityElementLocatedWait(s);
//                }
//            } else if (y == 0) {
//                Wait.visibilityElementLocatedWait(folderClose);
//                ActionT.OneClick.click(button);
//                Wait.visibilityElementLocatedWait(folderOpen);
//                for (WebElement s : elements) {
//                    Wait.visibilityElementLocatedWait(s);
//                }
//            } else {
//                Assert.fail("Часть элементов видна, а часть нет");
//            }
//        }
//    }
//
//    /**
//     * Проверки параметров элемента
//     */
//    public static class Property {
//
//        @Step("Проверка, что элемент имеет атрибут {CSS}, со значением больше, чем {value}")
//        public static void elementHaveCssValueInIntegerGreaterThan(By locator, String CSS, int value) {
//            assertThat(MethodT.getCSSValueAsInt(locator, CSS))
//                    .as("CSS атрибут " + CSS + " элемента меньше чем: " + value).isGreaterThan(value);
//        }
//
//        @Step("Проверка, что элемент имеет атрибут {CSS}, со значением больше, чем {value}")
//        public static void elementHaveCssValueInIntegerGreaterThan(WebElement webElement, String CSS, int value) {
//            System.out.println("height = " + webElement.getCssValue("height"));
//            assertThat(MethodT.getCSSValueAsInt(webElement, CSS))
//                    .as("CSS атрибут " + CSS + " элемента меньше чем: " + value).isGreaterThan(value);
//        }
//
//        @Step("Проверка соответствия атрибута {attribute}, со значением {compareValue}")
//        public static void elementHaveAttributePropertyWithValue(String locator, String attribute, String compareValue) {
//            while (TurboNavigation.isMaskClickable()) {
//            }
//            String getAttribute = getDriverInstance().findElement(By.xpath(locator)).getAttribute(attribute);
//            log.info("Attribute: " + attribute + " value: " + getAttribute);
//            Assert.assertEquals(getAttribute, compareValue, "Полученное значение атрибута: " + getAttribute + " не соответствует ожидаемому: " + compareValue);
//        }
//
//        @Step("Проверка соответствия атрибута {attribute}, со значением {compareValue}")
//        public static void elementHaveAttributePropertyWithValue(WebElement webElement, String attribute, String compareValue) {
//            while (TurboNavigation.isMaskClickable()) {
//            }
//            String getAttribute = webElement.getAttribute(attribute);
//            log.info("Attribute: " + attribute + " value: " + getAttribute);
//            Assert.assertEquals(getAttribute, compareValue, "Полученное значение атрибута: " + getAttribute + " не соответствует ожидаемому: " + compareValue);
//        }
//
//        @Step("Проверка соответствия CSS атрибута {CSSProperty}, со значением {compareValue}")
//        public static void elementHaveCssPropertyWithValue(String locator, String CSSProperty, String compareValue) {
//            while (TurboNavigation.isMaskClickable()) {
//            }
//            assertThat(getDriverInstance().findElement(By.xpath(locator)).getCssValue(CSSProperty)).
//                    as("Полученное значение атрибута: не соответствует ожидаемому: " + compareValue).
//                    isEqualTo(compareValue);
//            log.info("Атрибут " + CSSProperty + " имеет значение: " + compareValue);
//        }
//
//        @Step("Проверка соответствия CSS атрибута {CSSProperty}, со значением {compareValue}")
//        public static void elementHaveCssPropertyWithValue(WebElement webElement, String CSSProperty, String compareValue) {
//            while (TurboNavigation.isMaskClickable()) {
//            }
//            assertThat(webElement.getCssValue(CSSProperty)).
//                    as("Полученное значение атрибута "
//                            + webElement.getCssValue(CSSProperty) +
//                            ": не соответствует ожидаемому: " + compareValue).
//                    isEqualTo(compareValue);
//            log.info("Атрибут " + CSSProperty + " имеет значение: " + compareValue);
//        }
//
//        @Step("Проверка соответствия класса {CSSProperty}, со значением {compareValue}")
//        public static void elementHaveClassWithValue(String locator, String CSSProperty, String compareValue) {
//            while (TurboNavigation.isMaskClickable()) {
//            }
//            assertThat(getDriverInstance().findElement(By.xpath(locator)).getAttribute(CSSProperty)).
//                    as("Полученное значение атрибута: не соответствует ожидаемому: " + compareValue).
//                    isEqualTo(compareValue);
//            log.info("Атрибут " + CSSProperty + " имеет значение: " + compareValue);
//        }
//
//        @Step("Проверка соответствия класса {CSSProperty}, со значением {compareValue}")
//        public static void elementHaveClassWithValue(WebElement webElement, String CSSProperty, String compareValue) {
//            while (TurboNavigation.isMaskClickable()) {
//            }
//            assertThat(webElement.getAttribute(CSSProperty)).
//                    as("Полученное значение атрибута: не соответствует ожидаемому: " + compareValue).
//                    isEqualTo(compareValue);
//            log.info("Атрибут " + CSSProperty + " имеет значение: " + compareValue);
//        }
//
//        @Step("Проверка соответствия высоты элемента ожидаемой: {compareValue}")
//        public static void elementHaveHeight(String locator, int compareValue) {
//            while (TurboNavigation.isMaskClickable()) {
//            }
//            int elementSize = MethodT.getHeightOfElement(By.xpath(locator));
//            assertThat(elementSize).as("Высота элемента не соответствует ожидаемой, фактическая: " + elementSize).isEqualTo(compareValue);
//        }
//
//        @Step("Проверка соответствия высоты элемента ожидаемой: {compareValue}")
//        public static void elementHaveHeight(WebElement webElement, int compareValue) {
//            while (TurboNavigation.isMaskClickable()) {
//            }
//            int elementSize = MethodT.getHeightOfElement(webElement);
//            assertThat(elementSize).as("Высота элемента не соответствует ожидаемой, фактическая: " + elementSize).isEqualTo(compareValue);
//        }
//
//        @Step("Проверка соответствия CSS атрибута {CSSProperty}")
//        public static void elementHaveCssProperty(String locator, String CSSProperty) {
//            while (TurboNavigation.isMaskClickable()) {
//            }
//            assertThat(getDriverInstance().findElement(By.xpath(locator)).getCssValue(CSSProperty)).
//                    as("У элемента нет данного атрибута: " + CSSProperty).isNotEmpty();
//        }
//
//        @Step("Проверка соответствия CSS атрибута {CSSProperty}")
//        public static void elementHaveAttributeProperty(WebElement webElement, String Attribute) {
//            while (TurboNavigation.isMaskClickable()) {
//            }
//            assertThat(webElement.getAttribute(Attribute)).
//                    as("У элемента нет данного атрибута: " + Attribute).isNotEmpty();
//        }
//
//        @Step("Проверка соответствия CSS атрибута {CSSProperty}")
//        public static void elementNotHaveCssProperty(String locator, String CSSProperty) {
//            while (TurboNavigation.isMaskClickable()) {
//            }
//            assertThat(MethodT.isCssPropertyEmpty(By.xpath(locator), CSSProperty)).
//                    as("У элемента присутствует данный атрибут (ожидается, что его нет): " + CSSProperty).isTrue();
//        }
//
//        @Step("Проверка соответствия ширины элемента ожидаемой: {compareValue}")
//        public static void elementHaveWidth(String locator, int compareValue) {
//            while (TurboNavigation.isMaskClickable()) {
//            }
//            int elementSize = MethodT.getWidthOfElement(By.xpath(locator));
//            assertThat(elementSize).as("Ширина элемента не соответствует ожидаемой, фактическая: " + elementSize).isEqualTo(compareValue);
//        }
//
//        @Step("Проверка соответствия ширины элемента ожидаемой: {compareValue}")
//        public static void elementHaveWidth(WebElement webElement, int compareValue) {
//            while (TurboNavigation.isMaskClickable()) {
//            }
//            int elementSize = MethodT.getWidthOfElement(webElement);
//            assertThat(elementSize).as("Ширина элемента не соответствует ожидаемой, фактическая: " + elementSize).isEqualTo(compareValue);
//        }
//    }
//
//    /**
//     * Проверки реакции на событие после взаимодействия с элементом
//     */
//    public static class Message {
//
//        @Step("Изменение инф. поля при одиночном клике на объект")
//        public static void compareMessageAfterOneClick(String locator, String locatorInfo) {
//            WaitT.elementToBeClickable(locator);
//            String before = MethodT.getElementTextValue(locatorInfo);
//            ActionT.OneClick.click(locator);
//            waitChangeTextInMessageField(before, locatorInfo);
//        }
//
//        @Step("Изменение инф. поля при одиночном клике на объект")
//        public static void compareMessageAfterOneClick(String locator, WebElement webElement) {
//            WaitT.elementToBeClickable(locator);
//            String before = MethodT.getElementTextValue(webElement);
//            ActionT.OneClick.click(locator);
//            waitChangeTextInMessageField(before, webElement);
//        }
//
//        @Step("Изменение инф. поля при одиночном клике на объект")
//        public static void compareMessageAfterOneClick(WebElement webElement, WebElement webElementInfo) {
//            WaitT.elementToBeClickable(webElement);
//            String before = MethodT.getElementTextValue(webElementInfo);
//            ActionT.OneClick.click(webElement);
//            waitChangeTextInMessageField(before, webElementInfo);
//        }
//
//        @Step("Изменение инф. поля при двойном клике на объект")
//        public static void compareMessageAfterDoubleClick(String locator, String locatorInfo) {
//            WaitT.elementToBeClickable(locator);
//            String before = MethodT.getElementTextValue(locatorInfo);
//            ActionT.DoubleClick.doubleClick(locator);
//            waitChangeTextInMessageField(before, locatorInfo);
//        }
//
//        public static void compareMessageAfterDoubleClick(WebElement webElement, WebElement webElementInfo) {
//            WaitT.elementToBeClickable(webElement);
//            String before = MethodT.getElementTextValue(webElementInfo);
//            ActionT.DoubleClick.doubleClick(webElement);
//            waitChangeTextInMessageField(before, webElementInfo);
//        }
//
//        @Step("Изменение инф. поля при вводе '{data}' в поле")
//        public static void compareMessageAfterSendKeys(String locator, String locatorInfo, String data) {
//            WaitT.elementToBeClickable(locator);
//            String before = MethodT.getElementTextValue(locatorInfo);
//            ActionT.DoubleClick.doubleClickSendKeysAndEnter(locator, data);
//            waitChangeTextInMessageField(before, locatorInfo);
//        }
//
//        @Step("Изменение инф. поля при вводе '{data}' в поле")
//        public static void compareMessageAfterSendKeys(WebElement webElement, WebElement infoElement, String data) {
//            WaitT.elementToBeClickable(webElement);
//            String before = MethodT.getElementTextValue(infoElement);
//            ActionT.DoubleClick.doubleClickSendKeysAndEnter(webElement, data);
//            waitChangeTextInMessageField(before, infoElement);
//        }
//
//        @Step("Изменение инф. поля при вводе '{data}' в поле")
//        public static void compareMessageAfterOneClickAndSendKeys(WebElement webElement, WebElement infoElement, String data) {
//            WaitT.elementToBeClickable(webElement);
//            String before = MethodT.getElementTextValue(infoElement);
//            ActionT.OneClick.clickAndEnterText(webElement,data);
//            waitChangeTextInMessageField(before, infoElement);
//        }
//
//        @Step("Изменение инф. поля при удалении данных из поля")
//        public static void compareMessageAfterDeleteText(String locator, String locatorInfo) {
//            WaitT.elementToBeClickable(locator);
//            String before = MethodT.getElementTextValue(locatorInfo);
//            ActionT.DoubleClick.clickAndClear(locator);
//            waitChangeTextInMessageField(before, locatorInfo);
//        }
//
//        @Step("Изменение инф. поля при удалении данных из поля")
//        public static void compareMessageAfterDeleteText(WebElement webElement, WebElement webElementrInfo) {
//            WaitT.elementToBeClickable(webElement);
//            String before = MethodT.getElementTextValue(webElementrInfo);
//            ActionT.DoubleClick.clickAndClear(webElement);
//            waitChangeTextInMessageField(before, webElementrInfo);
//        }
//
//        @Step("Изменение инф. поля при клике на последний элемент списка")
//        public static void compareMessageAfterLastItemListClick(String locator, String locatorListLi, String locatorInfo) {
//            WaitT.elementToBeClickable(locatorListLi);
//            String before = MethodT.getElementTextValue(locatorInfo);
//            List<WebElement> list = getDriverInstance().findElements(By.xpath(locatorListLi));
//            //todo костыль для выпадающих списков в которых есть прокрутка
//            new Actions(getDriverInstance())
//                    .moveToElement(list.get(list.size() - 1))
//                    .perform();
//            //-----------------------------------
//            String lastListText = list.get(list.size() - 1).getText();
//            log.info("Текст в последнем элементе списка --> " + lastListText);
//            ActionT.ListElement.clickToLastItemInList(list);
//            waitChangeTextInMessageField(before, locatorInfo);
//            Property.elementHaveAttributePropertyWithValue(locator, "textContent", lastListText);
//        }
//
//        @Step("Изменение инф. поля при клике на последний элемент списка")
//        public static void compareMessageAfterLastItemListClick(WebElement webElement, String locatorListLi, WebElement elementInfo) {
//            WaitT.elementToBeClickable(locatorListLi);
//            String before = MethodT.getElementTextValue(elementInfo);
//            List<WebElement> list = getDriverInstance().findElements(By.xpath(locatorListLi));
//            //todo костыль для выпадающих списков в которых есть прокрутка
//            new Actions(getDriverInstance())
//                    .moveToElement(list.get(list.size() - 1))
//                    .perform();
//            //-----------------------------------
//            String lastListText = list.get(list.size() - 1).getText();
//            log.info("Текст в последнем элементе списка --> " + lastListText);
//            ActionT.ListElement.clickToLastItemInList(list);
//            waitChangeTextInMessageField(before, elementInfo);
//            Property.elementHaveAttributePropertyWithValue(webElement, "textContent", lastListText);
//        }
//
//        @Step("Изменение инф. поля при клике на последний элемент списка")
//        public static void compareMessageAfterLastItemListClick(WebElement webElement, List<WebElement> list, WebElement elementInfo) {
//            String before = MethodT.getElementTextValue(elementInfo);
//            //todo костыль для выпадающих списков в которых есть прокрутка
//            new Actions(getDriverInstance())
//                    .moveToElement(list.get(list.size() - 1))
//                    .perform();
//            //-----------------------------------
//            String lastListText = list.get(list.size() - 1).getText();
//            log.info("Текст в последнем элементе списка --> " + lastListText);
//            ActionT.ListElement.clickToLastItemInList(list);
//            waitChangeTextInMessageField(before, elementInfo);
//            Property.elementHaveAttributePropertyWithValue(webElement, "textContent", lastListText);
//        }
//
//
//        @Step("Ожидание изменения текста в инф. поле")
//        public static void waitChangeTextInMessageField(String before, String locatorField) {
//            String after = MethodT.getElementTextValue(locatorField);
//            int i = 0;
//            while (before.equals(after)) {
//                log.info("Ожидание изменения текста в инф. поле --> 30 мс");
//                WaitT.littleWait(30);
//                after = MethodT.getElementTextValue(locatorField);
//                i++;
//                if (i == 50) {
//                    break;
//                }
//            }
//            Assert.assertNotEquals(before, after, "Нет реакции на событие в инф. поле");
//        }
//
//        @Step("Ожидание изменения текста в инф. поле")
//        public static void waitChangeTextInMessageField(String before, WebElement webElement) {
//            String after = MethodT.getElementTextValue(webElement);
//            int i = 0;
//            while (before.equals(after)) {
//                log.info("Ожидание изменения текста в инф. поле --> 30 мс");
//                WaitT.littleWait(30);
//                after = MethodT.getElementTextValue(webElement);
//                i++;
//                if (i == 50) {
//                    break;
//                }
//            }
//            Assert.assertNotEquals(before, after, "Нет реакции на событие в инф. поле");
//        }
//    }
//
//    /**
//     * Проверки после взаимодействием окна с ошибкой
//     */
//    public static class Error {
//
//        @Step("Закрытие окна ERROR при клике")
//        public static void errorClosesAfterClick(String locator) {
//            WaitT.elementToBeClickable(locator);
//            ActionT.OneClick.click(locator);
//            Wait.invisibilityElementLocatedWait(locator);
//        }
//
//        @Step("Закрытие окна ERROR при клике")
//        public static void errorClosesAfterClick(WebElement webElement) {
//            WaitT.elementToBeClickable(webElement);
//            ActionT.OneClick.click(webElement);
//            Wait.invisibilityElementLocatedWait(webElement);
//        }
//
//        @Step("Появление окна ERROR при вводе невалидного текста: {dataInput} в форму")
//        public static void doubleClickSendKeysWaitError(String locator, String locatorError, String dataInput) {
//            ActionT.DoubleClick.doubleClick(locator);
//            ActionT.OneClick.clickClearEnterText(By.xpath(locator), dataInput);
//            ActionT.OneClick.clickToHeader();
//            Wait.visibilityElementLocatedWait(locatorError);
//        }
//
//        @Step("Появление окна ERROR при вводе невалидного текста: {dataInput} в форму")
//        public static void doubleClickSendKeysWaitError(String locator, WebElement elementError, String dataInput) {
//            ActionT.DoubleClick.doubleClick(locator);
//            ActionT.OneClick.clickClearEnterText(By.xpath(locator), dataInput);
//            ActionT.OneClick.clickToHeader();
//            Wait.visibilityElementLocatedWait(elementError);
//        }
//
//        @Step("Появление окна ERROR при вводе невалидного текста: {dataInput} в форму")
//        public static void doubleClickSendKeysWaitError(WebElement webElement, WebElement elementError, String dataInput) {
//            ActionT.DoubleClick.doubleClick(webElement);
//            ActionT.OneClick.clickClearEnterText(webElement, dataInput);
//            ActionT.OneClick.clickToHeader();
//            Wait.visibilityElementLocatedWait(elementError);
//        }
//
//        @Step("Появление окна ERROR при вводе невалидного текста: {dataInput} в форму")
//        public static void clickSendKeysWaitError(WebElement webElement, WebElement elementError, String dataInput) {
//            ActionT.OneClick.clickAndEnterText(webElement, dataInput);
//            ActionT.OneClick.clickToHeader();
//            Wait.visibilityElementLocatedWait(elementError);
//        }
//
//        @Step("Появление окна ERROR при вводе невалидного текста: {dataInput} в форму")
//        public static void clickSendKeysWaitError2(WebElement webElement, WebElement elementError, String dataInput) {
//            ActionT.OneClick.clickAndEnterText(webElement, dataInput);
//
//            Wait.visibilityElementLocatedWait(elementError);
//        }
//
//        @Step("Появление окна ERROR при вводе невалидного текста: {dataInput} в форму")
//        public static void clickSendKeysWaitError(String locator, WebElement elementError, String dataInput) {
//
//            ActionT.OneClick.clickAndEnterText(By.xpath(locator), dataInput);
//            ActionT.OneClick.clickToHeader();
//            Wait.visibilityElementLocatedWait(elementError);
//        }
//
//        @Step("Появление окна ERROR при вводе невалидного текста: {dataInput} в форму")
//        public static void doubleClickSendKeysWaitError2(String locator, String locatorError, String dataInput) {
//            ActionT.OneClick.clickAndEnterText(By.xpath(locator), dataInput);
//            WaitT.littleWait(1000);
//            ActionT.OneClick.clickToHeader();
//            Wait.visibilityElementLocatedWait(locatorError);
//        }
//
//        @Step("Появление окна ERROR при вводе невалидного текста: {dataInput} в форму")
//        public static void doubleClickSendKeysWaitError3(String locator, String locatorError, String dataInput) {
////            ActionT.OneClick.clickAndEnterText(By.xpath(locator), dataInput);
//            ActionT.DoubleClick.doubleClickAndSendKeys(locator, dataInput);
//            WaitT.littleWait(1000);
//            ActionT.OneClick.clickToHeader();
//            Wait.visibilityElementLocatedWait(locatorError);
//        }
//
//        @Step("Появление окна ERROR при вводе невалидного текста: {dataInput} в форму")
//        public static void doubleClickSendKeysWaitError3(WebElement webElement, WebElement webElementError, String dataInput) {
//            ActionT.OneClick.click(webElement);
//            WaitT.littleWait(500);
//            ActionT.OneClick.clickAndEnterText(webElement, dataInput + Keys.ENTER);
//            //ActionT.OneClick.clickToHeader();
//            Wait.visibilityElementLocatedWait(webElementError);
//        }
//    }
//
//    /**
//     * Сравнение скринов
//     */
//    public static class ScreenshotCompare {
//        @Step("Сравнение скринов")
//        public static void screenshotCompare(BufferedImage actualImage, BufferedImage expectedImage ){
//            ImageDiffer imageDiffer = new ImageDiffer();
//            ImageDiff diff = imageDiffer.makeDiff(actualImage, expectedImage);
//            boolean result;
//            result = !diff.hasDiff();
//            Assert.assertTrue(result, "Скриншоты различны");
//        }
//    }
//
//    public static class CheckButton {
//
//        @Step("Проверка состояния кнопки, что кнопка не нажата")
//        public static void checkButtonStatus(WebElement webElement) {
//            Assert.assertFalse(TurboNavigation.isElementPresent(webElement), "Кнопка не должна быть нажата");
//        }
//
//        @Step("Проверка активация кнопки")
//        public static void enabledButton(WebElement webElement_Button, WebElement webElement_Pressed) {
//            webElement_Button.click();
//            Assert.assertTrue(TurboNavigation.isElementPresent(webElement_Pressed), "Кнопка не активировалась");
//        }
//
//        @Step("Проверка отключение кнопки")
//        public static void offButton(WebElement webElement_Button, WebElement webElement_Pressed, WebElement webElement_Active) {
//            webElement_Button.click();
//            checkButtonStatus(webElement_Pressed);
//            Assert.assertTrue(TurboNavigation.isElementPresent(webElement_Active), "Кнопка должна быть Активной");
//        }
//
//        @Step("Проверка состояния кнопки, что кнопка не активна")
//        public static void checkButtonStatusOff(WebElement webElement_Active) {
//            ActionT.OneClick.clickToHeader();
//            Assert.assertFalse(TurboNavigation.isElementPresent(webElement_Active), "Кнопка не должна быть Активной");
//        }
//    }
//}
