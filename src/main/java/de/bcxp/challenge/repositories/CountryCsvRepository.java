package de.bcxp.challenge.repositories;

import com.opencsv.bean.CsvToBeanBuilder;
import de.bcxp.challenge.models.Country;
import de.bcxp.challenge.models.WeatherDay;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CountryCsvRepository implements CountryRepository {

    public static String PATH = "src/main/resources/de/bcxp/challenge/countries.csv";

    private List<Country> countries;

    @Override
    public List<Country> findAll() {

        if (this.countries != null) {
            return this.countries;
        }

        try {
            List<Country> countries = new CsvToBeanBuilder<Country>(new FileReader(PATH))
                    .withType(Country.class)
                    .withSeparator(';')
                    .build()
                    .parse();
            this.countries = countries;
            return countries;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
