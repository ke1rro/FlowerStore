package com.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlowerSpecs {

    private FlowerColor color;
    private FlowerType type;

    public FlowerSpecs(FlowerColor color, FlowerType type) {
        this.color = color;
        this.type = type;
    }

    public boolean isMatch(FlowerSpecs other) {
        if (type != other.type) {
            return false;
        }
        if (color != other.color) {
            return false;
        }
        return true;
    }

}
