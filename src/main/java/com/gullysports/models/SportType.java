package com.gullysports.models;

public enum SportType {

    // Game played within house or buiding.
    INDOOR("indoor"),

    // Game played outside.
    OUTDOOR("outdoor");

    @Override
    public String toString() {
        return value;
    }

    private final String value;

    SportType(String value) {
        this.value = value;
    }
}
