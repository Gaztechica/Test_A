package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import jdk.jfr.Name;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class LibraryPage extends BasePage {

//    @FindBy(xpath = "//span[@class='ant-menu-title-content'][contains(.,'Библиотека')]")
//    private WebElement libraryClick;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary Checklists__extraButtonChecklict-create']")
    private WebElement buttonCheckListCreate;

    @FindBy(xpath = "//input[@class='ant-input primaryInput  not-entered']")
    private WebElement inputCheckListName;

    @FindBy(xpath = "//textarea[@class='ant-input primaryInput  not-entered']")
    private WebElement inputCheckListPrimary;

    @FindBy(xpath = "//textarea[@class='ant-input primaryInput createCategoryModal__input not-entered']")
    private WebElement createCategoryCheckList;

    @FindBy(xpath = "//div[@class='createCategoryModal__buttonsPanel']//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")
    private WebElement primaryButtonCheckListCreateClick;

    @FindBy(xpath = "//button[@class='CreateChecklist__addCategoryButton']")
    private WebElement buttonChecklistAddCategory;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")
    private WebElement buttonChecklistAdd;

    @FindBy(xpath = "//button[@class='CreateChecklist__addSubcategoryButton']")
    private WebElement buttonChecklistSubcategory;

    @FindBy(xpath = "//textarea[@class='ant-input primaryInput  not-entered']")
    private WebElement inputChecklistSubcateName;

    @FindBy(xpath = "//textarea[@class='ant-input primaryInput createCategoryModal__input not-entered']")
    private WebElement inputChecklistCategorySubcateName;

    @FindBy(xpath = "//div[@class='createCategoryModal__buttonsPanel']//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")
    private WebElement buttonChecklistCategory;

    @FindBy(xpath = "//button[@class='CreateChecklist__categoryItemButton']")
    private WebElement buttonChecklistCategoryDelete;

    @FindBy(xpath = "//div[@class='DeleteModal__buttonsPanel']//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")
    private WebElement buttonChecklistCategoryDeleteClick;

    @FindBy(xpath = "//tr[@data-row-key='1025']//img[@src='/static/media/Elipsis.f20471af64bc8c8f7914cf572c37ee72.svg']")
    private WebElement buttonChecklistRemove;

    public final static String USER_NAME = "123EvgenTest";

    public final static String USER_EMAIL = "yevgen@mail.ru";


    public LibraryPage(WebDriver driver) {
        super(driver);
    }

//    public LibraryPage libraryClick() {
//        libraryClick.click();
//        return this;
//    }

    public LibraryPage buttonChecListCreateClick() {
        buttonCheckListCreate.click();
        return this;
    }

    public LibraryPage inputChecListNameClick() {
        inputCheckListName.click();
        return this;
    }

    public LibraryPage inputChecListNameSent() {
        inputCheckListName.sendKeys("ChecListName");
        return this;
    }

    public LibraryPage inputChecListNameEnter() {
        inputCheckListName.sendKeys(Keys.ENTER);
        return this;
    }

    public LibraryPage inputChecListPrimaryClick() {
        inputCheckListPrimary.click();
        return this;
    }

    public LibraryPage inputChecListPrimarySent() {
        inputCheckListPrimary.sendKeys("ChecListPrimary");
        return this;
    }

    public LibraryPage inputChecListPrimaryEnter() {
        inputCheckListPrimary.click();
        return this;
    }

    public LibraryPage createCategoryChecList() {
        createCategoryCheckList.click();
        return this;
    }

    public LibraryPage createCategoryChecListSent() {
        createCategoryCheckList.sendKeys("createCategoryChecList");
        return this;
    }

    public LibraryPage primaryButtonChecListCreateClick() {
        primaryButtonCheckListCreateClick.click();
        return this;
    }

    public LibraryPage buttonChecklistAddCategory() {
        buttonChecklistAddCategory.click();
        return this;
    }

    public LibraryPage buttonChecklistAdd() {
        buttonChecklistAdd.click();
        return this;
    }

    public LibraryPage buttonChecklistSubcategory() {
        buttonChecklistSubcategory.click();
        return this;
    }

    public LibraryPage inputChecklistSubcateName() {
        inputChecklistSubcateName.click();
        return this;
    }

    public LibraryPage inputChecklistSubcateSent() {
        inputChecklistSubcateName.sendKeys("ChecklistSubcateName");
        return this;
    }

    public LibraryPage inputChecklistCategorySubcateNameSent() {
        inputChecklistCategorySubcateName.sendKeys("ChecklistCategorySubcateName");
        return this;
    }

    public LibraryPage inputChecklistCategorySubcateClick() {
        inputChecklistCategorySubcateName.click();
        return this;
    }

    public LibraryPage buttonChecklistCategory() {
        buttonChecklistCategory.click();
        return this;
    }

    public LibraryPage buttonChecklistCategoryDelete() {
        buttonChecklistCategoryDelete.click();
        return this;
    }

    public LibraryPage buttonChecklistCategoryDeleteClick() {
        buttonChecklistCategoryDeleteClick.click();
        return this;
    }

    public LibraryPage buttonChecklistRemove() {
        buttonChecklistRemove.click();
        return this;
    }

    @Name("Вид работ в инспекции")
    public LibraryPage inspectTypesWork() {
        getDriver().findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']")).sendKeys("name" );
        getDriver().findElement(By.xpath("//button[@class='CreateChecklist__addCategoryButton']")).click();
        getDriver().findElement(By.xpath("//textarea[@class='ant-input primaryInput  not-entered']")).sendKeys("name2" );
        getDriver().findElement(By.xpath("//textarea[@class='ant-input primaryInput createCategoryModal__input not-entered']")).sendKeys("name22" );
        getDriver().findElement(By.xpath("(//*[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(., 'Добавить')])[2]")).click();

        return this;
    }


//    public LibraryPage URL() throws InterruptedException {
//        getDriver().get(URL);
//        Thread.sleep(2000);
//        getDriver().manage().window().setSize(new Dimension(1820, 1080));
//        getDriver().findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
//        getDriver().findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
//        getDriver().findElement(By.xpath(BTN_PASSWORD)).click();
//        Thread.sleep(11500);
//        return this;
//    }
}
