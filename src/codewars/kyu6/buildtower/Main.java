package codewars.kyu6.buildtower;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(towerBuilder(3)));

    }

    public static String[] towerBuilder(int nFloors) {
        String[] result = new String[nFloors];
        for (int i=0; i<nFloors; i++) {
            String current = "";
            result[i] = " ".repeat(nFloors-1-i) + "*".repeat(1+i*2) + " ".repeat(nFloors-1-i);
        }

        return result;
    }
}
