package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class UserSidebarPage extends BasePage {


    public UserSidebarPage(WebDriver driver) {
        super(driver);
    }

    public UserSidebarPage btnAddUser() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();

        return this;
    }

    public UserSidebarPage btnCheckboxUserClick() {
        getDriver().findElement(By.xpath("(//div[@id='CheckboxComponent-check'])[2]")).click();

        return this;
    }
}
