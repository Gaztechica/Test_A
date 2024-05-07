package XRBP.modelPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import XRBP.modelPage.base.BasePage;

public class HomePage extends BasePage {

       public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickRega() {
        getDriver().findElement(By.xpath("//h2[@class='ant-typography h2_m Login__restore-text']")).click();
    }

//    public List<String> getJobList() {
//           List<WebElement> elementsList = getDriver().findElements(By.xpath());
//           List<String> resultList = elementsList.stream().toList().stream().map(WebElement::getText).toList();
//
//           return  resultList;
//    }
}
