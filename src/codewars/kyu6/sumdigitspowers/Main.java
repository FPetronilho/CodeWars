package codewars.kyu6.sumdigitspowers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        System.out.println(sumDigPow(1, 1000));

    }

    public static List<Long> sumDigPow(long a, long b) {
        List<Long> result = new ArrayList<>();
        for (long i = a; i <= b; i++) {
            String num = String.valueOf(i);
            long[] digits = Arrays.stream(num.split(""))
                    .mapToLong(Long::parseLong)
                    .toArray();

            double sum = IntStream.range(0, digits.length)
                    .mapToDouble(x -> Math.pow(digits[x], x + 1))
                    .sum();

            if (sum == i) {
                result.add(i);
            }
        }

        return result;
    }
}
