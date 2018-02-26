package com.example.Foods;

import com.example.*;

public class Egg implements Food {
    private String foodName = "Egg";
    private double foodValue = .10;

    @Override
    public String getFoodName() {
        return foodName;
    }

    @Override
    public double getFoodValue() {
        return foodValue;
    }

    @Override
    public double sellToMarket() {
        double marketValue = foodValue * .8;
        return ResturantMethods.roundNumber(marketValue);
    }
}
