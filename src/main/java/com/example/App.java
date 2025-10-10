package com.example;

public class App {
    public static void main(String[] args) {
        FlowerSpecs tulipSpecs = new FlowerSpecs(FlowerColor.GREEN, FlowerType.TULIP);
        Flower tulip = new Flower(190.0, 12.0, tulipSpecs);
        FlowerPack tulips = new FlowerPack(tulip, 4);
        System.out.println(tulips.toString());
    }
}
