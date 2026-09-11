package ar.soft.Test.sauceDemo.baseTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

/**
 * Единый тестовый стенд (SUT):
 * а) для базовых сценариев и Page Object: SauceDemo (Swag Labs) https://www.saucedemo.com/
 * б) для сложных локаторов и AJAX: http://the-internet.herokuapp.com/
 * <p>
 * Задача:
 * <p>
 * 1. Автоматизировать сценарий на SauceDemo: Логин -> Добавление двух товаров в корзину -> Переход в Cart -> Checkout (ввод данных) -> Finish.
 * <p>
 * 2. Реализовать паттерн Page Object + Steps.
 * - Page — только локаторы и базовые действия (click, type).
 * - Steps — бизнес-логика (addItemsToCart, completeCheckout).
 * - Test — только оркестрация и бизнес-ассерты.
 * <p>
 * 3. Вынести URL, логин (standard_user) и пароль в config.properties (или .env), читать их через кастомный ConfigReader или библиотеку Owner.
 * <p>
 * Критерий приемки: В тестовом классе нет ни одного импорта из org.openqa.selenium. Все локаторы инкапсулированы. Конфиг читается динамически.
 */
public class SeleniumBaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

//    @BeforeEach
//    public void setUp() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new"); // Headless режим
//        options.setCapability("se:cdp", false);  // Отключение сбойного CDP
//        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--window-size=1920,1080");
//
//        driver = new ChromeDriver(options);
//    }

    /**
     * Общий метод авторизации для всех наследников.
     * Теперь он использует слой бизнес-шагов (Steps).
     */
//    protected void loginAsStandardUser() {
//        SauceDemoSteps steps = new SauceDemoSteps(driver);
//        steps.openLoginPage();
//        steps.loginAsStandardUser();
//    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Вызывается один раз в самом конце после прогона ВСЕХ тестов в классе
    @AfterAll
    public static void killDriverProcesses() {
        String os = System.getProperty("os.name").toLowerCase();
        try {
            if (os.contains("win")) {
                // Жестко убивает зависшие процессы в Windows
                Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
                Runtime.getRuntime().exec("taskkill /F /IM chrome.exe /T");
            } else {
                // Для macOS и Linux
                Runtime.getRuntime().exec("pkill -f chromedriver");
            }
        } catch (IOException e) {
            System.err.println("Не удалось очистить процессы драйвера: " + e.getMessage());
        }

    }
}
