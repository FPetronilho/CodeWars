package codewars.rot13;

import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        System.out.println(rot13("W3 ar3 in ye@r 2023$$$!äöü"));
        System.out.println(rot13Optimized("W3 ar3 in ye@r 2023$$$!äöü"));
    }

    public static String rot13(String message) {
        StringBuilder result = new StringBuilder();

        for (int i=0; i<message.length(); i++) {
            char currentChar = message.charAt(i);

            if (hasDiaeresis(currentChar)) {
                result.append(currentChar);
            } else if  (Character.isUpperCase(currentChar)) {
                // Rotate uppercase letters
                result.append((char) ((currentChar - 'A' + 13) % 26 + 'A'));
            } else if (Character.isLowerCase(currentChar)) {
                // Rotate lowercase letters
                result.append((char) ((currentChar - 'a' + 13) % 26 + 'a'));
            } else {
                // Non-alphabetic characters remain unchanged
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    private static boolean hasDiaeresis(char c) {
        return c == 'ä' || c == 'ë' || c == 'ï' || c == 'ö' || c == 'ü' || c == 'ÿ' ||
                c == 'Ä' || c == 'Ë' || c == 'Ï' || c == 'Ö' || c == 'Ü' || c == 'Ÿ';
    }


    public static String rot13Optimized(String message) {
        return message.chars()
                .mapToObj(c -> String.valueOf((char) ((c >= 'a' && c <= 'm') || (c >= 'A' && c <= 'M') ? c + 13 :
                                                      (c >= 'n' && c <= 'z') || (c >= 'N' && c <= 'Z') ? c - 13 : c)))
                .collect(Collectors.joining());
    }
}
