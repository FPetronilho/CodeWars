package codewars.kyu7.rowsumoddnumbers;

public class Main {

    public static void main(String[] args) {
        System.out.println(rowSumOddNumbers(3));
    }

    public static int rowSumOddNumbers(int n) {
        int firstNumber = n*n - n + 1;
        int cumulative = firstNumber;
        int total = firstNumber;

        for (int i=1; i<n; i++) {
            cumulative += 2;
            total += cumulative;
        }

        return total;
    }
}
