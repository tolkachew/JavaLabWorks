package laba3.task3;

import by.vsu.mf.ai.ssd.strings.Job;
import by.vsu.mf.ai.ssd.strings.Manager;

public class Main {
    public static void main(String[] args) {
        Manager.createWindow(new Job() {
            @Override
            public void perform(StringBuilder input) {
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
                input.setLength(0);
                input.append(output);
            }
        });
    }
}