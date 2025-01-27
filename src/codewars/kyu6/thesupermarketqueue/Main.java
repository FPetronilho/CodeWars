package codewars.kyu6.thesupermarketqueue;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(solveSuperMarketQueue(
                new int[] {2, 2, 3, 3, 4, 4},
                2
        ));

        System.out.println(solveSuperMarketQueueOptimized(
                new int[] {2, 2, 3, 3, 4, 4},
                2
        ));

    }

    public static int solveSuperMarketQueue(int[] customers, int n) {
        if (customers == null || customers.length == 0 || n == 0) {
            return 0;
        }

        List<Integer> tills = new ArrayList<>();
        for (int i=0; i<n; i++) {
            tills.add(i < customers.length ? customers[i] : 0);
        }

        for (int i=n; i<customers.length; i++) {
            int minIndex = tills.indexOf(Collections.min(tills));
            tills.set(minIndex, tills.get(minIndex)+customers[i]);
        }

        return Collections.max(tills);
    }

    public static int solveSuperMarketQueueOptimized(int[] customers, int n) {
        PriorityQueue<Integer> tills = new PriorityQueue<>();
        for (int i=0; i<n; i++) {
            tills.add(0);
        }

        for (int customer : customers) {
            int currentTime = tills.poll();
            tills.add(currentTime+customer);
        }

        return Collections.max(tills);
    }
}
