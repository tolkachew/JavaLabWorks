package laba1.task2;

public class Main {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double acc = Double.parseDouble(args[1]);
        System.out.println("Result method sum: " + sum(x, acc));
        System.out.println("Result Math.cosh: " + Math.cosh(x));
    }

    public static double sum(double x, double acc) {
        double sum = 0.0;
        double f = 1.0;
        int n = 0;
        while (Math.abs(f) >= acc) {
            f = Math.pow(x, 2 * n) / fact(2 * n);
            sum += f;
            n++;
        }
        return sum;
    }

    public static double fact(int n) {
        double result = 1.0;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}