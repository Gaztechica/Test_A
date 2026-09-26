package ru.qa.property.components;

public enum ICardFileDemo {

    ICardFileWithDifferentTypesOfFields("ICardFileWithDifferentTypesOfFields",
            "Тест картотеки с различными типами полей");

    public final String formName;
    public final String title;

    @Override
    public String toString() {
        return title;
    }

    ICardFileDemo(String formName, String title) {
        this.formName = formName;
        this.title = title;
    }

    public String getFormName() {
        return formName;
    }
}
