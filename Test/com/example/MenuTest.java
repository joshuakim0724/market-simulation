package com.example;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {
    private Restaurant restaurant;
    private Menu menu;
    private Market market;
    private Food[] foodArray;
    private static final double DELTA = 0.00001;
    @Before
    public void setUp() throws Exception {
        Gson gson = new Gson();
        restaurant = gson.fromJson(RestaurantJsonString.BREAKFAST_RESTAURANT, Restaurant.class);
        market = restaurant.getMarket();
        menu = restaurant.getMenu();

        foodArray = market.getFoodAvailable();
        menu.addItem(foodArray[0]);
        menu.addItem(foodArray[1]);
    }
    @Test
    public void sellFood() {
        double amount = 0;
        Food food = foodArray[0];
        Food food2 = foodArray[5];

        assertEquals(0.75, menu.sellFood(food), DELTA);
        assertEquals(-1, menu.sellFood(food2),DELTA);
    }

    @Test
    public void isValidFood() {
        Food food = foodArray[0];
        Food food2 = foodArray[5];

        assertTrue(menu.isValidFood(food));
        assertFalse(menu.isValidFood(food2));
    }

    @Test
    public void addItem() {
        Food food = foodArray[5];

        assertTrue(menu.addItem(food));
    }

    @Test
    public void removeItem() {
        Food food = foodArray[0];
        Food food1 = foodArray[5];

        assertTrue(menu.removeItem(food));
        assertFalse(menu.removeItem(food1));
    }

    @Test
    public void menuOutput() {
        String expected = "Menu: \n" +
                "Bacon $0.75\n" +
                "BaconOmelette $9.0\n";
        String actual = menu.menuOutput().toString();

        assertEquals(expected, actual);
    }

    @Test
    public void uniqueFood() {
        assertEquals(2, menu.uniqueFood());

        Food food = foodArray[0];
        menu.addItem(food);

        assertEquals(2, menu.uniqueFood());
    }

    @Test
    public void getComplexity() {
        Recipe[] recipe = market.getRecipeAvailable();
        Recipe newRecipe = recipe[0];

        Food food2 = newRecipe.getOutputFood();

        assertEquals(0, menu.getComplexity(), DELTA);

        menu.addItem(food2);

        assertEquals(15, menu.getComplexity(), DELTA);
    }

    @Test
    public void getPopularity() {
        Recipe[] recipe = market.getRecipeAvailable();
        Recipe newRecipe = recipe[0];

        Food food2 = newRecipe.getOutputFood();

        assertEquals(1, menu.getPopularity(), DELTA);

        menu.addItem(food2);

        assertEquals(2, menu.getPopularity(), DELTA);

    }
}