package codewars.kyu5.findpeaks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println(getPeaks(
                new int[] {6, -4, 18, 18, -1, 13, 13, 9, 7, 10, 0, 14, -2, 14}
        ));
    }

    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        Map<String, List<Integer>> result = new HashMap<>();
        List<Integer> pos = new ArrayList<>();
        List<Integer> peaks = new ArrayList<>();

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1]) {
                int j = i;
                while (j < arr.length - 1 && arr[j] == arr[j + 1]) {
                    j++;
                }
                if (j < arr.length - 1 && arr[j] > arr[j + 1]) {
                    pos.add(i);
                    peaks.add(arr[i]);
                }
            }
        }

        result.put("pos", pos);
        result.put("peaks", peaks);
        return result;
    }
}
