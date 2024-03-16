package ar.soft.modelPage.base;

import ar.soft.modelPage.UserPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage extends BaseModel {
//    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        super(driver);
    }
//    protected WebDriver getDriver() {
//        return driver;
//    }

//    @FindBy(xpath = "http://23.105.246.172:5000/login")
//    private WebElement URL;

    public void goHome() {
        getDriver().findElement(By.xpath("//img[@scr='http://23.105.246.172:5000/ac5efbd8-e0c6-4eae-acb2-85d8ac88a3e5']"));

    }

//    public BasePage URL() {
//        URL.click();
//        return this;
//    }
}
