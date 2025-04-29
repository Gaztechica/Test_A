package ar.soft;

import ar.soft.modelPage.AuthorizationPege;
import ar.soft.modelPage.HomePage;
import ar.soft.modelPage.base.BasePage;
import ar.soft.runner.BaseTest;
//import org.junit.Assert;
//import org.junit.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class AuthorizationTest extends BaseTest {

    private final By GET_ERROR_TEXT = By.xpath("//div[@style='text-align: center; margin-bottom: 20px; color: rgb(255, 0, 0);']");
    private final By GET_EMAIL_TEXT = By.xpath("//div[@class='ant-typography p_r RestorePassword__form-userNotFound']");
    private final By GET_PASSWORD = By.xpath("//h2[@class='ant-typography h2_m SendSuccessBlock__text'][contains(.,'Мы отправили по адресу')]");
    public static final String NEGA_EMAIL = "yyyyyyyyyyyyyy@mail.ru";

    @Story("Проверка заполнения ключа при выборе значения EnumFormat из выпадающего списка")
    @Description("Проверка заполнения ключа при выборе значения EnumFormat из выпадающего списка")
    @Test(priority = 1,
            description = "Авторизация под ролью владельца")
    public void ownerAuthorizationTest() {
        driver.get(URL);

        String role = new AuthorizationPege(getDriver())
                .inputMail(EMAIL)
                .inputPassword(PASSWORD)
                .btnSubmit()
                .btnProfile()
                .selectProfile()
                .roleProfile();

        Assert.assertEquals(role, "Владелец");
    }

    @Test(priority = 2,
            description = "Авторизация под ролью admin")
    public void adminAuthorizationTest() {
        driver.get(URL);

        String roleAdmin = new AuthorizationPege(getDriver())
                .inputMail("batrayilto@gufum.com")     //test
//                .inputMail("armtset18@bk.ru")
                .inputPassword(PASSWORD)
                .btnSubmit()
                .btnProfile()
                .selectProfile()
                .roleProfile();

        Assert.assertEquals(roleAdmin, "Администратор проекта");
    }

    @Test(priority = 3,
            description = "Авторизация под ролью Инспектор")
    public void inspectorAuthorizationTest() {
        driver.get(URL);

        String roleAdmin = new AuthorizationPege(getDriver())
                .inputMail("cil2e@mailtub.com")     //test
//                .inputMail("testlinka@rambler.ru")
//                .inputMail("e4lya@belgianairways.com")
                .inputPassword(PASSWORD)
                .btnSubmit()
                .btnProfile()
                .selectProfile()
                .roleProfile();

        Assert.assertEquals(roleAdmin, "Инспектор");
    }

    @Test(priority = 4,
            description = "Авторизация под ролью Подрядчик")
    public void subcontractorAuthorizationTest() {
        driver.get(URL);

        String roleAdmin = new AuthorizationPege(getDriver())
                .inputMail("d8q2s@fthcapital.com")          //test
//                .inputMail("murkegotri@gufum.com")
//                .inputMail("armtset9@bk.ru")
//                .inputMail("hrpup@rustyload.com")
                .inputPassword(PASSWORD)
                .btnSubmit()
                .btnProfile()
                .selectProfile()
                .roleProfile();

        Assert.assertEquals(roleAdmin, "Подрядчик");
    }

    @Test(priority = 5,
            description = "Авторизация под ролью Наблюдатель")
    public void observerAuthorizationTest() {
        driver.get(URL);

        String roleAdmin = new AuthorizationPege(getDriver())
                .inputMail("cecily16432@lu1f.cse445.com")               //test
//                .inputMail("armtset52@bk.ru")
                .inputPassword(PASSWORD)
                .btnSubmit()
                .btnProfile()
                .selectProfile()
                .roleProfile();

        Assert.assertEquals(roleAdmin, "Наблюдатель");
    }

    @Test(priority = 6,
            description = "Авторизация под ролью Супервизор")
    public void visorAuthorizationTest() {
        driver.get(URL);

        String roleAdmin = new AuthorizationPege(getDriver())
                .inputMail("vognofurdu@gufum.com")     //test
//                .inputMail("armtset18@bk.ru")
                .inputPassword(PASSWORD)
                .btnSubmit()
                .btnProfile()
                .selectProfile()
                .roleProfile();

        Assert.assertEquals(roleAdmin, "Супервизор");
    }
    @Test(priority = 9,
            description = "получить письмо для восстановления доступа")
    public void restorePasswordTest() {
        driver.get(URL);

        String getEmail = new AuthorizationPege(getDriver())
                .inputMail(EMAIL)
                .inputPassword("PASSWORD")
                .forgotYourPassword()
                .inputMailRestore(EMAIL)
                .btnContinue()
                .getEmailPas();

//        Assert.assertEquals(getEmail, "Мы отправили по адресу f.ff.1980@list.ru ссылку для восстановления доступа");
        Assert.assertEquals(getEmail, "Мы отправили по адресу " + EMAIL + " ссылку для восстановления доступа");
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

        Assert.assertEquals(getError, "Неправильный логин или пароль");
    }

    @DataProvider(name = "restoreEmail")
    public Object[][] restoreEmail() {
        return new Object[][]{
//                {"batrayilto@gufum.com"}, {"cil2e@mailtub.com"},                        //test
//                {"d8q2s@fthcapital.com"}, {"cecily16432@lu1f.cse445.com"},               //test
                {"jartestaw@bk.ru"}, {"armtset18@bk.ru"},                                //stage
                {"testlinka@rambler.ru"}, {"dzyuban@spgr.ru"}                            //stage
        };
    }

    @Test(priority = 8,
            description = "получить письмо для восстановления доступа", dataProvider = "restoreEmail")
    public void testRandomRega(String name) {
        driver.get(URL);
        getDriver().findElement(By.xpath("//h2[@class='ant-typography h2_m Login__restore-text']")).click();

        getDriver().findElement(By.xpath(INPUT_EMAIL)).sendKeys(name);
        getDriver().findElement(By.xpath(BTN_PASSWORD)).click();

        Assert.assertEquals(getDriver().findElement(GET_PASSWORD).getText(), "Мы отправили по адресу " + name + " ссылку для восстановления доступа");
    }

    @DataProvider(name = "randomEmail")
    public Object[][] randomEmail() {
        return new Object[][]{
                {"rrrrrrrrrrrrrr@mail.yy"}, {"NNNNNNNNNN@mail.xx"}, {"22222222222@mail.xx"},
                {"ыыыWEFCGhjjjlk@mail.xx"}, {"lllllllllly@mail.xx"},
                {"!@#$%^&*()_+@mail.xx"}
        };
    }

