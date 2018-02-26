package com.example.Recipes;

import com.example.*;
import com.example.Foods.*;
import com.example.Equipments.*;

import java.util.ArrayList;

public class EggsAndToastRecipe implements Recipe {

    private String recipeName = "Eggs and Toast";
    private ArrayList<Food> ingredientList = new ArrayList<Food>();
    private ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();

    private double recipeValue = 5;
    private static final double MARKET_VALUE = .5;

    public EggsAndToastRecipe() {
        Egg egg = new Egg();
        Bread bread = new Bread();
        ingredientList.add(egg);
        ingredientList.add(bread);

        FryingPan fryingPan = new FryingPan();
        Toaster toaster = new Toaster();
        equipmentList.add(fryingPan);
        equipmentList.add(toaster);
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
        Food eggsAndToast = new EggsAndToast();
        return eggsAndToast;
    }

    @Override
    public ArrayList<Equipment> equipmentList() {
        return equipmentList;
    }

    @Override
    public int timeRequired() {
        return 12;
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
