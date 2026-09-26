package ru.qa.property.components;

/**
 * @author Slava Solodov
 * @created 07/08/2023 - 10:27
 * @email vsolodov@cbgr.ru
 */

public enum TaskAndPerformers {

    TASK_GENERATOR("Генератор заданий", "Генератор заданий"),
    STORED_TASKS("Хранимые задания", "Хранимые задания");

    public final String formName;
    public final String title;

    // ! возврат data-testid обязателен, по нему происходят переходы по формам
    @Override
    public String toString() {
        return title;
    }

    TaskAndPerformers(String formName, String title) {
        this.formName = formName;
        this.title = title;
    }

    public String getFormName() {
        return formName;
    }
}
