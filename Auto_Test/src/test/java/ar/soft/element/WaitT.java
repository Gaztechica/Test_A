package ar.soft.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static ar.soft.driver.WebDriverSetup.getDriverInstance;

public class WaitT {

    static Logger log = LoggerFactory.getLogger(WaitT.class);

    protected static WebDriverWait wait;

    /** Установка таймаута ожидания и интервал опроса */
    public static void initWait(Duration timeOut, Duration sleep) {
        wait = new WebDriverWait(getDriverInstance(), timeOut, sleep);
    }

    /** Ожидание наличия элемента по локатору */
    public static void presenceOfElementLocated(By webElement) {
        wait.until(ExpectedConditions.presenceOfElementLocated(webElement));
    }

    /** Ожидание появления текста в элементе */
    public static void presenceOfTextInElement(WebElement webElement, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    /** Ожидание появления текста в элементе */
    public static boolean isPresenceOfTextInElement(By locator, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    /** Ожидание появления текста в элементе */
    public static boolean isPresenceOfTextInElement(WebElement webElement, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    /** Ожидание кликабельности элемента по локатору */
    public static void elementToBeClickable(By webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /** Ожидание кликабельности элемента по локатору */
    public static void elementToBeClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /** Ожидание кликабельности элемента по локатору */
    public static void elementToBeClickable(String locator) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    /** Ожидание видимости элемента */
    public static void visibilityOfElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /** Ожидание видимости элемента по локатору */
    public static void visibilityOfElementLocated(By webElement) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
    }

    /** Ожидание видимости элемента по локатору */
    public static void visibilityOfAllElementLocated(By webElement) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(webElement));
    }

    public static boolean isElementDisplayed(By webElement) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(webElement)).isDisplayed();
    }

    public static boolean isElementDisplayed(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement)).isDisplayed();
    }

    public static boolean isInvisibilityOfElement(By webElement) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(webElement));
    }

    public static boolean isInvisibilityOfElement(WebElement webElement) {
        return wait.until(ExpectedConditions.invisibilityOf(webElement));
    }



    public static boolean isAttributeContainsText(By webElement, String attribute, String text) {
        return wait.until(ExpectedConditions.attributeContains(webElement, attribute, text));
    }
    public static boolean isAttributeContainsText(WebElement webElement, String attribute, String text) {
        return wait.until(ExpectedConditions.attributeContains(webElement, attribute, text));
    }


    public static void littleWait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException  e) {
//            ActionT.log.error("Явно указанное ожидание завершилось аварийно!");
        }
    }
}
