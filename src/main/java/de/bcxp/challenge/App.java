package de.bcxp.challenge;

import de.bcxp.challenge.repositories.CountryCsvRepository;
import de.bcxp.challenge.repositories.CountryRepository;
import de.bcxp.challenge.repositories.WeatherCsvRepository;
import de.bcxp.challenge.repositories.WeatherRepository;
import de.bcxp.challenge.service.CountryService;
import de.bcxp.challenge.service.WeatherService;

public final class App {

    public static WeatherRepository weatherRepository = new WeatherCsvRepository();
    public static CountryRepository countryRepository = new CountryCsvRepository();
    public static WeatherService weatherService = new WeatherService();
    public static CountryService countryService = new CountryService();

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        var dayWithSmallestTempSpread = weatherService.findDayWithSmallestTempSpread();
        System.out.println("Day with smallest temperature spread: " + dayWithSmallestTempSpread.getDay());

        var countryWithHighestPopulationDensity = countryService.findHighestPopulationDensity();
        System.out.println("Country with highest population density: " + countryWithHighestPopulationDensity.getName());
    }
}
