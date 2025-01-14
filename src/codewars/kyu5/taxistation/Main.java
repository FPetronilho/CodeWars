package codewars.kyu5.taxistation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(calculateTrips(
                new int[]{ 100, 50, 80, 40, 40 },
                new int[]{ 30, 20, 10 }
        )));
    }

    public static int[] calculateTrips(int[] distances, int[] speeds) {
        if (speeds == null || speeds.length == 0 || distances == null || distances.length == 0) {
            return new int[] { 0 };
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
            taxiToGo.setTrips(taxiToGo.getTrips()+1);
            taxiToGo.setTimeUntilReady(distances[currentTravelCounter]*2);
            currentTravelCounter++;
        }

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
            if (entry.getKey() == 0) {
                continue;
            }

            if (taxiToGo == null || currentTaxi.getTimeUntilReady() < taxiToGo.getTimeUntilReady()) {
                taxiToGo = currentTaxi;
            } else if (taxiToGo.getTimeUntilReady() == currentTaxi.getTimeUntilReady()) {
                if (currentTaxi.getSpeed() > taxiToGo.getSpeed()) {
                    taxiToGo = currentTaxi;
                }
            }
        }

        for (Map.Entry<Integer, Taxi> entry: taxiMap.entrySet()) {
            Taxi currentTaxi = entry.getValue();
            if (currentTaxi == taxiToGo) {
                continue;
            }

            float newTimeUntilReady =
                    taxiToGo != null ? (currentTaxi.getTimeUntilReady() - taxiToGo.getTimeUntilReady()) : 0f;

            if (entry.getKey() == 0) {
                continue;
            }

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
