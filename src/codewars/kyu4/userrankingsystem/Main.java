package codewars.kyu4.userrankingsystem;

public class Main {

    public static void main(String[] args) {

        User user = new User();
        System.out.println("Rank: " + user.getRank());
        System.out.println("Progress: " + user.getProgress());

//        System.out.println("------------------  Rank -6 Challenge  ----------------------");
//        user.incProgress(-6);
//        System.out.println("Rank: " + user.getRank());
//        System.out.println("Progress: " + user.getProgress());
//
//        System.out.println("------------------  Rank -5 Challenge  ----------------------");
//        user.incProgress(-5);
//        System.out.println("Rank: " + user.getRank());
//        System.out.println("Progress: " + user.getProgress());
//
//        System.out.println("------------------  Rank -7 Challenge  ----------------------");
//        user.incProgress(-7);
//        System.out.println("Rank: " + user.getRank());
//        System.out.println("Progress: " + user.getProgress());
//
//        System.out.println("------------------  Rank -6 Challenge  ----------------------");
//        user.incProgress(-6);
//        System.out.println("Rank: " + user.getRank());
//        System.out.println("Progress: " + user.getProgress());

        System.out.println("------------------  Rank 6 Challenge  ----------------------");
        user.incProgress(-1);
        System.out.println("Rank: " + user.getRank());
        System.out.println("Progress: " + user.getProgress());
    }
}
