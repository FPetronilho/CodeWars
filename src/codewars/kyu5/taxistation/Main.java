package codewars.kyu5.taxistation;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        calculateTrips(
                new int[] {40, 80, 40, 80},
                new int[] {20, 40}
        );
    }

    public static int[] calculateTrips(int[] distances, int[] speeds) {
        int[] sortedSpeeds = Arrays.stream(speeds)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int[] travels = new int[speeds.length];
        Map<Integer, Integer> taxis = new HashMap<>();
        for (int speed : speeds) {
            taxis.put(speed, 0);
        }

        int distanceCounter = 0;

        while (distanceCounter < distances.length) {
            for (int speed : sortedSpeeds) {
                if (speed != 0) {
                    int time = calculateTravelTime(distances[distanceCounter], speed);
                    taxis.put(speed, taxis.get(speed)+1);
                    distanceCounter++;
                }
            }


        }

        return null;
    }

    public static int calculateTravelTime(int distance, int speed){
        return distance / speed * 2;
    }

    public static int checkWhichTaxiWillBeAvailableFirstAndTravelTimesOfRemainingOnes(int[] traveling) {
        return -1;
    }
}
