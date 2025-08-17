package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import io.qameta.allure.Allure;
import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthorizationPege extends BasePage {

    public AuthorizationPege(WebDriver driver) {
        super(driver);
    }

    @Name("кнопка войти")
    public AuthorizationPege btnSubmit() {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();

        return this;
    }

    @Name("кнопка Checkbox")
    public AuthorizationPege btnCheckbox() {
        getDriver().findElement(By.xpath("//*[@id='CheckboxComponent-check']")).click();

        return this;
    }

    @Name("кнопка Зарегистрироваться")
    public AuthorizationPege btnContinue() {
        getDriver().findElement(By.xpath("//button[@type='submit'][contains(.,'Зарегистрироваться')]")).click();

        return this;
    }

    @Name("кнопка Продолжить")
    public AuthorizationPege btnContinueR() {
        getDriver().findElement(By.xpath("//button[@type='submit'][contains(.,'Продолжить')]")).click();

        return this;
    }

    @Name("кнопка Отправить еще раз")
    public AuthorizationPege againRestorePassword() {
        getDriver().findElement(By.xpath("//h2[@class='ant-typography h2_sb RestorePassword__bottom-textThree activeLink']")).click();

        return this;
    }

    @Name("кнопка профиль")
    public AuthorizationPege btnProfile() {
        getDriver().findElement(By.xpath("//h2[@class='ant-typography h2_sb']")).click();

        return this;
    }

    @Name("выбрать профиль ")
    public AuthorizationPege selectProfile() {
        getDriver().findElement(By.xpath("//div[@class='ant-typography p_r Profile__item']")).click();

        return this;
    }

    @Name("забыли пароль?")
    public AuthorizationPege forgotYourPassword() {
        getDriver().findElement(By.xpath("//div[@class='Login__restore']")).click();

        return this;
    }

    @Name("Электронная почта")
    public AuthorizationPege inputMailRestore(String mail) {
//    public BasePage inputMail() {
        getDriver().findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']")).sendKeys(mail);

        return this;
    }
//    @Name("кнопка ")
//    public AuthorizationPege roleProfile() {
//        getDriver().findElement(By.xpath("//h3[@class='ant-typography h3_m']")).getText();
//
//        return this;
//    }

    @Name("название профиля")
    public String roleProfile() {
        return getDriver().findElement(By.xpath("//div[@class='ant-typography p_r InformationProfile__info-role']")).getText();
    }

    @Name("Мы отправили по адресу")
    public String getEmailPas() {
        return getDriver().findElement(By.xpath("//h2[@class='ant-typography h2_m SendSuccessBlock__text'][contains(.,'Мы отправили по адресу')]")).getText();
    }

    @Name("Мы повторно отправили по адресу")
    public String againGetEmailPas() {
        return getDriver().findElement(By.xpath("//h2[@class='ant-typography h2_m SendSuccessBlock__text'][contains(.,'Мы отправили по адресу')]")).getText();
    }

    @Name("GET_ERROR_TEXT")
    public String getError() {
        return getDriver().findElement(By.xpath("//div[@style='text-align: center; margin-bottom: 20px; color: rgb(255, 0, 0);']")).getText();
    }

    @Name("GET_ERROR_TEXT")
    public String getEmailError() {
        return getDriver().findElement(By.xpath("//input[@id='basic_email']")).getAttribute("border-color: #ff4d4f;");
    }

    @Name("Пользователь не найден, попробуйте снова")
    public String getRestoreEmailError() {
        return getDriver().findElement(By.xpath("//div[@class='ant-message-custom-content ant-message-error']")).getText();
    }

    @Name("администратора, который не добавлен в проект")
    public String notProjectsError() {
        return getDriver().findElement(By.xpath("//p[@class='NotProjects__content-title']")).getText();
    }

    @Name("Пароль *********")
    public String passwordError() {
        return getDriver().findElement(By.xpath("//input[@type='password']")).getText();
    }

    @Name("Поле “Электронная почта” подсвечено красной обводкой")
    public String inputMailError() {
        return getDriver().findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']")).getAttribute("border-color");
//        return getDriver().findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']")).getAttribute("value style");
    }

    @Name("Электронная почта")
    public AuthorizationPege eMail() {
//    public BasePage inputMail() {
        getDriver().findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']")).getAttribute("border-color");

//        return new AutorisaitionPege(getDriver());
        return this;
    }
}
