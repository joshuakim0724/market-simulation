package com.example;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTest {
    private Time time;

    @Before
    public void setUp() throws Exception {
        Gson gson = new Gson();
        Restaurant restaurant = gson.fromJson(RestaurantJsonString.BREAKFAST_RESTAURANT, Restaurant.class);
        time = restaurant.getTime();
    }

    @Test
    public void addHours() {
        time.addHours(2);

        assertEquals(2, time.getHours());

        time.addHours(24);

        assertEquals(2, time.getHours());
        assertEquals(1, time.getDay());
    }

    @Test
    public void addMinutes() {
        time.addMinutes(50);

        assertEquals(50, time.getMinutes());

        time.addMinutes(40);

        assertEquals(30, time.getMinutes());
        assertEquals(1, time.getHours());
    }

    @Test
    public void displayTime() {
        String expected = "The time is: 00:00\n" +
                "Amount of days passed: 0";
        String actual = time.displayTime().toString();

        assertEquals(expected, actual);
    }

    @Test
    public void isRestaurantOpen() {
        assertFalse(time.isRestaurantOpen());

        time.addHours(6);

        assertTrue(time.isRestaurantOpen());

        time.addHours(17);

        assertFalse(time.isRestaurantOpen());
    }
}