package ru.qa.property.components;

/**
 * Константы для навигации по основным меню.
 *
 * @author Evgeny Gribanov
 * @link egribanov@cbgr.ru
 * @since 08.07.2022 10:28
 */
public enum MenuButton {
    // основная навигация
    Header("Header", "HeaderFrame", ""),
    Hamburger("Заходим в основное меню - Бургер", "toolbarButton_burger", "меню"),
    TestPlatformComponent("Тест компонентов платформы", "", "Тест компонентов платформы"),
    TestingPlatformComponents1("Тестирование компонентов платформы", "Module_Autotesting",
            "Тестирование компонентов платформы"),
    TestingForms("Тестовые формы", "Module_Autotesting$MenuPanel_Autotesting$Test",
            "Тестовые формы"),

    FormsForAutotest("Формы для автотестирования", "Module_Autotesting$MenuPanel_Autotesting",
            "Формы для автотестирования"),

    PropertiesOfComponents("Cвойства компонентов", "Module_Autotesting$MenuPanel_Components",
            "Cвойства компонентов"),


    PropertiesOfComponentsGroup("Cвойства компонентов", "Module_Autotesting$MenuPanel_Components$StatisPropertiesGroup",
            "Cвойства компонентов"),

    IEditComponentProperties("Cвойства компонента Edit", "Module_Autotesting$MenuPanel_Components$EditProperties",
            "Cвойства компонента Edit"),

    ITableComponentProperties("Cвойства компонента ITable", "Module_Autotesting$MenuPanel_Components$TableProperties",
            "Cвойства компонента Table"),

    RefInPlaceCard("Картотека Ref с Inplace-редактированием", "Module_Autotesting$MenuPanel_Autotesting$Sample_Ref_Inline",
            "Картотека Ref с Inplace-редактированием"),
    RefCard("Картотека Ref", "Module_Autotesting$MenuPanel_Autotesting$Sample_Ref",
            "Картотека Ref"),
    ErrorDemo("Демо ошибок", "",
                      "Демо ошибок"),

    SubMenuErrorDemo("Подменю - Демо ошибок",
                             "Module$ATMPanelsNativeWebPanel_DemoError$Group1",
                             "Демо ошибок"),
    Administration("Админитрирование",
            "",
            "Администрирование");

    public final String formName;
    public final String dataTestId;
    public final String title;

    // ! возврат data-testid обязателен, по нему происходят переходы по формам
    @Override
    public String toString() {
        return formName;
    }

    MenuButton(String formName, String dataTestId, String title) {
        this.formName = formName;
        this.dataTestId = dataTestId;
        this.title = title;
    }

    public String getFormName() {
        return formName;
    }
}
