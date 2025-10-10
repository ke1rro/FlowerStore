package com.example;

import com.example.Flower;

import lombok.Getter;

@Getter
public class FlowerPack {
    private Flower flower;
    private int count;

    public FlowerPack(Flower flower, int count) {
        this.flower = new Flower(flower);
        this.count = count;
    }

    public double getPrice() {
        return count * flower.getPrice();
    }

    @Override
    public String toString() {
        return flower.toString();
    }
}
