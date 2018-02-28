package com.example;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RestaurantTest {

    private Restaurant restaurant;
    private Market market;
    private static final double DELTA = 0.00001;

    @Before
    public void setUp() throws Exception {
        Gson gson = new Gson();
        restaurant = gson.fromJson(RestaurantJsonString.BREAKFAST_RESTAURANT, Restaurant.class);
        market = restaurant.getMarket();

        restaurant.buyFromMarket("bacon");
        restaurant.buyFromMarket("BaconOmelette");
        restaurant.buyFromMarket("fryer");
        restaurant.buyFromMarket("CookedBaconRecipe");
    }

    @Test
    public void getFood() {
        Food food = market.getFood("bacon");

        assertEquals(food, restaurant.getFood("bacon"));
        assertEquals(null, restaurant.getFood("idk"));
    }

    @Test
    public void getEquipment() {
        Equipment equipment = market.getEquipment("Fryer");

        assertEquals(equipment, restaurant.getEquipment("fryer"));
        assertEquals(null, restaurant.getEquipment("idk"));
    }

    @Test
    public void getRecipe() {
        Recipe recipe = market.getRecipe("CookedBaconRecipe");

        assertEquals(recipe, restaurant.getRecipe("CookedBaconRecipe"));
        assertEquals(null, restaurant.getRecipe("idk"));
    }

    @Test
    public void displayMoney() {
        String expected = "The restaurant has $140.5";
        String actual = restaurant.displayMoney().toString();

        assertEquals(expected, actual);
    }

    @Test
    public void displayFoodInventory() {
        String expected = "Food: \n" +
                "Bacon\n" +
                "BaconOmelette\n";
        String actual = restaurant.displayFoodInventory().toString();

        assertEquals(expected, actual);
    }

    @Test
    public void displayEquipmentInventory() {
        String expected = "Equipment:\n" +
                "Fryer\n";
        String actual = restaurant.displayEquipmentInventory().toString();

        assertEquals(expected, actual);
    }

    @Test
    public void displayRecipeInventory() {
        String expected = "Recipes:\n" +
                "CookedBaconRecipe\n";
        String actual = restaurant.displayRecipeInventory().toString();

        assertEquals(expected, actual);
    }

    @Test
    public void cookFood() {
        restaurant.buyFromMarket("fryingPan");
        assertTrue(restaurant.cookFood("cookedBacon"));
        assertFalse(restaurant.cookFood("no"));
    }

    @Test
    public void addItemToMenu() {
        Food food = market.getFood("bacon");
        Food food1 = market.getFood("potato");

        assertTrue(restaurant.addItemToMenu(food));
        assertFalse(restaurant.addItemToMenu(food1));
    }

    @Test
    public void buyFromMarket() {
        assertEquals(140.5, restaurant.getMoney(), DELTA);
        assertTrue(restaurant.buyFromMarket("oven"));

        assertEquals(40.5, restaurant.getMoney(), DELTA);
        assertFalse(restaurant.buyFromMarket("no"));
    }

    @Test
    public void sellToMarket() {
        assertEquals(140.5, restaurant.getMoney(), DELTA);
        assertTrue(restaurant.sellToMarket("fryer"));

        assertEquals(165.5, restaurant.getMoney(), DELTA);
        assertFalse(restaurant.sellToMarket("no"));
    }

    @Test
    public void canBuyItem() {
        assertTrue(restaurant.canBuyItem(50));
        assertFalse(restaurant.canBuyItem(300));
    }

    @Test
    public void totalUpkeepCost() {
        assertEquals(2, restaurant.totalUpkeepCost(), DELTA);
    }
}