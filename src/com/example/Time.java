package com.example;

public class Time {

    private int hours;
    private int minutes;

    private static final int OPENING_HOURS = 6;
    private static final int CLOSING_HOURS = 22;

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void addHours(int hours) {
        int addedHours = this.hours + hours;

        if (addedHours > 24) {
            addedHours = addedHours - 24;
        }
        this.hours = addedHours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void addMinutes(int minutes) {
        int addedMinutes = this.minutes + minutes;

        if (addedMinutes > 60) {
            addedMinutes = addedMinutes - 60;
            this.hours ++;
        }
        this.minutes = addedMinutes;
    }

    public boolean isResturantOpen() {
        return OPENING_HOURS < hours && hours < CLOSING_HOURS;
    }
}
