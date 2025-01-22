package codewars.kyu6.enoughisenough;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(deleteNth(
                new int[]{ 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3
        )));

        System.out.println(Arrays.toString(deleteNthOptimized(
                new int[]{ 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3
        )));
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        int[] result = new int[elements.length];

        for (int i=0; i<elements.length; i++) {
            int number = elements[i];

            if (!occurrences.containsKey(number)) {
                occurrences.put(number, 1);
            } else {
                occurrences.put(number, occurrences.get(number)+1);
            }

            if (occurrences.get(number) <= maxOccurrences) {
                result[i] = number;
            } else {
                result[i] = Integer.MAX_VALUE;
            }
        }

        return Arrays.stream(result)
                .filter(n -> n != Integer.MAX_VALUE)
                .toArray();
    }

    public static int[] deleteNthOptimized(int[] elements, int maxOccurrences) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        return Arrays.stream(elements)
                .filter(n -> occurrences.merge(n, 1, Integer::sum) <= maxOccurrences)
                .toArray();
    }
}
