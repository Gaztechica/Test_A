package ar.soft.driver;

import ar.soft.browsers.Browsers;
import ar.soft.element.ActionT;
import ar.soft.element.JavaScriptT;
import ar.soft.element.WaitT;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import static ar.soft.driver.WebDriverSetup.browser;
import static ar.soft.driver.WebDriverSetup.getDriverInstance;

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
    private static final Duration DURATION_TIMEOUT = Duration.ofSeconds(5);

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
    @BeforeSuite(groups = {"10.5"})
    public static void setUpDriver() {
//        log.info("СОБЫТИЕ: Адрес стенда: > " + StandAddress.getStandUrl(STAND));
        log.info("СОБЫТИЕ: LOGIN FROM ENV > " + USER);

        WebDriverSetup.setupDriver(Browsers.fromString(browser));

        log.info("Запуск тестов на локальной машине!");

        WaitT.initWait(DURATION_TIMEOUT, DURATION_SLEEP);
        ActionT.initActions();
        JavaScriptT.initJS();
    }

    /**
     * Закрывает открытые вкладки перед выполнением набора тестов и разворачивает окно в полный экран
     */
    @BeforeClass(groups = {"10.5"})
    public void prepareBrowserBeforeTests() {
        checkLoginInSystem();
//        TurboNavigation.clickWhileCloseTab();
        getDriverInstance().manage().window().maximize();
        getDriverInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterGroups(groups = {"10.5"})
//    public void closeTabAfterTestGroup() {
//        TurboNavigation.clickWhileCloseTab();
//    }

    @Step("Проверка что вход в систему произведен")
    protected void checkLoginInSystem() {
        String currentUrl = getDriverInstance().getCurrentUrl();
        // если драйвер отсутствует запустить заново
        if (getDriverInstance() == null) TestBase.setUpDriver();
        else  getDriverInstance().navigate().refresh();
        // !! без этой проверки страница не открывается
        if (!currentUrl.contains("/workspace")) login();
    }

    @Step("Вход в систему")
    protected void login() {
        log.info("СОБЫТИЕ: LOGIN FROM ENV* -> " + USER);
//        getDriverInstance().get(StandAddress.getStandUrl(STAND));
//        Attachment.getAllureEnvironment();
//        LoginPage loginPage = new LoginPage();
//        loginPage.clickToLoginInAuthPage(USER);

        //TurboNavigation.clickToLoginInAuthPage(USER);
    }
}
