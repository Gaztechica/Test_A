//package ar.soft.driver;
//
//import ar.soft.browsers.Browsers;
//import ar.soft.browsers.Chrome;
//import ar.soft.browsers.Edge;
//import ar.soft.browsers.FireFox;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * Настройки запуска вебдрайвера
// */
//public abstract class WebDriverSetup {
//
//    private static final Logger log = LoggerFactory.getLogger(WebDriverSetup.class);
//
//    /** Получение проперти для указания запуска браузера в maven -Dbrowser=firefox.
//     * При передаче неверного значения используется значение по умолчанию */
//    static String browser = System.getProperty("browser", "chrome").toLowerCase();
//
//    /**
//     * Единственный экземпляр драйвера, реализует паттерн синглетон
//     */
//    private static RemoteWebDriver remoteWebDriver;
//
//    /**
//     * Получение уже созданного экземпляра вебдрайвера.
//     * Если нужно обратиться к драйверу, используем этот метод (TestBase.getDriverInstance)
//     */
//    public static RemoteWebDriver getDriverInstance() {
//        return remoteWebDriver;
//    }
//
//    /** Метод первичной настройки вебдрайвера, принимает в качестве аргумента название браузера из перечисления (enum)
//     * При передаче строки необходимо привести значение к строке (Browsers.fromString(browserName)) */
//    public static void setupDriver(Browsers name) {
//        switch (name) {
//            case CHROME -> {
//                log.info("Драйвер для браузера Google Chrome");
//                remoteWebDriver = Chrome.getDriver();
//            }
//            case EDGE -> {
//                log.info("Драйвер для браузера Microsoft Edge");
//                remoteWebDriver = Edge.getDriver();
//            }
//            case FIREFOX -> {
//                log.info("Драйвер для браузера Mozilla Firefox");
//                remoteWebDriver = FireFox.getDriver();
//            }
//            default -> throw new RuntimeException("Некорректное имя браузера");
//        }
//    }
//}
