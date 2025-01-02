package codewars.fundamentals.stringendswith;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println(solution("abc", "bghjy"));
        System.out.println(solutionOptimized("abc", "bghjy"));
    }

    public static boolean solution(String str, String ending) {
         return ending.length() > str.length() ? false : str.substring((str.length() - ending.length())).equals(ending);
    }

    public static boolean solutionOptimized(String str, String ending) {
        return str.endsWith(ending);
    }
}
