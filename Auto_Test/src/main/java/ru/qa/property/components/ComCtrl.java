package ru.qa.property.components;

/**
 * Константы для открытия форм в разделе Com. Ctrl.
 * @author Evgeny Gribanov
 * @link egribanov@cbgr.ru
 * @since 08.07.2022 10:28
 */
public enum ComCtrl {

    // Com.Ctrl
    IButton("IButton", "Тест компонента IButton"),
    ICheckBox("ICheckBox", "Тест компонента ICheckBox"),
    IRadioButton("IRadioButton","Тест компонента IRadioButton"),
    IEdit("IEdit", "Тест компонента IEdit"),
    IStatic("IStatic", "Тест компонента IStatic"),
    IListEdit("IListEdit", "Тест компонента IListEdit"),
    IEditEx("IEditEx", "Тест компонента IEditEx"),
    IColorEdit("IColorEdit", "Тест компонента IColorEdit"),
    IPasswordEdit("IPasswordEdit", "Тест компонента IPasswordEdit"),
    IFrame("IFrame", "Тест компонента IFrame"),
    IBox("IBox", "Тест компонента IBox"),
    IHeader("IHeader", "Тест компонента IHeader"),
    IColumnsGroup("IColumnsGroup", "Тест компонента IColumnsGroup"),
    IReportFrame("IReportFrame", "Тест компонента IReportFrame"),
    IPicture("IPicture", "Тест компонента IPicture"),
    IGroup("IGroup", "Тест компонента IGroup"),
    INewLine("INewLine", "Тест компонента INewLine"),
    IListButton("IListButton", "Тест компонента IListButton"),
    IJumpButton("IJumpButton", "Тест компонента IJumpButton"),
    ICardFile("ICardFile", "Тест компонента ICardFile"),
    ICardTree("ICardTree", "Тест компонента ICardTree"),
    ITable("ITable", "Тест компонента ITable"),
    IGrid("IGrid", "Тест компонента IGrid"),
    IChart("IChart", "Тест компонента IChart"),
    IAxis("Chart.IAxis", "Тест компонента Chart.IAxis"),
    IBrowser("IBrowser", "Тест компонента IBrowser"),
    IClassesTree("IClassesTree", "Тест компонента Grid.IClassesTree"),
    IComponentTree("IComponentTree", "Тест компонента Grid.IComponentTree"),
    INode("INode", "Тест компонента Grid.INode"),
    IPopupMenu("IPopupMenu", "Тест компонента IPopupMenu"),
    IJSControlIE("IJSControl", "Тест компонента IJSControl"),
    IJSControlEdge("IJSControl (Edge)", "Тест компонента IJSControl");


    public final String formName;
    public final String title;

    // ! возврат data-testid обязателен, по нему происходят переходы по формам
    @Override
    public String toString() {
        return title;
    }

    ComCtrl(String formName, String title) {
        this.formName = formName;
        this.title = title;
    }

    public String getFormName() {
        return formName;
    }

}
