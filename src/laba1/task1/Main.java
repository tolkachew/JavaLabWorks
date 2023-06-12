package laba1.task1;

public class Main {
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);

        System.out.println("Result: " + result(a, b, c));
    }

    public static double result(double a, double b, double c) {
        return (a - b) / (2 * c +1);
    }
}