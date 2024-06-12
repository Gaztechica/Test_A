package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserSidebarPage extends BasePage {

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")
    private WebElement btnAddUser;

    @FindBy(xpath = "(//div[@id='CheckboxComponent-check'])[2]")
    private WebElement btnCheckboxUser;

    @FindBy(xpath = "//div[@id='CheckboxComponent-check']")
    private WebElement CheckboxComponent;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")
    private WebElement btnCprimaryButton;

    public UserSidebarPage(WebDriver driver) {
        super(driver);
    }

    public UserSidebarPage btnAddUserClick() {
        btnAddUser.click();

        return this;
    }

    public UserSidebarPage btnCheckboxUserClick() {
        btnCheckboxUser.click();

        return this;
    }

    public UserSidebarPage checkboxComponentClick() {
        CheckboxComponent.click();

        return this;
    }

    public UserSidebarPage btnCprimaryButtonClik() {
        btnCprimaryButton.click();

        return this;
    }
}
