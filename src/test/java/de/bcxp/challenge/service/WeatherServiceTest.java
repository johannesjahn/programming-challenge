package de.bcxp.challenge.service;

import de.bcxp.challenge.App;
import de.bcxp.challenge.models.WeatherDay;
import de.bcxp.challenge.repositories.WeatherRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.hamcrest.MatcherAssert.assertThat;

public class WeatherServiceTest {

    @Test()
    public void testFindDayWithSmallestTempSpread() {
        List<WeatherDay> dayMockData = new ArrayList<>();
        dayMockData.add(new WeatherDay(1, 88, 59));
        dayMockData.add(new WeatherDay(2, 79, 63));
        dayMockData.add(new WeatherDay(3, 77, 55));

        var repoMock = mock(WeatherRepository.class);
        Mockito.when(repoMock.findAll()).thenReturn(dayMockData);

        App.weatherRepository = repoMock;

        var service = new WeatherService();

        var result = service.findDayWithSmallestTempSpread();

        assertThat(result.getDay(), equalTo(2));
    }

    @Test()
    public void testFindDayWithSmallestTempSpreadError() {
        List<WeatherDay> dayMockData = new ArrayList<>();

        var repoMock = mock(WeatherRepository.class);
        Mockito.when(repoMock.findAll()).thenReturn(dayMockData);

        App.weatherRepository = repoMock;

        var service = new WeatherService();

        Throwable exception = assertThrows(RuntimeException.class, service::findDayWithSmallestTempSpread);

        assertThat(exception.getMessage(), equalTo("No day found"));
    }
}
