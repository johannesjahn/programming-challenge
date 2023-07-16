package de.bcxp.challenge.service;

import de.bcxp.challenge.App;
import de.bcxp.challenge.models.WeatherDay;
import de.bcxp.challenge.repositories.WeatherRepository;

public class WeatherService {

    WeatherRepository weatherRepository = App.weatherRepository;

    /**
     * Returns the day with the smallest temperature spread.
     * The temperature spread is the difference between the maximum and minimum
     * temperature measured in a day.
     *
     * @return the day with the smallest temperature spread
     */
    public WeatherDay findDayWithSmallestTempSpread() {
        final var days = weatherRepository.findAll();

        var result = days.stream().min((day1, day2) -> {
            final var day1TempSpread = day1.getMaxTemp() - day1.getMinTemp();
            final var day2TempSpread = day2.getMaxTemp() - day2.getMinTemp();
            return Integer.compare(day1TempSpread, day2TempSpread);
        });

        return result.orElseThrow(() -> new RuntimeException("No day found"));
    }
}
