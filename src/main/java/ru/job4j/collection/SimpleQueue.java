package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> input = new SimpleStack<>();
    private final SimpleStack<T> output = new SimpleStack<>();

    private int intSize;
    private int outSize;

    public T poll() {
        if (outSize == 0 && intSize == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        if (outSize == 0) {
            while (intSize > 0) {
                output.push(input.pop());
                intSize--;
                outSize++;
            }
        }
        outSize--;
        return output.pop();
    }

    public void push(T value) {
        input.push(value);
        intSize++;
    }

    public int size() {
        return intSize + outSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}