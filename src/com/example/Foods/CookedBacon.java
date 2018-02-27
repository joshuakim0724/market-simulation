package com.example.Foods;

import com.example.*;

public class CookedBacon implements Food {

    private String foodName = "Cooked Bacon";
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
