package ar.soft.AT.UI.tests.baseTest;

import ar.soft.AT.UI.config.ConfigReader;
import ar.soft.AT.UI.modelPage.authorization.AuthorizationsSPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class SelenideBaseTest {
    // Если используете TestNG, импортируйте org.testng.annotations.BeforeMethod
// Если используете JUnit 5, импортируйте org.junit.jupiter.api.BeforeEach

    @BeforeAll // или @BeforeClass для TestNG (ваш текущий метод настройки браузера)
    public static void globalSetup() {
        Configuration.browser = "chrome";
        Configuration.timeout = 8000;
        Configuration.holdBrowserOpen = true; // для отладки
// Установка конкретного FullHD разрешения (самый стабильный вариант для CI/CD и разных ОС)
        Configuration.browserSize = "1920x1080";


        // Включаем логгер, который сам будет делать скриншоты при падениях
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false) // по желанию: сохранять ли HTML-код страницы
        );

//        // получаем токен один раз перед тестами ВАЖНО: Запрещаем Selenide закрывать браузер между тестами,
//        // иначе при запуске второго теста сессия сотрется
//        Configuration.holdBrowserOpen = true;
//
//        // 2. Получаем токен авторизации через Rest Assured
//        String token = AuthSteps.getToken();
//
//        // 3. Принудительно открываем фронтенд для инициализации LocalStorage
//        String baseUrl = ConfigReader.get("arSelenide.url");
//        open(baseUrl + "/login");
//
//        // 4. Записываем токен в LocalStorage один раз для ВСЕГО прогона тестов
//        Selenide.localStorage().setItem("token", token);
//
//        // 5. Освежаем страницу, чтобы войти в систему
//        Selenide.refresh();
}

//    //получаем токен через Апи и переходим в вэб
//    @BeforeEach
//    void loginViaApi() {
//        // 1. Быстро получаем токен с бэкенда через Rest Assured
//        String token = AuthSteps.getToken();
//
//        // 2. Открываем фронтенд, чтобы инициализировать контекст LocalStorage для этого домена
//        String baseUrl = ConfigReader.get("arSelenide.url");
//        open(baseUrl + "/login");
//
//        // 3. Записываем токен напрямую в LocalStorage браузера
//        // Замените первый аргумент "token" на точное имя ключа вашего приложения, если оно отличается
//        com.codeborne.selenide.Selenide.localStorage().setItem("token", token);
//
//        // 4. Освежаем страницу — скрипты фронтенда увидят токен и пропустят нас в личный кабинет!
//        com.codeborne.selenide.Selenide.refresh();
//    }


// НОВЫЙ МЕТОД: будет запускаться строго ПЕРЕД КАЖДЫМ @Test
@BeforeEach
public void setUpLogin() {
    open(ConfigReader.get("arSelenide.url"));

    AuthorizationsSPage steps = new AuthorizationsSPage();
    steps.login(
            ConfigReader.get("arSelenide.email"),
            ConfigReader.get("arSelenide.password")
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
