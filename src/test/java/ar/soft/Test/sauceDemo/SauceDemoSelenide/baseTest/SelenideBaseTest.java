package ar.soft.Test.sauceDemo.SauceDemoSelenide.baseTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

/**
 * Единый тестовый стенд (SUT):
 * а) для базовых сценариев и Page Object: SauceDemo (Swag Labs) https://www.saucedemo.com/
 * б) для сложных локаторов и AJAX: http://the-internet.herokuapp.com/
 *
 * Задача:
 *
 * 1. Автоматизировать сценарий на SauceDemo: Логин -> Добавление двух товаров в корзину -> Переход в Cart -> Checkout (ввод данных) -> Finish.
 *
 * 2. Реализовать паттерн Page Object + Steps.
 * - Page — только локаторы и базовые действия (click, type).
 * - Steps — бизнес-логика (addItemsToCart, completeCheckout).
 * - Test — только оркестрация и бизнес-ассерты.
 *
 * 3. Вынести URL, логин (standard_user) и пароль в config.properties (или .env), читать их через кастомный ConfigReader или библиотеку Owner.
 *
 * Критерий приемки: В тестовом классе нет ни одного импорта из org.openqa.selenium. Все локаторы инкапсулированы. Конфиг читается динамически.
 */
public class SelenideBaseTest {
    @BeforeAll
    public static void globalSetup() {
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
        Configuration.holdBrowserOpen = true; // для отладки
    }
}
