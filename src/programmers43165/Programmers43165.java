package programmers43165;

import java.util.List;

public class Programmers43165 {
    private static int result = 0;

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(solve(numbers, target));
    }

    public static int solve(int[] numbers, int target) {
        int[] visited = new int[numbers.length];

        backtracking(numbers, visited, 0, numbers.length, target);

        return result;
    }

    public static void backtracking(int[] arr, int[] values, int start, int n, int target) {
        if(start == n) {
            int sum = 0;
            for(int i = 0; i < values.length; i++)
                sum += values[i];

            if(sum == target) result++;
            return;
        }
        values[start] = arr[start];
        backtracking(arr, values, start + 1, n, target);

        values[start] = arr[start] * -1;
        backtracking(arr, values, start + 1, n, target);
    }
}
