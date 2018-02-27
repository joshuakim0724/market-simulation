package com.example;

public class Time {

    private int hours;
    private int minutes;
    private int day;

    private static final int OPENING_HOURS = 6;
    private static final int CLOSING_HOURS = 22;
    private static final int FINAL_HOUR = 24;
    private static final int FINAL_MINUTE = 60;
    private static final int MARKET_TRIP_TIME = 1;

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getDay() {
        return day;
    }

    public void addHours(int hours) {
        int addedHours = this.hours + hours;

        while (addedHours > FINAL_HOUR) {
            addedHours = addedHours - FINAL_HOUR;
            addDay();
        }
        this.hours = addedHours;
    }

    public void addMinutes(int minutes) {
        int addedMinutes = this.minutes + minutes;

        while (addedMinutes >= FINAL_MINUTE) {
            addedMinutes = addedMinutes - FINAL_MINUTE;
            this.hours ++;
        }
        this.minutes = addedMinutes;
    }

    private void addDay() {
        day++;
    }

    public StringBuffer displayTime() {
        StringBuffer timeOutput = new StringBuffer();

        timeOutput.append(SimulationConstants.TIME_IS + hours + ":" + minutes);
        timeOutput.append("\n");
        timeOutput.append(SimulationConstants.DAY_PASSED + day);

        return timeOutput;
    }

    public boolean isResturantOpen() {
        return OPENING_HOURS < hours && hours < CLOSING_HOURS;
    }

    public boolean marketTrip() {
        int addedHours = this.hours + MARKET_TRIP_TIME;

        if (addedHours > FINAL_HOUR) {
            hours = addedHours - FINAL_HOUR;
            return true;
        }
        hours = addedHours;

        return false;
    }
}
