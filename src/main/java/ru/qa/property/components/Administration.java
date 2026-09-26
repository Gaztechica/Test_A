package ru.qa.property.components;

public enum Administration {
    UserRole("Роли доступа", "Роли доступа");

    public final String formName;
    public final String title;

    @Override
    public String toString() {
        return title;
    }

    Administration(String formName, String title) {
        this.formName = formName;
        this.title = title;
    }

    public String getFormName() {
        return formName;
    }
}
