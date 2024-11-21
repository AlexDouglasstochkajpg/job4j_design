package ru.job4j.ood.lsp;

public class ThirdExample {
    public ThirdExample get() {
        return new ThirdExample();
    }
}

class Cat extends ThirdExample {
    public void sleep() {
        System.out.println("Cat is sleeping");
    }

    public Cat get() {
        sleep();
        return new Cat();
    }
}
