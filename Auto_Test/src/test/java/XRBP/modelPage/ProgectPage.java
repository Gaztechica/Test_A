package XRBP.modelPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import XRBP.modelPage.base.BasePage;

public class ProgectPage extends BasePage {

    public ProgectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")
    private WebElement btnCreateProgect;

    public ProgectPage btnCreateProgect() {
        btnCreateProgect.click();
        return this;
    }
}
