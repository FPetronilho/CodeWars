package codewars.kyu6.tribonaccisequence;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(tribonacci(
                        new double[]{ 0, 1, 1 },
                        10
                ))
        );
    }

    public static double[] tribonacci(double[] s, int n) {
        if (n == 0) {
            return new double[0];
        }

        double[] result = Arrays.copyOf(s, n);
        for (int i=3; i<n; i++) {
            result[i] = result[i-1] + result[i-2] + result[i-3];
        }

        return result;
    }
}
