package codewars.kyu7.reversewords;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println(reverseWordsOptimized("  Hello World!  "));
    }

    public static String reverseWords(final String original) {
        if (original.trim().isEmpty()) {
            return original;
        }

        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (char c: original.toCharArray()) {
            if (c == ' ') {
                if (word.length() > 0) {
                    result.append(word.reverse());
                    word.setLength(0);
                }
                result.append(c);
            } else {
                word.append(c);
            }
        }

        if (word.length() > 0) {
            result.append(word.reverse());
        }

        return result.toString();
    }

    public static String reverseWordsOptimized(final String original) {
        return Arrays.stream(original.split(" ", -1))
                .map(w -> new StringBuilder(w).reverse().toString())
                .collect(Collectors.joining(" "));
    }
}
