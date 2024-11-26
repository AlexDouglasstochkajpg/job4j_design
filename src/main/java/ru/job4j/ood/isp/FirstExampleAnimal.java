package ru.job4j.ood.isp;

public interface FirstExampleAnimal {
    void eat();
    void sleep();
    void fly();
}

class Dog implements FirstExampleAnimal {
    @Override
    public void eat() {
        System.out.println("Om-nom-nom");
    }

    @Override
    public void sleep() {
        System.out.println("Sleeping");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException();
    }
}


