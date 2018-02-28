package com.example;

import java.lang.StringBuffer;
import java.util.ArrayList;
import java.util.Collections;

public class Market {

    private Food[] foodAvailable;
    private Equipment[] equipmentAvailable;
    private Recipe[] recipeAvailable;

    //Getters

    public Food[] getFoodAvailable() {
        return foodAvailable;
    }

    public Equipment[] getEquipmentAvailable() {
        return equipmentAvailable;
    }

    public Recipe[] getRecipeAvailable() {
        return recipeAvailable;
    }

    /**
     * This method is used to get of list of available foods
     * @return a StringBuffer of all the foods you can buy and their cost
     */
    public StringBuffer foodAvailableOutput() {
        StringBuffer foodOutput = new StringBuffer();

        for (Food aFoodAvailable : foodAvailable) {
            foodOutput.append(aFoodAvailable.getFoodName());
            foodOutput.append(SimulationConstants.COST);
            foodOutput.append(aFoodAvailable.getFoodValue());
            foodOutput.append("\n");
        }
        return foodOutput;
    }

    /**
     * This method is used to get of list of available equipment
     * @return a StringBuffer of all the equipment you can buy and their cost
     */
    public StringBuffer equipmentAvailableOutput() {
        StringBuffer equipmentOutput = new StringBuffer();

        for (Equipment aEquipmentAvailable : equipmentAvailable) {
            equipmentOutput.append(aEquipmentAvailable.getEquipmentName());
            equipmentOutput.append(SimulationConstants.COST);
            equipmentOutput.append(aEquipmentAvailable.getEquipmentValue());
            equipmentOutput.append("\n");
        }
        return equipmentOutput;
    }

    /**
     * This method is used to get of list of available recipes
     * @return a StringBuffer of all the recipes you can buy and their cost
     */
    public StringBuffer recipeAvailableOutput() {
        StringBuffer recipeOutput = new StringBuffer();

        for (Recipe aRecipeAvailable : recipeAvailable) {
            recipeOutput.append(aRecipeAvailable.getRecipeName());
            recipeOutput.append(SimulationConstants.COST);
            recipeOutput.append(aRecipeAvailable.getRecipeValue());
            recipeOutput.append("\n");
        }
        return recipeOutput;
    }

    /**
     * Checks to see if the string is a food object
     * @param input String that is being tested if it is a food
     * @return true if it is a food, false if not
     */
    public boolean isFood(String input) {
        for (Food aFoodAvailable : foodAvailable) {
            String foodName = aFoodAvailable.getFoodName();
            if (input.equalsIgnoreCase(foodName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Will get a food from the String input. Used in conjunction with isFood
     * @param input Food Name that you are getting the food object for
     * @return Food object called by reference of input, null if not found
     */
    public Food getFood(String input) {
        for (Food aFoodAvailable : foodAvailable) {
            String foodName = aFoodAvailable.getFoodName();
            if (input.equalsIgnoreCase(foodName)) {
                return aFoodAvailable;
            }
        }
        return null;
    }

    /**
     * Checks to see if the string is a equipment object
     * @param input String that is being tested if it is a equipment
     * @return true if it is a equipment, false if not
     */
    public boolean isEquipment(String input) {
        for (Equipment aEquipmentAvailable : equipmentAvailable) {
            String equipmentName = aEquipmentAvailable.getEquipmentName();
            if (input.equalsIgnoreCase(equipmentName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Will get a Equipment from the String input. Used in conjunction with isEquipment
     * @param input Equipment Name that you are getting the Equipment object for
     * @return Equipment object called by reference of input, null if not found
     */
    public Equipment getEquipment(String input) {
        for (Equipment aEquipmentAvailable : equipmentAvailable) {
            String equipmentName = aEquipmentAvailable.getEquipmentName();
            if (input.equalsIgnoreCase(equipmentName)) {
                return aEquipmentAvailable;
            }
        }
        return null;
    }

    /**
     * Checks to see if the string is a recipe object
     * @param input String that is being tested if it is a recipe
     * @return true if it is a recipe, false if not
     */
    public boolean isRecipe(String input) {
        for (Recipe aRecipeAvailable : recipeAvailable) {
            String recipeName = aRecipeAvailable.getRecipeName();
            if (input.equalsIgnoreCase(recipeName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Will get a Recipe from the String input. Used in conjunction with isRecipe
     * @param input Recipe Name that you are getting the Recipe object for
     * @return Recipe object called by reference of input, null if not found
     */
    public Recipe getRecipe(String input) {
        for (Recipe aRecipeAvailable : recipeAvailable) {
            String recipeName = aRecipeAvailable.getRecipeName();
            if (input.equalsIgnoreCase(recipeName)) {
                return aRecipeAvailable;
            }
        }
        return null;
    }
}
