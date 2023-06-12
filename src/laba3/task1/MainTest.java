package laba3.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    public void testByStringLength() {
        String[] words = {"dog", "book", "banana", "i", "garden", "go", "English", "Morningg"};
        Main.sortByStringLength(words);

        String[] expected = {"i", "go", "dog", "book", "banana", "garden", "English", "Morningg"};
        assertArrayEquals(expected, words);

    }
    @Test
    public void testSortBySubstring() {
        String[] words = {"dog", "book", "banana", "i", "garden", "go", "English", "Morningg"};
        Main.sortBySubstring(words, "a", "c");

        String[] expected = {"English", "Morningg", "banana", "book", "dog", "garden", "go", "i"};
        assertArrayEquals(expected, words);

    }

    @Test
    public void testCountLetters() {
        int count1 = Main.countLetters("Morninggg");
        assertEquals(9, count1);

        int count2 = Main.countLetters("wordZXSD");
        assertEquals(8, count2);

        int count3 = Main.countLetters("ZXC");
        assertEquals(3, count3);
    }
}