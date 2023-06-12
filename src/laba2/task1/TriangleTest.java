package laba2.task1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TriangleTest {

    @Test
    public void testCalculateHeightIntersection() {

        Point vertex = new Point(1.0, 1.0);
        Point sideStart = new Point(3.0, 3.0);
        Point sideEnd = new Point(5.0, 5.0);
        Point expectedIntersection = new Point(1.0, -0.0);
        Point actualIntersection = Triangle.calcuInt(vertex, sideStart, sideEnd);
        assertEquals(expectedIntersection, actualIntersection);


        vertex = new Point(2, 2);
        sideStart = new Point(5, 6);
        sideEnd = new Point(8, 2);
        expectedIntersection = new Point(2, 6);
        actualIntersection = Triangle.calcuInt(vertex, sideStart, sideEnd);
        assertEquals(expectedIntersection, actualIntersection);

        vertex = new Point(-1, -1);
        sideStart = new Point(1, 1);
        sideEnd = new Point(3, -1);
        expectedIntersection = new Point(-1, 4);
        actualIntersection = Triangle.calcuInt(vertex, sideStart, sideEnd);
        assertEquals(expectedIntersection, actualIntersection);
    }
}