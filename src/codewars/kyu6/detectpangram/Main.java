package codewars.kyu6.detectpangram;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println(check(
                "The quick brown fox jumps over the lazy dog"
        ));
    }

    public static boolean check(String sentence){
        boolean result = true;
        Map<String, Boolean> present = new HashMap<>();
        for (String s: sentence.split("")) {
            s = s.toLowerCase();
            if (Character.isLetter(s.charAt(0))) {
                present.put(s, true);
            }
        }

        int count = 0;
        for (Boolean value: present.values()) {
            count++;
        }

        return count == 26;
    }

    public static boolean checkOptimized(String sentence) {
        return sentence.chars()
                .map(Character::toLowerCase)
                .filter(Character::isLetter)
                .distinct()
                .count() == 26;
    }
}
