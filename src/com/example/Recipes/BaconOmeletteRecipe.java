package com.example.Recipes;

import com.example.*;
import com.example.Foods.*;
import com.example.Equipments.*;

public class BaconOmeletteRecipe implements Recipe {

    private String recipeName = "Bacon Omelette";
    private String[] ingredientList = new String[1];
    private String[] equipmentList = new String[0];

    private double recipeValue = 5;
    private static final double MARKET_VALUE = .5;

    public BaconOmeletteRecipe() {
        ingredientList[0] = "bacon";
        ingredientList[1] = "Egg";

        equipmentList[0] = "Frying Pan";

    }

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
