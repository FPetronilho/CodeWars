package codewars.kyu7.arithmeticfunction;

public class Main {

    public static void main(String[] args) {

    }

    public static int arithmetic(int a, int b, String operator) {
        return operator.equals("add") ? a + b :
                operator.equals("subtract") ? a - b :
                operator.equals("multiply") ? a * b :
                operator.equals("divide") ? a / b :
                Integer.MIN_VALUE;
    }
}
