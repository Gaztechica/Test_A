package ru.qa.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.qa.driver.TestBase;
import ru.qa.service.TurboNavigation;


import java.util.List;

import static ru.qa.driver.WebDriverSetup.getDriverInstance;


public class MethodT extends TestBase {
    private static final Logger log = LoggerFactory.getLogger(MethodT.class);

    public static void printElementCssAndAttributeProperty(String locator, String atribute) {
        String getCSS = getDriverInstance().findElement(By.xpath(locator)).getCssValue(atribute);
        String getAttribute = getDriverInstance().findElement(By.xpath(locator)).getAttribute(atribute);
        log.info(" CSS --> " + atribute + " --> " + getCSS);
        log.info(" Attribute --> " + atribute + " --> " + getAttribute);
    }

    // получение значения атрибута {searchedAttribute}
    public static String getElementCssProperty(By elementLocator, String searchedAttribute) {
        while (TurboNavigation.isMaskClickable()) {}
        WaitT.presenceOfElementLocated(elementLocator);
        WaitT.elementToBeClickable(elementLocator);
        return getDriverInstance().findElement(elementLocator).getCssValue(searchedAttribute);
    }

    // получение значения атрибута {searchedAttribute}
    public static String getElementCssProperty(WebElement webElement, String searchedAttribute) {
        while (TurboNavigation.isMaskClickable()) {}
        WaitT.elementToBeClickable(webElement);
        return webElement.getCssValue(searchedAttribute);
    }

    // получение значения атрибута {searchedAttribute}
    public static boolean isCssPropertyEmpty(By elementLocator, String searchedAttribute) {
        while (TurboNavigation.isMaskClickable()) {}
        WaitT.presenceOfElementLocated(elementLocator);
        WaitT.elementToBeClickable(elementLocator);
        log.info(getDriverInstance().findElement(elementLocator).getCssValue(searchedAttribute));
        return getDriverInstance().findElement(elementLocator).getCssValue(searchedAttribute).isEmpty();
    }

    // получение значения атрибута {searchedAttribute}
    public static String getElementAttributeProperty(By elementLocator, String searchedAttribute) {
        while (TurboNavigation.isMaskClickable()) {}
        WaitT.presenceOfElementLocated(elementLocator);
        WaitT.elementToBeClickable(elementLocator);
        return getDriverInstance().findElement(elementLocator).getAttribute(searchedAttribute);
    }

    // получение значения атрибута {searchedAttribute}
    public static String getElementAttributeProperty(WebElement webElement, String searchedAttribute) {
        while (TurboNavigation.isMaskClickable()) {}
        WaitT.visibilityOfElement(webElement);
        WaitT.elementToBeClickable(webElement);
        return webElement.getAttribute(searchedAttribute);
    }

    // Получаем текст из инф. поля
    public static String getElementTextValue(String locatorInfo) {
        while (TurboNavigation.isMaskClickable()) {}
        WaitT.presenceOfElementLocated(By.xpath(locatorInfo));
        WaitT.elementToBeClickable(locatorInfo);
        return getDriverInstance().findElement(By.xpath(locatorInfo)).getText();
    }

    // Получаем текст из инф. поля


    // Получаем текст элемента отсуствующего на странице, но находящегося в DOM
    public static String getDOMElementTextValue(String locatorInfo) {
        WaitT.presenceOfElementLocated(By.xpath(locatorInfo));
        return getDriverInstance().findElement(By.xpath(locatorInfo)).getText();
    }

    // Получаем текст из инф. поля
    public static String getElementTextValue(By locatorInfo) {
        while (TurboNavigation.isMaskClickable()) {}
        WaitT.presenceOfElementLocated(locatorInfo);
        WaitT.elementToBeClickable(locatorInfo);
        return getDriverInstance().findElement(locatorInfo).getText();
    }

    // Получаем текст из инф. поля
    public static String getElementTextValue(WebElement webElement) {
        while (TurboNavigation.isMaskClickable()) {}
        WaitT.elementToBeClickable(webElement);
        return webElement.getText();
    }

    // todo - Выпилить, оставить getNumberOfElements2
    // Получить количество элементов
    public static int getNumberOfElements(String locator) {
        while (TurboNavigation.isMaskClickable()) {}
        WaitT.presenceOfElementLocated(By.xpath(locator));
        return getDriverInstance().findElements(By.xpath(locator)).size();
    }

    // Получить количество элементов
    public static int getNumberOfElements2(List<WebElement> elementsList) {
        while (TurboNavigation.isMaskClickable()) {}
        return elementsList.size();
    }

    /** Получить высоту элемента
     * @param locator - локатор элемента
     * @return значение высоты в int */
    public static int getHeightOfElement(By locator) {
        return getDriverInstance().findElement(locator).getRect().getHeight();
    }

    public static int getHeightOfElement(WebElement webElement) {
        return webElement.getRect().getHeight();
    }

    public static int getWidthOfElement(By locator) {
        return getDriverInstance().findElement(locator).getRect().getWidth();
    }

    public static int getWidthOfElement(WebElement webElement) {
        return webElement.getRect().getWidth();
    }

    public static int getCSSValueAsInt(By locator, String CSS) {
        String getElementHeightAsString = MethodT.getElementCssProperty(locator, CSS);
        log.info("Значение атрибута " + CSS + ": " + getElementHeightAsString);
        return Integer.parseInt(getElementHeightAsString.replaceAll("[^0-9]",""));
    }

    public static int getCSSValueAsInt(WebElement webElement, String CSS) {
        String getElementHeightAsString = MethodT.getElementCssProperty(webElement, CSS);
        log.info("Значение атрибута " + CSS + ": " + getElementHeightAsString);
        return Integer.parseInt(getElementHeightAsString.replaceAll("[^0-9]",""));
    }


}
