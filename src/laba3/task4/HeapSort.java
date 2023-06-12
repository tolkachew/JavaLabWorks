package laba3.task4;

import java.util.Comparator;

public class HeapSort<T> implements Sortable<T> {
    private int heapSortOperationCount;
    private Comparator<T> comparator;

    @Override
    public void sort(T[] array, Comparator<T> comparator) {
        this.comparator = comparator;
        heapSortOperationCount = 0;

        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            T temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private void heapify(T[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && comparator.compare(array[left], array[largest]) > 0) {
            largest = left;
        }

        if (right < n && comparator.compare(array[right], array[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            T temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, n, largest);
        }
        heapSortOperationCount++;
    }

    public int getOperationCount() {
        return heapSortOperationCount;
    }
}