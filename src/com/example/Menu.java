package com.example;

import java.lang.StringBuffer;
import java.util.ArrayList;

public class Menu {

    private Food[] foodAvailable;

//    public double sellFood(Food food) {
//        double foodBaseValue = food.getFoodValue();
//        foodAvailable.remove(food);
//        return foodBaseValue * 1.5;
//    }

    public StringBuffer printFoodAvailable() {
        StringBuffer menuOutput = new StringBuffer();

        for (Food aFoodAvailable : foodAvailable) {
            menuOutput.append(aFoodAvailable.getFoodName());
            menuOutput.append("\n");
        }
        return menuOutput;
    }
}
