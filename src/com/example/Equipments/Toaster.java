package com.example.Equipments;

import com.example.*;

public class Toaster implements Equipment {
    private String equipmentName = "Toaster";
    private double equipmentValue = 25;
    private double unkeepValue = 1;
    private static final double MARKET_VALUE = .5;

    @Override
    public String getEquipmentName() {
        return equipmentName;
    }

    @Override
    public double getEquipmentValue() {
        return equipmentValue;
    }

    @Override
    public double getUnkeepValue() {
        return unkeepValue;
    }

    @Override
    public double sellToMarket() {
        double marketValue = equipmentValue * MARKET_VALUE;
        return ResturantMethods.roundNumber(marketValue);
    }
}
