package laba4.task2;

import java.io.*;
import java.util.*;

public class Main {
    private static final String FILE_NAME = "data.txt";

    public static void main(String[] args) {
        Map<String, Integer> wordFrequencyMap = readDataFromFile();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Добавить данные");
            System.out.println("2. Удалить данные");
            System.out.println("3. Показать частотный словарь");
            System.out.println("4. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите данные для добавления: ");
                    String newData = scanner.nextLine();
                    addData(wordFrequencyMap, newData);
                    break;
                case 2:
                    System.out.print("Введите данные для удаления: ");
                    String dataToRemove = scanner.nextLine();
                    removeData(wordFrequencyMap, dataToRemove);
                    break;
                case 3:
                    displayWordFrequency(wordFrequencyMap);
                    break;
                case 4:
                    saveDataToFile(wordFrequencyMap);
                    System.out.println("Программа завершена.");
                    return;
                default:
                    System.out.println("Некорректный выбор. Попробуйте еще раз.");
            }
        }
    }

    private static Map<String, Integer> readDataFromFile() {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            wordFrequencyMap = (Map<String, Integer>) inputStream.readObject();
            System.out.println("Данные успешно загружены из файла.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Файл не найден или произошла ошибка при чтении данных.");
        }
        return wordFrequencyMap;
    }

    private static void saveDataToFile(Map<String, Integer> wordFrequencyMap) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            outputStream.writeObject(wordFrequencyMap);
            System.out.println("Данные успешно сохранены в файл.");
        } catch (IOException e) {
            System.out.println("Произошла ошибка при сохранении данных в файл.");
        }
    }

    static void addData(Map<String, Integer> wordFrequencyMap, String newData) {
        String[] words = newData.split("\\s+");
        int totalWords = words.length;
        for (String word : words) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }
        System.out.println("Данные успешно добавлены. Общее количество слов: " + totalWords);
    }

    static void removeData(Map<String, Integer> wordFrequencyMap, String dataToRemove) {
        int count = wordFrequencyMap.remove(dataToRemove);
        if (count > 0) {
            System.out.println("Данные успешно удалены. Количество удаленных слов: " + count);
        } else {
            System.out.println("Данные для удаления не найдены.");
        }
    }

    static void displayWordFrequency(Map<String, Integer> wordFrequencyMap) {
        if (wordFrequencyMap.isEmpty()) {
            System.out.println("Частотный словарь пуст.");
        } else {
            List<String> sortedWords = new ArrayList<>(wordFrequencyMap.keySet());
            Collections.sort(sortedWords);

            int totalWords = 0;
            for (int count : wordFrequencyMap.values()) {
                totalWords += count;
            }

            System.out.println("Частотный словарь:");
            for (String word : sortedWords) {
                int count = wordFrequencyMap.get(word);
                double frequency = (count * 100.0) / totalWords;
                System.out.println(word + ": " + String.format("%.2f%%", frequency));
            }
        }
    }
}