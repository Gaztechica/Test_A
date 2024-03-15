package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LibraryPage extends BasePage {

    @FindBy(xpath = "//a[@href='/library']")
    private WebElement libraryClick;

    public final static String USER_NAME = "123EvgenTest";

    public final static String USER_EMAIL = "yevgen@mail.ru";


    public LibraryPage(WebDriver driver) {
        super(driver);
    }

    public LibraryPage libraryClick() {
        libraryClick.click();
        return this;
    }
}
