package codewars.kyu8.countingsheeps;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(countSheeps(new Boolean[] {
                true,  true,  true,  null,
                true,  true,  true,  true ,
                true,  false, true,  false,
                true,  false, false, true ,
                true,  true,  true,  true ,
                false, false, true,  true }));
    }

    public static int countSheeps(Boolean[] arrayOfSheeps) {
        if (arrayOfSheeps == null) {
            return 0;
        }

        return (int) Arrays.stream(arrayOfSheeps)
                .filter(n -> n != null && n)
                .count();
    }
}
