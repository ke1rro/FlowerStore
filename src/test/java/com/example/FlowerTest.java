
package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import org.junit.jupiter.api.Assertions;

public class FlowerTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;
    private Flower flower;

    @BeforeEach
    public void init() {
        FlowerSpecs specs = new FlowerSpecs(FlowerColor.RED, FlowerType.ROSE);
        flower = new Flower(10.0, 25.0, specs);
    }

    @Test
    public void testPrice() {
        double price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setPrice(price);
        Assertions.assertEquals(price, flower.getPrice(), 0.01);
    }

    @Test
    public void testColor() {
        FlowerColor expectedColor = FlowerColor.RED;
        FlowerColor actualColor = flower.getSpecs().getColor();
        Assertions.assertEquals(expectedColor, actualColor);
    }
}
