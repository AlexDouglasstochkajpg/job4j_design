package ru.job4j.serialization.xml;

import java.util.Arrays;

public class City {
    private final boolean capital;
    private final int foundationYear;
    private final String name;
    private final Population population;
    private final String[] districts;

    public City(boolean capital, int foundationYear, String name, Population population, String[] districts) {
        this.capital = capital;
        this.foundationYear = foundationYear;
        this.name = name;
        this.population = population;
        this.districts = districts;
    }

    @Override
    public String toString() {
        return "City{"
                + "capital=" + capital
                + ", foundationYear=" + foundationYear
                + ", name='" + name + '\''
                + ", population=" + population
                + ", districts=" + Arrays.toString(districts)
                + '}';
    }
}
