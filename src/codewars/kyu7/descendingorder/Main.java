package codewars.kyu7.descendingorder;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        System.out.println(sortDesc(1234));
        System.out.println(sortDescOptimized(1234));
        System.out.println(sortDescOptimized2(4561));
    }

    public static int sortDesc(final int num) {
        String number = String.valueOf(num);
        List<Character> numbers = new ArrayList<>();
        for (char currentNum : number.toCharArray()) {
            numbers.add(currentNum);
        }

        numbers.sort(Collections.reverseOrder());
        StringBuilder result = new StringBuilder();
        for (int i=0; i<numbers.size(); i++) {
            result.append(numbers.get(i));
        }

        return Integer.parseInt(result.toString());
    }

    public static int sortDescOptimized(final int num) {
        return Integer.parseInt(String.valueOf(num)
                .chars()
                .mapToObj(c -> String.valueOf(Character.getNumericValue(c)))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining("")));
    }

    public static int sortDescOptimized2(final int num) {
        String[] numbers = String.valueOf(num).split("");
        Arrays.sort(numbers, Collections.reverseOrder());
        return Integer.parseInt(String.join("", numbers));
    }
}
