package com.example.Recipes;

import com.example.*;
import com.example.Foods.*;
import com.example.Equipments.*;

import java.util.ArrayList;

public class HashBrownsRecipe implements Recipe {

    private String recipeName = "Hash Browns";
    private ArrayList<Food> ingredientList = new ArrayList<Food>();
    private ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();

    private double recipeValue = 3;
    private static final double MARKET_VALUE = .5;

    public HashBrownsRecipe() {
        Potato potato = new Potato();
        ingredientList.add(potato);

        Fryer fryer = new Fryer();
        equipmentList.add(fryer);
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
        Food hashBrowns = new HashBrowns();
        return hashBrowns;
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
