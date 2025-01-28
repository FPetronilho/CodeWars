package codewars.kyu8.convertstringtoarray;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(stringToArray("I love arrays they are my favorite")));
    }

    public static String[] stringToArray(String s) {
        return s.split(" ");
    }
}
