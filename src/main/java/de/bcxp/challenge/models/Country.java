package de.bcxp.challenge.models;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import de.bcxp.challenge.utils.CustomLongConverter;

public class Country {

    /**
     * The name of the country.
     */
    @CsvBindByName(column = "Name")
    private String name;

    /**
     * The population of the country.
     */
    @CsvCustomBindByName(column = "Population", converter = CustomLongConverter.class)
    private long population;

    /**
     * The area of the country in square kilometers.
     */
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
