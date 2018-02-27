package com.example.Recipes;

import com.example.*;
import com.example.Foods.*;

public class SpinachOmeletteRecipe implements Recipe {

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
        Food baconOmelette = new BaconOmelette();
        return baconOmelette;
    }

    @Override
    public String[] equipmentList() {
        return equipmentList;
    }

    @Override
    public int timeRequired() {
        return 15;
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
