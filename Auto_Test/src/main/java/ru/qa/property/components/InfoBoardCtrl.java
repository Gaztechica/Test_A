package ru.qa.property.components;

/**
 * @author Evgeny Gribanov
 * @link egribanov@cbgr.ru
 * @since 08.07.2022 10:14
 */
public enum InfoBoardCtrl {

    // InfoBoard.Ctrl
    JKanban("JKanban", "Тест компонента JKanban"),
    JscGant("JscGantt", "Тест компонента JscGantt"),
    JDiagram("JDiagram", "Тест компонента JDiagram");

    public final String formName;
    public final String title;

    // ! возврат data-testid обязателен, по нему происходят переходы по формам
    @Override
    public String toString() {
        return title;
    }

    InfoBoardCtrl(String formName, String title) {
        this.formName = formName;
        this.title = title;
    }

    public String getFormName() {
        return formName;
    }
}
