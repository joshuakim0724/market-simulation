package com.example;

import java.lang.StringBuffer;

public class RestaurantMethods {

    public static double roundNumber(double number) {
        return Math.round(number*100.0)/100.0;
    }

    public static StringBuffer getFoodInfo(Food food) {
        StringBuffer foodInfo = new StringBuffer();

        foodInfo.append(SimulationConstants.FOOD_NAME);
        foodInfo.append(food.getFoodName());
        foodInfo.append("\n");

        foodInfo.append(SimulationConstants.BASE_VALUE);
        foodInfo.append(food.getFoodValue());

        return foodInfo;
    }

    public static StringBuffer getEquipmentInfo(Equipment equipment) {
        StringBuffer equipmentInfo = new StringBuffer();

        equipmentInfo.append(SimulationConstants.EQUIPMENT_NAME);
        equipmentInfo.append(equipment.getEquipmentName());
        equipmentInfo.append("\n");

        equipmentInfo.append(SimulationConstants.BASE_VALUE);
        equipmentInfo.append(equipment.getEquipmentValue());
        equipmentInfo.append("\n");

        equipmentInfo.append(SimulationConstants.UPKEEP_VALUE);
        equipmentInfo.append(equipment.getUpkeepValue());

        return equipmentInfo;
    }

    public static StringBuffer getRecipeInfo(Recipe recipe) {
        StringBuffer recipeInfo = new StringBuffer();

        recipeInfo.append(SimulationConstants.RECIPE_NAME);
        recipeInfo.append(recipe.getRecipeName());
        recipeInfo.append("\n");

        recipeInfo.append(SimulationConstants.BASE_VALUE);
        recipeInfo.append(recipe.getRecipeValue());
        recipeInfo.append("\n");

        recipeInfo.append(SimulationConstants.FOOD_NEEDED);
        for (int i = 0; i < recipe.getIngredientList().length; i ++) {
            String foodName = recipe.getIngredientList()[i];
            recipeInfo.append(foodName);
            if (i != recipe.getIngredientList().length - 2) {
                recipeInfo.append(", ");
            }
        }
        recipeInfo.append("\n");

        recipeInfo.append(SimulationConstants.EQUIPMENT_NEEDED);
        for (int j = 0; j < recipe.getEquipmentList().length; j ++) {
            String equipmentName = recipe.getEquipmentList()[j];
            recipeInfo.append(equipmentName);
            if (j != recipe.getIngredientList().length - 2) {
                recipeInfo.append(", ");
            }
        }
        recipeInfo.append("\n");

        recipeInfo.append(SimulationConstants.TIME_REQUIRED);
        recipeInfo.append(recipe.getTimeRequired());
        recipeInfo.append("\n");

        recipeInfo.append(SimulationConstants.RECIPE_MAKES);
        recipeInfo.append(recipe.getOutputFood().getFoodName());

        return recipeInfo;
    }
}
