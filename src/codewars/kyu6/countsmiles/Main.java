package codewars.kyu6.countsmiles;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(countSmileys(
                Arrays.asList(":)", ";(", ";}", ":-D")
        ));

        System.out.println(countSmileysOptimized(
                Arrays.asList(":)", ";(", ";}", ":-D")
        ));
    }

    public static int countSmileys(List<String> arr) {
        int smileCount = 0;
        for (String smile : arr) {
            char eyes = smile.charAt(0);
            if (eyes == ';' || eyes == ':') {
                if (smile.length() == 2) {
                    char mouth = smile.charAt(1);
                    if (mouth == 'D' || mouth == ')') {
                        smileCount++;
                    }
                }

                if (smile.length() == 3) {
                    char nose = smile.charAt(1);
                    char mouth = smile.charAt(2);
                    if ((nose == '-' || nose == '~') && (mouth == 'D' || mouth == ')')) {
                        smileCount++;
                    }
                }
            }
        }

        return smileCount;
    }

    public static int countSmileysOptimized(List<String> arr) {
        return (int) arr.stream()
                .filter(x -> x.matches("[:;][-~]?[)D]"))
                .count();
    }
}
