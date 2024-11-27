package ru.job4j.ood.dip;

public class ThirdExampleElectricity {
    void turnOn() {
        System.out.println("Turn on the electricity");
    }
}

class TV {
    ThirdExampleElectricity thirdExampleElectricity = new ThirdExampleElectricity();
}
