package com.example;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class Flower {
    private double sepallength;
    private double price;
    private FlowerSpecs specs;

    public Flower() {
    }

    public Flower(Flower flower) {
        sepallength = flower.sepallength;
        price = flower.price;
        specs = flower.getSpecs();
    }

    public Flower(double sepallength, double price, FlowerSpecs specs) {
        this.sepallength = sepallength;
        this.price = price;
        this.specs = specs;
    }

    public void setColor(FlowerColor color) {
        specs.setColor(color);
    }

    public void setType(FlowerType type) {
        specs.setType(type);
    }

    public FlowerColor getColor() {
        return specs.getColor();
    }

    public FlowerSpecs getSpecs() {
        return specs;
    }

    @Override
    public String toString() {
        return ("Flower [sepallength=" + sepallength
                + ", price="
                + price + ", color=" + specs.getColor()
                + ", type=" + specs.getType() + "]");
    }

}
