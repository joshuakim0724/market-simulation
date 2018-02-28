package com.example;

import java.lang.StringBuffer;
import java.util.ArrayList;

public class Restaurant {

    private Market market;
    private Menu menu;
    private Time time;
    private double money;

    private ArrayList<Food> foodOwned = new ArrayList<>();
    private ArrayList<Equipment> equipmentOwned = new ArrayList<>();
    private ArrayList<Recipe> recipeOwned = new ArrayList<>();

    private static final String RECIPE_ADD_ON = "Recipe";

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

    public ArrayList<Food> getFoodOwned() {
        return foodOwned;
    }

    public ArrayList<Equipment> getEquipmentOwned() {
        return equipmentOwned;
    }

    public ArrayList<Recipe> getRecipeOwned() {
        return recipeOwned;
    }

    /**
     * Will get a food that the restaurant owns
     * @param input Food name
     * @return Food if can be found, null otherwise
     */
    public Food getFood(String input) {
        for (Food aFoodOwned : foodOwned) {
            String foodOwnedName = aFoodOwned.getFoodName();
            if (input.equalsIgnoreCase(foodOwnedName)) {
                return aFoodOwned;
            }
        }
        return null;
    }

    /**
     * Will get a equipment that the restaurant owns
     * @param input equipment name
     * @return Equipment if can be found, null otherwise
     */
    public Equipment getEquipment(String input) {
        for (Equipment aEquipmentOwned : equipmentOwned) {
            String equipmentOwnedName = aEquipmentOwned.getEquipmentName();
            if (input.equalsIgnoreCase(equipmentOwnedName)) {
                return aEquipmentOwned;
            }
        }
        return null;
    }

    /**
     * Will get a Recipe that the restaurant owns
     * @param input Recipe name
     * @return Recipe if can be found, null otherwise
     */
    public Recipe getRecipe(String input) {
        for (Recipe aRecipeOwned : recipeOwned) {
            String recipeOwnedName = aRecipeOwned.getRecipeName();
            if (input.equalsIgnoreCase(recipeOwnedName)) {
                return aRecipeOwned;
            }
        }
        return null;
    }

    /**
     * Will display how much money the restaurant has
     * @return StringBuffer that displays how much money restaurant has
     */
    public StringBuffer displayMoney() {
        StringBuffer moneyOutput = new StringBuffer();
        moneyOutput.append(SimulationConstants.RESTAURANT_HAS);
        moneyOutput.append(money);

        return moneyOutput;
    }

    /**
     * Will display what Foods the restaurant owns
     * @return StringBuffer that contains list of foods
     */
    public StringBuffer displayFoodInventory() {
        StringBuffer inventory = new StringBuffer();

        inventory.append(SimulationConstants.FOOD_INPUT);
        inventory.append("\n");
        for (Food aFoodOwned : foodOwned) {
            inventory.append(aFoodOwned.getFoodName());
            inventory.append("\n");
        }

        return inventory;
    }

    /**
     * Will display what Equipment the restaurant owns
     * @return StringBuffer that contains list of equipments
     */
    public StringBuffer displayEquipmentInventory() {
        StringBuffer inventory = new StringBuffer();

        inventory.append(SimulationConstants.EQUIPMENT_INPUT);
        inventory.append("\n");
        for (Equipment anEquipmentOwned : equipmentOwned) {
            inventory.append(anEquipmentOwned.getEquipmentName());
            inventory.append("\n");
        }

        return inventory;
    }

    /**
     * Will display what Recipe the restaurant owns
     * @return StringBuffer that contains list of recipes
     */
    public StringBuffer displayRecipeInventory() {
        StringBuffer inventory = new StringBuffer();

        inventory.append(SimulationConstants.RECIPE_INPUT);
        inventory.append("\n");
        for (Recipe aRecipe: recipeOwned) {
            inventory.append(aRecipe.getRecipeName());
            inventory.append("\n");
        }

        return inventory;
    }

    /**
     * This method will try to cook a certain food.
     * Restaurant MUST own ALL Ingredients, Equipments, and Recipe needed to create this food
     * @param foodName name of food trying to create
     * @return true if food can be created, false otherwise
     */
    public boolean cookFood(String foodName) {
        String recipeName = foodName + RECIPE_ADD_ON; //My recipes names are just the same foodName with a "Recipe" added
        Recipe recipe = null;
        /* Gets the Recipe for the Food */
        for (Recipe aRecipeOwned : recipeOwned) {
            if (aRecipeOwned.getRecipeName().equalsIgnoreCase(recipeName)) {
                recipe = aRecipeOwned;
            }
        }

        if (recipe == null) {
            return false;
        }
        String[] equipmentList = recipe.getEquipmentList();

        String[] foodList = recipe.getIngredientList();

        /* Checks to see if you own the equipment needed */
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
        /* Checks to see if you own the ingredients needed */
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
        /* If you own the ingredients it then removes the ingredients to create the food */
        for (String aFoodList : foodList) {
            for (int j = 0; j < foodOwned.size(); j++) {
                String foodOwnedName = foodOwned.get(j).getFoodName();
                if (aFoodList.equalsIgnoreCase(foodOwnedName)) {
                    foodOwned.remove(j);
                    break;
                }
            }
        }
        Food food = recipe.getOutputFood();
        foodOwned.add(food);

        time.addMinutes(recipe.getTimeRequired());
        customerPurchase(recipe.getTimeRequired());

        return true;
    }

