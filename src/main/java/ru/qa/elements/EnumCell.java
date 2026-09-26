package ru.qa.elements;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.qa.methods.WaitT;


import java.util.List;

import static ru.qa.driver.WebDriverSetup.getDriverInstance;


/**
 * @author Slava Solodov
 * @created 04/04/2023 - 16:02
 * @email vsolodov@cbgr.ru
 */

public class EnumCell extends BaseElement {

    private final Actions actions = new Actions(getDriverInstance());

    public EnumCell(String typeElement) {
        super(typeElement);
    }


    public EnumCell clickElement() {
        Allure.step("Клик на ячейку дроп-бокса '" + getName() + "'");
        WaitT.elementToBeClickable(this.getWrappedElement());
        this.getWrappedElement().click();
        return this;
    }

    public EnumCell doubleClick() {
        Allure.step("Двойной клик на ячейку дроп-бокса '" + getName() + "'");
        WaitT.elementToBeClickable(this.getWrappedElement());
        actions.moveToElement(this.getWrappedElement()).doubleClick().build().perform();
        return this;
    }

    @Step("Ожидание {time} миллисекунд")
    public EnumCell littleWait(int time) {
        WaitT.littleWait(time);
        return this;
    }

    public EnumCell moveToElement() {
        Allure.step("Навести курсор на ячейку дроп-бокса '" + getName() + "'");
        WaitT.elementToBeClickable(this.getWrappedElement());
        actions.moveToElement(this.getWrappedElement()).perform();
        return this;
    }

    public EnumCell rightMouseClickTextBox() {
        Allure.step("Клик правой кнопкой мыши по ячейку дроп-бокса '" + getName() + "'");
        WaitT.elementToBeClickable(this.getWrappedElement());
        actions.contextClick(this.getWrappedElement()).perform();
        return this;
    }

    @Step("Выбрать элемент из списка по его имени: {elementName}")
    public EnumCell selectElementFromListByName(String elementName) {
        WaitT.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'ScrollbarsCustom-Scroller')]//p"));

        List<WebElement> options =
                getDriverInstance().findElements(By.xpath("//div[contains(@class, 'ScrollbarsCustom-Scroller')]//p"));
        options.stream()
                .filter(option -> option.getText().equals(elementName))
                .findFirst()
                .ifPresent(WebElement::click);

        return this;
    }

    /**
     * Выбираем элемент из выпадающего списка по атрибуту data-title
     * @param elementName элемент выпадающего списка
     * @return
     */
    @Step("Выбрать элемент из списка по его имени: {elementName}")
    public EnumCell selectElementFromListByTitle(String elementName) {
        WaitT.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'drop-down')]//ul//li"));

        List<WebElement> options =
                getDriverInstance().findElements(By.xpath("//div[contains(@class, 'drop-down')]//ul//li"));
        options.stream()
                .filter(option -> option.getAttribute("data-title").equals(elementName))
                .findFirst()
                .ifPresent(WebElement::click);

        return this;
    }
}
