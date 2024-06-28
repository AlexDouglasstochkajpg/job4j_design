package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Car car = new Car(true, 150, new Year("2024"),
                new String[] {"Tested", "Verified"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));

        final String carJson =
                "{"
                        + "\"autoTransmission\":false,"
                        + "\"power\":130,"
                        + "\"year\":"
                        + "{"
                        + "\"releaseYear\":\"2023\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Not tested\",\"Not verified\"]"
                        + "}";

        final Car carMod = gson.fromJson(carJson, Car.class);
        System.out.println(carMod);
    }
}
