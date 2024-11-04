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

    @Name("кнопка Продолжить")
    public AuthorizationPege btnContinue() {
        getDriver().findElement(By.xpath("//button[@type='submit'][contains(.,'Продолжить')]")).click();

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
        return getDriver().findElement(By.xpath("//h3[@class='ant-typography h3_m']")).getText();
    }

    @Name("Мы отправили по адресу")
    public String getEmailPas() {
        return getDriver().findElement(By.xpath("//h2[@class='ant-typography h2_m SendSuccessBlock__text'][contains(.,'Мы отправили по адресу')]")).getText();
    }

    @Name("GET_ERROR_TEXT")
    public String getError() {
        return getDriver().findElement(By.xpath("//div[@style='text-align: center; margin-bottom: 20px; color: rgb(255, 0, 0);']")).getText();
    }
}
