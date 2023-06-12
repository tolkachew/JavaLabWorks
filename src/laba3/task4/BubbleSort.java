package laba3.task4;

import java.util.Comparator;

public class BubbleSort<T> implements Sortable<T> {
    private int bubbleSortOperationCount;

    @Override
    public void sort(T[] array, Comparator<T> comparator) {
        bubbleSortOperationCount = 0;
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
                bubbleSortOperationCount++;
            }

            if (!swapped) {
                break;
            }
        }
    }

    public int getOperationCount() {
        return bubbleSortOperationCount;
    }
}