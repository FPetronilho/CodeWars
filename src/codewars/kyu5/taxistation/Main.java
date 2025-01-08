package codewars.kyu5.taxistation;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(calculateTrips(
                new int[]{40, 80, 40, 80},
                new int[]{20, 40}
        )));
    }

    public static int[] calculateTrips(int[] distances, int[] speeds) {
        // Get number of travels and set number of taxis that left to 0
        int numberOfTravels = distances.length;

        // Sort the taxis speed array to descending so that they can leave in order on the first instance
        int[] sortedSpeeds = Arrays.stream(speeds)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        // Create a map to track which taxis ("id" by speeds) have completed travels and how much time there is left
        // until arrival back at garage
        Map<Integer, List<Integer>> numberOfTravelsPerSpeed = populateTaxisAndFirstTravel(
                sortedSpeeds,
                distances,
                numberOfTravels
        );

        // Check number of travels from departing taxis
        int currentTravelCounter = 0;
        for (Map.Entry<Integer, List<Integer>> entry: numberOfTravelsPerSpeed.entrySet()) {
            currentTravelCounter += entry.getValue().get(0);
        }

        // Loop until all travels are finished
        while (checkIfThereIsANextTravel(currentTravelCounter, numberOfTravels)) {
            int taxiReadyToGo = checkWhichTaxiIsReadyToGo(numberOfTravelsPerSpeed);
            int travelTime = calculateTravelTime(distances[currentTravelCounter-1], taxiReadyToGo);
            numberOfTravelsPerSpeed.put(taxiReadyToGo, Arrays.asList(
                    numberOfTravelsPerSpeed.get(taxiReadyToGo).get(0)+1,
                    travelTime
            ));
        }

        // Create result array and populate it in the same order of the given speeds
        int[] travelsResult = new int[speeds.length];
        for (int i=0; i<speeds.length; i++) {
            travelsResult[i] = numberOfTravelsPerSpeed.get(speeds[i]).get(0);
        }

        return travelsResult;
    }


    private static int calculateTravelTime(int distance, int speed){
        return distance / speed * 2;
    }


    private static boolean checkIfThereIsANextTravel(int counter, int numberOfTravels) {
        return numberOfTravels > counter;
    }


    private static Map<Integer, List<Integer>> populateTaxisAndFirstTravel(
            int[] sortedSpeeds,
            int[] distances,
            int numberOfTravels
    ) {
        Map<Integer, List<Integer>> numberOfTravelsPerSpeed = new HashMap<>();
        int currentTravelCounter = 0;

        // Populate the map and take advantage of the initiated loop to start the travels already
        for (int speed: sortedSpeeds) {
            if (speed == 0) {
                numberOfTravelsPerSpeed.put(speed, new ArrayList<>(Arrays.asList(0, 0)));
                continue;
            }

            if (checkIfThereIsANextTravel(currentTravelCounter, numberOfTravels)) {
                int travelTime = calculateTravelTime(distances[currentTravelCounter], speed);
                numberOfTravelsPerSpeed.put(speed, new ArrayList<>(Arrays.asList(1, travelTime)));
                currentTravelCounter++;
            } else {
                numberOfTravelsPerSpeed.put(speed, new ArrayList<>(Arrays.asList(0, 0)));
            }
        }

        return numberOfTravelsPerSpeed;
    }


    private static int checkWhichTaxiIsReadyToGo(Map<Integer, List<Integer>> numberOfTravelsPerSpeed) {
        // If we get to this point then all taxis have left and there are still travels pending so, we do not need to
        // check for taxis that have not yet departed
        int expectedSpeed = 0;
        int minWaitTime = Integer.MAX_VALUE;

        // Check which is the taxi with the minimum waiting time
        for (Map.Entry<Integer, List<Integer>> entry: numberOfTravelsPerSpeed.entrySet()) {
            if (entry.getKey() == 0) {
                continue;
            }

            if (entry.getValue().get(1) < minWaitTime) {
                minWaitTime = entry.getValue().get(1);
                expectedSpeed = entry.getKey();
            }
        }

        // Subtract the minimum waiting time for all taxis to simulate the time passing
        for (Map.Entry<Integer, List<Integer>> entry: numberOfTravelsPerSpeed.entrySet()) {
            if (entry.getKey() == 0) {
                continue;
            }

            numberOfTravelsPerSpeed.put(
                    entry.getKey(),
                    Arrays.asList(
                            entry.getValue().get(0),
                            entry.getValue().get(1)-minWaitTime)
            );
        }

        return expectedSpeed;
    }
}
