package laba3.task4;

import java.util.Comparator;

interface Sortable<T> {
    void sort(T[] array, Comparator<T> comparator);
}