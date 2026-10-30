package ar.soft.AT.API.models.workResource.request;

import com.fasterxml.jackson.annotation.JsonValue;

public enum LabourType {
    ITR("ITR"),
    WORKER("WORKER");

    private final String value;

    LabourType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}