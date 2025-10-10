package com.example;

public class App {
    public static void main(String[] args) {
        Flower tulip = new Flower(190, 12, FlowerColor.GREEN, FlowerType.TULIP);
        FlowerPack tulips = new FlowerPack(tulip, 4);

        System.out.println(tulips.toString());
    }
}
