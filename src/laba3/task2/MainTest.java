package laba3.task2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void testReplaceEllipsis() {
        String inputString = "...Tolkachev...Vladislav...Sergeevich...";
        String expectedOutputString = "АTolkachevБVladislavВSergeevichГ";

        String actualOutputString = Main.replaceEllipsis(inputString);

        assertEquals(expectedOutputString, actualOutputString);
    }
}
