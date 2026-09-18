package ar.soft.AT.UI.tests.authorization;


import ar.soft.AT.UI.tests.baseTest.SelenideBaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

@Epic("Тестирование веб-интерфейса")
@Feature("Динамическая загрузка элементов")
public class AuthorizationSTest extends SelenideBaseTest {

    @Test
    @Story("Успешная загрузка скрытого элемента")
    @Description("Тест проверяет, что после клика на кнопку элемент появляется на странице")
    @Severity(SeverityLevel.CRITICAL)
    public void authorizationTest() {
        // Шаги внутри теста, которые будут красиво отображаться в Allure
        Allure.step("Открыть главную страницу", () -> {
            //  код открытия страницы
        });


    }
}