package ru.qa.driver;

import io.qameta.allure.Step;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterGroups;
import ru.qa.browsers.Browsers;
import ru.qa.methods.ActionT;
import ru.qa.methods.JavaScriptT;
import ru.qa.methods.WaitT;
import ru.qa.property.turbo.StandAddress;
import ru.qa.service.Attachment;
import ru.qa.service.TurboNavigation;

import java.time.Duration;

import static ru.qa.driver.WebDriverSetup.*;


/**
 * Базовый класс для всех тестов. Инициализирует вебдрайвер и готовит окружение для открытия форм.
 */
abstract public class TestBase {
    /**
     * инициализация логирования
     */
    private static final Logger log = LoggerFactory.getLogger(TestBase.class);

    /**
     * Задержка перед повторным поиском элемента (большее значение замедляет, т.к. при кликах на элементах есть маска если они недоступны)
     */
    private static final Duration DURATION_SLEEP = Duration.ofMillis(100);
    /**
     * по истечении будет NoSuchElementException
     */
    private static final Duration DURATION_TIMEOUT = Duration.ofSeconds(6);

    // переменные окружения, указываются при вызове через командную строку или во кладке maven
    // для более удобной отладки и работе с разных пользований
    /**
     * стенд из mvn -Dstand= или из Jenkins
     */
    public static final String STAND = System.getProperty("stand", "test");
    /**
     * юзер из mvn -Duser= или из Jenkins
     */
    public static final String USER = System.getProperty("user", "VMoskvichev");

    /**
     * Инициализация вебдрайвера при запуске
     */
//    @BeforeSuite(groups = {"10.5"})
//    public static void setUpDriver() {
//        log.info("СОБЫТИЕ: Адрес стенда: > " + StandAddress.getStandUrl(STAND));
//        log.info("СОБЫТИЕ: LOGIN FROM ENV > " + USER);
//
//        WebDriverSetup.setupDriver(Browsers.fromString(browser));
//
//        log.info("Запуск тестов на локальной машине!");
//
//        WaitT.initWait(DURATION_TIMEOUT, DURATION_SLEEP);
//        ActionT.initActions();
//        JavaScriptT.initJS();
//    }

    /**
     * Закрывает открытые вкладки перед выполнением набора тестов и разворачивает окно в полный экран
     */
//    @BeforeClass(groups = {"10.5"})
//    public static void prepareBrowserBeforeTests() {
//        // Получение экземпляра драйвера
//        RemoteWebDriver driver = getDriverInstance();
//        System.out.println("Capabilities: " + driver.getCapabilities());
//        // Проверка, запущен ли браузер в headless-режиме
//        boolean isHeadless = isHeadlessMode();
//
//        // Управление размером окна в зависимости от режима
//        if (isHeadless) {
//            // Установка размера окна для headless-режима
//            driver.manage().window().setSize(new Dimension(2560, 1440));
//            System.out.println("Режим headless: установлено разрешение 2560x1440");
//        } else {
//            // Разворачивание окна на весь экран в обычном режиме
//            driver.manage().window().maximize();
//            System.out.println("Обычный режим: окно развернуто на весь экран");
//        }
//
//        // Получение и вывод текущего разрешения
//        Dimension size = driver.manage().window().getSize();
//        System.out.println("Текущее разрешение: " + size.getWidth() + "x" + size.getHeight());
//
//        checkLoginInSystem();
//        TurboNavigation.clickWhileCloseTab();
//
//        // Повторное получение и вывод разрешения
//        Dimension size2 = driver.manage().window().getSize();
//        System.out.println("Разрешение после действий: " + size2.getWidth() + "x" + size2.getHeight());
//
//        // Установка неявного ожидания
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//    }

    // Метод для проверки, запущен ли браузер в headless-режим
    public static boolean isHeadlessMode() {
        // Проверяем, содержит ли строка аргумент --headless или --headless=new
        return browserOptions.contains("--headless=new") || browserOptions.contains("--headless");
    }

    @AfterGroups(groups = {"10.5"})
    public void closeTabAfterTestGroup() {
        TurboNavigation.clickWhileCloseTab();
    }

//    @Step("Проверка что вход в систему произведен")
//    protected void checkLoginInSystem() {
//        String currentUrl = getDriverInstance().getCurrentUrl();
//        // если драйвер отсутствует запустить заново
//        if (getDriverInstance() == null) TestBase.setUpDriver();
//        else  getDriverInstance().navigate().refresh();
//        // !! без этой проверки страница не открывается
//        if (!currentUrl.contains("/workspace")) login();
//    }

    @Step("Вход в систему")
    protected void login() {
        log.info("СОБЫТИЕ: LOGIN FROM ENV* -> " + USER);
        getDriverInstance().get(StandAddress.getStandUrl(STAND));
        Attachment.getAllureEnvironment();
        LoginPage loginPage = new LoginPage();
        loginPage.clickToLoginInAuthPage(USER);

        //TurboNavigation.clickToLoginInAuthPage(USER);
    }
}