package codewars.kyu6.persistencebugger;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(persistence(3));
    }


    public static int persistence(long n) {
        String[] nums = String.valueOf(n).split("");
        int numberOfDigits = nums.length;
        if (numberOfDigits <= 1) {
            return 0;
        }

        int persistenceNumber = 0;
        while (numberOfDigits > 1) {
            long multiplication = 1;
            for (int i=0; i<numberOfDigits; i++) {
                multiplication *= Long.parseLong(nums[i]);
            }

            nums = String.valueOf(multiplication).split("");
            numberOfDigits = nums.length;
            persistenceNumber++;
        }

        return persistenceNumber;
    }
}
