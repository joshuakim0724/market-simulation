package com.example.Equipments;

import com.example.*;

public class Fryer implements EquipmentInterface {

    private String equipmentName = "Fryer";
    private double equipmentValue = 50;
    private double upkeepValue = 2;
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
    public double getUpkeepValue() {
        return upkeepValue;
    }

    @Override
    public double sellToMarket() {
        double marketValue = equipmentValue * MARKET_VALUE;
        return RestaurantMethods.roundNumber(marketValue);
    }
}
