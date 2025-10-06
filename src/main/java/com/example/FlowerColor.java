package com.example;

public enum FlowerColor {
    RED("#FF0000"),
    GREEN("#1cff00"),
    BLUE("#0019ff");

    private String hexColor;

    FlowerColor(String hexColor) {
        this.hexColor = hexColor;
    }

    public String toString() {
        return this.hexColor;
    }
}
