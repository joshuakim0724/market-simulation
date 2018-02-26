package com.example;

public interface Recipe {

    public Food[] getIngreidentList();

    public Food outputFood();

    public Equipment[] equipmentList();

    public double timeRequired();

    public double sellToMarket();

}
