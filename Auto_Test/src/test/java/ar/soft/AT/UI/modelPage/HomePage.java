package ar.soft.AT.UI.modelPage;

import ar.soft.AT.UI.modelPage.base.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

       public HomePage(WebDriver driver) {
        super(driver);
    }

//    public void clickRega() {
//        getDriver().findElement(By.xpath("//h2[@class='ant-typography h2_m Login__restore-text']")).click();
//    }

//    public List<String> getJobList() {
//           List<WebElement> elementsList = getDriver().findElements(By.xpath());
//           List<String> resultList = elementsList.stream().toList().stream().map(WebElement::getText).toList();
//
//           return  resultList;
//    }
}
