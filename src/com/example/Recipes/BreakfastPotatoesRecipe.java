package com.example.Recipes;

import com.example.*;
import com.example.Foods.*;
import com.example.Equipments.*;

import java.util.ArrayList;

public class BreakfastPotatoesRecipe implements Recipe {

    private String recipeName = "Breakfast Potatoes";
    private ArrayList<Food> ingredientList = new ArrayList<Food>();
    private ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();

    private double recipeValue = 3;
    private static final double MARKET_VALUE = .5;

    public BreakfastPotatoesRecipe() {
        Potato potato = new Potato();
        ingredientList.add(potato);

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
        Food breakfastPotatoes = new BreakfastPotatoes();
        return breakfastPotatoes;
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
