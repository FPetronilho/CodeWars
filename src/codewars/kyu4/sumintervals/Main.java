package codewars.kyu4.sumintervals;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(sumIntervals(new int[][] {
                {0, 20}, {-100000000, 10}, {30, 40}
        }));

        System.out.println(sumIntervals2(new int[][] {
                {0, 20}, {-100000000, 10}, {30, 40}
        }));
    }

    public static int sumIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int result = 0;
        Arrays.sort(intervals, Comparator.comparing(i -> i[0]));
        List<int[]> mergedIntervals = new ArrayList<>();

        int[] currentInterval = intervals[0];
        for (int i=1; i<intervals.length; i++) {
            if (currentInterval[1] >= intervals[i][0]) {
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                mergedIntervals.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        mergedIntervals.add(currentInterval);

        for (int[] interval : mergedIntervals) {
            result += interval[1] - interval[0];
        }

        return result;
    }

    public static int sumIntervals2(int[][] intervals) {
        HashSet<Integer> numbers = new HashSet<>();
        for (int[] interval : intervals) {
            for (int i=interval[0]; i<interval[1]; i++) {
                numbers.add(i);
            }
        }

        return numbers.size();
    }
}
