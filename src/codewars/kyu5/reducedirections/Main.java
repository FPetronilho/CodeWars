package codewars.kyu5.reducedirections;

import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(dirReduc(
                new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}
        )));
    }

    public static String[] dirReduc(String[] arr) {
        Stack<String> stack = new Stack<>();
        for (String direction : arr) {
            if (!stack.isEmpty() && isOpposite(stack.peek(), direction)) {
                stack.pop();
            } else {
                stack.push(direction);
            }
        }

        return stack.toArray(new String[0]);
    }

    private static boolean isOpposite(String dir1, String dir2) {
        return (dir1.equals("NORTH") && dir2.equals("SOUTH")) ||
                (dir1.equals("SOUTH") && dir2.equals("NORTH")) ||
                (dir1.equals("EAST") && dir2.equals("WEST")) ||
                (dir1.equals("WEST") && dir2.equals("EAST"));
    }
}
