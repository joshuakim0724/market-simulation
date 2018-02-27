package com.example;

import java.lang.StringBuffer;
import java.util.ArrayList;
import java.util.Collections;

public class Market {

    private Food[] foodAvailable;
    private Equipment[] equipmentAvailable;
    private Recipe[] recipeAvailable;

    public Food[] getFoodAvailable() {
        return foodAvailable;
    }

    public Equipment[] getEquipmentAvailable() {
        return equipmentAvailable;
    }

    public Recipe[] getRecipeAvailable() {
        return recipeAvailable;
    }


    public StringBuffer foodAvailableOutput() {
        StringBuffer foodOutput = new StringBuffer();
        if (foodAvailable.length == 0) {
            foodOutput.append("Has no food");
            return foodOutput;
        }
        for (Food aFoodAvailable : foodAvailable) {
            foodOutput.append(aFoodAvailable.getFoodName());
            foodOutput.append(SimulationConstants.COST);
            foodOutput.append(aFoodAvailable.getFoodValue());
            foodOutput.append("\n");
        }
        return foodOutput;
    }

    public StringBuffer equipmentAvailableOutput() {
        StringBuffer equipmentOutput = new StringBuffer();
        if (equipmentAvailable.length == 0) {
            equipmentOutput.append("Has no equipment");
            return equipmentOutput;
        }
        for (Equipment aEquipmentAvailable : equipmentAvailable) {
            equipmentOutput.append(aEquipmentAvailable.getEquipmentName());
            equipmentOutput.append(SimulationConstants.COST);
            equipmentOutput.append(aEquipmentAvailable.getEquipmentValue());
            equipmentOutput.append("\n");
        }
        return equipmentOutput;
    }

    public StringBuffer recipeAvailableOutput() {
        StringBuffer recipeOutput = new StringBuffer();
        if (recipeAvailable.length == 0) {
            recipeOutput.append("Has no recipe");
            return recipeOutput;
        }

        for (Recipe aRecipeAvailable : recipeAvailable) {
            recipeOutput.append(aRecipeAvailable.getRecipeName());
            recipeOutput.append(SimulationConstants.COST);
            recipeOutput.append(aRecipeAvailable.getRecipeValue());
            recipeOutput.append("\n");
        }
        return recipeOutput;
    }

    public boolean isFood(String input) {
        for (Food aFoodAvailable : foodAvailable) {
            String foodName = aFoodAvailable.getFoodName();
            if (input.equalsIgnoreCase(foodName)) {
                return true;
            }
        }
        return false;
    }

    public Food getFood(String input) {
        for (Food aFoodAvailable : foodAvailable) {
            String foodName = aFoodAvailable.getFoodName();
            if (input.equalsIgnoreCase(foodName)) {
                return aFoodAvailable;
            }
        }
        return null;
    }

    public boolean isEquipment(String input) {
        for (Equipment aEquipmentAvailable : equipmentAvailable) {
            String equipmentName = aEquipmentAvailable.getEquipmentName();
            if (input.equalsIgnoreCase(equipmentName)) {
                return true;
            }
        }
        return false;
    }

    public Equipment getEquipment(String input) {
        for (Equipment aEquipmentAvailable : equipmentAvailable) {
            String equipmentName = aEquipmentAvailable.getEquipmentName();
            if (input.equalsIgnoreCase(equipmentName)) {
                return aEquipmentAvailable;
            }
        }
        return null;
    }

    public boolean isRecipe(String input) {
        for (Recipe aRecipeAvailable : recipeAvailable) {
            String recipeName = aRecipeAvailable.getRecipeName();
            if (input.equalsIgnoreCase(recipeName)) {
                return true;
            }
        }
        return false;
    }

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
