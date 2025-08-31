package ru.qa.property.components;

public enum AutotestIFormExample {

    KeepMount("KeepMount", "KeepMount");

    public final String formName;
    public final String title;

    @Override
    public String toString() {
        return title;
    }

    AutotestIFormExample(String formName, String title) {
        this.formName = formName;
        this.title = title;
    }

    public String getFormName() {
        return formName;
    }
}
