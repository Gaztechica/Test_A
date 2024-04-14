package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class LogFilePage extends BasePage {

    public LogFilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/logfiles']")
    private WebElement btnLogFile;

    public void btnLogFile() {
        btnLogFile.click();    }
}