    /**
     * Will add an item to the Restaurant Menu
     * @param foodInput is the food that is trying to be added
     * @return True if food was able to be added, false otherwise
     */
    public boolean addItemToMenu(Food foodInput) {
        String foodInputName = foodInput.getFoodName();

        for (Food aFoodOwned : foodOwned) {
            String foodOwnedName = aFoodOwned.getFoodName();
            if (foodInputName.equalsIgnoreCase(foodOwnedName)) {
                menu.addItem(foodInput);
                foodOwned.remove(foodInput);
                return true;
            }
        }
        return false;
    }

    /**
     * This will buy items from the Market
     * @param itemName Name of item you are trying to buy
     * @return True if you can buy it, false otherwise
     */
    public boolean buyFromMarket(String itemName) {
        double itemCost;

        /* Checks to see if item is a food */
        if (market.isFood(itemName)) {
            Food food = market.getFood(itemName);

            /* This checks if you can afford the item */
            itemCost = food.getFoodValue();
            if (!canBuyItem(itemCost)) {
                return false;
            }
            money -= itemCost;

            foodOwned.add(food);

            return true;
        }
        /* Checks to see if item is a equipment */
        if (market.isEquipment(itemName)) {
            Equipment equipment = market.getEquipment(itemName);

            /* This checks if you can afford the item */
            itemCost = equipment.getEquipmentValue();
            if (!canBuyItem(itemCost)) {
                return false;
            }
            money -= itemCost;

            equipmentOwned.add(equipment);

            return true;
        }
        /* Checks to see if item is a recipe */
        if (market.isRecipe(itemName)) {
            Recipe recipe = market.getRecipe(itemName);

            /* This checks if you can afford the item */
            itemCost = recipe.getRecipeValue();
            if (!canBuyItem(itemCost)) {
                return false;
            }
            money -= itemCost;

            recipeOwned.add(recipe);

            return true;
        }
        return false;
    }

    /**
     * This will sell items from the Market
     * @param itemName Name of item you are trying to sell
     * @return True if you can sell it, false otherwise
     */
    public boolean sellToMarket(String itemName) {
        double itemCost;

        /* Checks to see if item is a food */
        if (market.isFood(itemName)) {
            Food food = getFood(itemName);

            /* Makes sure the item isn't null/ item is valid */
            if (food == null) {
                return false;
            }

            itemCost = food.getFoodValue() * SimulationConstants.FOOD_RESELL_VALUE;
            itemCost = RestaurantMethods.roundNumber(itemCost);

            money += itemCost;

            foodOwned.remove(food);

            return true;
        }
        /* Checks to see if item is a equipment */
        if (market.isEquipment(itemName)) {
            Equipment equipment = getEquipment(itemName);

            /* Makes sure the item isn't null/ item is valid */
            if (equipment == null) {
                return false;
            }

            itemCost = equipment.getEquipmentValue() * SimulationConstants.EQUIPMENT_RESELL_VALUE;
            itemCost = RestaurantMethods.roundNumber(itemCost);

            money += itemCost;

            equipmentOwned.remove(equipment);

            return true;
        }
        /* Checks to see if item is a recipe */
        if (market.isRecipe(itemName)) {
            Recipe recipe = getRecipe(itemName);

            /* Makes sure the item isn't null/ item is valid */
            if (recipe == null) {
                return false;
            }

            itemCost = recipe.getRecipeValue() * SimulationConstants.RECIPE_RESELL_VALUE;
            itemCost = RestaurantMethods.roundNumber(itemCost);

            money += itemCost;

            recipeOwned.remove(recipe);

            return true;
        }
        return false;
    }

    /**
     * This makes sure you have enough money to buy the item
     * @param amount is amount item cost
     * @return true if can buy item, false otherwise
     */
    public boolean canBuyItem(double amount) {
        return money - amount >= 0;
    }

    /**
     * This is the method that will be run whenever time is passed
     * Takes in time input of how many minutes passed, and then runs the RNG menu.customerSales
     * Chances are increased during Peak time (Breakfast)
     *
     * @param minutes amount of minutes passed
     * @return true if made money, false otherwise
     */
    public boolean customerPurchase(int minutes) {
        double multiplier = minutes / SimulationConstants.MINUTE_DIVIDER;
        double moneyMade = 0;
        if (time.isRestaurantOpen()) {
            if (SimulationConstants.BEGINNING_PEAK_HOURS <= time.getHours() &&
                    time.getHours() <= SimulationConstants.CLOSING_PEAK_HOURS) {
                moneyMade +=
                        menu.customerSales(menu.getPopularity() * multiplier * SimulationConstants.PEAK_MULTIPLIER);
            } else {
                moneyMade += menu.customerSales(menu.getPopularity() * multiplier);
            }
            if (moneyMade > 0) {
                System.out.println(displayMoney());
                return true;
            }
        }
        return false;
    }

    /**
     * Total Cost per day in order to own equipment
     * @return total cost of owning equipment
     */
    public double totalUpkeepCost() {
        double total = 0;
        for (Equipment anEquipmentOwned : equipmentOwned) {
            total += anEquipmentOwned.getUpkeepValue();
        }
        return total;
    }

    /**
     * Used to pay the total upkeepCost of equipment
     */
    public void payUpkeepCost() {
        money -= totalUpkeepCost();
    }
}
