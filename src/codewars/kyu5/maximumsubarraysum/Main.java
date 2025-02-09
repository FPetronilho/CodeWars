package codewars.kyu5.maximumsubarraysum;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(sequence(
                new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}
        ));

        System.out.println(sequenceOptimized(
                new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}
        ));
    }

    public static int sequence(int[] arr) {
        // Check if array is empty
        if (arr.length == 0) {
            return 0;
        }

        // Check if only positive numbers
        boolean onlyPositives = true;
        for (int num : arr) {
            if (num < 0) {
                onlyPositives = false;
            }
        }

        if (onlyPositives) {
            return Arrays.stream(arr).sum();
        }

        // Check if only negative numbers
        boolean onlyNegatives = true;
        for (int num : arr) {
            if (num > 0) {
                onlyNegatives = false;
            }
        }

        if (onlyNegatives) {
            return 0;
        }

        // Case there is a mix of both positive and negative numbers
        int maxSum = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++) {
            int sum = arr[i];
            for (int j=i+1; j<arr.length; j++) {
                sum += arr[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }


    public static int sequenceOptimized(int[] arr) {
        int max = 0;
        int sum = 0;
        for (int num : arr) {
            sum += num;
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }

        return max;
    }
}
