package ru.job4j.serialization.xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.*;

import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "city")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {
    @XmlAttribute
    private boolean capital;
    @XmlAttribute
    private int foundationYear;
    @XmlAttribute
    private String name;
    private Population population;
    @XmlElementWrapper(name = "districts")
    @XmlElement(name = "district")
    private String[] districts;

    public City() { }

    public City(boolean capital, int foundationYear, String name, Population population, String... districts) {
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

    public static void main(String[] args) throws JAXBException {

        final City city = new City(true, 1147, "Moscow",
                new Population("5 million"), "Kremlin", "Arbat street");

        JAXBContext context = JAXBContext.newInstance(City.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(city, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
