package codewars.kyu6.findtheoddint;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(findIt(new int[] { 1,2,2,3,3,3,4,3,3,3,2,2,1 }));
    }

    public static int findIt(int[] a) {
        Map<Integer, Integer> intCount = new HashMap<>();

        for (int num : a) {
            if (!intCount.containsKey(num)) {
                intCount.put(num, 1);
            } else {
                intCount.put(num, intCount.get(num)+1);
            }
        }

        int oddNumber = 0;
        for (Map.Entry<Integer, Integer> entry : intCount.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddNumber = entry.getKey();
            }
        }

        return oddNumber;
    }
}
