package ar.soft.Test.sauceDemoSelenide.tests;


import ar.soft.Test.sauceDemoSelenide.baseTest.SelenideBaseTest;
import ar.soft.Test.sauceDemoSelenide.steps.SauceDemoSteps;
import org.junit.jupiter.api.Test;

public class SelenideLoginTest extends SelenideBaseTest {

    private final SauceDemoSteps steps = new SauceDemoSteps();

    @Test
    public void testEndToEndPurchaseFlow() {
        // 1. Бизнес-проверка: мы на странице продуктов
        steps.verifyUserIsOnProductsPage();

        // 2. Бизнес-шаг: Добавление двух товаров и переход в корзину
        steps.addTwoItemsToCartAndGoToCart();

        // 3. Бизнес-шаг: Переход к оформлению
        steps.proceedToCheckout();

        // 4. Бизнес-шаг: Заполнение данных и завершение
        steps.fillCheckoutDataAndFinish("Ivan", "Ivanov", "123456");

        // 5. Финальный бизнес-ассерт: Покупка успешно завершена
        steps.verifyOrderIsSuccessfullyCompleted();
    }
}
