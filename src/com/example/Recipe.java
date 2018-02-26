package com.example;

public interface Recipe {

    public String getRecipeName();
    /**
     * A list of food needed to create this recipe
     * @return a list of food needed to create this recipe
     */
    public Food[] getIngreidentList();

    /**
     * @return the food that this recipe will create
     */
    public Food outputFood();

    /**
     * A list of equipment needed to create this recipe
     * @return a list of equipment needed to create this equipment
     */
    public Equipment[] equipmentList();

    /**
     * 1 == 1 minute
     * @return Time needed to create this recipe
     */
    public int timeRequired();

    /**
     * Recipes can also be sold at the market at 0.5x the base value
     * @return this will return how you will get it you sell the recipe for the market
     */
    public double sellToMarket();

}
