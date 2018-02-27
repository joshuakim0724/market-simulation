package com.example.Foods;

import com.example.*;

public class HashBrowns implements FoodInterface {

    private String foodName = "Hash Browns";
    private double foodValue = 3;
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
