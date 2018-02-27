package com.example.Recipes;

import com.example.*;
import com.example.Foods.*;

public class SpinachOmeletteRecipe implements RecipeInterface {

    private String recipeName = "Bacon Omelette";
    private String[] ingredientList;
    private String[] equipmentList;

    private double recipeValue = 5;
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
//        Food baconOmelette = (Food) new BaconOmelette();
//        return baconOmelette;
        return null;
    }

    @Override
    public String[] equipmentList() {
        return equipmentList;
    }

    @Override
    public int getTimeRequired() {
        return 15;
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
