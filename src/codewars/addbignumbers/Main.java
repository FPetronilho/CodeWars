package codewars.addbignumbers;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        System.out.println(add("697072523", "033240528340482728949272650854"));
        System.out.println(addWithoutBigInteger("697072523", "033240528340482728949272650854"));
    }

    public static String add(String a, String b) {
        return String.valueOf(new BigInteger(a).add(new BigInteger(b)));
    }

    public static String addWithoutBigInteger(String a, String b) {
        int positionNumberA = a.length()-1;
        int positionNumberB = b.length()-1;
        int carryOver = 0;
        StringBuilder result = new StringBuilder();

        while (positionNumberA >= 0 || positionNumberB >= 0 || carryOver != 0) {
            int digitA = positionNumberA >= 0 ? a.charAt(positionNumberA) - '0' : 0;
            int digitB = positionNumberB >= 0 ? b.charAt(positionNumberB) - '0' : 0;
            int sum = digitA + digitB + carryOver;

            result.append(sum % 10);
            carryOver = sum / 10;
            positionNumberA--;
            positionNumberB--;
        }

        String res = result.reverse().toString();
        if (res.charAt(0) == '0') {
            res = res.substring(1);
        }

        return res;
    }
}
