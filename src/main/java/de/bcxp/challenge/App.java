package de.bcxp.challenge;

import de.bcxp.challenge.repositories.WeatherCsvRepository;
import de.bcxp.challenge.repositories.WeatherRepository;
import de.bcxp.challenge.service.WeatherService;

public final class App {

    public static WeatherRepository weatherRepository = new WeatherCsvRepository();
    public static WeatherService weatherService = new WeatherService();

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        var dayWithSmallestTempSpread = weatherService.findDayWithSmallestTempSpread();
        System.out.println("Day with smallest temperature spread: " + dayWithSmallestTempSpread.getDay());

        String countryWithHighestPopulationDensity = "Some country"; // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
