package codewars.kyu6.equalsidesofanarray;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        System.out.println(findEvenIndex(
                new int[] {1,100,50,-51,1,1}
        ));

        System.out.println(findEvenIndexOptimized(
                new int[] {1,100,50,-51,1,1}
        ));
    }

    public static int findEvenIndex(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            if (i != 0) {
                int sumLeft = Arrays.stream(arr, 0, i).sum();
                int sumRight = Arrays.stream(arr, i + 1, arr.length).sum();
                if (sumRight == sumLeft) {
                    System.out.println("true");
                    return i;
                }
            } else {
                int sumRight = Arrays.stream(arr, i +1, arr.length).sum();
                if (sumRight == 0) {
                    return 0;
                }
            }
        }

        return -1;
    }

    public static int findEvenIndexOptimized(int[] arr) {
        return IntStream.range(0, arr.length)
                .filter(n -> IntStream.of(arr).limit(n).sum() == IntStream.of(arr).skip(n+1).sum())
                .findFirst()
                .orElse(-1);
    }
}