//    @Test(priority = 9,
//            description = "Ввод не подтвержденной почты при авторизации", dataProvider = "randomEmail")
//    public void testRandomEmai(String name) {
//        driver.get(URL);
//
////        new HomePage(driver)
////                .inputMail(EMAIL);
//
//        driver.findElement(By.xpath(INPUT_EMAIL)).click();
//        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(name);
//
//        driver.findElement(By.xpath(BTN_PASSWORD)).click();
//
//        Assert.assertEquals(driver.findElement(GET_EMAIL_TEXT).getText(),"Неправильный логин или пароль");
//    }

    @Test(priority = 10,
            description = "Неправильным логином или паролем", dataProvider = "randomEmail")
    public void regEmailNegaTest(String name) {
        driver.get(URL);

        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(name);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();

        String getError = driver.findElement(GET_ERROR_TEXT).getText();

        Assert.assertEquals(getError, "Неправильный логин или пароль");

    }

    @Test(priority = 11,
            description = "авторизация без пароля")
    public void removePasswordTest() {
        driver.get(URL);

        String getError = new AuthorizationPege(getDriver())
                .inputMail(EMAIL)
                .inputPassword(NOT_PASSWORD)
                .btnSubmit()
                .getError();

        Assert.assertEquals(getError, "Неправильный логин или пароль");
    }


