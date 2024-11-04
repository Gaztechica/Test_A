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

    @Name("кнопка Новый вид работ")
    public AuthorizationPege btnSubmit() {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();

        return this;
    }

    @Name("кнопка ")
    public AuthorizationPege btnProfile() {
        getDriver().findElement(By.xpath("//h2[@class='ant-typography h2_sb']")).click();

        return this;
    }

    @Name("кнопка ")
    public AuthorizationPege selectProfile() {
        getDriver().findElement(By.xpath("//div[@class='ant-typography p_r Profile__item']")).click();

        return this;
    }

//    @Name("кнопка ")
//    public AuthorizationPege roleProfile() {
//        getDriver().findElement(By.xpath("//h3[@class='ant-typography h3_m']")).getText();
//
//        return this;
//    }

    @Name("созданный вид р")
    public String roleProfile() {
        return getDriver().findElement(By.xpath("//h3[@class='ant-typography h3_m']")).getText();
    }


}
