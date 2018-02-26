package com.example.Foods;

import com.example.*;

public class Bread implements Food {

    private String foodName = "Bread";
    private double foodValue = .50;
    private static final double MARKET_VALUE = .8;


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
        double marketValue = foodValue * MARKET_VALUE;
        return ResturantMethods.roundNumber(marketValue);
    }
}
