package codewars.kyu5.emirps;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(findEmirp(100)));
    }

    public static long[] findEmirp(long n){
        if (n < 13) {
            return new long[] {0, 0, 0};
        }

        int emirpsCount = 0;
        long largestEmirp = 0;
        long sumEmirps = 0;

        for (long i=13; i<=n; i++) {
            String currentNumber = String.valueOf(i);
            String reversed = new StringBuilder(currentNumber).reverse().toString();
            if (!currentNumber.equals(reversed) && isEmirp(i, Integer.parseInt(reversed))) {
                emirpsCount++;
                sumEmirps += i;
                largestEmirp = i;
            }
        }

        return new long[] {emirpsCount, largestEmirp, sumEmirps};
    }

    private static boolean isEmirp(long number, long reversed) {
        return isPrime(number) && isPrime(reversed);
    }

    private static boolean isPrime(long number) {
        for (int i=2; i<=10; i++) {
            if (number%i == 0 && number != i) {
                return false;
            }
        }

        return true;
    }
}
