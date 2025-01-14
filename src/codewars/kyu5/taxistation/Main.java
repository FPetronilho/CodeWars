package codewars.kyu5.taxistation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(calculateTrips(
                new int[]{ 100, 50, 80 },
                new int[]{  }
        )));
    }

    public static int[] calculateTrips(int[] distances, int[] speeds) {
        // Check for null or empty arrays.
        if (distances == null || distances.length == 0) {
            return new int[] { 0 };
        }

        if (speeds == null || speeds.length == 0) {
            return new int[0];
        }

        // Create Map for different taxis speeds
        Map<Integer, Taxi> taxiMap = new HashMap<>();
        for (int i=0; i<speeds.length; i++) {
            Taxi taxi = new Taxi(speeds[i]);
            taxiMap.put(i, taxi);
        }


        // Start looping through the trips
        int currentTravelCounter = 0;
        int numberOfTravels = distances.length;

        while (currentTravelCounter<numberOfTravels) {
            Taxi taxiToGo = prioritizeTaxiToGo(taxiMap);
            taxiToGo.setTrips(taxiToGo.getTrips()+1);
            float timeUntilReady = (float) distances[currentTravelCounter] / taxiToGo.getSpeed() * 2;
            taxiToGo.setTimeUntilReady(timeUntilReady);
            currentTravelCounter++;
        }

        // Create array to return the number of trips in the same order as the speed array parameter
        int[] trips = new int[speeds.length];
        for (int i=0; i<trips.length; i++) {
            trips[i] = taxiMap.get(i).getTrips();
        }

        return trips;
    }

    public static Taxi prioritizeTaxiToGo(Map<Integer, Taxi> taxiMap) {
        Taxi taxiToGo = null;
        for (Map.Entry<Integer, Taxi> entry: taxiMap.entrySet()) {
            Taxi currentTaxi = entry.getValue();

            if (taxiToGo == null || currentTaxi.getTimeUntilReady() < taxiToGo.getTimeUntilReady()) {
                taxiToGo = currentTaxi;
            }

            if (taxiToGo.getTimeUntilReady() == currentTaxi.getTimeUntilReady()) {
                if (currentTaxi.getSpeed() > taxiToGo.getSpeed()) {
                    taxiToGo = currentTaxi;
                }
            }
        }

        for (Map.Entry<Integer, Taxi> entry: taxiMap.entrySet()) {
            Taxi currentTaxi = entry.getValue();
            if (Objects.equals(currentTaxi, taxiToGo)) {
                continue;
            }

            float newTimeUntilReady = currentTaxi.getTimeUntilReady() - taxiToGo.getTimeUntilReady();

            currentTaxi.setTimeUntilReady(newTimeUntilReady);
        }

        return taxiToGo;
    }


    static class Taxi {
        private final int speed;
        private int trips;
        private float timeUntilReady;

        public Taxi(int speed) {
            this.speed = speed;
            trips = 0;
            timeUntilReady = speed == 0 ? -1 : 0;
        }

        public int getSpeed() {
            return speed;
        }

        public int getTrips() {
            return trips;
        }

        public float getTimeUntilReady() {
            return timeUntilReady;
        }

        public void setTrips(int trips) {
            this.trips = trips;
        }

        public void setTimeUntilReady(float timeUntilReady) {
            this.timeUntilReady = timeUntilReady;
        }
    }
}
