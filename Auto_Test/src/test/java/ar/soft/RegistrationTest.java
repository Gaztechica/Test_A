package ar.soft;

import ar.soft.modelPage.AuthorizationPege;
import ar.soft.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @Test(priority = 18,
            description = "проверить отображение - Попробуйте бесплатно в течение 14 дней")
    public void trialTextTest() {
        driver.get(URL_REGISTRATION);

        String trialText = new AuthorizationPege(getDriver())
                .trialText();

        Assert.assertEquals(trialText, "Попробуйте бесплатно в течение 14 дней");
    }

    @Test(priority = 24,
            description = "Ввод некорректной почты при регистрации")
    public void ппbadEmailTest() {
        driver.get(URL_REGISTRATION);

        String badEmailError = new AuthorizationPege(getDriver())
                .inputMail("armtset.qwe")
                .inputPassword(PASSWORD)
                .btnCheckbox()
                .btnContinue()
                .getEmailError();
        String getRestoreEmailError = new AuthorizationPege(getDriver())
                .getRestoreEmailError();

//        Assert.assertEquals(inputMailError,  "border-color: rgb(255, 0, 0);")
        Assert.assertEquals(getRestoreEmailError, "Пользователь с таким e-mail уже существует");
    }

    @Test(priority = 23,
            description = "Регистрация пользователя существующего в системе")
    public void ррbadEmailTest() {
        driver.get(URL_REGISTRATION);

        String badEmailError = new AuthorizationPege(getDriver())
                .inputMail(EMAIL)
                .inputPassword(PASSWORD)

                .btnCheckbox()
                .btnContinue()
                .getEmailError();
        String getRestoreEmailError = new AuthorizationPege(getDriver())
                .getRestoreEmailError();

        Assert.assertEquals(getRestoreEmailError, "Пользователь с таким e-mail уже существует");
    }

    @Test(priority = 9,
            description = "при регистрации вам отправлено письмо")
    public void restorePasswordTest() {
        driver.get(URL_REGISTRATION);

        String getEmail = new AuthorizationPege(getDriver())
                .inputMail(EMAIL)
                .inputPassword("PASSWORD")
                .forgotYourPassword()
                .inputMailRestore(EMAIL)
                .btnCheckbox()
                .btnContinue()
                .getEmailPas();

//        Assert.assertEquals(getEmail, "Мы отправили по адресу f.ff.1980@list.ru ссылку для восстановления доступа");
        Assert.assertEquals(getEmail, "Мы отправили по адресу " + EMAIL + " ссылку для восстановления доступа");
    }

    @Test(priority = 14,
            description = "повторно отправить письмо при регистрации")
    public void againRestorePasswordTest() throws InterruptedException {
        driver.get(URL);

        String getEmail = new AuthorizationPege(getDriver())
                .inputMail(EMAIL)
                .inputPassword("PASSWORD")
                .forgotYourPassword()
                .inputMailRestore(EMAIL)
                .btnCheckbox()
                .btnContinue()
                .getEmailPas();

//        Assert.assertEquals(getEmail, "Мы отправили по адресу f.ff.1980@list.ru ссылку для восстановления доступа");            //test
        Assert.assertEquals(getEmail, "Мы отправили по адресу " + EMAIL + " ссылку для восстановления доступа");
        Thread.sleep(61000);
        String againGetEmail = new AuthorizationPege(getDriver())
                .againRestorePassword()
                .againGetEmailPas();

        Assert.assertEquals(againGetEmail, "Мы отправили по адресу " + EMAIL + " ссылку для восстановления доступа");
    }

    /**
     * дописать тест
     */
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

    /**
     * дописать тест
     */
    @Test(priority = 20,
            description = "Нажать ссылку “Загрузите на Google Play”")
    public void GooglePlayTest() {
        driver.get(URL_REGISTRATION);

        String trialText = new AuthorizationPege(getDriver())
                .trialText();

        Assert.assertEquals(trialText, "Попробуйте бесплатно в течение 14 дней");
    }

}
