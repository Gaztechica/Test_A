package ar.soft.AT.API.models.workResource.request;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ResourceType {
    LABOUR("LABOUR"),
    MECHANISM("MECHANISM");

    private final String value;

    ResourceType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}