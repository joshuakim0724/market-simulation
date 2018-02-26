package com.example.Foods;

import com.example.*;

public class Bread implements Food {

    private String foodName = "Bread";
    private double foodValue = .50;

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
