package ar.soft;

import ar.soft.modelPage.HomePage;
import ar.soft.runner.BaseTest;
//import org.junit.Assert;
//import org.junit.Test;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class AutorisaitionTest extends BaseTest {

    private final By GET_ERROR_TEXT = By.xpath("//div[@style='text-align: center; margin-bottom: 20px; color: rgb(255, 0, 0);']");
    private final By GET_EMAIL_TEXT = By.xpath("//div[@class='ant-typography p_r RestorePassword__form-userNotFound']");
    private final By GET_PASSWORD = By.xpath("//h2[@class='ant-typography h2_m SendSuccessBlock__text'][contains(.,'Мы отправили по адресу')]");
    public static final String NEGA_EMAIL = "yyyyyyyyyyyyyy@mail.ru";

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

    @Parameters({ "user_role", "isActive" })
    @Test
    public void testUserRole(@Optional("Admin") @NotNull String role, @Optional("true") Boolean isActive) {
        Assert.assertTrue(role.equals("Admin") && isActive);
    }

    @Test
    public void restorePasswordTest () {
        driver.get(URL);

//        driver.findElement(By.xpath("//h2[@class='ant-typography h2_m Login__restore-text']")).click();
        new HomePage(driver)
                .clickRega();

        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();

        String getEmailPas = driver.findElement(GET_PASSWORD).getText();

        Assert.assertEquals(getEmailPas,"Мы отправили по адресу f.ff.1980@list.ru ссылку для восстановления доступа");
    }

    @Test
    public void regNegaTest() {
        driver.get(URL);
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(NEGA_EMAIL);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();

        String getError = driver.findElement(GET_ERROR_TEXT).getText();

        Assert.assertEquals(getError,"Неправильный логин или пароль");
    }

    @DataProvider(name = "randomEmail")
    public Object[][] randomEmail() {
        return new Object[][]{
                {"rrrrrrrrrrrrrr@mail.yy"}, {"NNNNNNNNNN@mail.xx"}, {"22222222222@mail.xx"},
                {"ыыыыыыыыыыы@mail.xx"}, {"lllllllllly@mail.xx"},
//                {"!@#$%^&*()_+@mail.xx"}
        };
    }

    @Test(dataProvider = "randomEmail")
    public void testRandomEmai(String name) {
        driver.get(URL);

        new HomePage(driver).clickRega();

        driver.findElement(By.xpath(INPUT_EMAIL)).click();
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(name);

        driver.findElement(By.xpath(BTN_PASSWORD)).click();

        Assert.assertEquals(driver.findElement(GET_EMAIL_TEXT).getText(),"Пользователь не найден, попробуйте снова");
    }

    @Test(dataProvider = "randomEmail")
    public void regEmailNegaTest(String name) {
        driver.get(URL);

        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(name);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();

        String getError = driver.findElement(GET_ERROR_TEXT).getText();

        Assert.assertEquals(getError,"Неправильный логин или пароль");

    }

    @Test
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


    @Test
    public void regaTest() {
        driver.get(URL);

        driver.findElement(By.xpath("//h2[@class='ant-typography h2_m Login__restore-text']")).click();

        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();

//        String getPasError = driver.findElement(getPaswordText).getText();
//
//        Assert.assertEquals(getPasError,"Мы отправили по адресу n-k-65@list.ru ссылку для восстановления доступа");
    }

    //      ======  добавить Test ===============================

    @Test(dataProvider = "randomEmail")
    public void testRandomRega(String name) {
        driver.get(URL);
        getDriver().findElement(By.xpath("//h2[@class='ant-typography h2_m Login__restore-text']")).click();

        getDriver().findElement(By.xpath(INPUT_EMAIL)).sendKeys(name);
        getDriver().findElement(By.xpath(BTN_PASSWORD)).click();

//        Assert.assertEquals(getDriver().findElement(GET_PASSWORD).getText(),"Мы отправили по адресу /" + name + "/ ссылку для восстановления доступа");
    }

//    ===================== смена языка ============================
//    @Test
//    public void localizTest() {
//        driver.findElement(By.xpath("//h2[@class='ant-typography h2_sb']")).click();
//        driver.findElement(By.xpath("//div[@class='ant-typography p_r Profile__item'][contains(.,'Профиль')]")).click();
//        driver.findElement(By.xpath("//input[@id='editedUser_lang']")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//    }
}
