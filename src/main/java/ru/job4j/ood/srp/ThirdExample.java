package ru.job4j.ood.srp;

import java.util.ArrayList;
import java.util.List;

public class ThirdExample {
    List<ThirdExample> list = new ArrayList<>();

    public void add(ThirdExample thirdExample) {
        list.add(thirdExample);
    }

    public void print() {
        list.forEach(System.out::println);
    }
}
