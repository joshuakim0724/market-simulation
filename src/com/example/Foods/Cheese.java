package com.example.Foods;

import com.example.*;

public class Cheese implements Food {

    private String foodName = "Cheese";
    private double foodValue = .15;

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
