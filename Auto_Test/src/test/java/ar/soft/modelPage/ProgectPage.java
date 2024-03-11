package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProgectPage extends BasePage {

    public ProgectPage(WebDriver driver) {
        super(driver);
    }
    public void buttonCreateProgect () {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();
    }
}
