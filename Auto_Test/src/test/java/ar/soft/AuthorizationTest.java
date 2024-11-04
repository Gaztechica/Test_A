package ar.soft;

import ar.soft.modelPage.AuthorizationPege;
import ar.soft.modelPage.HomePage;
import ar.soft.modelPage.base.BasePage;
import ar.soft.runner.BaseTest;
//import org.junit.Assert;
//import org.junit.Test;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class AuthorizationTest extends BaseTest {

    private final By GET_ERROR_TEXT = By.xpath("//div[@style='text-align: center; margin-bottom: 20px; color: rgb(255, 0, 0);']");
    private final By GET_EMAIL_TEXT = By.xpath("//div[@class='ant-typography p_r RestorePassword__form-userNotFound']");
    private final By GET_PASSWORD = By.xpath("//h2[@class='ant-typography h2_m SendSuccessBlock__text'][contains(.,'Мы отправили по адресу')]");
    public static final String NEGA_EMAIL = "yyyyyyyyyyyyyy@mail.ru";



    @Test(priority = 1,
            description = "Авторизация под ролью владельца")
    public void ownerAuthorizationTest () {
        driver.get(URL);

        String role = new AuthorizationPege(getDriver())
                .inputMail(EMAIL)
                .inputPassword(PASSWORD)
                .btnSubmit()
                .btnProfile()
                .selectProfile()
                .roleProfile();

        Assert.assertEquals(role,"Владелец");
    }

    @Test(priority = 2,
            description = "Авторизация под ролью admin")
    public void adminAuthorizationTest () {
        driver.get(URL);

        String roleAdmin = new AuthorizationPege(getDriver())
                .inputMail("batrayilto@gufum.com")
                .inputPassword(PASSWORD)
                .btnSubmit()
                .btnProfile()
                .selectProfile()
                .roleProfile();

        Assert.assertEquals(roleAdmin,"Администратор проекта");
    }

    @Test(priority = 3,
            description = "Авторизация под ролью Инспектор")
    public void inspectorAuthorizationTest () {
        driver.get(URL);

        String roleAdmin = new AuthorizationPege(getDriver())
                .inputMail("cil2e@mailtub.com")
                .inputPassword(PASSWORD)
                .btnSubmit()
                .btnProfile()
                .selectProfile()
                .roleProfile();

        Assert.assertEquals(roleAdmin,"Инспектор");
    }

    @Test(priority = 4,
            description = "Авторизация под ролью Подрядчик")
    public void subcontractorAuthorizationTest () {
        driver.get(URL);

        String roleAdmin = new AuthorizationPege(getDriver())
                .inputMail("d8q2s@fthcapital.com")
                .inputPassword(PASSWORD)
                .btnSubmit()
                .btnProfile()
                .selectProfile()
                .roleProfile();

        Assert.assertEquals(roleAdmin,"Подрядчик");
    }

    @Test(priority = 5,
            description = "Авторизация под ролью Наблюдатель")
    public void observerAuthorizationTest () {
        driver.get(URL);

        String roleAdmin = new AuthorizationPege(getDriver())
                .inputMail("cecily16432@lu1f.cse445.com")
                .inputPassword(PASSWORD)
                .btnSubmit()
                .btnProfile()
                .selectProfile()
                .roleProfile();

        Assert.assertEquals(roleAdmin,"Наблюдатель");
    }


    @Test(priority = 6,
            description = "получить письмо для восстановления доступа")
    public void restorePasswordTest () {
        driver.get(URL);

        String getEmail = new AuthorizationPege(getDriver())
                .inputMail(EMAIL)
                .inputPassword("PASSWORD")
                .forgotYourPassword()
                .inputMailRestore(EMAIL)
                .btnContinue()
                .getEmailPas();

        Assert.assertEquals(getEmail,"Мы отправили по адресу f.ff.1980@list.ru ссылку для восстановления доступа");
    }

    @Test(priority = 7,
            description = "Ввод некорректной почты при регистрации")
    public void regNegaTest() {
        driver.get(URL);

        String getError = new AuthorizationPege(getDriver())
                .inputMail(NEGA_EMAIL)
                .inputPassword(PASSWORD)
                .btnSubmit()
                .getError();

        Assert.assertEquals(getError,"Неправильный логин или пароль");
    }

    @DataProvider(name = "restoreEmail")
    public Object[][] restoreEmail() {
        return new Object[][]{
                {"batrayilto@gufum.com"}, {"cil2e@mailtub.com"}, {"d8q2s@fthcapital.com"},
                {"cecily16432@lu1f.cse445.com"}
        };
    }
    @Test(priority = 8,
            description = "получить письмо для восстановления доступа", dataProvider = "restoreEmail")
    public void testRandomRega(String name) {
        driver.get(URL);
        getDriver().findElement(By.xpath("//h2[@class='ant-typography h2_m Login__restore-text']")).click();

        getDriver().findElement(By.xpath(INPUT_EMAIL)).sendKeys(name);
        getDriver().findElement(By.xpath(BTN_PASSWORD)).click();

        Assert.assertEquals(getDriver().findElement(GET_PASSWORD).getText(),"Мы отправили по адресу " + name + " ссылку для восстановления доступа");
    }
    @DataProvider(name = "randomEmail")
    public Object[][] randomEmail() {
        return new Object[][]{
                {"rrrrrrrrrrrrrr@mail.yy"}, {"NNNNNNNNNN@mail.xx"}, {"22222222222@mail.xx"},
                {"ыыыыыыыыыыы@mail.xx"}, {"lllllllllly@mail.xx"},
               {"!@#$%^&*()_+@mail.xx"}
        };
    }

    @Test(priority = 9,
            description = "Ввод не подтвержденной почты при авторизации", dataProvider = "randomEmail")
    public void testRandomEmai(String name) {
        driver.get(URL);

//        new HomePage(driver)
//                .inputMail(EMAIL);

        driver.findElement(By.xpath(INPUT_EMAIL)).click();
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(name);

        driver.findElement(By.xpath(BTN_PASSWORD)).click();

        Assert.assertEquals(driver.findElement(GET_EMAIL_TEXT).getText(),"Пользователь не найден, попробуйте снова");
    }

    @Test(priority = 10,
            description = "получить письмо для восстановления доступа c Неправильным логином или паролем", dataProvider = "randomEmail")
    public void regEmailNegaTest(String name) {
        driver.get(URL);

        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(name);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();

        String getError = driver.findElement(GET_ERROR_TEXT).getText();

        Assert.assertEquals(getError,"Неправильный логин или пароль");

    }

    @Test(priority = 11,
            description = "авторизация без пароля")
    public void removePasswordTest() {
        driver.get(URL);

        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();

        String getError = driver.findElement(GET_ERROR_TEXT).getText();

        Assert.assertEquals(getError,"Неправильный логин или пароль");
    }


