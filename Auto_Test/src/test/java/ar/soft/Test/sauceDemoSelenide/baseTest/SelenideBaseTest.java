package ar.soft.Test.sauceDemoSelenide.baseTest;

import ar.soft.Test.sauceDemo.utils.ConfigReader;
import ar.soft.Test.sauceDemoSelenide.steps.SauceDemoSteps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class SelenideBaseTest {
    @BeforeAll
    public static void globalSetup() {
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
        Configuration.holdBrowserOpen = true; // для отладки
    }

//    // Включаем интеграцию Allure с Selenide.
//    // Благодаря этому в отчет Allure будут автоматически добавляться скриншоты,
//    // исходный код страницы и пошаговые логи на каждый клик/ввод текста!
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
//                .screenshots(true)
//                .savePageSource(false));
//}

    @BeforeEach
    public void setUpLogin() {
        open(ConfigReader.get("saucedemo.url"));

        SauceDemoSteps steps = new SauceDemoSteps();
        steps.login(
                ConfigReader.get("saucedemo.username"),
                ConfigReader.get("saucedemo.password")
        );
    }

    @AfterEach
    void tearDown() {
        // Очищаем куки и локальное хранилище после каждого теста,
        // чтобы гарантировать изоляцию (следующий тест начнется с "чистого листа")
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
}
