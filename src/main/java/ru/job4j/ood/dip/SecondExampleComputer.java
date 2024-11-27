package ru.job4j.ood.dip;

public class SecondExampleComputer {
    void work() {
        System.out.println("Computer is working");
    }
}

class Printer {
    SecondExampleComputer secondExampleComputer;

    public Printer(SecondExampleComputer secondExampleComputer) {
        this.secondExampleComputer = secondExampleComputer;
    }
}