// Авторизация с неверным паролем


    @Test(priority = 12,
            description = "Авторизоваться под ролью администратора, который не добавлен в проект")
    public void notProjectsAdminTest() {
        driver.get(URL);

        String notProjectsError = new AuthorizationPege(getDriver())
//                .inputMail("yirtemedru@gufum.com")
                .inputMail("degnusamlo@gufum.com")              //stage
                .inputPassword(PASSWORD)
                .btnSubmit()
                .notProjectsError();

        Assert.assertEquals(notProjectsError, "Отсутствуют доступные проекты, обратитесь к Администратору проекта");
    }

    @Test(priority = 13,
            description = "Авторизация с незаполненным полем почты")
    public void notEmailTest() {
        driver.get(URL);

        String notEmailError = new AuthorizationPege(getDriver())
                .inputMail(NOT_EMAIL)
                .inputPassword(PASSWORD)
                .btnSubmit()
                .getEmailError();

        Assert.assertEquals(notEmailError, "border-color: rgb(255, 0, 0);");
//        Поле “Электронная почта” подсвечено красной обводкой

    }

    @Test(priority = 14,
            description = "повторно получить письмо для восстановления доступа")
    public void againRestorePasswordTest() throws InterruptedException {
        driver.get(URL);

        String getEmail = new AuthorizationPege(getDriver())
                .inputMail(EMAIL)
                .inputPassword("PASSWORD")
                .forgotYourPassword()
                .inputMailRestore(EMAIL)
                .btnContinue()
                .getEmailPas();

//        Assert.assertEquals(getEmail, "Мы отправили по адресу f.ff.1980@list.ru ссылку для восстановления доступа");            //test
        Assert.assertEquals(getEmail, "Мы отправили по адресу " + EMAIL + " ссылку для восстановления доступа");          //stage
        Thread.sleep(60000);
        String againGetEmail = new AuthorizationPege(getDriver())
                .againRestorePassword()
                .againGetEmailPas();

//        Assert.assertEquals(againGetEmail, "Мы отправили по адресу f.ff.1980@list.ru ссылку для восстановления доступа");           //test
        Assert.assertEquals(againGetEmail, "Мы отправили по адресу " + EMAIL + " ссылку для восстановления доступа");             //stage
    }

    @Test(priority = 15,
            description = "Авторизация с незарегистрированной в приложении почтой")
    public void notRegisteredEmailTest() {
        driver.get(URL);

        String getError = new AuthorizationPege(getDriver())
                .inputMail("asfasfasww@yarkv.qm")
                .inputPassword("qwerty123")
                .btnSubmit()
                .getError();

        Assert.assertEquals(getError, "Неправильный логин или пароль");
    }

    @Test(priority = 16,
            description = "Ввод некорректного значения email при восстановлении пароля")
    public void badEmailTest() {
        driver.get(URL);

        String badEmailError = new AuthorizationPege(getDriver())
                .inputMail(NEGA_EMAIL)
                .inputPassword("PASSWORD")
                .forgotYourPassword()
                .inputMailRestore(NEGA_EMAIL)
                .btnContinue()
                .getEmailError();
        String getRestoreEmailError = new AuthorizationPege(getDriver())
                .getRestoreEmailError();

        Assert.assertEquals(badEmailError, "border-color: rgb(255, 0, 0);");
        Assert.assertEquals(getRestoreEmailError, "Пользователь не найден, попробуйте снова");
    }

    @Test(priority = 17,
            description = "иконка ARMobile")
    public void iconARMobileTest() {
        driver.get(URL_REGISTRATION);

        String iconRegistration = new AuthorizationPege(getDriver())
                .iconRegistrationClick()
                .getRegistrationText();

        Assert.assertEquals(iconRegistration, "Войдите в аккаунт");
    }

    @Test(priority = 18,
            description = "Ввод некорректного значения email при восстановлении пароля")
    public void trialTextTest() {
        driver.get(URL_REGISTRATION);

        String trialText = new AuthorizationPege(getDriver())
                .trialText();

        Assert.assertEquals(trialText, "Попробуйте бесплатно в течение 14 дней");
    }

//    @Test(priority = 19,
//            description = "Нажать ссылку “Загрузите в appstore”")
//    public void appstoreTest() {
//        driver.get(URL_REGISTRATION);
//
//        String trialText = new AuthorizationPege(getDriver())
//                .trialText();
//
//            driver.findElement(By.xpath("//a[@href='https://vr-arsoft.com/personal-data-processing-policy/']")).click();
//
//            ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
//            driver.switchTo().window(newTab.get(1));
//
//            Assert.assertEquals("Политика обработки персональных данных", driver.findElement(GET_POLITIC).getText());
//
//        Assert.assertEquals(trialText, "Попробуйте бесплатно в течении 7 дней");
//    }

    @Test(priority = 20,
            description = "Нажать ссылку “Загрузите на Google Play”")
    public void GooglePlayTest() {
        driver.get(URL_REGISTRATION);

        String trialText = new AuthorizationPege(getDriver())
                .trialText();

        Assert.assertEquals(trialText, "Попробуйте бесплатно в течение 14 дней");
    }


//    @Test(priority = 17,
//            description = "Авторизация с незаполненными полями логина и пароля")
//    public void notEmailPasswordTest () {
//        driver.get(URL);
//
//        String inputMailError = new AuthorizationPege(getDriver())
////        new AuthorizationPege(getDriver())
//                .inputMail(NOT_EMAIL)
//                .inputPassword(NOT_PASSWORD)
//                .btnSubmit()
//                .eMail();
//
//        Assert.assertEquals(inputMailError,  "border-color: rgb(255, 0, 0);");
//    }

    @Test(priority = 21,
            description = "Значение “Пароль” отображается в поле ввода в скрытом виде")
    public void passwordTest() {
        driver.get(URL);

        String Password = new AuthorizationPege(getDriver())
                .inputMail(EMAIL)
                .inputPassword(PASSWORD)
                .passwordError();
//         в поле “Пароль” Значение отображается в поле ввода в скрытом виде
        Assert.assertEquals(Password, "");
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


//    пауза    window.setTimeout(() =>{debugger},4000)
}
