package com.example.Recipes;

import com.example.*;
import com.example.Foods.*;
import com.example.Equipments.*;

import java.util.ArrayList;

public class SpinachOmeletteRecipe implements Recipe {

    private String recipeName = "Bacon Omelette";
    private ArrayList<Food> ingredientList = new ArrayList<Food>();
    private ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();

    private double recipeValue = 5;
    private static final double MARKET_VALUE = .5;

    public SpinachOmeletteRecipe() {
        Spinach spinach = new Spinach();
        Egg egg = new Egg();
        ingredientList.add(spinach);
        ingredientList.add(egg);

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
        Food baconOmelette = new BaconOmelette();
        return baconOmelette;
    }

    @Override
    public ArrayList<Equipment> equipmentList() {
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
