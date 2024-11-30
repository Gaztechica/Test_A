package ar.soft.element;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class AssertionT {

    @Step("Проверка что элемент присутствует на странице и содержит текст: '{elementHaveText}'")
    public static void elementPresentOnPageAndContainText(WebElement webElement, String elementHaveText) {
        String elementText = MethodT.getElementTextValue(webElement);
        assertThat(elementText).as("Элемент с таким именем не найден").contains(elementHaveText);
        log.info("Элемент " + "'" + elementHaveText + "'" + " присутствует на странице");
    }
}
