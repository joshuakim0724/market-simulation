package com.example;

import java.lang.StringBuffer;

public class RestaurantMethods {

    private static final double NUMBER_MULTIPLIER = 100.0;
    private static final double SECOND_TO_LAST_VALUE = 2;

    /**
     * This will round a number to 2 decimal points
     * @param number that is going to be rounded
     * @return rounded number up to 2 decimal points
     */
    public static double roundNumber(double number) {
        return Math.round(number * NUMBER_MULTIPLIER) / NUMBER_MULTIPLIER;
    }

    /**
     * This will display a list of information about the food
     * (Name, Cost)
     * @param food which getting information from
     * @return StringBuffer of list of information about the food
     */
    public static StringBuffer getFoodInfo(Food food) {
        StringBuffer foodInfo = new StringBuffer();

        foodInfo.append(SimulationConstants.FOOD_NAME);
        foodInfo.append(food.getFoodName());
        foodInfo.append("\n");

        foodInfo.append(SimulationConstants.BASE_VALUE);
        foodInfo.append(food.getFoodValue());

        return foodInfo;
    }

    /**
     * This will display a list of information about the Equipment
     * (Name, cost, upkeep cost)
     * @param equipment which getting information from
     * @return StringBuffer of list of information about the equipment
     */
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

    /**
     * This will display a list of information about the recipe
     * (Name, cost, ingredients needed, equipment needed, time required, what it makes)
     * @param recipe which getting information from
     * @return StringBuffer of list of information about the recipe
     */
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
            if (j != recipe.getIngredientList().length - SECOND_TO_LAST_VALUE) {
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
