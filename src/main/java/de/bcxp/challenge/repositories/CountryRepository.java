package de.bcxp.challenge.repositories;

import de.bcxp.challenge.models.Country;

import java.util.List;

public interface CountryRepository {

    /**
     * Returns all countries.
     * @return the list of countries
     */
    List<Country> findAll();
}
