package laba2.task1;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите координаты вершин треугольника:");
        System.out.print("x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("y2: ");
        double y2 = scanner.nextDouble();
        System.out.print("x3: ");
        double x3 = scanner.nextDouble();
        System.out.print("y3: ");
        double y3 = scanner.nextDouble();

        Point vertexA = new Point(x1, y1);
        Point vertexB = new Point(x2, y2);
        Point vertexC = new Point(x3, y3);

        Point intersectionA = calcuInt(vertexA, vertexB, vertexC);
        Point intersectionB = calcuInt(vertexB, vertexA, vertexC);
        Point intersectionC = calcuInt(vertexC, vertexA, vertexB);

        System.out.println("Точки пересечения высот треугольника:");
        System.out.println("Точка пересечения высоты из вершины A: " + intersectionA);
        System.out.println("Точка пересечения высоты из вершины B: " + intersectionB);
        System.out.println("Точка пересечения высоты из вершины C: " + intersectionC);
    }

    public static Point calcuInt(Point vertex, Point sideStart, Point sideEnd) {
        double x = vertex.getX();
        double y = ((sideStart.getX() - sideEnd.getX()) * (vertex.getY() - sideEnd.getY())
                + (sideStart.getY() - sideEnd.getY()) * (sideEnd.getX() - vertex.getX()))
                / (sideStart.getY() - sideEnd.getY());
        return new Point(x, y);
    }
}