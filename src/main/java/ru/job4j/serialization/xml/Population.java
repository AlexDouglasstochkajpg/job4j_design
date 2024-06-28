package ru.job4j.serialization.xml;

public class Population {
    private final String cityPopulation;

    public Population(String cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    @Override
    public String toString() {
        return "Population{"
                + "cityPopulation='" + cityPopulation + '\''
                + '}';
    }
}
