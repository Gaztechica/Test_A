package ar.soft.modelPage.base;

import ar.soft.modelPage.UserPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import static ar.soft.runner.BaseTest.*;

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
//
//    @FindBy(xpath = "//input[@class='ant-input']")
//    private WebElement INPUT_EMAIL;
//
//    @FindBy(xpath = "//input[@class='ant-input']")
//    private WebElement INPUT_PASSWORD;
//
//    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default authButton big colorPrimary ']")
//    private WebElement BTN_PASSWORD;
//    public static final String EMAIL = "n-k-65@list.ru";
//    public static final String PASSWORD = "qwe135";

    public void goHome() {
        getDriver().findElement(By.xpath("//img[@scr='http://23.105.246.172:5000/ac5efbd8-e0c6-4eae-acb2-85d8ac88a3e5']"));

    }

    public BasePage URL()throws InterruptedException {
//        URL.click();
//        INPUT_EMAIL.sendKeys(EMAIL);
//        INPUT_PASSWORD.sendKeys(PASSWORD);
//        BTN_PASSWORD.click();
        getDriver().get(URL);
        Thread.sleep(1000);
        getDriver().manage().window().setSize(new Dimension(1820,1080));
        getDriver().findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        getDriver().findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        getDriver().findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(5000);
        return this;
    }
}
