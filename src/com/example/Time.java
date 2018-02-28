package com.example;

public class Time {

    private int hours;
    private int minutes;
    private int day;

    private static final int OPENING_HOURS = 6;
    private static final int CLOSING_HOURS = 22;
    private static final int FINAL_HOUR = 24;
    private static final int FINAL_MINUTE = 60;

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getDay() {
        return day;
    }

    /**
     * This will add hours to the time. If it goes past 24 hours, resets back to 0 and adds a day
     * @param hours amount of hours to add
     */
    public void addHours(int hours) {
        int addedHours = this.hours + hours;

        while (addedHours > FINAL_HOUR) {
            addedHours = addedHours - FINAL_HOUR;
            day++;
        }
        this.hours = addedHours;
    }

    /**
     * This will add minutes to the time. If it goes past 60 minutes, resets back to 0 and adds a hour
     * @param minutes amount ofminutes to add
     */
    public void addMinutes(int minutes) {
        int addedMinutes = this.minutes + minutes;

        while (addedMinutes >= FINAL_MINUTE) {
            addedMinutes = addedMinutes - FINAL_MINUTE;
            addHours(1);
        }
        this.minutes = addedMinutes;
    }

    /**
     * This will display the current time
     * @return return a StringBuffer of the current time
     */
    public StringBuffer displayTime() {
        StringBuffer timeOutput = new StringBuffer();
        /**
         * https://stackoverflow.com/questions/275711/add-leading-zeroes-to-number-in-java
         * Learned how to make width of number 2 so it prints 00 instead of 0
         */
        if (hours == 0) {
            hours = 00;
        }
        if (minutes == 0) {
            minutes = 00;
        }

        String hoursFormatted = String.format("%02d", hours);
        String minutesFormatted = String.format("%02d", minutes);

        timeOutput.append(SimulationConstants.TIME_IS + hoursFormatted + ":" + minutesFormatted);
        timeOutput.append("\n");
        timeOutput.append(SimulationConstants.DAY_PASSED + day);

        return timeOutput;
    }

    /**
     * This method checks to see if the restaurant is open
     * @return true if open, false otherwise
     */
    public boolean isRestaurantOpen() {
        return OPENING_HOURS <= hours && hours <= CLOSING_HOURS;
    }

}
