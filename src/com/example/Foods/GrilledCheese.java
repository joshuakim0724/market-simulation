package com.example.Foods;

import com.example.*;

public class GrilledCheese implements FoodInterface {

    private String foodName = "Grilled Cheese";
    private double foodValue = 4;
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
