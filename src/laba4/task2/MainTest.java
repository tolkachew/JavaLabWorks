package laba4.task2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class MainTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
    private final InputStream inputStream = System.in;
    private final PrintStream originalOutput = System.out;
    private final PrintStream originalError = System.err;

    private final Map<String, Integer> wordFrequencyMap = new HashMap<>();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
        System.setErr(new PrintStream(errorStream));
        wordFrequencyMap.clear();
    }

    @Test
    public void testAddData() {
        String inputData = "Hello world hello world";
        String expectedOutput = "Данные успешно добавлены. Общее количество слов: 4\n";

        setInput(inputData);
        Main.addData(wordFrequencyMap, inputData);

        Assertions.assertEquals(expectedOutput, getOutput().replaceAll("\\r\\n", "\n"));
        Assertions.assertEquals(1, wordFrequencyMap.get("Hello"));
        Assertions.assertEquals(2, wordFrequencyMap.get("world"));
    }

    @Test
    public void testRemoveData() {
        wordFrequencyMap.put("Hello", 2);
        wordFrequencyMap.put("world", 3);

        String inputData = "Hello";
        String expectedOutput = "Данные успешно удалены. Количество удаленных слов: 2\n";

        setInput(inputData);
        Main.removeData(wordFrequencyMap, inputData);

        Assertions.assertEquals(expectedOutput, getOutput().replaceAll("\\r\\n", "\n"));
        Assertions.assertNull(wordFrequencyMap.get("Hello"));
    }

    @Test
    public void testDisplayWordFrequency() {
        wordFrequencyMap.put("Vlad", 2);
        wordFrequencyMap.put("Tolkachev", 3);

        String expectedOutput = "Частотный словарь:\nTolkachev: 60,00%\nVlad: 40,00%\n";

        Main.displayWordFrequency(wordFrequencyMap);

        Assertions.assertEquals(expectedOutput, getOutput().replaceAll("\\r\\n", "\n"));
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    private String getOutput() {
        return outputStream.toString();
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOutput);
        System.setErr(originalError);
        System.setIn(inputStream);
    }
}