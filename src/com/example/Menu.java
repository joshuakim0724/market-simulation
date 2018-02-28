package com.example;

import java.lang.StringBuffer;
import java.util.ArrayList;
import java.util.Arrays;

public class Menu {
    private Food[] foodList;
    private ArrayList<Food> foodAvailableList = new ArrayList<Food>();

    private static final double SALE_MULTIPLIER = 1.5;

    public double customerSales(double chance) {
        double amountMade = 0;
        int numberSold = (int) Math.ceil((Math.random() * chance));

        while (numberSold > 0) {
            int itemSoldIndex = (int)(Math.random() * foodAvailableList.size() - 1);
            Food food = foodAvailableList.get(itemSoldIndex);
            amountMade += sellFood(food);

            numberSold --;
        }
        return amountMade;
    }

    public double sellFood(Food food) {
        if (!isValidFood(food)) {
            return -1; //Returns -1 if you can't sell the food
        }
        double foodBaseValue = food.getFoodValue();

        foodAvailableList.remove(food);

        return foodBaseValue * SALE_MULTIPLIER;
    }

    public boolean isValidFood(Food food) {
        if (food == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_FOOD);
        }

        String foodName = food.getFoodName();
        double foodValue = food.getFoodValue();

        for (Food aFoodAvailable : foodAvailableList) {
            String foodListName = aFoodAvailable.getFoodName();
            double foodListValue = aFoodAvailable.getFoodValue();

            if (foodName.equalsIgnoreCase(foodListName) && foodValue == foodListValue) {
                return true;
            }
        }
        return false;
    }

    public boolean addItem(Food food) {
        foodAvailableList.add(food);

        return true;
    }

    public boolean removeItem(Food food) {
        if (foodAvailableList.remove(food)) {
            return true;
        }
        return false;
    }

    public StringBuffer menuOutput() {
        StringBuffer menuOutput = new StringBuffer();
        menuOutput.append("Menu: \n");
        for (Food aFoodAvailable : foodAvailableList) {
            menuOutput.append(aFoodAvailable.getFoodName());

            double foodValue = aFoodAvailable.getFoodValue() * SALE_MULTIPLIER;
            foodValue = RestaurantMethods.roundNumber(foodValue);

            menuOutput.append(SimulationConstants.SALE_COST);
            menuOutput.append(foodValue);
            menuOutput.append("\n");
        }
        return menuOutput;
    }

    public int uniqueFood() {
        ArrayList<String> uniqueFood = new ArrayList<>();
        int uniqueItems = 0;

        for (Food aFoodAvailableList : foodAvailableList) {
            String foodName = aFoodAvailableList.getFoodName();
            if (!uniqueFood.contains(foodName)) {
                uniqueFood.add(foodName);
                uniqueItems++;
            }
        }
        return uniqueItems;
    }

    public double getComplexity() {
        double totalTime = 0;

        for (Food aFoodAvailableList : foodAvailableList) {
             totalTime += aFoodAvailableList.getTimeRequired();
        }
        return totalTime;
    }

    public double getPopularity() {
        double complexity = getComplexity();
        int uniqueItems = uniqueFood();

        return Math.ceil((complexity + uniqueItems) / 10);
    }
}
