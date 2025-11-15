package ar.soft;

import ar.soft.modelPage.AuthorizationPege;
import ar.soft.runner.BaseTest;
//import org.junit.Assert;
//import org.junit.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.qa.methods.AssertionT;

import java.util.ArrayList;

public class AuthorizationTest extends BaseTest {

    private final By GET_ERROR_TEXT = By.xpath("//div[@style='text-align: center; margin-bottom: 20px; color: rgb(255, 0, 0);']");
    private final By GET_EMAIL_TEXT = By.xpath("//div[@class='ant-typography p_r RestorePassword__form-userNotFound']");
    private final By GET_PASSWORD = By.xpath("//h2[@class='ant-typography h2_m SendSuccessBlock__text'][contains(.,'Мы отправили по адресу')]");
    public static final String NEGA_EMAIL = "yyyyyyyyyyyyyy@mail.ru";

    @Story("Проверка заполнения ключа при выборе значения EnumFormat из выпадающего списка")
    @Description("Проверка заполнения ключа при выборе значения EnumFormat из выпадающего списка")
    @Test(priority = 1, groups = {"10.5", "Dialogs"},
            description = "Авторизация под ролью владельца")
    public void ownerAuthorizationTest() {
        driver.get(URL);

        String role = new AuthorizationPege(getDriver())
                .inputMail(EMAIL)
                .inputPassword(PASSWORD)
                .btnCheckbox()
                .btnSubmit()
                .btnProfile()
                .selectProfile()
                .roleProfile();

        Assert.assertEquals(role, OWNER);
    }

//    @Story("Проверка заполнения ключа при выборе значения EnumFormat из выпадающего списка")
//    @Description("Проверка заполнения ключа при выборе значения EnumFormat из выпадающего списка")
//    @Test(priority = 1, groups = {"10.5", "Dialogs"},
//            description = "Авторизация под ролью владельца")
//    public void ownerAuthorization2Test() {
//        driver.get(URL);
//
//        String role = new AuthorizationPege(getDriver())
//                .inputMail("jartestaw@bk.ru")
//                .inputPassword(PASSWORD)
//                .btnCheckbox()
//                .btnSubmit()
//                .btnProfile()
//                .selectProfile()
//                .roleProfile();
//
//        Assert.assertEquals(role, "Владелец");
//    }

    @Test(priority = 2, groups = "Dialogs",
            description = "Авторизация под ролью admin")
    public void adminAuthorizationTest() {
        driver.get(URL);

        String roleAdmin = new AuthorizationPege(getDriver())
                .inputMail(ADMIN_EMAIL)
                .inputPassword(PASSWORD)
                .btnCheckbox()
                .btnSubmit()
                .btnProfile()
                .selectProfile()
                .roleProfile();

        Assert.assertEquals(roleAdmin, ADMIN);
    }

    @Test(priority = 3, groups = "Dialogs",
            description = "Авторизация под ролью Инспектор")
    public void inspectorAuthorizationTest() {
        driver.get(URL);

        String roleAdmin = new AuthorizationPege(getDriver())
                .inputMail(INSPECTOR_EMAIL)
                .inputPassword(PASSWORD)
                .btnCheckbox()
                .btnSubmit()
                .btnProfile()
                .selectProfile()
                .roleProfile();

        Assert.assertEquals(roleAdmin, INSPECTOR);
    }

    @Test(priority = 4, groups = {"10.5", "Dialogs"},
            description = "Авторизация под ролью Подрядчик")
    public void subcontractorAuthorizationTest() {
        driver.get(URL);

        String roleAdmin = new AuthorizationPege(getDriver())
                .inputMail(SUBCONTRACTOR_EMAIL)
                .inputPassword(PASSWORD)
                .btnCheckbox()
                .btnSubmit()
                .btnProfile()
                .selectProfile()
                .roleProfile();

        Assert.assertEquals(roleAdmin, SUBCONTRACTOR);
    }

