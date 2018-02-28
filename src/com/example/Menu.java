package com.example;

import java.lang.StringBuffer;
import java.util.ArrayList;

public class Menu {
    private ArrayList<Food> foodAvailableList = new ArrayList<Food>();

    private static final double SALE_MULTIPLIER = 1.5;
    private static final double POPULARITY_DIVIDER = 5;

    /**
     * This will sell items from ur restaurant based off chance
     * Will always sell the first item on the menu first
     * @param chance is value that is created from restaurant popularity
     * @return Total amount of money made
     */
    public double customerSales(double chance) {
        double amountMade = 0;
        int numberSold = (int)(Math.random() * chance);

        while (numberSold > 0) {
            Food food = foodAvailableList.get(0);
            amountMade += sellFood(food);

            numberSold --;
        }
        return amountMade;
    }

    /**
     * This method is a helper method. Used to sell food from menu
     * @param food is what food you are selling from menu
     * @return How much food was sold for, or -1 if not a valid food input
     */
    public double sellFood(Food food) {
        if (!isValidFood(food)) {
            return -1; //Returns -1 if you can't sell the food
        }
        double foodBaseValue = food.getFoodValue();

        foodAvailableList.remove(food);

        return foodBaseValue * SALE_MULTIPLIER;
    }

    /**
     * This method is a helper method for sellFood. Used to make sure it is a valid food
     * @param food is what you are checking is in the Menu
     * @return true if it is a valid food, false otherwise
     */
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

    /**
     * Will add food to the foodArrayList
     * @param food is being added to the array
     * @return true just for testing purposes
     */
    public boolean addItem(Food food) {
        if (food == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_FOOD);
        }
        foodAvailableList.add(food);

        return true;
    }

    /**
     * Will remove food from the foodArrayList
     * @param food is being removed from the array
     * @return true if you can move the item, false if you can't
     */
    public boolean removeItem(Food food) {
        if (foodAvailableList.remove(food)) {
            return true;
        }
        return false;
    }

    /**
     * This method displays what foods are available and the cost of them
     * @return a StringBuffer of menuOutput
     */
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

    /**
     * This will get the popularity of the restaurant which is gotten by the formula
     * (Complexity + Number of Unique Items) / 10 (Which is rounded up)
     * @return popularity value
     */
    public double getPopularity() {
        double complexity = getComplexity();
        int uniqueItems = uniqueFood();

        return Math.ceil((complexity + uniqueItems) / POPULARITY_DIVIDER);
    }

    /**
     * This is a helper method for getPopularity
     * @return number of uniqueFood in the menu
     */
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

    /**
     * This is a helper method for get Popularity
     * @return total time it took to create all foods in the menu
     */
    public double getComplexity() {
        double totalTime = 0;

        for (Food aFoodAvailableList : foodAvailableList) {
             totalTime += aFoodAvailableList.getTimeRequired();
        }
        return totalTime;
    }
}
