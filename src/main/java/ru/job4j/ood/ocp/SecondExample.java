package ru.job4j.ood.ocp;

public class SecondExample {
    public String fly() {
        return "Machine fly";
    }
    public String ride() {
        return "Machine ride";
    }
}
class Car extends SecondExample {
    public String fly() {
        return "Car not fly";
    }
    public String cure() {
        return "Car ride";
    }
}
