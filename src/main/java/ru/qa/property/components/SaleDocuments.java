package ru.qa.property.components;

public enum SaleDocuments {

    ORDER("Накладные", "Накладные");
    public final String formName;

    public final String title;

    @Override
    public String toString() {
        return formName;
    }

    SaleDocuments(String formName, String title) {
        this.formName = formName;
        this.title = title;

    }

    public String getFormName() {
        return formName;
    }
}
