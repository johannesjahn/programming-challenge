package de.bcxp.challenge.repositories;

import de.bcxp.challenge.models.Country;

import java.util.List;

public interface CountryRepository {

    List<Country> findAll();
}