    @Test(priority = 5, groups = {"10.5", "Dialogs"},
            description = "Авторизация под ролью Наблюдатель")
    public void observerAuthorizationTest() {
        driver.get(URL);

        String roleAdmin = new AuthorizationPege(getDriver())
                .inputMail(OBSERVER_EMAIL)
                .inputPassword(PASSWORD)
                .btnCheckbox()
                .btnSubmit()
                .btnProfile()
                .selectProfile()
                .roleProfile();

        Assert.assertEquals(roleAdmin, OBSERVER);
    }

    @Test(priority = 6, groups = {"10.5", "Dialogs"},
            description = "Авторизация под ролью Супервизор")
    public void visorAuthorizationTest() {
        driver.get(URL);

        String roleAdmin = new AuthorizationPege(getDriver())
                .inputMail(VISOR_EMAIL)
                .inputPassword(PASSWORD)
                .btnCheckbox()
                .btnSubmit()
                .btnProfile()
                .selectProfile()
                .roleProfile();

        Assert.assertEquals(roleAdmin, WISOR);
    }

//    @Test(priority = 9,
//            description = "получить письмо для восстановления доступа")
//    public void restorePasswordTest() {
//        driver.get(URL);
//
//        String getEmail = new AuthorizationPege(getDriver())
//                .inputMail(EMAIL)
//                .inputPassword("PASSWORD")
//                .forgotYourPassword()
//                .inputMailRestore(EMAIL)
//                .btnCheckbox()
//                .btnContinues()
//                .getEmailPas();
//
////        Assert.assertEquals(getEmail, "Мы отправили по адресу f.ff.1980@list.ru ссылку для восстановления доступа");
//        Assert.assertEquals(getEmail, "Мы отправили по адресу " + EMAIL + " ссылку для восстановления доступа");
//    }
//
//    @Test(priority = 7,
//            description = "Ввод некорректной почты при регистрации")
//    public void regNegaTest() {
//        driver.get(URL);
//
//        String getError = new AuthorizationPege(getDriver())
//                .inputMail(NEGA_EMAIL)
//                .inputPassword(PASSWORD)
//                .btnCheckbox()
//                .btnSubmit()
//                .getError();
//
//        Assert.assertEquals(getError, "Неправильный логин или пароль");
//    }
//
//
//
//    @Test(priority = 11,
//            description = "авторизация без пароля")
//    public void removePasswordTest() {
//        driver.get(URL);
//
//        String getError = new AuthorizationPege(getDriver())
//                .inputMail(EMAIL)
//                .inputPassword(NOT_PASSWORD)
//                .btnCheckbox()
//                .btnSubmit()
//                .getError();
//
//        Assert.assertEquals(getError, "Неправильный логин или пароль");
//    }
//
//
//// Авторизация с неверным паролем
//
//
//    @Test(priority = 12,
//            description = "Авторизоваться под ролью администратора, который не добавлен в проект")
//    public void notProjectsAdminTest() {
//        driver.get(URL);
//
//        String notProjectsError = new AuthorizationPege(getDriver())
//                .inputMail("yirtemedru@gufum.com")
////                .inputMail("degnusamlo@gufum.com")              //stage
//                .inputPassword(PASSWORD)
//                .btnCheckbox()
//                .btnSubmit()
//                .notProjectsError();
//
//        Assert.assertEquals(notProjectsError, "Отсутствуют доступные проекты, обратитесь к Администратору проекта");
//    }
//
//    @Test(priority = 13,
//            description = "Авторизация с незаполненным полем почты" +
//                    "Поле “Электронная почта” подсвечено красной обводкой")
//    public void notEmailTest() {
//        driver.get(URL);
//
//        String notEmailError = new AuthorizationPege(getDriver())
//                .inputMail(NOT_EMAIL)
//                .inputPassword(PASSWORD)
//                .btnCheckbox()
//                .btnSubmit()
//                .getEmailError2();
//
////        AssertionT.Element.elementDisplayed(getEmailError.newUsersCheck);
////        Assert.assertEquals(notEmailError, "border-color: rgb(255, 0, 0);");
//        Assert.assertEquals("border-color: rgb(255, 0, 0);", "border-color: rgb(255, 0, 0);");
//    }
//
//    @Test(priority = 22,
//            description = "Авторизация с незаполненным полем Password " +
//                    "Поле “Password” подсвечено красной обводкой")
//    public void notPasswordTest() {
//        driver.get(URL);
//
//        String notPasswordError = new AuthorizationPege(getDriver())
//                .inputMail(EMAIL)
//                .inputPassword("")
//                .btnCheckbox()
//                .btnSubmit()
//                .getPasswordError();
//
//        Assert.assertEquals("border-color: rgb(255, 0, 0);", "border-color: rgb(255, 0, 0);");
//    }
//
//    @Test(priority = 14,
//            description = "повторно получить письмо для восстановления доступа")
//    public void againRestorePasswordTest() throws InterruptedException {
//        driver.get(URL);
//
//        String getEmail = new AuthorizationPege(getDriver())
//                .inputMail(EMAIL)
//                .inputPassword("PASSWORD")
//                .forgotYourPassword()
//                .inputMailRestore(EMAIL)
//                .btnCheckbox()
//                .btnContinues()
//                .getEmailPas();
//
////        Assert.assertEquals(getEmail, "Мы отправили по адресу f.ff.1980@list.ru ссылку для восстановления доступа");            //test
//        Assert.assertEquals(getEmail, "Мы отправили по адресу " + EMAIL + " ссылку для восстановления доступа");
//        Thread.sleep(61000);
//        String againGetEmail = new AuthorizationPege(getDriver())
//                .againRestorePassword()
//                .againGetEmailPas();
//
//        Assert.assertEquals(againGetEmail, "Мы отправили по адресу " + EMAIL + " ссылку для восстановления доступа");
//    }
//
//    @Test(priority = 15,
//            description = "Авторизация с незарегистрированной в приложении почтой")
//    public void notRegisteredEmailTest() {
//        driver.get(URL);
//
//        String getError = new AuthorizationPege(getDriver())
//                .inputMail("asfasfasww@yarkv.qm")
//                .inputPassword("qwerty123")
//                .btnCheckbox()
//                .btnSubmit()
//                .getError();
//
//        Assert.assertEquals(getError, "Неправильный логин или пароль");
//    }
//
//    @Test(priority = 16,
//            description = "Ввод некорректного значения email при восстановлении пароля")
//    public void badEmailTest() {
//        driver.get(URL);
//
//        String badEmailError = new AuthorizationPege(getDriver())
//                .inputMail(NEGA_EMAIL)
//                .inputPassword("PASSWORD")
//                .forgotYourPassword()
//                .inputMailRestore(NEGA_EMAIL)
//                .btnCheckbox()
//                .btnContinues()
//                .getEmailError();
//        String getRestoreEmailError = new AuthorizationPege(getDriver())
//                .getRestoreEmailError();
//
//        Assert.assertEquals(badEmailError, "border-color: rgb(255, 0, 0);");
//        Assert.assertEquals(getRestoreEmailError, "Пользователь не найден, попробуйте снова");
//    }
//
//    @Test(priority = 17,
//            description = "иконка ARMobile")
//    public void iconARMobileTest() {
//        driver.get(URL_REGISTRATION);
//
//        String iconRegistration = new AuthorizationPege(getDriver())
//                .iconRegistrationClick()
//                .getRegistrationText();
//
//        Assert.assertEquals(iconRegistration, "Войдите в аккаунт");
//    }
//
//    @Test(priority = 18,
//            description = "Ввод некорректного значения email при восстановлении пароля")
//    public void trialTextTest() {
//        driver.get(URL_REGISTRATION);
//
//        String trialText = new AuthorizationPege(getDriver())
//                .trialText();
//
//        Assert.assertEquals(trialText, "Попробуйте бесплатно в течение 14 дней");
//    }
//
//
//
//
//    /**
//     * проверить тест
//     */
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

//    @Test(priority = 21,
//            description = "Значение “Пароль” отображается в поле ввода в скрытом виде")
//    public void passwordTest() {
//        driver.get(URL);
//
//        String Password = new AuthorizationPege(getDriver())
//                .inputMail(EMAIL)
//                .inputPassword(PASSWORD)
//                .passwordError();
////         в поле “Пароль” Значение отображается в поле ввода в скрытом виде
//        Assert.assertEquals(Password, "");
//    }
//
//    /**
//     * дописать тест
//     */
//
//
//    /**
//     * дописать тест
//     */
//
//
//    @DataProvider(name = "restoreEmail")
//    public Object[][] restoreEmail() {
//        return new Object[][]{
////                {"batrayilto@gufum.com"}, {"cil2e@mailtub.com"},                        //test
////                {"d8q2s@fthcapital.com"}, {"cecily16432@lu1f.cse445.com"},               //test
//                {"jartestaw@bk.ru"}, {"armtset18@bk.ru"},                                //stage
//                {"testlinka@rambler.ru"}, {"dzyuban@spgr.ru"}                            //stage
//        };
//    }
//
//    @Ignore
//    @Test(priority = 8,
//            description = "получить письмо для восстановления доступа", dataProvider = "restoreEmail")
//    public void testRandomRega(String name) {
//        driver.get(URL);
//        getDriver().findElement(By.xpath("//h2[@class='ant-typography h2_m Login__restore-text']")).click();
//
//        getDriver().findElement(By.xpath(INPUT_EMAIL)).sendKeys(name);
//        getDriver().findElement(By.xpath(BTN_PASSWORD)).click();
//
//        Assert.assertEquals(getDriver().findElement(GET_PASSWORD).getText(), "Мы отправили по адресу " + name + " ссылку для восстановления доступа");
//    }
//
//    @DataProvider(name = "randomEmail")
//    public Object[][] randomEmail() {
//        return new Object[][]{
//                {"rrrrrrrrrrrrrr@mail.yy"}, {"NNNNNNNNNN@mail.xx"}, {"22222222222@mail.xx"},
//                {"ыыыWEFCGhjjjlk@mail.xx"}, {"lllllllllly@mail.xx"},
//                {"!@#$%^&*()_+@mail.xx"}
//        };
//    }
//
//    @Ignore
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
//        Assert.assertEquals(driver.findElement(GET_EMAIL_TEXT).getText(), "Неправильный логин или пароль");
//    }


//    добавить куки почты и вводить полученное письмо для замены пароля
//
//    @Test
//    public void cookieTest() {
//        Cookie getCookie = new Cookie("_ga", "GA1.2");
//        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(NEGA_EMAIL);
//        driver.findElement(By.xpath(BTN_PASSWORD)).click();
//
//        String getError = driver.findElement(getErrorText).getText();
//
//        Assert.assertEquals(getError,"Неправильный логин или пароль");
//          ======  добавить проверку ===
//    }
//
//
//    @Test(priority = 1,
//            description = "получить письмо для восстановления доступа")
//    public void regaTest() {
//        driver.get(URL);
//
//        driver.findElement(By.xpath("//h2[@class='ant-typography h2_m Login__restore-text']")).click();
//
//        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
//        driver.findElement(By.xpath(BTN_PASSWORD)).click();
//
//        String getPasError = driver.findElement(getPaswordText).getText();
//
//        Assert.assertEquals(getPasError,"Мы отправили по адресу n-k-65@list.ru ссылку для восстановления доступа");
//    }

//          ======  добавить Test ===============================


//    ===================== смена языка ============================
//    @Test
//    public void localizTest() {
//        driver.findElement(By.xpath("//h2[@class='ant-typography h2_sb']")).click();
//        driver.findElement(By.xpath("//div[@class='ant-typography p_r Profile__item'][contains(.,'Профиль')]")).click();
//        driver.findElement(By.xpath("//input[@id='editedUser_lang']")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//    }


//    =============================== регистрация нового пользователя ====================================


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
//        driver.findElement(By.xpath("//button[@class='btn btn-light shadow-sm btn-email border rounded-5 m-2'][contains(.,' Копировать')]")).click();
//        WebDriver driver = new ChromeDriver();
//        Thread.sleep(2000);
//        driver.get(URL);
//        driver.findElement(By.xpath("////*[@id="ajax-html"]/div[1]/div/div/div[1]/div[1]/div[3]/button[1]")).click();
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
