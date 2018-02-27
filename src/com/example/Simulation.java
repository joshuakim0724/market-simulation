package com.example;

import com.google.gson.Gson;
import sun.rmi.registry.RegistryImpl_Stub;

import java.util.Scanner;

public class Simulation {

    private static Restaurant restaurant;
    private static Market market;
    private static Menu menu;
    private static Time time;

    private static boolean inMarket = false;
    private static boolean gameFinished = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        simulationSetup();
        while (!gameFinished) {
            userInput(scanner);
        }
    }

    public static void simulationSetup() {
        restaurantSetupFromJSON(RestaurantJsonString.BREAKFAST_RESTAURANT);
        market = restaurant.getMarket();
        menu = restaurant.getMenu();
        time = restaurant.getTime();

        System.out.println(restaurant.displayMoney());
        System.out.println(time.displayTime());
    }

    public static void restaurantSetupFromJSON (String jsonFile) {
        Gson gson = new Gson();
        restaurant = gson.fromJson(jsonFile, Restaurant.class);
    }

    public static void userInput(Scanner scanner) {
        String input = scanner.nextLine();
        input = input.trim().replaceAll(" +", " ");

        /* Splitting the String into an array based on its spaces */
        String[] inputArray = input.split("\\s+");

        if (inputArray.length == 1) {
            oneWordInput(inputArray[0]);
        }
        else if (inputArray.length == 2) {
            twoWordInput(inputArray[0], inputArray[1]);
        }
        else if (inputArray.length == 3) {
            threeWordInput(inputArray[0], inputArray[1], inputArray[2]);
        }
        else {
            System.out.println("Invalid Input");
        }
    }

    public static void oneWordInput(String input) {
        if (input.equalsIgnoreCase("wealth")) {
            System.out.println(restaurant.displayMoney());
        }

        if (input.equalsIgnoreCase("time")) {
            System.out.println(time.displayTime());
        }

        if (input.equalsIgnoreCase("market")) {
            inMarket = true;
            System.out.println("Entering Market");
        }

        if (inMarket && input.equalsIgnoreCase("exit")) {
            inMarket = false;
            System.out.println("Exiting Market");
            time.addHours(1);
            System.out.println(time.displayTime());
        }
    }

    public static void twoWordInput(String input1, String input2) {
        if (input1.equalsIgnoreCase("inventory")) {
            if (input2.equalsIgnoreCase("food")) {
                restaurant.displayFoodInventory();
            }
            else if (input2.equalsIgnoreCase("equipment")) {
                restaurant.displayEquipmentInventory();
            }
            else if (input2.equalsIgnoreCase("recipe")) {
                restaurant.displayRecipeInventory();
            }
            else {
                System.out.println("Invalid Input");
            }
        }

        if (input1.equalsIgnoreCase("info")) {
            if (market.isFood(input2)) {
                Food food = market.getFood(input2);
                RestaurantMethods.getFoodInfo(food);
            }
            else if (market.isEquipment(input2)) {
                Equipment equipment = market.getEquipment(input2);
                RestaurantMethods.getEquipmentInfo(equipment);
            }
            else if (market.isRecipe(input2)) {
                Recipe recipe = market.getRecipe(input2);
                RestaurantMethods.getRecipeInfo(recipe);
            }
            else {
                System.out.println("Invalid Input");
            }
        }

        if (input1.equalsIgnoreCase("cook")) {
            if (restaurant.cookFood(input2)) {
                System.out.println(time.displayTime());
            } else {
                System.out.println("Invalid Food");
            }
        }

        if (input1.equalsIgnoreCase("menu") && input2.equalsIgnoreCase("list")) {
            System.out.println(menu.menuOutput());
        }

        if (inMarket && input1.equalsIgnoreCase("list")) {
            if (market.isFood(input2)) {
                market.foodAvailableOutput();
            }
            else if (market.isEquipment(input2)) {
                market.equipmentAvailableOutput();
            }
            else if (market.isRecipe(input2)) {
                market.recipeAvailableOutput();
            }
            else {
                System.out.println("Invalid Input");
            }
        }

        if (inMarket && input1.equalsIgnoreCase("buy")) {
            if (restaurant.buyFromMarket(input2)) {
                System.out.println("Bought " + input2);
            }
            else {
                System.out.println("Cannot Buy " + input2);
            }
        }
    }

    public static void threeWordInput(String input1, String input2, String input3) {
        if (input1.equalsIgnoreCase("pass") && input2.equalsIgnoreCase("time")) {
            try {
                int amount = Integer.parseInt(input3);
                time.addMinutes(amount);
                time.displayTime();

            } catch (NumberFormatException e) {
                System.out.println("This is not a number");
                System.out.println(e.getMessage());
            }
        }

        if (input1.equalsIgnoreCase("cook")) {
            int amount = 0;

            try {
                amount = Integer.parseInt(input3);
            } catch (NumberFormatException e) {
                System.out.println("This is not a number");
                System.out.println(e.getMessage());
            }

            if (restaurant.cookFood(input2)) {
                amount--; //Since already ran cooking once.
                while (amount > 0) {
                    if (!restaurant.cookFood(input2)) {
                        System.out.println("You ran out of ingredients. Made " + amount + " times");
                    }
                    amount--;
                }
            }
            else {
                System.out.println("Invalid Food");
            }
            System.out.println(time.displayTime());
        }

        if (input1.equalsIgnoreCase("menu") && input2.equalsIgnoreCase("add")) {
            if (market.isFood(input3)) {
                Food food = market.getFood(input3);
                if (restaurant.addItemToMenu(food)) {
                    System.out.println("Added " + input3);
                }
                else {
                    System.out.println("Restaurant does not have " + input3);
                }
            }
        }

        if (input1.equalsIgnoreCase("menu") && input2.equalsIgnoreCase("removed")) {
            if (market.isFood(input3)) {
                Food food = market.getFood(input3);
                if (menu.removeItem(food)) {
                    System.out.println("Removed " + input3);
                }
                else {
                    System.out.println("Menu does not have " + input3);
                }
            }
        }

        if (inMarket && input1.equalsIgnoreCase("buy")) {
            int amount = 0;

            try {
                amount = Integer.parseInt(input3);
            } catch (NumberFormatException e) {
                System.out.println("This is not a number");
                System.out.println(e.getMessage());
            }

            if (restaurant.buyFromMarket(input2)) {
                while (amount > 0) {
                    if (!restaurant.buyFromMarket(input2)) {
                        System.out.println("You ran out of money. Bought " + amount + " times");
                    }
                    amount--;
                }
            }
            else {
                System.out.println("Invalid Item Input");
            }
        }
    }
}
