package ru.qa.service;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.qa.driver.WebDriverSetup;
import ru.qa.methods.ActionT;
import ru.qa.methods.WaitT;

import java.time.Duration;
import java.util.List;

public class TurboNavigation {
    private static final String CLOSE_TAB_BUTTON_LOCATOR = "//span[@data-testid='tab-bar__tab-icon']";
    public static final String INDICATOR_LOCATOR = "//*[@id='indicator']/div";
    public static final String LEFT_ARROW_LOCATOR = "//*[@class='ri-arrow-drop-left-line ri-fw']";
    public static final String TAB_BAR = "//div[@data-testid='tab-bar__tab']";
    public static final String CLOSE_ALL_TABS_BUTTON = "//span[text()='Закрыть все' and contains(@data-testid,'context-menu_caption')]";

    // отсутствие маски на элементе, нужна перед взаимодействиями с элементами и ассертами
    // маска присутствует во время обновления состояния элемента
    public static boolean isMaskClickable() {
        return isClickable(By.xpath(INDICATOR_LOCATOR));
    }

    public static boolean isClickable(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverSetup.getDriverInstance(), Duration.ofSeconds(1), Duration.ofMillis(50));
            wait.until(ExpectedConditions.elementToBeClickable(by));
            return true;
        } catch (Exception ignore) {
            return false;
        }
    }

    @Step("Нажимать на стрелочку (в лево) в вверхнем левом углу на уровне открытых табов до её исчезновения")
    public static void clickLeftArrow() {
        while (isClickable(By.xpath(LEFT_ARROW_LOCATOR))) {
            WaitT.elementToBeClickable(LEFT_ARROW_LOCATOR);
            WebDriverSetup.getDriverInstance().findElement(By.xpath(LEFT_ARROW_LOCATOR)).click();
        }
    }

    @Step("Закрыть все открытые табы")
    public static void clickWhileCloseTab() {
        while (isElementPresent(By.xpath(CLOSE_TAB_BUTTON_LOCATOR))) {
            clickLeftArrow();
            WaitT.elementToBeClickable(By.xpath(CLOSE_TAB_BUTTON_LOCATOR));
            WebDriverSetup.getDriverInstance().findElement(By.xpath(CLOSE_TAB_BUTTON_LOCATOR)).click();
        }
    }

    public static boolean isElementPresent(By by) {
        try {
            while (isMaskClickable()) {}
            WebDriverSetup.getDriverInstance().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isElementPresent(WebElement webElement) {
        try {
            while (isMaskClickable()) {}
            webElement.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void clickToLoginInAuthPage(String LOGIN) {
        String locatorUser = "//*[@data-testid='user']";
        String locatorLoginButton = "//*[@data-testid='button_caption']";
        String checkBoxLocator = "//*/div[contains(text(),'Отключить пользователя и продолжить')]";
        String loginButtonLocator = "//*[@data-testid='button_caption']";
        String OkButton = "//span[contains(@data-testid,'button_caption') and contains(text(),'Готово')]";

        ActionT.OneClick.clickClearEnterText(By.xpath(locatorUser), LOGIN);
        ActionT.OneClick.click(locatorLoginButton);

        while (TurboNavigation.isMaskClickable()) {}

        if (isElementFoundDisplayedEnabled(By.xpath("//*/div[contains(text(),'Отключить пользователя и продолжить')]"))) {
            ActionT.OneClick.click(checkBoxLocator);
            WaitT.elementToBeClickable(loginButtonLocator);
            ActionT.OneClick.click(loginButtonLocator);
            while (TurboNavigation.isMaskClickable()) {}
        }

//        if(TurboNavigation.isElementPresent(By.xpath(OkButton))) {
//          ActionT.OneClick.click(OkButton);
//        }
    }

    /** Если элемент отображается и чекбокс не нажат, вернуть true, иначе false */
    private static boolean isElementFoundDisplayedEnabled(By by) {
        try {
            List<WebElement> e = WebDriverSetup.getDriverInstance().findElements(by);
            return !e.isEmpty() && e.get(e.size() - 1).isDisplayed() && e.get(e.size() - 1).isEnabled();
        } catch (Exception ignored) {}
        return false;
    }

    // ! закрытие по нажатию правой клавиши может работать нестабильно или не работать на старых версиях
    // оставлен на будущее
    public static void closeOpenTabs() {
        ActionT.OneClick.rightMouseClick(TAB_BAR);
        ActionT.OneClick.click(CLOSE_ALL_TABS_BUTTON);
    }
}
