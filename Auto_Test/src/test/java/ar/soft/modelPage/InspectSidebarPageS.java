package ar.soft.modelPage;

//import ar.soft.element.WaitT;
import ar.soft.modelPage.base.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import jdk.jfr.Name;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static ar.soft.InspectSidebarTest.*;
//import static ar.soft.driver.WebDriverSetup.getDriverInstance;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static org.openqa.selenium.By.xpath;

public class InspectSidebarPageS extends BasePage {

    public InspectSidebarPageS(WebDriver driver) {
        super(driver);
    }

    private final SelenideElement
            selectReportParamButton = $x("(//*[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(., 'Добавить')])[2]")
            .as("кнопка добавить");

    @Step("кнопка добавить")
    public InspectSidebarPage sendDescription() {
        selectReportParamButton.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        Selenide.sleep(500);
        selectReportParamButton.click();
        // selectReportParamButton.sendKeys(value + Keys.ENTER);
        return page(InspectSidebarPage.class);
    }
}
