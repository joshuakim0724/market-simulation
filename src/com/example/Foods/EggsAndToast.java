package com.example.Foods;

import com.example.*;

public class EggsAndToast implements Food {

    private String foodName = "Bacon";
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
        return ResturantMethods.roundNumber(marketValue);
    }
}
