package ru.itmo.ebay.model;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.constraints.NotNull;

public class Filter {

    @JsonbProperty("fieldType")
    @NotNull
    private final FieldType fieldType;

    @JsonbProperty("value")
    private final String value;

    @JsonbCreator
    public Filter(FieldType fieldType, String value) {
        this.fieldType = fieldType;
        this.value = value;
    }

    public @NotNull FieldType getFieldType() {
        return fieldType;
    }

    public String getValue() {
        return value;
    }
}
