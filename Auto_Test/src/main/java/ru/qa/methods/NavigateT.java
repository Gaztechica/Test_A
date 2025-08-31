package ru.qa.methods;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.qa.driver.WebDriverSetup;
import ru.qa.property.components.MenuButton;
import ru.qa.property.components.SubMenuButton;
import ru.qa.service.TurboNavigation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.qa.driver.WebDriverSetup.getDriverInstance;
import static ru.qa.service.TurboNavigation.isMaskClickable;


public class NavigateT {
    private static final String formNameLocator = "//*[@title='%s']";
    private static final String FORM_MAIN_LOCATOR = "//*[contains(@data-testid,'%s') and contains(@title,'%s')]";
    private static final String subFormMainLocator = "//*[contains(@data-testid,'%s') and contains(@title,'%s')]";

    private static final String subFormMainLocatorFromDataId = "//*[contains(@data-id,'%s') and contains(@title,'%s')]";

    public static class OpenForm {

        @Step("Переход по разделам меню до формы")
        public static void ComCtrl(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);
            NavigateT.openTurboPage(MenuButton.TestPlatformComponent);
            NavigateT.openSubMenuTurboPage(SubMenuButton.TestingPlatformComponents);
            NavigateT.openSubMenuTurboPage(SubMenuButton.ComCtrl);
            NavigateT.getForm(formLocators);
            ActionT.OneClick.clickToHeader();
        }

