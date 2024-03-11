package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends BasePage {

    @FindBy(xpath = "//a[@href='/users']")
    private WebElement createUser;

    @FindBy(xpath = "//input[@id='user_name']")
    private WebElement imputName;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default secondaryButton big colorPrimary ']")
    private WebElement createUserClick;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")
    private WebElement inviteUserClick;

    @FindBy(xpath = "//input[@id='InviteUserModal_email']")
    private WebElement inviteUserEmail;

    @FindBy(xpath = "//input[@id='InviteUserModal_roles']")
    private WebElement inviteRoles;

//    @FindBy(xpath = "")
//    private WebElement inviteRolesSearch;

    @FindBy(xpath = "//input[@id='user_email']")
    private WebElement imputEmail;

    @FindBy(xpath = "//input[@id='user_timezone']")
    private WebElement userTimezone;

    @FindBy(xpath = "//input[@id='user_roles']")
    private WebElement userRoles;

    @FindBy(xpath = "//input[@id='user_password']")
    private WebElement imputPassword;

    @FindBy(xpath = "//input[@id='user_employmentName']")
    private WebElement imputRolesEmploment;

    public final static String USER_NAME = "123EvgenTest";

    public final static String USER_EMAIL = "yevgen@mail.ru";


    public UserPage(WebDriver driver) {
        super(driver);
    }

    public UserPage createUser() {
        createUser.click();
        return this;
    }

    public UserPage createUserClick() {
       createUserClick.click();
        return this;
    }

    public UserPage inviteUserClick() {
        inviteUserClick.click();
        return this;
    }

    public UserPage userName(String name) {
        imputName.sendKeys(name);
        return this;
    }

    public UserPage userLastName(String lastName) {
        getDriver().findElement(By.xpath("//input[@id='user_last_name']")).sendKeys(lastName);
        return this;
    }

    public UserPage userEmail(String email) {
        imputEmail.sendKeys(USER_EMAIL);
        return this;
    }

    public UserPage inviteUserEmail(String email) {
        inviteUserEmail.sendKeys(USER_EMAIL);
        return this;
    }

    public UserPage userEmailClick() {
        imputEmail.click();
        return this;
    }

    public UserPage userTimezoneClick() {
        userTimezone.click();
        return this;
    }

    public UserPage userTime(String time) {
        userTimezone.sendKeys(time);
        return this;
    }

    public UserPage userTimeEnter() {
        userTimezone.sendKeys(Keys.ENTER);
        return this;
    }

    public UserPage userRolesClick() {
        userRoles.click();
        return this;
    }

    public UserPage inviteRoles() {
        inviteRoles.click();
        return this;
    }

    public UserPage inviteRolesArron() {
        inviteRoles.sendKeys(Keys.ARROW_DOWN);
        return this;
    }

    public UserPage inviteRolesEnter() {
        inviteRoles.sendKeys(Keys.ENTER);
        return this;
    }
    public UserPage userRolesArron() {
        userRoles.sendKeys(Keys.ARROW_DOWN);
        return this;
    }

    public UserPage userRoles() {
        userRoles.sendKeys(Keys.ENTER);
        return this;
    }

    public UserPage createRoleClick() {
        getDriver().findElement(By.xpath("//img[@src='/static/media/AddButton.48ed616f99340e2467c9c2a6d8a8b67e.svg']")).click();
        return this;
    }

    public UserPage createRoleEmploment() {
        imputRolesEmploment.click();
        return this;
    }

    public UserPage roleEmploment() {
        imputRolesEmploment.sendKeys("Kir");
        return this;
    }

    public UserPage roleEmplomentClick() {
        imputRolesEmploment.sendKeys(Keys.ENTER);
        return this;
    }
    public UserPage userPassword(String password) {
       imputPassword.sendKeys(password);
       return this;
    }

    public UserPage userPasswordClick() {
       imputPassword.click();
        return this;
    }

    public UserPage buttonDeleteClick() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']")).click();
        return this;
    }

    public UserPage buttonRemove() {
        getDriver().findElement(By.xpath("//img[@class='ant-dropdown-trigger ContentUsers__iconBlock-img']")).click();
        return this;
    }

    public UserPage removeName() {
        getDriver().findElement(By.xpath("//div[@class='ant-typography p_r'][contains(.,'Редактировать')]")).click();
        return this;
    }

    public UserPage userNameClear() {
        imputName.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
        Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        return this;
    }

    public UserPage userNameDel() {
        getDriver().findElement(By.xpath("//span[@class='ant-dropdown-menu-title-content'][contains(.,'Удалить')]")).click();
        return this;
    }

    public UserPage buttonRemoOtmena() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary '][contains(.,'Отменить')]")).click();
        return this;
    }

    public UserPage buttonSave() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();
        return this;
    }
}
