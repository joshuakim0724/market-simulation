package com.example.Foods;

import com.example.*;

public class Potato implements FoodInterface {

    private String foodName = "Potato";
    private double foodValue = .25;
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
