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

    public Food getFood(String input) {
        for (Food aFoodOwned : foodOwned) {
            String foodOwnedName = aFoodOwned.getFoodName();
            if (input.equalsIgnoreCase(foodOwnedName)) {
                return aFoodOwned;
            }
        }
        return null;
    }

    public Equipment getEquipment(String input) {
        for (Equipment aEquipmentOwned : equipmentOwned) {
            String equipmentOwnedName = aEquipmentOwned.getEquipmentName();
            if (input.equalsIgnoreCase(equipmentOwnedName)) {
                return aEquipmentOwned;
            }
        }
        return null;
    }

    public Recipe getRecipe(String input) {
        for (Recipe aRecipeOwned : recipeOwned) {
            String recipeOwnedName = aRecipeOwned.getRecipeName();
            if (input.equalsIgnoreCase(recipeOwnedName)) {
                return aRecipeOwned;
            }
        }
        return null;
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

    public boolean cookFood(String foodName) {
        String recipeName = foodName + "Recipe";
        Recipe recipe = null;

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

        for (int i = 0; i < foodList.length; i++) {
            for (int j = 0; j <foodOwned.size(); j++) {
                String foodOwnedName = foodOwned.get(j).getFoodName();
                if (foodList[i].equalsIgnoreCase(foodOwnedName)) {
                    foodOwned.remove(j);
                    break;
                }
            }
        }
        Food food = recipe.getOutputFood();
        foodOwned.add(food);

        time.addMinutes(recipe.getTimeRequired());
        return true;
    }

    public boolean addItemToMenu(Food foodInput) {
        String foodInputName = foodInput.getFoodName();

        for (Food aFoodOwned : foodOwned) {
            String foodOwnedName = aFoodOwned.getFoodName();
            if (foodInputName.equalsIgnoreCase(foodOwnedName)) {
                menu.addItem(foodInput);
                return true;
            }
        }
        return false;
    }

    public boolean buyFromMarket(String itemName) {
        double itemCost;

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

    public boolean sellToMarket(String itemName) {
        double itemCost;

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

    public boolean canBuyItem(double amount) {
        return money - amount >= 0;
    }

    public void customerPurchase(int minutes) {
        if (time.getHours() >= 6 && time.getHours() <= 12) {
            money += menu.customerSales(menu.getPopularity() * 2);
        } else {
            money += menu.customerSales(menu.getPopularity());
        }
    }

    public double totalUpkeep() {
        double total = 0;
        for (Equipment anEquipmentOwned : equipmentOwned) {
            total += anEquipmentOwned.getUpkeepValue();
        }
        return total;
    }
}
