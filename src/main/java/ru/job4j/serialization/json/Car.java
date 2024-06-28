package ru.job4j.serialization.json;

import java.util.Arrays;

public class Car {
    private final boolean autoTransmission;
    private final int power;
    private final Year year;
    private final String[] statuses;

    public Car(boolean autoTransmission, int power, Year year, String[] statuses) {
        this.autoTransmission = autoTransmission;
        this.power = power;
        this.year = year;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Car{"
                + "autoTransmission=" + autoTransmission
                + ", power=" + power
                + ", year=" + year
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }
}
