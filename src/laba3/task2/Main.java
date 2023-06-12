package laba3.task2;

public class Main {
    public static void main(String[] args) {
        String inputString = "...Tolkachev...Vladislav...Sergeevich...";
        String outputString = replaceEllipsis(inputString);
        System.out.println(outputString);
    }

    public static String replaceEllipsis(String input) {
        StringBuilder output = new StringBuilder(input);
        int alphabetLength = 32;
        int ellipsisCount = 0;

        for (int i = 0; i < output.length() - 2; i++) {
            if (output.charAt(i) == '.' && output.charAt(i + 1) == '.' && output.charAt(i + 2) == '.') {
                ellipsisCount++;
            }
        }

        int alphabetIndex = 0;
        for (int i = 0; i < output.length() - 2; i++) {
            if (output.charAt(i) == '.' && output.charAt(i + 1) == '.' && output.charAt(i + 2) == '.') {
                if (alphabetIndex >= alphabetLength) {
                    alphabetIndex = 0;
                }
                char replacementChar = (char) ('А' + alphabetIndex);
                output.replace(i, i + 3, String.valueOf(replacementChar));
                alphabetIndex++;
            }
        }
        return output.toString();
    }
}