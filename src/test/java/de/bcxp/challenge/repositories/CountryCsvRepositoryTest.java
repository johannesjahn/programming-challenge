package de.bcxp.challenge.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;

public class CountryCsvRepositoryTest {

    CountryRepository repository;

    @BeforeEach()
    public void setUp() {
        repository = new CountryCsvRepository();
    }

    @Test()
    public void testFindAll() {
        var result = repository.findAll();

        assertThat(result, not(empty()));
    }
}
