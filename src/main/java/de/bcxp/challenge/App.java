package de.bcxp.challenge;

import de.bcxp.challenge.repositories.CountryCsvRepository;
import de.bcxp.challenge.repositories.CountryRepository;
import de.bcxp.challenge.repositories.WeatherCsvRepository;
import de.bcxp.challenge.repositories.WeatherRepository;
import de.bcxp.challenge.service.CountryService;
import de.bcxp.challenge.service.WeatherService;

/**
 * The main class of the application.
 * This class is also responsible for wiring up the application.
 * It uses static fields to provide the repositories and services to the other classes.
 * Through this approach, the dependencies can be mocked in the tests.
 * This is not a good practice, but it is sufficient for this challenge.
 */
public final class App {

    public static WeatherRepository weatherRepository = new WeatherCsvRepository();
    public static CountryRepository countryRepository = new CountryCsvRepository();
    public static WeatherService weatherService = new WeatherService();
    public static CountryService countryService = new CountryService();

    /**
     * The main method of the application.
     *
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        var dayWithSmallestTempSpread = weatherService.findDayWithSmallestTempSpread();
        System.out.println("Day with smallest temperature spread: " + dayWithSmallestTempSpread.getDay());

        var countryWithHighestPopulationDensity = countryService.findHighestPopulationDensity();
        System.out.println("Country with highest population density: " + countryWithHighestPopulationDensity.getName());
    }
}
