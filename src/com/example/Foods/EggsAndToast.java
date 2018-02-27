package com.example.Foods;

import com.example.*;

public class EggsAndToast implements FoodInterface {

    private String foodName = "Eggs and Toast";
    private double foodValue = 5;
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
