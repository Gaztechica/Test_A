package ar.soft.modelPage;

//import ar.soft.element.WaitT;
import ar.soft.modelPage.base.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.*;

import java.time.Duration;

//import static ar.soft.driver.WebDriverSetup.getDriverInstance;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

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
