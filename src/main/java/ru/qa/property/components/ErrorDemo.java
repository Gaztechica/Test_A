package ru.qa.property.components;

public enum ErrorDemo {

    FrameVisibility("FrameVisibility", "Видимость фрейма + перемещение по тексту(в таблице)");

    public final String formName;
    public final String title;

    // ! возврат data-testid обязателен, по нему происходят переходы по формам
    @Override
    public String toString() {
        return title;
    }

    ErrorDemo(String formName, String title) {
        this.formName = formName;
        this.title = title;
    }

    public String getFormName() {
        return formName;
    }
}
