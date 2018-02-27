package com.example.Equipments;

import com.example.*;

public class FryingPan implements Equipment {

    private String equipmentName = "Frying Pan";
    private double equipmentValue = 30;
    private double upkeepValue = 1.5;
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
