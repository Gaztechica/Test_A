package ar.soft;

import ar.soft.runner.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemarcTest extends BaseTest {

    private static final By GET_ERROR = By.xpath("//div[@style='text-align: center; margin-bottom: 20px; color: rgb(255, 0, 0);']");

    @Test
    public void КemarcTest() {
        log();
        getDriver().findElement(By.xpath(INPUT_EMAIL)).sendKeys("yyyyyyyyyy@mail.xx");
        getDriver().findElement(By.xpath(BTN_PASSWORD)).click();

        String getError = getDriver().findElement(GET_ERROR).getText();

        Assert.assertEquals(getError,"Неправильный логин или пароль");
    }


}
