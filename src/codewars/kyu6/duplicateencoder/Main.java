package codewars.kyu6.duplicateencoder;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println(encode("   ()(   "));
    }

    static String encode(String word) {
        String aux = word.toLowerCase();
        Map<Character, Integer> duplicates = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (char c : aux.toCharArray()) {
            duplicates.put(c, duplicates.getOrDefault(c, 0) + 1);
        }

        for (char c : aux.toCharArray()) {
            result.append(duplicates.get(c) == 1 ? "(" : ")");
        }

        return result.toString();
    }
}
