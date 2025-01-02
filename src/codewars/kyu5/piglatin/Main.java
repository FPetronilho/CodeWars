package codewars.kyu5.piglatin;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        System.out.println(pigIt("sou tolo !"));
        System.out.println(pigItOptimized("sou tolo !"));
    }

    public static String pigIt(String str) {
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            char c = word.charAt(word.length()-1);
            if (!Character.isLetter(c)) {
                result.append(c).append(" ");
            } else {
                result.append(word.substring(1)).append(word.charAt(0)).append("ay ");
            }
        }

        return result.substring(0, result.length()-1);
    }

    public static String pigItOptimized(String str) {
        return Arrays.stream(str.trim().split(" "))
                .map(s -> s.length() > 1 ? s.substring(1).concat(s.substring(0, 1).concat("ay")) : s)
                .collect(Collectors.joining(" "));
    }
}
