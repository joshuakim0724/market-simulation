package com.example;
import com.example.Foods.*;

import java.util.ArrayList;

public class Market {

    private Food[] foodAvailable;
    private Equipment[] equipmentAvailable;
    private Recipe[] recipeAvailable;

    public Food[] getFoodAvailable() {
        return foodAvailable;
    }

    public Equipment[] getEquipmentAvailable() {
        return equipmentAvailable;
    }

    public Recipe[] getRecipeAvailable() {
        return recipeAvailable;
    }
}
