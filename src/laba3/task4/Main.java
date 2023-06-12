package laba3.task4;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        String[] inputArray = args.clone();

        System.out.println("Source array:");
        printArray(inputArray);

        BubbleSort<Comparable<?>> bubbleSort = new BubbleSort<>();
        HeapSort<Comparable<?>> heapSort = new HeapSort<>();

        System.out.println("\nBubble sort:");
        Comparable<?>[] array = convertToComparableArray(inputArray);
        Comparator<Comparable<?>> comparator = (Comparator<Comparable<?>>) Comparator.naturalOrder();
        bubbleSort.sort(array, comparator);
        printArray(array);
        System.out.println("Number of comparison operations: " + bubbleSort.getOperationCount());

        System.out.println("\nHeap sort:");
        array = convertToComparableArray(inputArray);
        heapSort.sort(array, comparator);
        printArray(array);
        System.out.println("Number of comparison operations: " + heapSort.getOperationCount());
    }

    private static void printArray(Object[] array) {
        for (Object item : array) {
            System.out.println(item);
        }
    }

    private static Comparable<?>[] convertToComparableArray(String[] array) {
        Comparable<?>[] result = new Comparable[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }
}