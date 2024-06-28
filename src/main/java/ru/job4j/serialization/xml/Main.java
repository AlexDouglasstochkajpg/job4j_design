package ru.job4j.serialization.xml;

public class Main {
    public static void main(String[] args) {
        final City city = new City(true, 1147, "Moscow",
                new Population("13 million"), new String[]{"Kremlin", "Arbat street"});
    }
}
