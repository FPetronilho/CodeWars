package codewars.kyu8.findsmallestinteger;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(findSmallestInt(new int[]{4, -2, 7, 9, 5}));
    }

    public static int findSmallestInt(int[] args) {
        return Arrays.stream(args)
                .min()
                .getAsInt();
    }
}
