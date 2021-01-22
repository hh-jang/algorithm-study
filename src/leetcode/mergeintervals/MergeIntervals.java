package leetcode.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = merge(input);

        Arrays.stream(result).forEach(ints -> System.out.println(ints[0] + " " + ints[1]));
    }

    public static int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;

        // interval들의 작은 수를 기준으로 정렬(문제 조건에서 왼쪽이 무조건 작다)
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] < o2[0]) return -1;
                if(o1[0] == o2[0]) return 0;
                return 1;
            }
        });

        int[] beforeInterval = intervals[0];
        result.add(beforeInterval);

        // 이전 interval과 다음 interval을 비교한다
        // 1. 이전 interval에서 큰값 >= 다음 interval 작은값이면 두개의 interval이 겹치므로 interval을 합침
        // 2. 이전 interval에서 큰값 < 다음 interval 작은값이면 두개의 interval이 안겹치므로 이전까지의 interval은 목록에 추가해야함
        for(int[] interval : intervals) {
            if(beforeInterval[1] >= interval[0]) {
                beforeInterval[1] = Math.max(beforeInterval[1], interval[1]);
            } else {
                beforeInterval = interval;
                result.add(beforeInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
