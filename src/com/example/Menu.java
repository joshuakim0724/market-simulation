package com.example;

import java.lang.StringBuffer;
import java.util.ArrayList;
import java.util.Arrays;

public class Menu {

    private Food[] foodAvailable;
    private ArrayList<Food> foodAvailableList;

    private static final double SALE_MULTIPLIER = 1.5;

    public double sellFood(Food food) {
        if (!isValidFood(food)) {
            return -1; //Returns -1 if you can't sell the food
        }
        double foodBaseValue = food.getFoodValue();

        foodAvailableList = new ArrayList<Food>(Arrays.asList(foodAvailable));
        foodAvailableList.remove(food);
        foodAvailable = foodAvailableList.toArray(new Food[foodAvailableList.size()]);

        return foodBaseValue * 1.5;
    }

    public boolean isValidFood(Food food) {
        if (food == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_FOOD);
        }

        String foodName = food.getFoodName();
        double foodValue = food.getFoodValue();

        for (Food aFoodAvailable : foodAvailable) {
            String foodListName = aFoodAvailable.getFoodName();
            double foodListValue = aFoodAvailable.getFoodValue();

            if (foodName.equalsIgnoreCase(foodListName) && foodValue == foodListValue) {
                return true;
            }
        }
        return false;
    }

    public boolean addItem(Food food) {
        foodAvailableList = new ArrayList<Food>(Arrays.asList(foodAvailable));
        foodAvailableList.add(food);
        foodAvailable = foodAvailableList.toArray(new Food[foodAvailableList.size()]);

        return true;
    }

    public boolean removeItem(Food food) {
        foodAvailableList = new ArrayList<Food>(Arrays.asList(foodAvailable));
        if (foodAvailableList.remove(food)) {
            return true;
        }
        foodAvailable = foodAvailableList.toArray(new Food[foodAvailableList.size()]);
        return false;
    }

    public StringBuffer menuOutput() {
        StringBuffer menuOutput = new StringBuffer();

        for (Food aFoodAvailable : foodAvailable) {
            menuOutput.append(aFoodAvailable.getFoodName());

            double foodValue = aFoodAvailable.getFoodValue() * SALE_MULTIPLIER;
            foodValue = RestaurantMethods.roundNumber(foodValue);

            menuOutput.append(SimulationConstants.SALE_COST);
            menuOutput.append(foodValue);
            menuOutput.append("\n");
        }
        return menuOutput;
    }
}
