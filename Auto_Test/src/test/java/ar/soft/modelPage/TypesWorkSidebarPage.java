package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TypesWorkSidebarPage extends BasePage {

    public void TypesWorkSidebarPage(WebDriver driver) {
        super(driver);
    }

    public TypesWorkSidebarPage l() {
        getDriver().findElement(By.xpath("//input[@aria-activedescendant='rc_select_4_list_0']")).sendKeys(Keys.ENTER);

        return this;
    }
}
