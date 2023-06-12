package laba3.task3;

import by.vsu.mf.ai.ssd.strings.Job;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testPerform() {
        StringBuilder input = new StringBuilder("1...2...3...4...5...6...7...8...9...10...11...12");
        Job job = new JobImpl();

        job.perform(input);

        assertEquals("1А2Б3В4Г5Д6Е7Ж8З9И10Й11К12", input.toString());
    }
}

class JobImpl implements Job {
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
}