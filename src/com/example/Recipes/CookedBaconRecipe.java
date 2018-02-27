package com.example.Recipes;

import com.example.*;
import com.example.Foods.*;

public class CookedBaconRecipe implements Recipe {

    private String recipeName = "Cooked Bacon";
    private String[] ingredientList;
    private String[] equipmentList;

    private double recipeValue = 3;
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
        Food cookedBacon = new CookedBacon();
        return cookedBacon;
    }

    @Override
    public String[] equipmentList() {
        return equipmentList;
    }

    @Override
    public int timeRequired() {
        return 5;
    }

    @Override
    public double recipePrice() {
        return recipeValue;
    }

    @Override
    public double sellToMarket() {
        double marketValue = recipeValue * MARKET_VALUE;
        return ResturantMethods.roundNumber(marketValue);
    }
}
