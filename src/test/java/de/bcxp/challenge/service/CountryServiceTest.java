package de.bcxp.challenge.service;

import de.bcxp.challenge.App;
import de.bcxp.challenge.models.Country;
import de.bcxp.challenge.repositories.CountryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class CountryServiceTest {
    @Test()
    public void testFindDayWithSmallestTempSpread() {
        List<Country> countryMockData = new ArrayList<>();
        countryMockData.add(new Country("First Country", 1, 10));
        countryMockData.add(new Country("Second Country", 2, 10));

        var repoMock = mock(CountryRepository.class);
        Mockito.when(repoMock.findAll()).thenReturn(countryMockData);

        App.countryRepository = repoMock;

        var service = new CountryService();

        var result = service.findHighestPopulationDensity();

        assertThat(result, samePropertyValuesAs(countryMockData.get(1)));
    }

    @Test()
    public void testFindDayWithSmallestTempSpreadError() {
        List<Country> countryMockData = new ArrayList<>();

        var repoMock = mock(CountryRepository.class);
        Mockito.when(repoMock.findAll()).thenReturn(countryMockData);

        App.countryRepository = repoMock;

        var service = new CountryService();

        Throwable exception = assertThrows(RuntimeException.class, service::findHighestPopulationDensity);

        assertThat(exception.getMessage(), equalTo("No country found"));
    }
}
