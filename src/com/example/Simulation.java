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

    /**
     * Main method that will run the simulation
     * @param args is arguments method runs
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        simulationSetup();
        while (!gameFinished) {

            int timeHour = time.getHours();
            userInput(scanner);
            int newTimeHour = time.getHours();

            if (didDayPass(timeHour, newTimeHour)) {
                restaurant.payUpkeepCost();
            }
            gameFinished = isGameOver();

        }
    }

    /**
     * If the current hour is behind the past hour, than a day has passed
     * @param pastTime time before action
     * @param currentTime time after actions
     * @return true if a day did pass, false if it did not
     */
    private static boolean didDayPass(int pastTime, int currentTime) {
        return currentTime < pastTime;
    }

    /**
     * Setups the simulation
     */
    private static void simulationSetup() {
        restaurantSetupFromJSON(RestaurantJsonString.BREAKFAST_RESTAURANT);
        market = restaurant.getMarket();
        menu = restaurant.getMenu();
        time = restaurant.getTime();

        System.out.println(restaurant.displayMoney());
        System.out.println(time.displayTime());
    }

    /**
     * Reads the jsonFile from a String and Setups the Gson file
     * @param jsonFile is json String
     */
    private static void restaurantSetupFromJSON(String jsonFile) {
        Gson gson = new Gson();
        restaurant = gson.fromJson(jsonFile, Restaurant.class);
    }

    /**
     * Game is over if you run out of money
     * @return true if restaurant has no money, false if has money
     */
    private static boolean isGameOver() {
        return restaurant.getMoney() < 0;
    }

    /**
     * Gets an input from the user and decides what to do based on the input
     * @param scanner where user gets inputs from
     */
    private static void userInput(Scanner scanner) {
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

    /**
     * This contains all the one word inputs
     * @param input user input
     */
    private static void oneWordInput(String input) {
        if (input.equalsIgnoreCase(SimulationConstants.WEALTH)) {
            System.out.println(restaurant.displayMoney());
        }

        if (input.equalsIgnoreCase(SimulationConstants.TIME)) {
            System.out.println(time.displayTime());
        }

        if (input.equalsIgnoreCase(SimulationConstants.MARKET)) {
            inMarket = true;
            System.out.println(SimulationConstants.ENTERING_MARKET);
        }

        if (inMarket && input.equalsIgnoreCase(SimulationConstants.EXIT)) {
            inMarket = false;
            System.out.println(SimulationConstants.EXITING_MARKET);
            time.addHours(SimulationConstants.MARKET_TRIP_TIME);
            restaurant.customerPurchase(SimulationConstants.MINUTE_IN_HOUR);
            System.out.println(time.displayTime());
        }
    }

    /**
     * This contains all the two word inputs
     * @param input1 First user word
     * @param input2 Second user word
     */
    private static void twoWordInput(String input1, String input2) {
        if (input1.equalsIgnoreCase(SimulationConstants.INVENTORY)) {
            if (input2.equalsIgnoreCase(SimulationConstants.FOOD)) {
                System.out.println(restaurant.displayFoodInventory());
            }
            else if (input2.equalsIgnoreCase(SimulationConstants.EQUIPMENT)) {
                System.out.println(restaurant.displayEquipmentInventory());
            }
            else if (input2.equalsIgnoreCase(SimulationConstants.RECIPE)) {
                System.out.println(restaurant.displayRecipeInventory());
            }
            else {
                System.out.println(SimulationConstants.INVALID_INPUT);
            }
        }

        if (input1.equalsIgnoreCase(SimulationConstants.INFO)) {
            if (market.isFood(input2)) {
                Food food = market.getFood(input2);
                System.out.println(RestaurantMethods.getFoodInfo(food));
            }
            else if (market.isEquipment(input2)) {
                Equipment equipment = market.getEquipment(input2);
                System.out.println(RestaurantMethods.getEquipmentInfo(equipment));
            }
            else if (market.isRecipe(input2)) {
                Recipe recipe = market.getRecipe(input2);
                System.out.println(RestaurantMethods.getRecipeInfo(recipe));
            }
            else {
                System.out.println(SimulationConstants.INVALID_INPUT);
            }
        }

        if (input1.equalsIgnoreCase(SimulationConstants.COOK)) {
            if (restaurant.cookFood(input2)) {
                System.out.println(time.displayTime());
            } else {
                System.out.println(SimulationConstants.CANNOT_COOK + input2);
            }
        }

        if (input1.equalsIgnoreCase(SimulationConstants.MENU) && input2.equalsIgnoreCase(SimulationConstants.LIST)) {
            System.out.println(menu.menuOutput());
        }

        if (inMarket && input1.equalsIgnoreCase(SimulationConstants.LIST)) {
            if (input2.equalsIgnoreCase(SimulationConstants.FOOD)) {
                System.out.println(market.foodAvailableOutput());
            }
            else if (input2.equalsIgnoreCase(SimulationConstants.EQUIPMENT)) {
                System.out.println(market.equipmentAvailableOutput());
            }
            else if (input2.equalsIgnoreCase(SimulationConstants.RECIPE)) {
                System.out.println(market.recipeAvailableOutput());
            }
            else {
                System.out.println(SimulationConstants.CANNOT_DISPLAY + input2);
            }
        }

        if (inMarket && input1.equalsIgnoreCase(SimulationConstants.BUY)) {
            if (restaurant.buyFromMarket(input2)) {
                System.out.println(SimulationConstants.BOUGHT + input2);
            }
            else {
                System.out.println(SimulationConstants.CANNOT_BUY + input2);
            }
        }

        if (inMarket && input1.equalsIgnoreCase(SimulationConstants.SELL)) {
            if (restaurant.sellToMarket(input2)) {
                System.out.println(SimulationConstants.SOLD + input2);
            }
            else {
                System.out.println(SimulationConstants.CANNOT_SELL + input2);
            }
        }
    }

    /**
     * This contains all the 3 word inputs
     * @param input1 First word user inputted
     * @param input2 Second word user inputted
     * @param input3 Third word user inputted
     */
    private static void threeWordInput(String input1, String input2, String input3) {
        if (input1.equalsIgnoreCase(SimulationConstants.PASS) && input2.equalsIgnoreCase(SimulationConstants.TIME)) {
            try {
                int amount = Integer.parseInt(input3);
                time.addMinutes(amount);
                restaurant.customerPurchase(amount);
                System.out.println(time.displayTime());

            } catch (NumberFormatException e) {
                System.out.println(ErrorConstants.NOT_NUMBER);
                System.out.println(e.getMessage());
            }
        }

        if (input1.equalsIgnoreCase(SimulationConstants.COOK)) {
            int amount = 0;

            try {
                amount = Integer.parseInt(input3);
            } catch (NumberFormatException e) {
                System.out.println(ErrorConstants.NOT_NUMBER);
                System.out.println(e.getMessage());
            }

            if (restaurant.cookFood(input2)) {
                amount--; //Since already ran cooking once.
                while (amount > 0) {
                    if (!restaurant.cookFood(input2)) {
                        System.out.println(SimulationConstants.NO_INGREDIENTS + amount + SimulationConstants.TIMES);
                    }
                    amount--;
                }
            }
            else {
                System.out.println(SimulationConstants.CANNOT_COOK + input2);
            }
            System.out.println(time.displayTime());
        }

        if (input1.equalsIgnoreCase(SimulationConstants.MENU) && input2.equalsIgnoreCase(SimulationConstants.ADD)) {
            if (market.isFood(input3)) {
                Food food = market.getFood(input3);
                if (restaurant.addItemToMenu(food)) {
                    System.out.println(SimulationConstants.ADDED + input3);
                }
                else {
                    System.out.println(SimulationConstants.RESTAURANT_NOT_HAVE + input3);
                }
            }
        }

        if (input1.equalsIgnoreCase(SimulationConstants.MENU) && input2.equalsIgnoreCase(SimulationConstants.REMOVE)) {
            if (market.isFood(input3)) {
                Food food = market.getFood(input3);
                if (menu.removeItem(food)) {
                    System.out.println(SimulationConstants.REMOVED + input3);
                }
                else {
                    System.out.println(SimulationConstants.MENU_NOT_HAVE + input3);
                }
            }
        }

        if (inMarket && input1.equalsIgnoreCase(SimulationConstants.BUY)) {
            int amount = 0;

            try {
                amount = Integer.parseInt(input3);
            } catch (NumberFormatException e) {
                System.out.println(ErrorConstants.NOT_NUMBER);
                System.out.println(e.getMessage());
            }

            if (restaurant.buyFromMarket(input2)) {
                amount --;
                System.out.println(SimulationConstants.BOUGHT + input2);
                while (amount > 0) {
                    if (!restaurant.buyFromMarket(input2)) {
                        System.out.println(SimulationConstants.NO_MONEY + amount + SimulationConstants.TIMES);
                        break;
                    }
                    System.out.println(SimulationConstants.BOUGHT + input2);
                    amount--;
                }
            }
            else {
                System.out.println(ErrorConstants.NOT_NUMBER);
            }
        }

        if (inMarket && input1.equalsIgnoreCase(SimulationConstants.SELL)) {
            int amount = 0;

            try {
                amount = Integer.parseInt(input3);
            } catch (NumberFormatException e) {
                System.out.println(ErrorConstants.NOT_NUMBER);
                System.out.println(e.getMessage());
            }

            if (restaurant.sellToMarket(input2)) {
                amount --;
                System.out.println(SimulationConstants.SOLD + input2);
                while (amount > 0) {
                    if (!restaurant.sellToMarket(input2)) {
                        System.out.println(SimulationConstants.NO_LONGER + input2);
                    }
                    System.out.println(SimulationConstants.SOLD + input2);
                    amount--;
                }
            }
            else {
                System.out.println(ErrorConstants.NOT_NUMBER);
            }
        }
    }
}
