package codewars.kyu6.arraydiff;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(arrayDiff(
                        new int[]{1, 2, 2, 3},
                        new int[]{1, 2}
                ))
        );
    }

    public static int[] arrayDiff(int[] a, int[] b) {
        int[] result = Arrays.copyOf(a, a.length);
        for (int i=0; i<b.length; i++) {
            int finalI = i;
            result = Arrays.stream(result)
                    .filter(x -> b[finalI] != x)
                    .toArray();
        }

        return result;
    }
}
