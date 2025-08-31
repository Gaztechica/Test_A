package ru.qa.property.components;

public enum IGridExample {

    I_GRID_EXAMPLE("IGrid", "CanvasGrid"),
    I_GRID_EXAMPLE_TX_3907("IGrid (TX-3907)", "Тест компонента IGrid"),
    I_GRID_EXAMPLE_TX_4168("IGrid (TX-4168)", "IGrid (TX-4168) внутренняя форма"),
    I_GRID_EXAMPLE_TX_4168_1("IGrid (TX-4168)", "IGrid (TX-4168) внешняя форма");

    public final String formName;
    public final String title;

    /** ! возврат data-testid обязателен, по нему происходят переходы по формам  */
    @Override
    public String toString() {
        return title;
    }

    IGridExample(String formName, String title) {
        this.formName = formName;
        this.title = title;
    }
}

