package ru.job4j.ood.isp;

public interface SecondExampleMachine {
    void ride();
    void fly();
}

class Car implements SecondExampleMachine {

    @Override
    public void ride() {
        System.out.println("Riding");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException();
    }
}

class Helicopter implements SecondExampleMachine {

    @Override
    public void ride() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void fly() {
        System.out.println("Flying");
    }
}
