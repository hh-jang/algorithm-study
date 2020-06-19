package programmers42839;

import java.util.HashMap;
import java.util.Map;

public class Programmers42839 {

    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String numbers = "011";

        System.out.println(solve(numbers));
    }

    private static int solve(String numbers) {
        int[] intNumbers = new int[numbers.length()];
        int result = 0;

        for(int i = 0; i  < numbers.length(); i++) {
            intNumbers[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }

        Map<Integer, Integer> compositeNumbers = getCompositeNumbersByNumbers(intNumbers);

        for(int value : compositeNumbers.keySet()) {
            if(isPrime(value)) result++;
        }
        return result;
    }

    private static boolean isPrime(int value) {
        if (value <= 1) {
            return false;
        }

        int sqrtValue = (int) Math.sqrt(value);
        for (int i = 2; i <= sqrtValue; i++) {
            if (value % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static Map<Integer, Integer> getCompositeNumbersByNumbers(int[] intNumbers) {
        for(int i = 1; i <= intNumbers.length; i++) {
            permutation(intNumbers, 0, intNumbers.length, i);
        }

        return map;
    }

    static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r; i++) {
                sb.append(arr[i]);
            }

            map.put(Integer.parseInt(sb.toString()), 1);
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
