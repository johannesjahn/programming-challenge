package de.bcxp.challenge.repositories;

import de.bcxp.challenge.models.WeatherDay;

import java.util.List;

public interface WeatherRepository {

    List<WeatherDay> findAll();
}
