package ru.job4j.serialization.xml;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "population")
public class Population {
    @XmlAttribute
    private String cityPopulation;

    public Population() { }

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
