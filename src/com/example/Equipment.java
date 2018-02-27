package com.example;

public interface Equipment {

    public String getEquipmentName();
    /**
     * @return this will return how much the equipment is worth
     */
    public double getEquipmentValue();

    /**
     * @return this will return how much it cost to keep an equipment for a day
     */
    public double getUpkeepValue();

    /** Equipment can also be sold at the market at 0.5x the base value
     * @return this will return how you will get it you sell the equipment for the market
     */
    public double sellToMarket();
}
