package codewars.kyu6.highestscoringword;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        System.out.println(high("what time are we climbing up to the volcano"));
        System.out.println(highOptimized("what time are we climbing up to the volcano"));
    }

    public static String high(String s) {
        String[] words = s.split(" ");
        int resultSum = 0;
        String result = null;

        for (String word : words) {
            int sum = 0;
            for (int i=0; i<word.length(); i++) {
                sum += (int) word.charAt(i) - 96;
            }

            if (sum > resultSum) {
                resultSum = sum;
                result = word;
            }
        }

        return result;
    }

    public static String highOptimized(String s) {
        return Arrays.stream(s.split(" "))
                .max(Comparator.comparingInt(
                   word -> word.chars()
                           .map(x -> x - 96)
                           .sum()
                ))
                .get();
    }
}
