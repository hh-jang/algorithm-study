package leetcode.nonoverlappingintervals;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
//        int[][] input = {{1,2},{2,3},{3,4},{1,3}};
//        int[][] input = {{1,2},{1,2},{1,2}};
        int[][] input = {{1,2},{2,3}};
        int result = eraseOverlapIntervals(input);
        System.out.println(result);
    }

    // interval의 큰 값을 기준으로 정렬을 하고 i-1의 큰값, i의 작은 값을 비교하여 중복되는 범위가 없으면 갱신, 아니면 result++
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[1] < o2[1]) return -1;
            if(o1[1] > o2[1]) return 1;
            return 0;
        });

        int result = 0;
        int beforeMaxValue = Integer.MIN_VALUE;

        for(int i = 0; i < intervals.length; i++) {
            if(beforeMaxValue <= intervals[i][0]) {
                beforeMaxValue = intervals[i][1];
            } else {
                result++;
            }
        }

        return result;
    }
}
