package de.bcxp.challenge.repositories;

import com.opencsv.bean.CsvToBeanBuilder;
import de.bcxp.challenge.models.WeatherDay;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * A repository for weather days. It reads the data from a CSV file.
 */
public class WeatherCsvRepository implements WeatherRepository {

    public static String PATH = "src/main/resources/de/bcxp/challenge/weather.csv";

    private List<WeatherDay> days;

    @Override
    public List<WeatherDay> findAll() {

        if (this.days != null) {
            return this.days;
        }

        try {
            List<WeatherDay> days = new CsvToBeanBuilder<WeatherDay>(new FileReader(PATH))
                    .withType(WeatherDay.class)
                    .build()
                    .parse();
            this.days = days;
            return days;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
