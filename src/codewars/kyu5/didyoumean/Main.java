package codewars.kyu5.didyoumean;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println(findMostSimilar(
                new String[]{"java", "javascript", "ruby", "php", "python", "coffeescript"}, "heaven"
        ));
    }

    public static String findMostSimilar(String[] words, String targetWord) {
        Map<String, Integer> discrepanciesCount = new HashMap<>();
        char[] targetChars = targetWord.toCharArray();
        String result = "";
        int min = Integer.MAX_VALUE;

        for (String word : words) {
            discrepanciesCount.put(word, 0);
            char[] wordChars = word.toCharArray();
            for (int i=0; i<targetChars.length; i++) {
                if (i < wordChars.length && wordChars[i] != targetChars[i]) {
                    discrepanciesCount.put(word, discrepanciesCount.get(word)+1);
                }
            }

            int sizeDifference = Math.abs(targetChars.length - wordChars.length);
            discrepanciesCount.put(word, discrepanciesCount.get(word) + sizeDifference);
        }

        for (String word : discrepanciesCount.keySet()) {
            if (discrepanciesCount.get(word) < min) {
                result = word;
                min = discrepanciesCount.get(word);
            }
        }

        return result;
    }
}
