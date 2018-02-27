package com.example.Foods;

public interface FoodInterface {

    public String getFoodName();

    /**
     * @return this will return how much the food is worth
     */
    public double getFoodValue();

    /**
     * Food can also be sold at the market at 0.8x the base value
     * @return this will return how you will get it you sell the food for the market
     */
    public double sellToMarket();
}
