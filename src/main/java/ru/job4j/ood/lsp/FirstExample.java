package ru.job4j.ood.lsp;

public class FirstExample {
    public Integer sum(int first, int second) {
        return first + second;
    }
}

class NewNumber extends FirstExample {
    @Override
    public Integer sum(int first, int second) {
        return null;
    }
}
