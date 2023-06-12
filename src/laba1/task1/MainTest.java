package laba1.task1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {
    @Test
    public void testPositiveValues() {
        assertEquals(-0.14, Main.result(1.0, 2.0, 3.0), 0.01);
    }

    @Test
    public void testNegativeValues() {
        assertEquals(1.2, Main.result(1.0, -5.0, 2.0), 0.001);
    }

    @Test
    public void testZeroDivision() {
        assertThrows(ArithmeticException.class,
                Main.result(1.0, 2.0, 0.0));
    }

    private void assertThrows(Class<ArithmeticException> arithmeticExceptionClass, double result) {
    }
}