package codewars.kyu8.removeexclamationmarks;

public class Main {

    public static void main(String[] args) {

        System.out.println(removeExclamationMarks("Tolo!"));
    }

    static String removeExclamationMarks(String s) {
        return s.replaceAll("!", "");
    }
}
