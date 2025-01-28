package codewars.kyu8.whatcentury;

public class Main {

    public static void main(String[] args) {
        System.out.println(century(102));
    }

    public static int century(int number) {
        return number%100 == 0 ? number/100 : number/100+1;
    }
}
