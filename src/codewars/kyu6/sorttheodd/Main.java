package codewars.kyu6.sorttheodd;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
        System.out.println(Arrays.toString(sortArrayOptimized(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
    }

    public static int[] sortArray(int[] array) {
        int[] result = new int[array.length];
        boolean[] isOdd = new boolean[array.length];
        List<Integer> odds = new ArrayList<>();

        for (int i=0; i<isOdd.length; i++) {
            if (array[i]%2 != 0) {
                isOdd[i] = true;
                odds.add(array[i]);
            } else {
                isOdd[i] = false;
            }
        }

        Collections.sort(odds);
        int oddsCounter = 0;
        for (int i=0; i<isOdd.length; i++) {
            if (isOdd[i]) {
                result[i] = odds.get(oddsCounter);
                oddsCounter++;
            } else {
                result[i] = array[i];
            }
        }

        return result;
    }

    public static int[] sortArrayOptimized(int[] array) {
        Iterator<Integer> sortedOdds = Arrays.stream(array)
                .filter(n -> n%2 == 1)
                .sorted()
                .iterator();

        return Arrays.stream(array)
                .map(n -> n%2 == 1 ? sortedOdds.next() : n)
                .toArray();
    }
}
