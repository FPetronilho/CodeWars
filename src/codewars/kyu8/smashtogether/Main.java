package codewars.kyu8.smashtogether;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println(smashTogether("Hello", "World"));
        System.out.println(smashTogetherOptimized("Hello", "World"));
    }

    public static String smashTogether(String... words) {
        return Arrays.stream(words)
                .map(s -> s + " ")
                .collect(Collectors.joining())
                .trim();
    }

    public static String smashTogetherOptimized(String... words) {
        return String.join(" ", words);
    }
}
