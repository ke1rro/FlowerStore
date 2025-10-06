package com.example;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter @Setter @AllArgsConstructor
public class Flower {
    private double sepallength;
    private double price;
    private FlowerColor color;
    private FlowerType type;
}
