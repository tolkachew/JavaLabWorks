package laba3.task1;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "z";
        String[] words = {"dog", "book", "banana", "i", "garden", "go", "English", "Morningg"};

        System.out.println("Array of words:");
        printArray(words);
        sortByStringLength(words);
        System.out.println("Sorting an array of words by length:");
        printArray(words);
        sortBySubstring(words, s1, s2);
        System.out.println("Sorting array by substring between first occurrence of S1 and last occurrence of S2:");
        printArray(words);
    }

    public static void sortBySubstring(String[] words, String s1, String s2) {
        Arrays.sort(words, Comparator.comparing(word -> {
            int start = word.indexOf(s1);
            int end = word.lastIndexOf(s2);
            if (start >= 0 && end >= 0 && start < end) {
                return word.substring(start, end + s2.length());
            }
            return word;
        }));
    }

    public static void sortByStringLength(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(Main::countLetters));
    }

    public static int countLetters(String word) {
        int count = 0;
        for (char z : word.toCharArray()) {
            count++;
        }
        return count;
    }

    private static void printArray(String[] words) {
        for (String word : words) {
            System.out.println(word);
        }
        System.out.println("Count: " + (words.length * (words.length - 1) / 2));
        System.out.println();
    }
}