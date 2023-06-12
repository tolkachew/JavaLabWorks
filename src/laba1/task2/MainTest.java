package laba1.task2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {
    @Test
    public void test1() {
        double x = 0.2;
        double acc = 0.0001;
        double coshResult = Math.cosh(x);
        double result = Main.sum(x, acc);
        assertEquals(coshResult, result, acc);
    }

    @Test
    public void test2() {
        double x = -3.5;
        double acc = 0.00001;
        double coshResult = Math.cosh(x);
        double result = Main.sum(x, acc);
        assertEquals(coshResult, result, acc);
    }

    @Test
    public void test3() {
        double x = 1.7;
        double acc = 0.000001;
        double coshResult = Math.cosh(x);
        double result = Main.sum(x, acc);
        assertEquals(coshResult, result, acc);
    }

    @Test
    public void test4() {
        double x = -0.3;
        double acc = 0.0000001;
        double coshResult = Math.cosh(x);
        double result = Main.sum(x, acc);
        assertEquals(coshResult, result, acc);
    }

    @Test
    public void test5() {
        double x = -0.11;
        double acc = 0.0000001;
        double coshResult = Math.cosh(x);
        double result = Main.sum(x, acc);
        assertEquals(coshResult, result, acc);
    }
}