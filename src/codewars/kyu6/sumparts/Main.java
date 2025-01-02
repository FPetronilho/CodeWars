package codewars.kyu6.sumparts;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumParts(new int[]{1,2,3})));
        System.out.println(Arrays.toString(sumPartsOptimized(new int[]{1,2,3})));
    }

    public static int[] sumParts(int[] ls) {
        int arrayLength = ls.length + 1;
        int[] result = new int[arrayLength];
        int resultIndex = 0;
        int startingIndex = 0;

        while (startingIndex < arrayLength) {
            int sum = 0;
            for (int i=startingIndex; i<=arrayLength-2; i++) {
                sum += ls[i];
            }

            result[resultIndex] = sum;
            resultIndex++;
            startingIndex++;
        }

        return result;
    }


    public static int[] sumPartsOptimized(int[] ls) {
        int arrayLength = ls.length + 1;
        int[] result = new int[arrayLength];
        int cumulativeSum = 0;

        for (int i=arrayLength-2; i>=0; i--) {
            cumulativeSum += ls[i];
            result[i] = cumulativeSum;
        }

        return result;
    }
}
