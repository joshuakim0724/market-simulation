package com.example;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarketTest {
    Restaurant restaurant;
    Market market;

    @Before
    public void setUp() throws Exception {
        Gson gson = new Gson();
        restaurant = gson.fromJson(RestaurantJsonString.BREAKFAST_RESTAURANT, Restaurant.class);
        market = restaurant.getMarket();
    }

    @Test
    public void foodAvailableOutput() {
        String expected = "Bacon Cost: $0.5\n" +
                "BaconOmelette Cost: $6.0\n" +
                "Bread Cost: $0.5\n" +
                "BreakfastPotatoes Cost: $3.0\n" +
                "Cheese Cost: $0.5\n" +
                "CookedBacon Cost: $3.0\n" +
                "Egg Cost: $0.5\n" +
                "EggsAndToast Cost: $5.0\n" +
                "GrilledCheese Cost: $4.0\n" +
                "HashBrowns Cost: $3.0\n" +
                "Potato Cost: $0.5\n" +
                "Spinach Cost: $0.5\n" +
                "SpinachOmelette Cost: $6.0\n";
        String actual = market.foodAvailableOutput().toString();

        assertEquals(expected, actual);
    }

    @Test
    public void equipmentAvailableOutput() {
        String expected = "Fryer Cost: $50.0\n" +
                "FryingPan Cost: $30.0\n" +
                "Oven Cost: $100.0\n" +
                "Toaster Cost: $25.0\n";
        String actual = market.equipmentAvailableOutput().toString();

        assertEquals(expected, actual);
    }

    @Test
    public void recipeAvailableOutput() {
        String expected = "BaconOmeletteRecipe Cost: $5.0\n" +
                "BreakfastPotatoesRecipe Cost: $3.0\n" +
                "CookedBaconRecipe Cost: $3.0\n" +
                "EggsAndToastRecipe Cost: $5.0\n" +
                "GrilledCheeseRecipe Cost: $4.0\n" +
                "HashBrownsRecipe Cost: $3.0\n" +
                "SpinachOmeletteRecipe Cost: $5.0\n";
        String actual = market.recipeAvailableOutput().toString();

        assertEquals(expected, actual);
    }

    @Test
    public void isFood() {
        String food1 = "Bacon";
        String food2 = "PoTaTo";
        String food3 = "egg";
        String fakeFood = "notFood";

        assertTrue(market.isFood(food1));
        assertTrue(market.isFood(food2));
        assertTrue(market.isFood(food3));

        assertFalse(market.isFood(fakeFood));
    }

    @Test
    public void getFood() {
        Food[] food = market.getFoodAvailable();
        Food bacon = food[0];
        Food cheese = food[4];

        assertEquals(bacon, market.getFood("bacon"));
        assertEquals(cheese, market.getFood("cheese"));
    }

    @Test
    public void isEquipment() {
        String equipment1 = "fryer";
        String equipment2 = "FrYiNGPan";
        String fakeEquipment = "notEquipment";

        assertTrue(market.isEquipment(equipment1));
        assertTrue(market.isEquipment(equipment2));

        assertFalse(market.isEquipment(fakeEquipment));
    }

    @Test
    public void getEquipment() {
        Equipment[] equipment = market.getEquipmentAvailable();
        Equipment fryer = equipment[0];
        Equipment oven = equipment[2];

        assertEquals(fryer, market.getEquipment("fryer"));
        assertEquals(oven, market.getEquipment("oven"));
    }

    @Test
    public void isRecipe() {
        String recipe1 = "CookedBaconRecipe";
        String recipe2 = "BaconOmeletteRecipe";
        String fakeRecipe = "notRecipe";

        assertTrue(market.isRecipe(recipe1));
        assertTrue(market.isRecipe(recipe2));

        assertFalse(market.isRecipe(fakeRecipe));
    }

    @Test
    public void getRecipe() {
        Recipe[] recipe = market.getRecipeAvailable();
        Recipe baconOmeletteRecipe = recipe[0];
        Recipe cookedBaconRecipe = recipe[2];

        assertEquals(baconOmeletteRecipe, market.getRecipe("BaconOmeletteRecipe"));
        assertEquals(cookedBaconRecipe, market.getRecipe("cookedBaconRecipe"));
    }
}