package com.example.Recipes;

import com.example.*;
import com.example.Foods.*;

public class GrilledCheeseRecipe implements Recipe {

    private String recipeName = "Grilled Cheese";
    private String[] ingredientList;
    private String[] equipmentList;

    private double recipeValue = 4;
    private static final double MARKET_VALUE = .5;

    @Override
    public String getRecipeName() {
        return recipeName;
    }

    @Override
    public String[] getIngredientList() {
        return ingredientList;
    }

    @Override
    public Food outputFood() {
        Food grilledCheese = new GrilledCheese();
        return grilledCheese;
    }

    @Override
    public String[] equipmentList() {
        return equipmentList;
    }

    @Override
    public int getTimeRequired() {
        return 10;
    }

    @Override
    public double getRecipeValue() {
        return recipeValue;
    }

    @Override
    public double sellToMarket() {
        double marketValue = recipeValue * MARKET_VALUE;
        return RestaurantMethods.roundNumber(marketValue);
    }
}
