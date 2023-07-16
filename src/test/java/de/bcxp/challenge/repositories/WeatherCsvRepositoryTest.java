package de.bcxp.challenge.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;

public class WeatherCsvRepositoryTest {

    WeatherRepository weatherRepository;

    @BeforeEach()
    public void setUp() {
     weatherRepository = new WeatherCsvRepository();
    }

    @Test()
    public void testFindAll() {
        var result = weatherRepository.findAll();

        assertThat(result, not(empty()));
    }
}
