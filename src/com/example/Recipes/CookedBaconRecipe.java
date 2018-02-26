package com.example.Recipes;

import com.example.*;
import com.example.Foods.*;
import com.example.Equipments.*;

import java.util.ArrayList;

public class CookedBaconRecipe implements Recipe {

    private String recipeName = "Cooked Bacon";
    private ArrayList<Food> ingredientList = new ArrayList<Food>();
    private ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();

    private double recipeValue = 3;
    private static final double MARKET_VALUE = .5;

    public CookedBaconRecipe() {
        Bacon bacon = new Bacon();
        ingredientList.add(bacon);

        FryingPan fryingPan = new FryingPan();
        equipmentList.add(fryingPan);
    }

    @Override
    public String getRecipeName() {
        return recipeName;
    }

    @Override
    public ArrayList<Food> getIngredientList() {
        return ingredientList;
    }

    @Override
    public Food outputFood() {
        Food cookedBacon = new CookedBacon();
        return cookedBacon;
    }

    @Override
    public ArrayList<Equipment> equipmentList() {
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
