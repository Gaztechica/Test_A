package ru.qa.property.components;

public enum OrderFile {

    ORDER_FILE("Картотека поручений", "Картотека поручений");
    public final String formName;

    public final String title;

    @Override
    public String toString() {
        return formName;
    }

    OrderFile(String formName,  String title) {
        this.formName = formName;
        this.title = title;

    }

    public String getFormName() {
        return formName;
    }
}
