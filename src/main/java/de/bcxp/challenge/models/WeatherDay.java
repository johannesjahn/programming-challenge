package de.bcxp.challenge.models;

import com.opencsv.bean.CsvBindByName;

public class WeatherDay {

    /**
     * The day of the month. Values are from 1 to 31.
     */
    @CsvBindByName(column = "Day")
    private int day;

    /**
     * The maximum temperature of the day. Values are integers in Celsius.
     */
    @CsvBindByName(column = "MxT")
    private int maxTemp;

    /**
     * The minimum temperature of the day. Values are integers in Celsius.
     */
    @CsvBindByName(column = "MnT")
    private int minTemp;

    public WeatherDay() {
    }

    public WeatherDay(int day, int maxTemp, int minTemp) {
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    @Override
    public String toString() {
        return "WeatherDay{" +
                "day=" + day +
                ", maxTemp=" + maxTemp +
                ", minTemp=" + minTemp +
                '}';
    }

    public int getDay() {
        return day;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }
}
