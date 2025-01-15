package codewars.kyu6.yourorderplease;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println(order(""));
    }

    public static String order(String words) {
        if (words.isEmpty()) {
            return "";
        }

        String[] wordsArray = words.split(" ");
        String[] phrase = new String[wordsArray.length];

        for (String w : wordsArray) {
            int position = -1;
            for (int i=0; i<w.length(); i++) {
                if (Character.isDigit(w.charAt(i))) {
                    position = Character.getNumericValue(w.charAt(i));
                }
            }

            phrase[position-1] = w;
        }

        return String.join(" ", phrase);
    }
}
