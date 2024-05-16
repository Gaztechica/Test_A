package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgjctPage extends BasePage {

    public ProgjctPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")
    private WebElement btnCreateProject;

    public ProgjctPage btnCreateProgect() {
        btnCreateProject.click();
        return this;
    }
}
