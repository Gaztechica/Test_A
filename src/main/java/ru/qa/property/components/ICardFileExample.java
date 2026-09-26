package ru.qa.property.components;

public enum ICardFileExample {

    I_CARD_FILE_EXAMPLE("CardFile", "Пример для автотестирования картотеки");

    public final String formName;
    public final String title;

    /** ! возврат data-testid обязателен, по нему происходят переходы по формам  */
    @Override
    public String toString() {
        return title;
    }

    ICardFileExample(String formName, String title) {
        this.formName = formName;
        this.title = title;
    }
}
