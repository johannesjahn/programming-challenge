package de.bcxp.challenge.models;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import de.bcxp.challenge.utils.CustomIntegerConverter;

public class Country {

    @CsvBindByName(column = "Name")
    private String name;

    @CsvCustomBindByName(column = "Population", converter = CustomIntegerConverter.class)
    private long population;

    @CsvBindByName(column = "Area (km²)")
    private long area;

    public Country() {
    }

    public Country(String name, long population, long area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public long getPopulation() {
        return population;
    }

    public long getArea() {
        return area;
    }
}
