package ar.soft.modelPage.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage extends BaseModel {
//    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        super(driver);
    }
//    protected WebDriver getDriver() {
//        return driver;
//    }

    public void goHome() {
        getDriver().findElement(By.xpath("//img[@scr='http://23.105.246.172:5000/ac5efbd8-e0c6-4eae-acb2-85d8ac88a3e5']"));

    }
}