        //openSubMenuTurboPageWithDataId
        @Step("Переход по разделам меню до формы")
        public static void ComCtrlWithDataId(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);
            NavigateT.openTurboPage(MenuButton.TestPlatformComponent);
            NavigateT.openSubMenuTurboPageWithDataId(SubMenuButton.TestingPlatformComponents);
            NavigateT.openSubMenuTurboPage(SubMenuButton.ComCtrl);
            NavigateT.getForm(formLocators);
            ActionT.OneClick.clickToHeader();
        }


        @Step("Переход по разделам меню до формы")
        public static void InfoBoardCtrl(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);
            NavigateT.openTurboPage(MenuButton.TestPlatformComponent);
            NavigateT.openSubMenuTurboPage(SubMenuButton.TestingPlatformComponents);
            NavigateT.openSubMenuTurboPage(SubMenuButton.InfoBoardCtrl);
            NavigateT.getForm(formLocators);
            ActionT.OneClick.clickToHeader();
        }

        @Step("Переход по разделам меню до формы")
        public static void CtrlJs(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);
            NavigateT.openTurboPage(MenuButton.TestPlatformComponent);
            NavigateT.openSubMenuTurboPage(SubMenuButton.TestingPlatformComponents);
            NavigateT.openSubMenuTurboPage(SubMenuButton.CtrlJs);
            NavigateT.getForm(formLocators);
            ActionT.OneClick.clickToHeader();
        }

        @Step("Переход по разделам меню до формы")
        public static void AutotestExample(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);
            NavigateT.openTurboPage(MenuButton.TestPlatformComponent);
            NavigateT.openSubMenuTurboPage(SubMenuButton.TestingPlatformComponents);
            NavigateT.openSubMenuTurboPage(SubMenuButton.AutotestExample);
            NavigateT.getForm(formLocators);
            ActionT.OneClick.clickToHeader();
        }

        @Step("Переход по разделам меню до формы")
        public static void AutotestIFormExample(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);
            NavigateT.openTurboPage(MenuButton.TestPlatformComponent);
            NavigateT.openSubMenuTurboPage(SubMenuButton.TestingPlatformComponents);
            NavigateT.openSubMenuTurboPage(SubMenuButton.AutotestIFormExample);
            NavigateT.getForm(formLocators);
            ActionT.OneClick.clickToHeader();
        }

        @Step("Переход по разделам меню до формы")
        public static void AutotestIGridExample(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);
            NavigateT.openTurboPage(MenuButton.TestPlatformComponent);
            NavigateT.openSubMenuTurboPage(SubMenuButton.TestingPlatformComponents);
            NavigateT.openSubMenuTurboPage(SubMenuButton.IGrid);
            NavigateT.getForm(formLocators);
            //ActionT.OneClick.clickToHeader();
        }

        @Step("Переход по разделам меню до формы")
        public static void ICardForm(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);
            NavigateT.openTurboPage(MenuButton.TestPlatformComponent);
            NavigateT.openSubMenuTurboPage(SubMenuButton.TestingPlatformComponents);
            NavigateT.openSubMenuTurboPage(SubMenuButton.ICardForm);
            NavigateT.getForm(formLocators);
            ActionT.OneClick.clickToHeader();
        }

        @Step("Переход по разделам меню до формы")
        public static void ICardFormFunctional() {
            NavigateT.openTurboPage(MenuButton.Hamburger);
            NavigateT.openTurboPage(MenuButton.TestPlatformComponent);
            NavigateT.openSubMenuTurboPage(SubMenuButton.TestingPlatformComponents);
            NavigateT.openSubMenuTurboPage(SubMenuButton.ICardForm);
            WebDriverSetup.getDriverInstance()
                    .findElement(By.xpath("(//*[@title ='Пример для автотестирования картотеки'])[2]"))
                    .click();
            ActionT.OneClick.clickToHeader();
        }

        @Step("Переход по разделам меню до формы")
        public static void ICardFileDemo(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);
            NavigateT.openTurboPage(MenuButton.TestPlatformComponent);
            NavigateT.openSubMenuTurboPage(SubMenuButton.TestingPlatformComponents);
            NavigateT.openSubMenuTurboPage(SubMenuButton.ICardFileDemo);
            NavigateT.getForm(formLocators);
            ActionT.OneClick.clickToHeader();
        }

        @Step("Переход по разделам меню до формы")
        public static void taskAndPerformers(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);
            NavigateT.openTurboPage(MenuButton.TestPlatformComponent);
            NavigateT.openSubMenuTurboPage(SubMenuButton.TaskAndPerformers);
            NavigateT.openSubMenuTurboPage(SubMenuButton.Testing);
            NavigateT.getForm(formLocators);
            ActionT.OneClick.clickToHeader();
        }

        @Step("Переход по разделам меню до формы")
        public static void Performers(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);
            NavigateT.openTurboPage(MenuButton.TestPlatformComponent);
            NavigateT.openSubMenuTurboPage(SubMenuButton.TaskAndPerformers);
            NavigateT.openSubMenuTurboPage(SubMenuButton.Performers);
            NavigateT.getForm(formLocators);
            ActionT.OneClick.clickToHeader();
        }

        @Step("Переход по разделам меню до формы")
        public static void ErrorDemo(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);
            NavigateT.openTurboPage(MenuButton.TestPlatformComponent);
            NavigateT.openTurboPage(MenuButton.ErrorDemo);
            NavigateT.openTurboPage(MenuButton.SubMenuErrorDemo);
            NavigateT.getForm(formLocators);
            ActionT.OneClick.clickToHeader();
        }

        @Step("Переход по разделам меню до формы Контроль поручений")
        public static void OrderControl(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);//Меню
            NavigateT.openSubMenuTurboPage(SubMenuButton.OrderControl);//Контроль поручений
            NavigateT.openSubMenuTurboPage(SubMenuButton.DataAndDirectories);//данные и справочники
            NavigateT.openSubMenuTurboPage(SubMenuButton.BasicData);//Основные данные
            NavigateT.getForm(formLocators);
        }

        @Step("Переход по разделам меню до формы Базовые настройки") // а далее отчёты
        public static void BaseSettings(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);//Меню
            NavigateT.openTurboPage(MenuButton.Administration);//Администрирование
            NavigateT.openSubMenuTurboPage(SubMenuButton.Settings); // Настройки
            NavigateT.openSubMenuTurboPage(SubMenuButton.BaseSettings); // Базовые настройки
            NavigateT.getForm(formLocators);
        }

        @Step("Переход по разделам меню до формы Продажи")
        public static void SaleDocuments(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);//Меню
            NavigateT.openSubMenuTurboPage(SubMenuButton.Demo);//Демо
            NavigateT.openSubMenuTurboPage(SubMenuButton.Sales);//Продажи
            NavigateT.openSubMenuTurboPage(SubMenuButton.Documents);//Документы
            NavigateT.getForm(formLocators);
        }

        @Step("Переход по разделам меню до формы Управление доступом -> Роли доступа")
        public static void AccessControl(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);//Меню
            NavigateT.openTurboPage(MenuButton.Administration); //Администрирование
            NavigateT.openSubMenuTurboPage(SubMenuButton.Settings); // Настройки
            NavigateT.openSubMenuTurboPage(SubMenuButton.AccessControl); // Управление доступом
            NavigateT.getForm(formLocators);
        }

        @Step("Переход по разделам меню до формы Картотека Ref с inplace - редакитрованием")
        public static void refInPlaceCard(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);//Меню
            NavigateT.openTurboPage(MenuButton.TestingPlatformComponents1);//Тестирование комп. платформы
            NavigateT.openTurboPage(MenuButton.FormsForAutotest);
            NavigateT.openTurboPage(MenuButton.TestingForms);//Тестовые формы
            NavigateT.openTurboPage(MenuButton.RefInPlaceCard);//Картотека Ref с inplace - редакитрованием
            //NavigateT.getForm(formLocators);
        }

        @Step("Переход по разделам меню до формы Картотека Ref")
        public static void refCard(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);//Меню
            NavigateT.openTurboPage(MenuButton.TestingPlatformComponents1);//Тестирование комп. платформы
            NavigateT.openTurboPage(MenuButton.FormsForAutotest);
            NavigateT.openTurboPage(MenuButton.TestingForms);//Тестовые формы
            NavigateT.openTurboPage(MenuButton.RefCard);//Картотека Ref
            //NavigateT.getForm(formLocators);
        }

        @Step("Переход по разделам меню до формы свойство компонента IEdit")
        public static void propertyIEdit(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);//Меню
            NavigateT.openTurboPage(MenuButton.TestingPlatformComponents1);//Тестирование комп. платформы
            NavigateT.openTurboPage(MenuButton.PropertiesOfComponents); //Свойства компонентов
            NavigateT.openTurboPage(MenuButton.PropertiesOfComponentsGroup);//Свойства компонентов Group
            NavigateT.openTurboPage(MenuButton.IEditComponentProperties);//Свойства компонента IEdit
            //NavigateT.getForm(formLocators);
        }

        @Step("Переход по разделам меню до формы свойство компонента ITable")
        public static void propertyITable(final Enum<?> formLocators) {
            NavigateT.openTurboPage(MenuButton.Hamburger);//Меню
            NavigateT.openTurboPage(MenuButton.TestingPlatformComponents1);//Тестирование комп. платформы
            NavigateT.openTurboPage(MenuButton.PropertiesOfComponents); //Свойства компонентов
            NavigateT.openTurboPage(MenuButton.PropertiesOfComponentsGroup);//Свойства компонентов Group
            NavigateT.openTurboPage(MenuButton.ITableComponentProperties);//Свойства компонента ITable
            //NavigateT.getForm(formLocators);
        }
    }

    public static void openTurboPage(MenuButton formLocators) {
        Actions act = new Actions(getDriverInstance());
        String locator = String.format(FORM_MAIN_LOCATOR, formLocators.dataTestId, formLocators.title);
        while (isMaskClickable()) {
        }
        if (!getDriverInstance().findElement(By.xpath(locator)).isDisplayed()) {
            act.moveToElement(getDriverInstance().findElement(By.xpath(locator))).build().perform();
        }
        WaitT.elementToBeClickable(locator);
        AssertionT.Wait.visibilityElementLocatedWait(locator);
        act.moveToElement(getDriverInstance().findElement(By.xpath(locator))).click().perform();
    }

    public static void openSubMenuTurboPage(SubMenuButton formLocators) {
        String locator = String.format(subFormMainLocator, formLocators.dataId, formLocators.title);
        Actions act = new Actions(getDriverInstance());
        while (isMaskClickable()) {
        }
        if (!getDriverInstance().findElement(By.xpath(locator)).isDisplayed()) {
            act.moveToElement(getDriverInstance().findElement(By.xpath(locator))).build().perform();
        }
        WaitT.elementToBeClickable(locator);
        AssertionT.Wait.visibilityElementLocatedWait(locator);
        act.moveToElement(getDriverInstance().findElement(By.xpath(locator))).click().perform();
    }

    public static void openSubMenuTurboPageWithDataId(SubMenuButton formLocators) {
        String locator = String.format(subFormMainLocatorFromDataId, formLocators.dataId, formLocators.title);
        Actions act = new Actions(getDriverInstance());
        while (isMaskClickable()) {
        }
        if (!getDriverInstance().findElement(By.xpath(locator)).isDisplayed()) {
            act.moveToElement(getDriverInstance().findElement(By.xpath(locator))).build().perform();
        }
        WaitT.elementToBeClickable(locator);
        AssertionT.Wait.visibilityElementLocatedWait(locator);
        act.moveToElement(getDriverInstance().findElement(By.xpath(locator))).click().perform();
    }

    public static void getForm(final Enum<?> title) {
        String locator = String.format(formNameLocator, title.toString());
        Actions act = new Actions(getDriverInstance());
        if (!getDriverInstance().findElement(By.xpath(locator)).isDisplayed()) {
            act.moveToElement(getDriverInstance().findElement(By.xpath(locator))).build().perform();
        }
        while (isMaskClickable()) {
        }
        WaitT.elementToBeClickable(locator);
        AssertionT.Wait.visibilityElementLocatedWait(locator);
        act.moveToElement(getDriverInstance().findElement(By.xpath(locator))).click().perform();
    }

