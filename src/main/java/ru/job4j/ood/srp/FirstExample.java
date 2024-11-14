package ru.job4j.ood.srp;

public class FirstExample {
    private String name;

    public FirstExample(String name) {
        this.name = name;
    }

    public String add(FirstExample firstExample) {
        return firstExample.name;
    }
}
