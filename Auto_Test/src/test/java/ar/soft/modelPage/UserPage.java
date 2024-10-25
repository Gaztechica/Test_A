package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserPage extends BasePage {

    @Name("пользователи")
    @FindBy(xpath = "//a[@href='/users']")
    private WebElement UserPage;

    @Name("создать ввод email")
    @FindBy(xpath = "//input[@id='user_email']")
    private WebElement inputEmail;

    @Name("кнопка создать")
    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")
    private WebElement createUserClick;

    @Name("кнопка Пригласить")
    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default secondaryButton big colorPrimary ']")
    private WebElement inviteUserClick;

    @Name("ввод email")
    @FindBy(xpath = "//input[@id='InviteUserModal_email']")
    private WebElement inviteUserEmail;

    @FindBy(xpath = "//input[@id='InviteUserModal_roles']")
    private WebElement inviteRoles;

    @FindBy(xpath = "//input[@id='InviteUserModal_employmentId']")
    private WebElement inviteRolesEmployment;

    @FindBy(xpath = "//input[@id='InviteUserModal_employmentName']")
    private WebElement createRolesEmployment;
    @FindBy(xpath = "//input[@id='user_last_name']")
    private WebElement userLastName;

    @Name("создание выбор роли")
    @FindBy(xpath = "//input[@id='user_roles']")
    private WebElement userCreateRole;

    @Name("пригласить выбор роли")
    @FindBy(xpath = "//input[@id='InviteUserModal_roles']")
    private WebElement userRole;

    @Name("роль админа")
    @FindBy(xpath = "//div[@class='ant-select-item-option-content']")
    private WebElement userRoleAdmin;

    @Name("роль инспектора")
    @FindBy(xpath = "(//div[@class='ant-select-item-option-content'])[2]")
    private WebElement userRoleInspect;

    @Name("роль подрядчика")
    @FindBy(xpath = "(//div[@class='ant-select-item-option-content'])[3]")
    private WebElement userRolePodr;

    @Name("роль наблюдателя")
    @FindBy(xpath = "(//div[@class='ant-select-item-option-content'])[4]")
    private WebElement userRoleNabl;

    @Name("кнопка пригласить")
    @FindBy(xpath = "//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")
    private WebElement btnSubmit;

    @Name("ввод имени")
    @FindBy(xpath = "//input[@id='user_name']")
    private WebElement inputName;

    @Name("созд")
    @FindBy(xpath = "//input[")
    private WebElement userCrea;

    @FindBy(xpath = "//img[@src='/static/media/AddButton.48ed616f99340e2467c9c2a6d8a8b67e.svg']")
    private WebElement createRole;

//    @FindBy(xpath = "//input[@id='user_email']")
//    private WebElement inputEmail;

    @FindBy(xpath = "//input[@id='user_timezone']")
    private WebElement userTimezone;

    @FindBy(xpath = "//input[@id='user_roles']")
    private WebElement userRoles;

    @FindBy(xpath = "//input[@id='user_password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@id='user_employmentName']")
    private WebElement inputRolesEmployment;

    @FindBy(xpath = "//input[@id='user_employmentId']")
    private WebElement inputRolesEmploymentClick;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']")
    private WebElement buttonDeleteClick;

    @FindBy(xpath = "//input[@class='ant-input']")
    private WebElement searchInput;

    @FindBy(xpath = "//span[@class='ant-input-affix-wrapper searchBoxInput  not-entered']")
    private WebElement searchInputClick;

    @FindBy(xpath = "//div[@class='ContentUsers__requestTitle']")
    private WebElement btnRequestUser;

    public final static String USER_NAME = "Алексей";
    public final static String LAST_NAME = "Адд";

    public final static String USER_EMAIL = "1аye21vtcmvg@mail.ru";

    public final static String USER_PASSWORD = "password";

    public UserPage(WebDriver driver) {
        super(driver);
    }

    @Name("пользователи")
    public UserPage userPage() {
        UserPage.click();
        return this;
    }

    @Name("кнопка создать")
    public UserPage createUserClick() {
       createUserClick.click();
        return this;
    }

    @Name("кнопка Пригласить")
    public UserPage inviteUserClick() {
        inviteUserClick.click();
        return this;
    }

    @Name("создать-ввод имени")
    public UserPage inputName(String name) {
        inputName.sendKeys(name);
        return this;
    }

    @Name("выбор роли")
    public UserPage userRole() {
        userRole.click();
        return this;
    }

    @Name("роль админа")
    public UserPage userRoleAdmin() {
        userRoleAdmin.click();
        return this;
    }

    @Name("роль инспектора")
    public UserPage userRoleInspect() {
        userRoleInspect.click();
        return this;
    }

    @Name("роль подрядчика")
    public UserPage userRolePodr() {
        userRolePodr.click();
        return this;
    }

    @Name("роль наблюдателя")
    public UserPage userRoleNabl() {
        userRoleNabl.click();
        return this;
    }

    @Name("кнопка пригласить")
    public UserPage btnSubmit() {
        btnSubmit.click();
        return this;
    }

    @Name("создать-ввод фамилии")
    public UserPage userLastName() {
        userLastName.sendKeys(LAST_NAME);
        return this;
    }

    @Name("ввод email")
    public UserPage inputEmail(String mail) {
        inputEmail.sendKeys(mail);
        return this;
    }

    @Name("ввод email")
    public UserPage inviteUserEmail() {
        inviteUserEmail.sendKeys(USER_EMAIL);
        return this;
    }

    public UserPage userCreateRole() {
        userCreateRole.click();
        return this;
    }
//    public UserPage userEmailClick() {
//        inputEmail.click();
//        return this;
//    }

    public UserPage userTimezoneClick() {
        userTimezone.click();
        return this;
    }

    public UserPage userTime() {
        userTimezone.sendKeys("UTC + 00:00");
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

    public UserPage inviteRolesClick() {
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
        createRole.click();
        return this;
    }

    public UserPage createRoleEmplomentEnter() {
        inputRolesEmployment.sendKeys(Keys.ENTER);
        return this;
    }

    public UserPage createRoleEmploment() {
        inputRolesEmployment.click();
        return this;
    }

    public UserPage inputRolesEmplomentArro() {
        inputRolesEmploymentClick.sendKeys(Keys.ARROW_DOWN);
        return this;
    }

    public UserPage imputRolesEmplomentClick() {
        inputRolesEmploymentClick.click();
        return this;
    }

    public UserPage imputRolesEmplomentEnter() {
        inputRolesEmploymentClick.sendKeys(Keys.ENTER);
        return this;
    }

    public UserPage inviteRolesEmploymentEnter() {
        inviteRolesEmployment.sendKeys(Keys.ENTER);
        return this;
    }

//    public UserPage inviteRolesEmploymentClick() {
//        inviteRolesEmployment.click();
//        return this;
//    }

    public UserPage createRolesEmplomentClick() {
        createRolesEmployment.click();
        return this;
    }

    public UserPage createRolesEmplomentSent() {
        createRolesEmployment.sendKeys("Kir");
        return this;
    }

    public UserPage inviteRoleEmplomentEnter() {
        createRolesEmployment.sendKeys(Keys.ENTER);
        return this;
    }

    public UserPage roleEmploment() {
            inputRolesEmployment.sendKeys("Kir");
            return this;
    }

    public UserPage inviteRoleEmplomentArro() {
        inviteRolesEmployment.sendKeys(Keys.ARROW_DOWN);
        return this;
    }

    public UserPage roleEmplomentClick() {
            inputRolesEmployment.sendKeys(Keys.ENTER);
            return this;
    }

    public UserPage userPassword() {
       inputPassword.sendKeys(USER_PASSWORD);
       return this;
    }

    public UserPage userPasswordClick() {
       inputPassword.click();
        return this;
    }

    public UserPage buttonDeleteClick() {
        buttonDeleteClick.click();
        return this;
    }

    public UserPage searchInputSent(String string) {
        searchInput.sendKeys(string);
        return this;
    }

    public UserPage search() {
        searchInput.clear();
        return this;
    }

    public UserPage searchInputEnter() {
        searchInput.sendKeys(Keys.ENTER);
        return this;
    }


    public UserPage searchInput() {
        searchInput.click();
        return this;
    }

    public UserPage searchInputClick() {
        searchInputClick.click();
        return this;
    }

    public UserPage searchClick() {
        getDriver().findElement(By.xpath("//div[@class='FilterUsers__search']")).click();
        return this;
    }

    @Name("кнопка троеточие")
    public UserPage buttonRemove() {
        getDriver().findElement(By.xpath("//img[@class='ant-dropdown-trigger AllUsers__iconBlock-img']")).click();
        return this;
    }

    public UserPage removeName() {
        getDriver().findElement(By.xpath("//div[@class='ant-typography p_r'][contains(.,'Редактировать')]")).click();
        return this;
    }

//    public UserPage userNameClear() {
//        inputName.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
//        Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
//        return this;
//    }

    public UserPage searchInputDelete() {
        searchInput.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        return this;
    }

    @Name("кнопка Удалить")
        public UserPage userNameDel() {
        getDriver().findElement(By.xpath("//li[@class='ant-dropdown-menu-item ant-dropdown-menu-item-only-child'][contains(.,'Удалить')]")).click();
        return this;
    }

    @Name("кнопка отменить")
        public UserPage buttonRemoCancel() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary '][contains(.,'Отменить')]")).sendKeys(Keys.ENTER);
        return this;
    }

    @Name("запрос на вступление в организацию отклонить Отклонить")
    public UserPage buttonRequestUser() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorRed '][contains(.,'Отклонить')]")).sendKeys(Keys.ENTER);
        return this;
    }

    @Name("запрос на вступление в организацию отклонить Отменить")
    public UserPage buttonRequestUserCancel() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary '][contains(.,'Отменить')]")).click();
        return this;
    }

    @Name("запрос на вступление в организацию отклонить Добавить")
    public UserPage buttonAddRequestUser() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(.,'Добавить')]")).click();
        return this;
    }

    @Name("запрос на вступление в организацию отклонить Отменить")
    public UserPage buttonAddRequestUserCancel() {
        getDriver().findElement(By.xpath("//div[@class='InviteUserModal__buttons']//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary '][contains(.,'Отменить')]")).click();
        return this;
    }

    public UserPage buttonSave() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();
        return this;
    }

    public UserPage inviteRolesEmploymentClick() {
        inviteRolesEmployment.click();
        return this;
    }

    public UserPage btnRequestUser() {
        btnRequestUser.click();
        return this;
    }

    @Name("запрос на вхождение в организацию отклонить")
    public UserPage hoverRequestUser() {
        WebElement targetElementStatus = getWait10().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//tr[@class='ant-table-row ant-table-row-level-0'][contains(.,'Отклонить')]")));
        new Actions(getDriver())
                .moveToElement(targetElementStatus)
                .perform();
        return this;
    }

    public UserPage inviteRolesEmploymentArron() {
        inviteRolesEmployment.sendKeys(Keys.ARROW_DOWN);
        return this;
    }

    public void btnAddUser() {

    }
}






