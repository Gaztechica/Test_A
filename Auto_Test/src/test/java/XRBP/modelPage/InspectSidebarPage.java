package XRBP.modelPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import XRBP.modelPage.base.BasePage;

public class InspectSidebarPage extends BasePage {

    public InspectSidebarPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "")
    private WebElement createI;

//    public InspectSidebarPage createUser() {
//        createUser.click();
//        return this;
//    }
}
