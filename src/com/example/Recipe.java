package com.example;

public class Recipe {

    private String recipeName;
    private String[] ingredientList;
    private String[] equipmentList;
    private Food outputFood;
    private int timeRequired;
    private double recipeValue;


    public String getRecipeName() {
        return recipeName;
    }
    /**
     * A list of food needed to create this recipe
     * @return a list of food needed to create this recipe
     */
    public String[] getIngredientList() {
        return ingredientList;
    }

    /**
     * @return the food that this recipe will create
     */
    public Food getOutputFood() {
        return outputFood;
    }

    /**
     * A list of equipment needed to create this recipe
     * @return a list of equipment needed to create this equipment
     */
    public String[] getEquipmentList() {
        return equipmentList;
    }

    /**
     * 1 == 1 minute
     * @return Time needed to create this recipe
     */
    public int getTimeRequired() {
        return timeRequired;
    }

    public double getRecipeValue() {
        return recipeValue;
    }

}
