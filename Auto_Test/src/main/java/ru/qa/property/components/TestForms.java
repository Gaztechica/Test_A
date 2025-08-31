package ru.qa.property.components;

public enum TestForms {
    REF_IN_PLACE_CARD("Картотека Ref с Inplace-редактированием", "Картотека Ref с Inplace-редактированием"),
    REF_CARD("Картотека Ref", "Картотека Ref");

    public final String formName;
    public final String title;

    @Override
    public String toString() {
        return formName;
    }

    TestForms(String formName,  String title) {
        this.formName = formName;
        this.title = title;

    }
    public String getFormName() {
        return formName;
    }
}
