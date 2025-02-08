package codewars.kyu6;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        System.out.println(isNarcissistic(153));

    }

    public static boolean isNarcissistic(int number) {
        String num = String.valueOf(number);
        return IntStream.range(0, num.length())
                .mapToDouble(x -> Math.pow(Character.getNumericValue(num.charAt(x)), num.length()))
                .sum() == number;
    }
}
