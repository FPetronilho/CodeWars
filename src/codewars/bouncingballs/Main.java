package codewars.bouncingballs;

public class Main {

    public static void main(String[] args) {

        System.out.println(bouncingBalls(6, 0.66f, 1.5f));
        System.out.println(bouncingBallsRecursion(6, 0.66f, 1.5f));
    }

    public static int bouncingBalls(float height, float bounce, float windowHeight) {
        if (height <= 0 || bounce <= 0 || bounce >=1 || windowHeight >= height) {
            return -1;
        }

        int count = 1;
        while (height * bounce > windowHeight) {
            count += 2;
            height = height * bounce;
        }

        return count;
    }

    public static int bouncingBallsRecursion(float height, float bounce, float windowHeight) {
        if (height <= 0 || bounce <= 0 || bounce >=1 || windowHeight >= height) {
            return -1;
        }

        return 2 + bouncingBallsRecursion(height * bounce, bounce, windowHeight);
    }
}
