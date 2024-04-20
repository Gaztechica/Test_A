package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InspectSidebarPage extends BasePage {

    public InspectSidebarPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "")
    private WebElement createI;

    public InspectSidebarPage createUser() {
        createUser.click();
        return this;
    }
}