//    добавить куки почты и вводить полученное письмо для замены пароля

//    @Test
//    public void cookieTest() {
//        Cookie getCookie = new Cookie("_ga", "GA1.2");
//        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(NEGA_EMAIL);
//        driver.findElement(By.xpath(BTN_PASSWORD)).click();

//        String getError = driver.findElement(getErrorText).getText();
//
//        Assert.assertEquals(getError,"Неправильный логин или пароль");
        //      ======  добавить проверку ===
//    }


//    @Test(priority = 1,
//            description = "получить письмо для восстановления доступа")
//    public void regaTest() {
//        driver.get(URL);
//
//        driver.findElement(By.xpath("//h2[@class='ant-typography h2_m Login__restore-text']")).click();
//
//        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
//        driver.findElement(By.xpath(BTN_PASSWORD)).click();

//        String getPasError = driver.findElement(getPaswordText).getText();
//
//        Assert.assertEquals(getPasError,"Мы отправили по адресу n-k-65@list.ru ссылку для восстановления доступа");
//    }

    //      ======  добавить Test ===============================



//    ===================== смена языка ============================
//    @Test
//    public void localizTest() {
//        driver.findElement(By.xpath("//h2[@class='ant-typography h2_sb']")).click();
//        driver.findElement(By.xpath("//div[@class='ant-typography p_r Profile__item'][contains(.,'Профиль')]")).click();
//        driver.findElement(By.xpath("//input[@id='editedUser_lang']")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//    }


    //=============================== регистрация нового пользователя ====================================


//  не работает тест рамдомные email и создавать/удалять пользователей  регистрация


//    @Test
//    public void randomAutorisationTest () throws InterruptedException {
//
//        driver.findElement(By.xpath("//h2[@class='ant-typography h2_m Login__restore-text']")).click();
//
//        driver.switchTo().newWindow(WindowType.TAB).get("https://tmailor.com/ru");
//
//
//        WebElement userRolesc = driver.findElement(By.xpath("//input[@class='form-control shadow-none']"));
//
//        userRolesc.sendKeys(Keys.LEFT_CONTROL + "c");
////        driver.findElement(By.xpath("//button[@class='btn btn-light shadow-sm btn-email border rounded-5 m-2'][contains(.,' Копировать')]")).click();
////        WebDriver driver = new ChromeDriver();
////        Thread.sleep(2000);
////        driver.get(URL);
////        driver.findElement(By.xpath("////*[@id="ajax-html"]/div[1]/div/div/div[1]/div[1]/div[3]/button[1]")).click();
////
//
//        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(newTab.get(0));
//
//        driver.findElement(By.xpath("//input[@id='RestorePassword_email']")).sendKeys(Keys.LEFT_CONTROL + "v");
////        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
//
//        // .sendKeys(EMAIL);
//        driver.findElement(By.xpath(BTN_PASSWORD)).click();
//
//
//    }

//    @Parameters({ "user_role", "isActive" })
//    @Test
//    public void testUserRole(@Optional("Admin") @NotNull String role, @Optional("true") Boolean isActive) {
//        Assert.assertTrue(role.equals("Admin") && isActive);
//    }
}
