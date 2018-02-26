package com.example.Foods;

import com.example.*;

public class Potato implements Food {
    private String foodName = "Potato";
    private double foodValue = .25;

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
