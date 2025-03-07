package codewars.kyu7.findthestraynumber;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(stray(
                new int[] {3, 2, 2, 2, 2, 2}
        ));
    }

    static int stray(int[] numbers) {
        for (int i=0; i<numbers.length; i++) {
            if (i == 0 && numbers[i] != numbers[i+1]) {
                if (numbers[i] != numbers[i+2]) {
                    return numbers[i];
                } else {
                    return numbers[i+1];
                }
            } else if (i != 0 && i != numbers.length-1 && numbers[i] != numbers[i-1] && numbers[i] != numbers[i+1]) {
                return numbers[i];
            } else if (i == numbers.length-1 && numbers[i] != numbers[i-1]) {
                if (numbers[i] != numbers[i-2]) {
                    return numbers[i];
                } else {
                    return numbers[i-1];
                }
            }
        }

        return -1;
    }

    static int strayOptimized(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0] != numbers[1] ? numbers[0] : numbers[numbers.length-1];
    }
}
