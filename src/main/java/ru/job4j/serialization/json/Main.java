package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JSONObject jsonYear = new JSONObject("{\"releaseYear\":\"2023\"}");

        List<String> list = new ArrayList<>();
        list.add("Not tested");
        list.add("Not verified");
        JSONArray jsonStatuses = new JSONArray(list);

        final Car car = new Car(true, 150, new Year("2024"),
                new String[] {"Tested", "Verified"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("autoTransmission", car.isAutoTransmission());
        jsonObject.put("power", car.getPower());
        jsonObject.put("year", jsonYear);
        jsonObject.put("statuses", jsonStatuses);

        System.out.println(jsonObject);

        System.out.println(new JSONObject(car));
    }
}
