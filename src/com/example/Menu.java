package com.example;

import java.lang.StringBuffer;
import java.util.ArrayList;
import java.util.Arrays;

public class Menu {

    private Food[] foodAvailable;
    private ArrayList<Food> fooodAvailableList;

    public double sellFood(Food food) {
        if (!isValidFood(food)) {
            return -1; //Returns -1 if you can't sell the food
        }
        double foodBaseValue = food.getFoodValue();

        fooodAvailableList = new ArrayList<Food>(Arrays.asList(foodAvailable));
        fooodAvailableList.remove(food);
        foodAvailable = fooodAvailableList.toArray(new Food[fooodAvailableList.size()]);

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

    public StringBuffer printFoodAvailable() {
        StringBuffer menuOutput = new StringBuffer();

        for (Food aFoodAvailable : foodAvailable) {
            menuOutput.append(aFoodAvailable.getFoodName());
            menuOutput.append("\n");
        }
        return menuOutput;
    }
}
