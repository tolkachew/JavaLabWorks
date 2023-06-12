package laba3.task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class MainTest {
    @Test
    void testBubbleSort() {
        String[] words = {"dog", "book", "banana", "i", "garden", "go", "English", "Morningg"};
        String[] expected = {"English", "Morningg", "banana", "book", "dog","garden","go","i"};

        Sortable<String> bubbleSort = new BubbleSort<>();
        bubbleSort.sort(words, Comparator.naturalOrder());

        Assertions.assertArrayEquals(expected, words);
    }

    @Test
    void testHeapSort() {
        Integer[] numbers = {1, 6, 8, 3, 9, 12, 44, 7};
        Integer[] expected = {1, 3, 6, 7, 8, 9, 12, 44};

        Sortable<Integer> heapSort = new HeapSort<>();
        heapSort.sort(numbers, Comparator.naturalOrder());

        Assertions.assertArrayEquals(expected, numbers);
    }
}