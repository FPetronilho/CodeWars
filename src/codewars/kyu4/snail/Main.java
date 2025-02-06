package codewars.kyu4.snail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(snail(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        })));

    }

    public static int[] snail(int[][] array) {
        if (array[0].length == 0 || array.length == 0) {
            return new int[0];
        }

        List<Integer> result = new ArrayList<>();
        int top = 0, left = 0;
        int bottom = array.length-1, right = array.length-1;

        while (top <= bottom && left <= right) {
            for (int i=left; i<=right; i++) {
                result.add(array[top][i]);
            }
            top++;

            for (int i=top; i<=bottom; i++) {
                result.add(array[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i=right; i>=left; i--) {
                    result.add(array[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i=bottom; i>=top; i--) {
                    result.add(array[i][left]);
                }
                left++;
            }
        }

        return result.stream().mapToInt(n -> n).toArray();
    }
}
