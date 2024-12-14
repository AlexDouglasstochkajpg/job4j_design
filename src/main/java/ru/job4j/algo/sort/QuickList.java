package ru.job4j.algo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QuickList {

    public static <T> void quickSort(List<T> sequence, Comparator<T> comparator) {
        quickSort(sequence, 0, sequence.size() - 1, comparator);
    }

    private static <T> void quickSort(List<T> sequence, int start, int end, Comparator<T> comparator) {
        if (start < end) {
            int h = breakPartition(sequence, start, end, comparator);
            quickSort(sequence, start, h - 1, comparator);
            quickSort(sequence, h + 1, end, comparator);
        }
    }

    private static <T> int breakPartition(List<T> sequence, int start, int end, Comparator<T> comparator) {
        T supportElement = sequence.get(end);
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (comparator.compare(sequence.get(j), supportElement) <= 0) {
                i++;
                swap(sequence, i, j);
            }
        }
        swap(sequence, i + 1, end);
        return i + 1;
    }

    private static <T> void swap(List<T> array, int i, int j) {
        T temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
