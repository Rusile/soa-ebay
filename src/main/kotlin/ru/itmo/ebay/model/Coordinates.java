package ru.itmo.ebay.model;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

public class Coordinates {
    private double x; // Поле не может быть null
    private double y; // Значение поля должно быть больше -110, Поле не может быть null

    @JsonbCreator
    public Coordinates(@JsonbProperty("x") double x, @JsonbProperty("y") double y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

