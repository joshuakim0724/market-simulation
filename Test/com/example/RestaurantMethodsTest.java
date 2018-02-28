package com.example;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RestaurantMethodsTest {

    private Market market;
    private static final double DELTA = 0.00001;

    @Before
    public void setUp() throws Exception {
        Gson gson = new Gson();
        Restaurant restaurant = gson.fromJson(RestaurantJsonString.BREAKFAST_RESTAURANT, Restaurant.class);
        market = restaurant.getMarket();
    }


    @Test
    public void roundNumber() {
        double number = 10.010001123;
        assertEquals(10.01, RestaurantMethods.roundNumber(number), DELTA);
    }

    @Test
    public void getFoodInfo() {
        Food food = market.getFood("bacon");

        String expected = "Food Name: Bacon\n" +
                "Base Value: 0.5";
        String actual = RestaurantMethods.getFoodInfo(food).toString();

        assertEquals(expected, actual);
    }

    @Test
    public void getEquipmentInfo() {
        Equipment equipment = market.getEquipment("oven");

        String expected = "Equipment Name: Oven\n" +
                "Base Value: 100.0\n" +
                "Upkeep Equipment Value: 4.0";
        String actual = RestaurantMethods.getEquipmentInfo(equipment).toString();

        assertEquals(expected, actual);
    }

    @Test
    public void getRecipeInfo() {
        Recipe recipe = market.getRecipe("GrilledCheeseRecipe");

        String expected = "Recipe Name: GrilledCheeseRecipe\n" +
                "Base Value: 4.0\n" +
                "Food Needed: CheeseBread, \n" +
                "Equipment Needed: FryingPan\n" +
                "Time Required: 10\n" +
                "This recipe makes GrilledCheese";
        String actual = RestaurantMethods.getRecipeInfo(recipe).toString();

        assertEquals(expected, actual);
    }
}