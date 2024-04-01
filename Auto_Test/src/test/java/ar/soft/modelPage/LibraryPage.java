//package ar.soft.modelPage;
//
//import ar.soft.modelPage.base.BasePage;
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.FindBy;
//
//import static ar.soft.runner.BaseTest.*;
//import static ar.soft.runner.BaseTest.BTN_PASSWORD;
//
//public class LibraryPage extends BasePage {
//
//    @FindBy(xpath = "//a[@href='/library']")
//    private WebElement libraryClick;
//
//    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary Checklists__extraButtonChecklict-create']")
//    private WebElement buttonChecListCreate;
//
//    @FindBy(xpath = "//input[@class='ant-input primaryInput  not-entered']")
//    private WebElement inputChecListName;
//
//    @FindBy(xpath = "//textarea[@class='ant-input primaryInput  not-entered']")
//    private WebElement inputChecListPrimary;
//
//    @FindBy(xpath = "//textarea[@class='ant-input primaryInput createCategoryModal__input not-entered']")
//    private WebElement createCategoryChecList;
//
//    @FindBy(xpath = "//div[@class='createCategoryModal__buttonsPanel']//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")
//    private WebElement primaryButtonChecListCreateClick;
//
//    @FindBy(xpath = "//button[@class='CreateChecklist__addCategoryButton']")
//    private WebElement buttonChecklistAddCategory;
//
//    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")
//    private WebElement buttonChecklistAdd;
//
//    @FindBy(xpath = "//button[@class='CreateChecklist__addSubcategoryButton']")
//    private WebElement buttonChecklistSubcategory;
//
//    @FindBy(xpath = "//textarea[@class='ant-input primaryInput  not-entered']")
//    private WebElement inputChecklistSubcateName;
//
//    @FindBy(xpath = "//textarea[@class='ant-input primaryInput createCategoryModal__input not-entered']")
//    private WebElement inputChecklistCategorySubcateName;
//
//    @FindBy(xpath = "//div[@class='createCategoryModal__buttonsPanel']//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")
//    private WebElement buttonChecklistCategory;
//
//    @FindBy(xpath = "//button[@class='CreateChecklist__categoryItemButton']")
//    private WebElement buttonChecklistCategoryDelete;
//
//    @FindBy(xpath = "//div[@class='DeleteModal__buttonsPanel']//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")
//    private WebElement buttonChecklistCategoryDeleteClick;
//
//    @FindBy(xpath = "//tr[@data-row-key='1025']//img[@src='/static/media/Elipsis.f20471af64bc8c8f7914cf572c37ee72.svg']")
//    private WebElement buttonChecklistRemove;
//
//    public final static String USER_NAME = "123EvgenTest";
//
//    public final static String USER_EMAIL = "yevgen@mail.ru";
//
//
//    public LibraryPage(WebDriver driver) {
//        super(driver);
//    }
//
//    public LibraryPage libraryClick() {
//        libraryClick.click();
//        return this;
//    }
//
//    public LibraryPage buttonChecListCreateClick() {
//        buttonChecListCreate.click();
//        return this;
//    }
//
//    public LibraryPage inputChecListNameClick() {
//        inputChecListName.click();
//        return this;
//    }
//
//    public LibraryPage inputChecListNameSent() {
//        inputChecListName.sendKeys("ChecListName");
//        return this;
//    }
//
//    public LibraryPage inputChecListNameEnter() {
//        inputChecListName.sendKeys(Keys.ENTER);
//        return this;
//    }
//
//    public LibraryPage inputChecListPrimaryClick() {
//        inputChecListPrimary.click();
//        return this;
//    }
//
//    public LibraryPage inputChecListPrimarySent() {
//        inputChecListPrimary.sendKeys("ChecListPrimary");
//        return this;
//    }
//
//    public LibraryPage inputChecListPrimaryEnter() {
//        inputChecListPrimary.click();
//        return this;
//    }
//
//    public LibraryPage createCategoryChecList() {
//        createCategoryChecList.click();
//        return this;
//    }
//
//    public LibraryPage createCategoryChecListSent() {
//        createCategoryChecList.sendKeys("createCategoryChecList");
//        return this;
//    }
//
//    public LibraryPage primaryButtonChecListCreateClick() {
//        primaryButtonChecListCreateClick.click();
//        return this;
//    }
//
//    public LibraryPage buttonChecklistAddCategory() {
//        buttonChecklistAddCategory.click();
//        return this;
//    }
//
//    public LibraryPage buttonChecklistAdd() {
//        buttonChecklistAdd.click();
//        return this;
//    }
//
//    public LibraryPage buttonChecklistSubcategory() {
//        buttonChecklistSubcategory.click();
//        return this;
//    }
//
//    public LibraryPage inputChecklistSubcateName() {
//        inputChecklistSubcateName.click();
//        return this;
//    }
//
//    public LibraryPage inputChecklistSubcateSent() {
//        inputChecklistSubcateName.sendKeys("ChecklistSubcateName");
//        return this;
//    }
//
//    public LibraryPage inputChecklistCategorySubcateNameSent() {
//        inputChecklistCategorySubcateName.sendKeys("ChecklistCategorySubcateName");
//        return this;
//    }
//
//    public LibraryPage inputChecklistCategorySubcateClick() {
//        inputChecklistCategorySubcateName.click();
//        return this;
//    }
//
//    public LibraryPage buttonChecklistCategory() {
//        buttonChecklistCategory.click();
//        return this;
//    }
//
//    public LibraryPage buttonChecklistCategoryDelete() {
//        buttonChecklistCategoryDelete.click();
//        return this;
//    }
//
//    public LibraryPage buttonChecklistCategoryDeleteClick() {
//        buttonChecklistCategoryDeleteClick.click();
//        return this;
//    }
//
//    public LibraryPage buttonChecklistRemove() {
//        buttonChecklistRemove.click();
//        return this;
//    }
//
////    public LibraryPage URL() throws InterruptedException {
////        getDriver().get(URL);
////        Thread.sleep(2000);
////        getDriver().manage().window().setSize(new Dimension(1820, 1080));
////        getDriver().findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
////        getDriver().findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
////        getDriver().findElement(By.xpath(BTN_PASSWORD)).click();
////        Thread.sleep(11500);
////        return this;
////    }
//}
