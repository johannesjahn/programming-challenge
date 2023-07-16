package de.bcxp.challenge.service;

import de.bcxp.challenge.App;
import de.bcxp.challenge.models.Country;
import de.bcxp.challenge.repositories.CountryRepository;

public class CountryService {

    private final CountryRepository countryRepository = App.countryRepository;

    /**
     * Returns the country with the highest population density.
     * The population density is the ratio of population to area.
     *
     * @return the country with the highest population density
     */
    public Country findHighestPopulationDensity() {

        var countries = countryRepository.findAll();

        var result = countries.stream().max((country1, country2) -> {
            final var country1PopulationDensity = (double) country1.getPopulation() / country1.getArea();
            final var country2PopulationDensity = (double) country2.getPopulation() / country2.getArea();
            return Double.compare(country1PopulationDensity, country2PopulationDensity);
        });

        return result.orElseThrow(() -> new RuntimeException("No country found"));
    }
}
