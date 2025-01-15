package codewars.kyu5.taxistation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Optimized {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(calculateTrips(
                new int[]{ 100, 50, 80, 40, 40,100, 50, 80, 40, 40, 100, 50, 80, 40, 40 },
                new int[]{ 30, 20, 10 }
        )));
    }


    public static int[] calculateTrips(int[] distances, int[] speeds) {
        int[] trips = new int[speeds.length];

        PriorityQueue<Taxi> taxiQueue = new PriorityQueue<>();
        for (int i=0; i<speeds.length; i++) {
            if (speeds[i] > 0) {
                taxiQueue.add(new Taxi(speeds[i], i));
            }
        }

        for (int distance : distances) {
            Taxi taxiToGo = taxiQueue.poll();
            taxiToGo.updateTimeUntilReady(distance);
            taxiQueue.add(taxiToGo);
            trips[taxiToGo.getIndex()]++;
        }

        return trips;
    }

    ///////////////////////////////////////////////////////////////
    public static class Taxi implements Comparable<Taxi> {

        private final int index;
        private final int speed;
        private float timeUntilReady;

        public Taxi(int speed, int index) {
            this.index = index;
            this.speed = speed;
            timeUntilReady = 0;
        }

        public int getIndex() {
            return index;
        }

        public int getSpeed() {
            return speed;
        }

        public float getTimeUntilReady() {
            return timeUntilReady;
        }

        public void updateTimeUntilReady(int distance) {
            timeUntilReady += (float) distance / speed * 2;
        }

        @Override
        public int compareTo(Taxi o) {
            if (timeUntilReady != o.timeUntilReady) {
                return Float.compare(timeUntilReady, o.getTimeUntilReady());
            }

            return Integer.compare(o.getSpeed(), speed);
        }
    }
}
