package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            List<String> list = reader.lines().filter(s -> !s.startsWith("#") && !s.isEmpty()).toList();
            for (String s : list) {
                String[] buff = s.split("=");
                if (buff.length <= 1 || buff[0].isEmpty()) {
                    throw new IllegalArgumentException();
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 1; i < buff.length; i++) {
                        stringBuilder.append(buff[i]);
                        if (s.endsWith("=") || i != buff.length - 1) {
                            stringBuilder.append("=");
                        }
                    }
                    values.put(buff[0], stringBuilder.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner output = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            reader.lines().forEach(output::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("data/app.properties"));
    }

}
