package codewars.kyu5.reducedirections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(dirReduc(
                new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}
        )));

        System.out.println(Arrays.toString(dirReducOptimized(
                new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}
        )));
    }

    public static String[] dirReduc(String[] arr) {
        int x = 0;
        int y = 0;
        for (String direction : arr) {
            switch (direction) {
                case "NORTH" -> x += 1;
                case "SOUTH" -> x -= 1;
                case "EAST" -> y += 1;
                case "WEST" -> y -= 1;
            }
        }

        int arrayLength = Math.abs(x) + Math.abs(y);
        String[] result = new String[arrayLength];
        for (int i=0; i<Math.abs(x); i++) {
            if (x < 0) {
                result[i] = "SOUTH";
            }

            if (x > 0) {
                result[i] = "NORTH";
            }
        }

        for (int i = Math.abs(x); i<arrayLength; i++) {
            if (y < 0) {
                result[i] = "WEST";
            }

            if (y > 0) {
                result[i] = "EAST";
            }
        }

        return result;
    }


    public static String[] dirReducOptimized(String[] arr) {
        List<String> directions = new ArrayList<>();
        for (String direction : arr) {
            switch (direction) {
                case "NORTH" -> {
                    if (directions.contains("SOUTH")) {
                        directions.remove("SOUTH");
                    } else {
                        directions.add("NORTH");
                    }
                }
                case "SOUTH" -> {
                    if (directions.contains("NORTH")) {
                        directions.remove("NORTH");
                    } else {
                        directions.add("SOUTH");
                    }
                }
                case "EAST" -> {
                    if (directions.contains("WEST")) {
                        directions.remove("WEST");
                    } else {
                        directions.add("EAST");
                    }
                }
                case "WEST" -> {
                    if (directions.contains("EAST")) {
                        directions.remove("EAST");
                    } else {
                        directions.add("WEST");
                    }
                }
            }
        }

        return directions.toArray(new String[0]);
    }
}
