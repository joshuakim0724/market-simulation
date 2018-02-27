package com.example.Recipes;

import com.example.*;
import com.example.Foods.*;
import com.example.Equipments.*;

import java.util.ArrayList;

public class HashBrownsRecipe implements Recipe {

    private String recipeName = "Hash Browns";
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
        Food hashBrowns = new HashBrowns();
        return hashBrowns;
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
