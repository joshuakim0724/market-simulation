package com.example.Equipments;

import com.example.*;

public class Oven implements EquipmentInterface {
    private String equipmentName = "Oven";
    private double equipmentValue = 100;
    private double upkeepValue = 4;
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
