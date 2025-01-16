package codewars.kyu6.tenminutewalk;

public class Main {

    public static void main(String[] args) {

    }

    public static boolean isValid(char[] walk) {
        if (walk.length != 10) {
            return false;
        }

        int[] coor = new int[2];
        for (char c : walk) {
            switch (c) {
                case 'e': coor[0]--;
                case 'w': coor[0]++;
                case 's': coor[1]--;
                case 'n': coor[1]++;
            }
        }

        return (coor[0] == 0 && coor[1] == 0);
    }
}
