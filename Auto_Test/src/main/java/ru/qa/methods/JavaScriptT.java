package ru.qa.methods;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static ru.qa.driver.WebDriverSetup.getDriverInstance;


public class JavaScriptT {

    protected static JavascriptExecutor js;

    /** Инициализация исполнителя Js скриптов */
    public static void initJS() {
        js = getDriverInstance();
    }

    @Step("Клик по невидимому элементу JS")
    public static void clickInvisibleElementJS(String locator) {
        String script = "arguments[0].click();";
        ((JavascriptExecutor)getDriverInstance()).executeScript(script, getDriverInstance().findElement(By.xpath(locator)));
    }

    @Step("Уменьшение масштаба страницы на %")
    public static void zoom(){
        js.executeScript("document.body.style.zoom='75%'");
    }

    @Step("Скролл страницы на заданное расстояние в пикселях по X и по Y JS")
    public static void scrollBy(int x, int y) {
        String script = "window.scrollBy(" + x + "," + y + ");";
        ((JavascriptExecutor)getDriverInstance()).executeScript(script);
    }

    @Step("Установка невидимости веб элемента JS")
    public static void displayNone(String locator) {
        String script = "arguments[0].style.display='none';";
        ((JavascriptExecutor)getDriverInstance()).executeScript(script, By.xpath(locator));
    }

    @Step("Получение текста веб элемента JS")
    public static String getTextJS(String locator) {
        String script = "return document.documentElement.innerText";
        return ((JavascriptExecutor)getDriverInstance()).executeScript(script,
                getDriverInstance().findElement(By.xpath(locator))).toString();
    }

    @Step("Получение текста веб элемента JS")
    public static String getTextJS(WebElement webElement) {
        String script = "return document.documentElement.innerText";
        return ((JavascriptExecutor)getDriverInstance()).executeScript(script,
                webElement).toString();
    }

    @Step("Получение текста веб элемента JS")
    public static String getTextElementJS(WebElement webElement) {
        String script = "return arguments[0].textContent";
        return ((JavascriptExecutor)getDriverInstance()).executeScript(script,
                webElement).toString();
    }
}
