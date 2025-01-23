package codewars.kyu6.expandedform;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        System.out.println(expandedForm(70304));
        System.out.println(expandedFormOptimized(70300));
    }

    public static String expandedForm(int num) {
        if (num == 0) {
            return "zero";
        }

        String number = String.valueOf(num);
        int[] numbers = Arrays.stream(number.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        StringBuilder result = new StringBuilder();
        for (int i=0; i<numbers.length; i++) {
            int currentNumber = numbers[i];
            if (currentNumber != 0) {
                result.append(currentNumber * ((int) Math.pow(10, numbers.length-1-i)));
                result.append(" + ");
            }
        }

        return result.substring(0, result.length()-3);
    }

    public static String expandedFormOptimized(int num) {
        return IntStream.range(0, String.valueOf(num).length())
                .mapToObj(i -> String.valueOf(Character.getNumericValue(String.valueOf(num).charAt(i)) * (int) Math.pow(
                        10,
                        String.valueOf(num).substring(i).length()-1)))
                .filter(n -> !n.equals("0"))
                .collect(Collectors.joining(" + "));
    }
}
