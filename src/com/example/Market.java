package com.example;

import java.lang.StringBuffer;

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

        for (Equipment aEquipmentAvailable : equipmentAvailable) {
            equipmentOutput.append(aEquipmentAvailable.getEquipmentName());
            equipmentOutput.append(SimulationConstants.COST);
            equipmentOutput.append(aEquipmentAvailable.getEquipmentValue());
            equipmentOutput.append("\n");
        }
        return equipmentOutput;
    }

    public StringBuffer recipeAvilable() {
        StringBuffer recipeOutput = new StringBuffer();

        for (Recipe aRecipeAvailable : recipeAvailable) {
            recipeOutput.append(aRecipeAvailable.getRecipeName());
            recipeOutput.append(SimulationConstants.COST);
            recipeOutput.append(aRecipeAvailable.getRecipeValue());
            recipeOutput.append("\n");
        }
        return recipeOutput;
    }
}
