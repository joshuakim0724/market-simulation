package com.example.Foods;

import com.example.*;

public class BreakfastPotatoes implements Food {

    private String foodName = "Breakfast Potatoes";
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
        return ResturantMethods.roundNumber(marketValue);
    }
}
