package com.example;

import java.util.ArrayList;

public interface Recipe {

    public String getRecipeName();
    /**
     * A list of food needed to create this recipe
     * @return a list of food needed to create this recipe
     */
    public ArrayList<Food> getIngredientList();

    /**
     * @return the food that this recipe will create
     */
    public Food outputFood();

    /**
     * A list of equipment needed to create this recipe
     * @return a list of equipment needed to create this equipment
     */
    public ArrayList<Equipment> equipmentList();

    /**
     * 1 == 1 minute
     * @return Time needed to create this recipe
     */
    public int timeRequired();

    public double recipePrice();

    /**
     * Recipes can also be sold at the market at 0.5x the base value
     * @return this will return how you will get it you sell the recipe for the market
     */
    public double sellToMarket();

}
