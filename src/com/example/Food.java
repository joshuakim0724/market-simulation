package com.example;

public class Food {

    private String foodName;
    private double foodValue;
    private double timeRequired;

    /**
     * @return name of food
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * @return this will return how much the food is worth
     */
    public double getFoodValue() {
        return foodValue;
    }

    /**
     * @return If the food has a cooking time, it will return it. Else its not declared
     */
    public double getTimeRequired() {
        return timeRequired;
    }
}
