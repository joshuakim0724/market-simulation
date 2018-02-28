package com.example;

public class Food {

    private String foodName;
    private double foodValue;
    private double timeRequired;

    public String getFoodName() {
        return foodName;
    }

    /**
     * @return this will return how much the food is worth
     */
    public double getFoodValue() {
        return foodValue;
    }

    public double getTimeRequired() {
        return timeRequired;
    }
}
