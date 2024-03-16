package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LibraryPage extends BasePage {

    @FindBy(xpath = "//a[@href='/library']")
    private WebElement libraryClick;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary Checklists__extraButtonChecklict-create']")
    private WebElement buttonChecListCreate;

    @FindBy(xpath = "//input[@class='ant-input primaryInput  not-entered']")
    private WebElement inputChecListName;

    @FindBy(xpath = "//textarea[@class='ant-input primaryInput  not-entered']")
    private WebElement inputChecListPrimary;

    @FindBy(xpath = "//textarea[@class='ant-input primaryInput createCategoryModal__input not-entered']")
    private WebElement createCategoryChecList;

    @FindBy(xpath = "//div[@class='createCategoryModal__buttonsPanel']//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")
    private WebElement primaryButtonChecListCreateClick;

//    @FindBy(xpath = "//a[@href='/library']")
//    private WebElement ;
//
//    @FindBy(xpath = "//a[@href='/library']")
//    private WebElement libraryClick;

    public final static String USER_NAME = "123EvgenTest";

    public final static String USER_EMAIL = "yevgen@mail.ru";


    public LibraryPage(WebDriver driver) {
        super(driver);
    }

    public LibraryPage libraryClick() {
        libraryClick.click();
        return this;
    }

    public LibraryPage buttonChecListCreateClick() {
        buttonChecListCreate.click();
        return this;
    }

    public LibraryPage inputChecListNameClick() {
        inputChecListName.click();
        return this;
    }

    public LibraryPage inputChecListNameSent() {
        inputChecListName.sendKeys("ChecListName");
        return this;
    }

    public LibraryPage inputChecListNameEnter() {
        inputChecListName.sendKeys(Keys.ENTER);
        return this;
    }

    public LibraryPage inputChecListPrimaryClick() {
        inputChecListPrimary.click();
        return this;
    }

    public LibraryPage inputChecListPrimarySent() {
        inputChecListPrimary.sendKeys("ChecListPrimary");
        return this;
    }

    public LibraryPage inputChecListPrimaryEnter() {
        inputChecListPrimary.click();
        return this;
    }

    public LibraryPage createCategoryChecList() {
        createCategoryChecList.click();
        return this;
    }

    public LibraryPage createCategoryChecListSent() {
        createCategoryChecList.sendKeys("createCategoryChecList");
        return this;
    }

    public LibraryPage primaryButtonChecListCreateClick() {
        primaryButtonChecListCreateClick.click();
        return this;
    }

//    public LibraryPage () {
//
//        return this;
//    }
//
//    public LibraryPage () {
//
//        return this;
//    }
//
//    public LibraryPage () {
//
//        return this;
//    }

//    public LibraryPage () {
//
//        return this;
//    }
//
//    public LibraryPage () {
//
//        return this;
//    }
//
//    public LibraryPage () {
//
//        return this;
//    }
//
//    public LibraryPage () {
//
//        return this;
//    }
//
//    public LibraryPage () {
//
//        return this;
//    }


}
