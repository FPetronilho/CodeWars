package codewars.kyu5.taxistation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(calculateTrips(
                new int[]{  },
                new int[]{ 0, 0, 0 }
        )));
    }

    public static int[] calculateTrips(int[] distances, int[] speeds) {
        if (speeds == null || speeds.length == 0) {
            return new int[0];
        }

        int[] trips = new int[speeds.length];
        if (distances == null || distances.length == 0) {
            for (int i=0; i<speeds.length; i++) {
                trips[i] = 0;
            }

            return trips;
        }

        Map<Integer, Taxi> taxiMap = new HashMap<>();
        for (int i=0; i<speeds.length; i++) {
            Taxi taxi = new Taxi(speeds[i]);
            taxiMap.put(i, taxi);
        }


        int currentTravelCounter = 0;
        int numberOfTravels = distances.length;

        while (currentTravelCounter<numberOfTravels) {
            Taxi taxiToGo = prioritizeTaxiToGo(taxiMap);
            taxiToGo.incrementTrips();
            float timeUntilReady = (float) distances[currentTravelCounter] / taxiToGo.getSpeed() * 2;
            taxiToGo.updateTimeUntilReady(timeUntilReady);
            currentTravelCounter++;
        }

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

            if (currentTaxi.getTimeUntilReady() > 0) {
                currentTaxi.deductTimeRelativeToCurrentTaxiToGo(taxiToGo.getTimeUntilReady());
            }
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
            timeUntilReady = speed == 0 ? Float.MAX_VALUE : 0;
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

        public void incrementTrips() {
            if (speed != 0) {
                trips++;
            }
        }

        public void deductTimeRelativeToCurrentTaxiToGo(float timeToDeduct) {
            timeUntilReady -= timeToDeduct;
        }

        public void updateTimeUntilReady(float newTimeUntilReady) {
            timeUntilReady = newTimeUntilReady;
        }
    }
}
