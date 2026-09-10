package ar.soft.Test.SauceDemoSelenide.tests;

import ar.soft.Test.SauceDemoSelenide.baseTest.SelenideBaseTest;
import ar.soft.Test.SauceDemoSelenide.pages.CheckoutPage;
import ar.soft.Test.SauceDemoSelenide.pages.ProductsPage;
import ar.soft.Test.SauceDemoSelenide.steps.SauceDemoSteps;
import ar.soft.Test.SauceDemoSelenide.utils.ConfigReader;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class SelenideLoginTest extends SelenideBaseTest {

    private final SauceDemoSteps steps = new SauceDemoSteps();
    private final ProductsPage productsPage = new ProductsPage();
    private final CheckoutPage checkoutPage = new CheckoutPage();

    @Test
    public void testEndToEndPurchaseFlow() {
        // Динамическое чтение URL и конфигов
        open(ConfigReader.get("saucedemo.url"));

        // 1. Бизнес-шаг: Авторизация
        steps.login(
                ConfigReader.get("saucedemo.username"),
                ConfigReader.get("saucedemo.password")
        );
        // Бизнес-проверка: мы на странице продуктов
        productsPage.getPageTitle().shouldHave(Condition.text("Products"));

        // 2. Бизнес-шаг: Добавление двух товаров и переход в корзину
        steps.addTwoItemsToCartAndGoToCart();

        // 3. Бизнес-шаг: Переход к оформлению
        steps.proceedToCheckout();

        // 4. Бизнес-шаг: Заполнение данных и завершение
        steps.fillCheckoutDataAndFinish("Ivan", "Ivanov", "123456");

        // Финальный бизнес-ассерт: Покупка успешно завершена
        checkoutPage.getCompleteHeader().shouldHave(Condition.text("Thank you for your order!"));
    }
}
