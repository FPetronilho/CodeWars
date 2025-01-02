package codewars.firstnonrepeatingletter;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingLetter(" I moonmoon"));
        System.out.println(firstNonRepeatingLetterOptimized("stress"));
        System.out.println(firstNonRepeatingLetterOptimized2("stress"));
    }

    public static String firstNonRepeatingLetter(String s){
        Map<Character, Integer> letterCount = new HashMap<>();
        String result = "";

        for (int i=0; i<s.length(); i++) {
            char c = s.toLowerCase().charAt(i);
            if (letterCount.containsKey(c)) {
                letterCount.put(c, letterCount.get(c) + 1);
            } else {
                letterCount.put(c, 1);
            }
        }

        for (int i=0; i<s.length(); i++) {
            boolean isLowerCase = Character.isLowerCase(s.charAt(i));
            Character c = s.toLowerCase().charAt(i);

            if (letterCount.get(c) == 1) {
                result = isLowerCase ? c.toString() : c.toString().toUpperCase();
                break;
            }
        }

        return result;
    }

    public static String firstNonRepeatingLetterOptimized(String s){
        return s.chars()
                .filter(c -> s.toLowerCase().indexOf(c) == s.toLowerCase().lastIndexOf(c))
                .mapToObj(c -> String.valueOf((char) c)).findFirst().orElse("");
    }

    public static String firstNonRepeatingLetterOptimized2(String s){
        for (String str : s.split("")) {
            if (s.toLowerCase().indexOf(str.toLowerCase()) == s.toLowerCase().lastIndexOf(str.toLowerCase())) {
                return str;
            }
        }

        return "";
    }
}
