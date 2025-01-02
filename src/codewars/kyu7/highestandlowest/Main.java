package codewars.kyu7.highestandlowest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(highAndLow("1 9 3 4 -5"));
        System.out.println(highAndLowOptimized("1 9 3 4 -5"));
    }


    public static String highAndLow(String numbers) {
        String[] nums = numbers.split(" ");
        int max = Integer.parseInt(nums[0]);
        int min = Integer.parseInt(nums[0]);;

        for (String num : nums) {
            int aux = Integer.parseInt(num);
            if (aux > max) {
                max = aux;
            }

            if (aux < min) {
                min = aux;
            }
        }

        return String.format("%s %s", max, min);
    }


    public static String highAndLowOptimized(String numbers) {
        List<Integer> nums = Arrays.stream(numbers.split(" "))
                .map(Integer::parseInt)
                .toList();

        return String.format("%s %s", Collections.max(nums), Collections.min(nums));
    }
}
