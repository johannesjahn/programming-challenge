package de.bcxp.challenge.repositories;

import de.bcxp.challenge.models.WeatherDay;

import java.util.List;

public interface WeatherRepository {

    /**
     * Returns all weather days.
     * @return the list of weather days
     */
    List<WeatherDay> findAll();
}
