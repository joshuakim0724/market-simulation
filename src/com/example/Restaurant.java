package com.example;
import java.lang.StringBuffer;
import java.util.ArrayList;
import java.util.Arrays;

public class Restaurant {

    private Market market;
    private Menu menu;
    private Time time;
    private double money;

    private Food[] foodOwned;
    private Equipment[] equipmentOwned;
    private Recipe[] recipeOwned;

    private ArrayList<Food> foodArray;
    private ArrayList<Recipe> recipeArray;


    public Market getMarket() {
        return market;
    }

    public Menu getMenu() {
        return menu;
    }

    public Time getTime() {
        return time;
    }

    public double getMoney() {
        return money;
    }

    public Food[] getFoodOwned() {
        return foodOwned;
    }

    public Equipment[] getEquipmentOwned() {
        return equipmentOwned;
    }

    public Recipe[] getRecipeOwned() {
        return recipeOwned;
    }

    public StringBuffer displayMoney() {
        StringBuffer moneyOutput = new StringBuffer();
        moneyOutput.append(SimulationConstants.RESTAURANT_HAS);
        moneyOutput.append(money);

        return moneyOutput;
    }

    public StringBuffer displayFoodInventory() {
        StringBuffer inventory = new StringBuffer();

        inventory.append(SimulationConstants.FOOD);
        inventory.append("\n");
        for (Food aFoodOwned : foodOwned) {
            inventory.append(aFoodOwned.getFoodName());
            inventory.append("\n");
        }

        return inventory;
    }

    public StringBuffer displayEquipmentInventory() {
        StringBuffer inventory = new StringBuffer();

        inventory.append(SimulationConstants.EQUIPMENT);
        inventory.append("\n");
        for (Equipment anEquipmentOwned : equipmentOwned) {
            inventory.append(anEquipmentOwned.getEquipmentName());
            inventory.append("\n");
        }

        inventory.append(SimulationConstants.RECIPE);
        inventory.append("\n");
        for (Recipe aRecipe: recipeOwned) {
            inventory.append(aRecipe.getRecipeName());
            inventory.append("\n");
        }

        return inventory;
    }

    public StringBuffer displayRecipeInventory() {
        StringBuffer inventory = new StringBuffer();

        inventory.append(SimulationConstants.RECIPE);
        inventory.append("\n");
        for (Recipe aRecipe: recipeOwned) {
            inventory.append(aRecipe.getRecipeName());
            inventory.append("\n");
        }

        return inventory;
    }

    public boolean cookFood(Recipe recipe) {
        recipeArray = new ArrayList<Recipe>(Arrays.asList(recipeOwned));

        if (!recipeArray.contains(recipe)) {
            return false;
        }

        String[] equipmentList = recipe.equipmentList();

        String[] foodList = recipe.getIngredientList();

        for (String equipmentListName : equipmentList) {
            boolean equipmentExist = false;

            for (Equipment anEquipmentOwned : equipmentOwned) {
                String equipmentOwnedName = anEquipmentOwned.getEquipmentName();

                if (equipmentListName.equalsIgnoreCase(equipmentOwnedName)) {
                    equipmentExist = true;
                }
            }
            if (!equipmentExist) {
                return false;
            }
        }

        for (String foodListName : foodList) {
            boolean foodExists = false;

            for (Food aFoodOwned : foodOwned) {
                String foodOwnedName = aFoodOwned.getFoodName();
                if (foodListName.equalsIgnoreCase(foodOwnedName)) {
                    foodExists = true;
                }
            }
            if (!foodExists) {
                return false;
            }
        }
        return true;
    }

    public boolean addItemToMenu(Food food) {
        foodArray = new ArrayList<Food>(Arrays.asList(foodOwned));

        if (!foodArray.contains(food)) {
            return false;
        }
        menu.addItem(food);
        return true;
    }
}
