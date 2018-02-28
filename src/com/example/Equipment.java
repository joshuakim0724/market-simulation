package com.example;

public class Equipment {

    private String equipmentName;
    private double equipmentValue;
    private double upkeepValue;

    /**
     * @return this will return name of the equipment
     */
    public String getEquipmentName() {
        return equipmentName;
    }
    /**
     * @return this will return how much the equipment is worth
     */
    public double getEquipmentValue() {
        return equipmentValue;
    }

    /**
     * @return this will return how much it cost to keep an equipment for a day
     */
    public double getUpkeepValue() {
        return upkeepValue;
    }
}
