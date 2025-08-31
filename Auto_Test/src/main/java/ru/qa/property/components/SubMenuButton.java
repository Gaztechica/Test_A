package ru.qa.property.components;

/**
 * Константы для навигации по основным меню.
 *
 * @author Evgeny Gribanov
 * @link egribanov@cbgr.ru
 * @since 08.07.2022 10:28
 */
public enum SubMenuButton {

    TestingPlatformComponents("Тестирование компонентов платформы", "Module$ATMPanelsNativeWebPanel_Test",
            "Тест компонентов платформы"),
    // категории компонентов
    ComCtrl("ComCtrl", "Module$ATMPanelsNativeWebPanel_Test$OpenNWTestComCtrl", "Com.Ctrl"),
    InfoBoardCtrl("InfoBoardCtrl", "Module$ATMPanelsNativeWebPanel_Test$OpenNWTestInfoBoardCtrl",
            "InfoBoard.Ctrl"),
    CtrlJs("CtrlJs", "Module$ATMPanelsNativeWebPanel_Test$OpenNWTestComCtrlJs",
            "Com.Ctrl.Js"),
    AutotestExample("AutotestExample", "Module$ATMPanelsNativeWebPanel_Test$Group1",
            "Автотест (примеры)"),
    AutotestIFormExample("AutotestIFormExample",
            "Module$ATMPanelsNativeWebPanel_Test$OpenNWTestExamplesIForm",
            "Автотест (IForm примеры)"),
    ICardForm("ICardForm", "Module$ATMPanelsNativeWebPanel_Test$OpenNWTestExamplesICardForm",
            "Автотест (ICardForm примеры)"),

    ICardFileDemo("ICardFileDemo", "Module$ATMPanelsNativeWebPanel_Test$OpenNWTestExamplesICardFile",
            "Автотест (ICardFile примеры)"),

    IGrid("IGrid", "Module$ATMPanelsNativeWebPanel_Test$OpenNWTestExamplesIGrid",
            "Автотест (IGrid примеры)"),
    TaskAndPerformers("TaskAndPerformers","Module$ATMPanelsNativeWebPanel_Jobs","Задания, исполнители"),
    Testing("Testing","Module$ATMPanelsNativeWebPanel_Jobs$Group2","Тестирование"),
    Performers("Performers","Module$ATMPanelsNativeWebPanel_Jobs$Group1","Исполнители"),
    DataAndDirectories("DataAndDirectories", "Module_Control$MenuPanel_ControlMain",
            "Данные и справочники"),
    BasicData("BasicData", "Module_Control$MenuPanel_ControlMain$MenuGroup_ControlDocs",
            "Основные данные"),
    OrderControl("Контроль поручений", "Module_Control", "Контроль поручений"),
    Settings("Настройки","Admin$SettingsPanel","Настройки"),
    BaseSettings("Базовые настройки","Admin$SettingsPanel$GroupCommonSettings","Базовые настройки"),
    AccessControl("Управление доступом",
            "Admin$SettingsPanel$MenuGroup_AccesManagement",
            "Управление доступом"),
    Demo("Демо","Demo","Демо"),
    Sales("Продажи", "Demo$MenuSales", "Продажи"),
    Documents("Документы", "Demo$MenuSales$DocGroup", "Документы");

    public final String formName;
    public final String dataId;
    public final String title;

    // ! возврат data-testid обязателен, по нему происходят переходы по формам
    @Override
    public String toString() {
        return formName;
    }

    SubMenuButton(String formName, String dataId, String title) {
        this.formName = formName;
        this.dataId = dataId;
        this.title = title;
    }

    public String getFormName() {
        return formName;
    }
}
