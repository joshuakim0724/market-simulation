package com.example.Recipes;

import com.example.*;
import com.example.Foods.*;
import com.example.Equipments.*;

import java.util.ArrayList;

public class GrilledCheeseRecipe implements Recipe {

    private String recipeName = "Grilled Cheese";
    private ArrayList<Food> ingredientList = new ArrayList<Food>();
    private ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();

    private double recipeValue = 4;
    private static final double MARKET_VALUE = .5;

    public GrilledCheeseRecipe() {
        Cheese cheese = new Cheese();
        Bread bread = new Bread();
        ingredientList.add(cheese);
        ingredientList.add(bread);

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
        Food grilledCheese = new GrilledCheese();
        return grilledCheese;
    }

    @Override
    public ArrayList<Equipment> equipmentList() {
        return equipmentList;
    }

    @Override
    public int timeRequired() {
        return 10;
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