//    public static void getForm(String dataTestId) {
//        String locator = String.format(FORM_NAME_LOCATOR, dataTestId);
//        while (isMaskClickable()){}
//        if (!getDriverInstance().findElement(By.xpath(locator)).isDisplayed()) {
//            Actions act = new Actions(getDriverInstance());
//            act.moveToElement(getDriverInstance().findElement(By.xpath(locator))).build().perform();
//        }
//        WaitT.elementToBeClickable(locator);
//        AssertionT.Wait.visibilityElementLocatedWait(locator);
//        getDriverInstance().findElement(By.xpath(locator)).click();
//    }  ------ fixme


    @Step("переход на вкладку {locatorTab}")
    public static void getTab(String locatorTab) {
        while (isMaskClickable()) {
        }
        if (!getDriverInstance().findElement(By.xpath(locatorTab)).isDisplayed()) {
            Actions act = new Actions(getDriverInstance());
            act.moveToElement(getDriverInstance().findElement(By.xpath(locatorTab))).build().perform();
        }
        WaitT.elementToBeClickable(locatorTab);
        boolean isPresent = TurboNavigation.isElementPresent(By.xpath(locatorTab));
        assertTrue(isPresent, "Отсутствует вкладка" + locatorTab);
        getDriverInstance().findElement(By.xpath(locatorTab)).click();
    }

    @Step("переход на вкладку {webElementTab}")
    public static void getTab(WebElement webElementTab) {
        while (isMaskClickable()) {
        }
        if (!webElementTab.isDisplayed()) {
            Actions act = new Actions(WebDriverSetup.getDriverInstance());
            act.moveToElement(webElementTab).build().perform();
        }
        WaitT.elementToBeClickable(webElementTab);
        boolean isPresent = TurboNavigation.isElementPresent(webElementTab);
        assertTrue(isPresent, "Отсутствует вкладка" + webElementTab);
        webElementTab.click();
    }
}
