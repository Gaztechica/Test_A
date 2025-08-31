package ru.qa.property.components;

public enum Report {

    REPORT("Отчёты", "Отчёты");
    public final String formName;

    public final String title;

    @Override
    public String toString() {
        return formName;
    }

    Report(String formName, String title) {
        this.formName = formName;
        this.title = title;

    }

    public String getFormName() {
        return formName;
    }
}
