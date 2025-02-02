package codewars.kyu6.givemeadiamond;

public class Main {

    public static void main(String[] args) {

        System.out.println(print(7));
    }

    public static String print(int n) {
        if (n<1 || n%2 == 0) {
            return null;
        }

        StringBuilder diamond = new StringBuilder();
        for (int i=1; i<=n; i+=2){
            diamond.append(" ".repeat((n-i)/2))
                    .append("*".repeat(i))
                    .append("\n");
        }

        for (int i=n-2; i>0; i-=2){
            diamond.append(" ".repeat((n-i)/2))
                    .append("*".repeat(i))
                    .append("\n");
        }

        return diamond.toString();
    }
}
