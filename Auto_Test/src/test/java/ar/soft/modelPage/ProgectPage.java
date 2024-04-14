package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgectPage extends BasePage {

    public ProgectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")
    private WebElement btnCreateProgect;

    public void btnCreateProgect() {
        btnCreateProgect.click();    }
}
