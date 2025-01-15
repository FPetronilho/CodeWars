package codewars.kyu8.lettercount;

import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        System.out.println(strCount("Hello", 'o'));
        System.out.println(strCountOptimized("Hello", 'l'));
    }

    public static int strCount(String str, char letter) {
        return (int) Arrays.stream(str.split(""))
                .filter(l -> Objects.equals(l, Character.toString(letter)))
                .count();
    }

    public static int strCountOptimized(String str, char letter) {
        return (int) str.chars()
                .filter(c -> c == letter)
                .count();
    }
}
