package com.example.Foods;

import com.example.*;

public class SpinachOmelette implements FoodInterface {

    private String foodName = "Spinach Omeltte";
    private double foodValue = 7;
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
        return RestaurantMethods.roundNumber(marketValue);
    }
}
