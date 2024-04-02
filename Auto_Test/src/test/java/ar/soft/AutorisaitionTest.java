package ar.soft;

import ar.soft.modelPage.HomePage;
import ar.soft.modelPage.ProgectPage;
import ar.soft.runner.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;

public class AutorisaitionTest extends BaseTest {

    WebDriver driver = new ChromeDriver();

    private final By getErrorText = By.xpath("//div[@style='text-align: center; margin-bottom: 20px; color: rgb(255, 0, 0);']");
    private final By getEmailText = By.xpath("//div[@class='ant-typography p_r RestorePassword__form-userNotFound']");

    private final By getPaswordText = By.xpath("//h2[@class='ant-typography h2_m RestorePassword__sendSuccess-text'][contains(.,'Мы отправили по адресу')]");
    public static final String NEGA_EMAIL = "yyyyyyyyyyyyyy@mail.ru";

//=============================== регистрация нового пользователя ====================================

//  рамдомные почтовые ящ и создавать/удалять пользователей?  регистрация


    @Test
    public void restorePasswordTest () {

        new ProgectPage(driver)
                .url();

//        driver.findElement(By.xpath("//h2[@class='ant-typography h2_m Login__restore-text']")).click();
        new HomePage(driver).clickRega();

        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys("EMAIL1");
        driver.findElement(By.xpath(BTN_PASSWORD)).click();

        String getPasError = driver.findElement(getPaswordText).getText();

        Assert.assertEquals(getPasError,"Мы отправили по адресу f.ff.1980@list.ru ссылку для восстановления доступа");
        driver.quit();
    }

    @Test
    public void regNegaTest() {

        new ProgectPage(driver)
                .url();

        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(NEGA_EMAIL);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();

        String getError = driver.findElement(getErrorText).getText();

        Assert.assertEquals(getError,"Неправильный логин или пароль");
//        driver.quit();
    }

    @DataProvider(name = "randomEmail")
    public Object[][] randomEmail() {
        return new Object[][]{
                {"rrrrrrrrrrrrrr@mail.yy"}, {"NNNNNNNNNN@mail.xx"}, {"22222222222@mail.xx"},
                {"ыыыыыыыыыыы@mail.xx"}, {"lllllllllly@mail.xx"}, {"!@#$%^&*()_+@mail.xx"}
        };
    }

//    @Test(dataProvider = "randomEmail")
//    public void testRandomEmail(String name) {
//        new ProgectPage(driver)
//                .url();
//        driver.findElement(By.xpath("//h2[@class='ant-typography h2_m Login__restore-text']")).click();
//
//        driver.findElement(By.xpath(INPUT_EMAIL)).click();
//        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(name);
//
//        driver.findElement(By.xpath(BTN_PASSWORD)).click();
//
//        Assert.assertEquals(driver.findElement(getEmailText).getText(),"Пользователь не найден, попробуйте снова");
//    }
//
//    @Test(dataProvider = "randomEmail")
//    public void regEmailNegaTest(String name) {
//
//        new ProgectPage(driver)
//                .url();
//
//        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(name);
//        driver.findElement(By.xpath(BTN_PASSWORD)).click();
//
//        String getError = driver.findElement(getErrorText).getText();
//
//        Assert.assertEquals(getError,"Неправильный логин или пароль");
////        driver.quit();
//    }
    @Test
    public void removePasswordTest() {

        new ProgectPage(driver)
                .url();

        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();

        String getError = driver.findElement(getErrorText).getText();

        Assert.assertEquals(getError,"Неправильный логин или пароль");
        driver.quit();
    }


//    добавить куки почты и вводить полученное письмо для замены пароля
   @Ignore
    @Test
    public void regCoogiTest() {

        new ProgectPage(driver)
                .url();

        Cookie getCookie = new Cookie("_ga", "GA1.2");
//        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(NEGA_EMAIL);
//        driver.findElement(By.xpath(BTN_PASSWORD)).click();

//        String getError = driver.findElement(getErrorText).getText();
//
//        Assert.assertEquals(getError,"Неправильный логин или пароль");
//        driver.quit();
    }

    //      ======  добавить проверку ===



}
