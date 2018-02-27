package com.example;

import com.google.gson.Gson;

import java.util.Scanner;

public class Simulation {

    private static Restaurant restaurant;

    public static void main(String[] args) {
        restaurantSetupFromJSON(ResturantJsonString.BREAKFAST_RESTURANT);
        Scanner scan = new Scanner(System.in);

    }

    public static void restaurantSetupFromJSON (String jsonFile) {
        Gson gson = new Gson();
        restaurant = gson.fromJson(jsonFile, Restaurant.class);
    }
}
