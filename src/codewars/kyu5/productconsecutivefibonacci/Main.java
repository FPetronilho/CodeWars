package codewars.kyu5.productconsecutivefibonacci;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(productFib(4895)));
    }

    public static long[] productFib(long prod) {
        long previous = 0;
        long current = 1;
        while (previous * current < prod) {
            long aux = previous;
            previous = current;
            current += aux;
        }

        if (previous * current == prod) {
            return new long[] {previous, current, 1};
        } else {
            return new long[] {previous, current, 0};
        }
    }
}
