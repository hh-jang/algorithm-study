package baeck2309;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Baeck2309 {
    private static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dwarfs = new int[9];
        boolean[] visited = new boolean[9];


        for(int i = 0; i < dwarfs.length; i++) {
            dwarfs[i] = sc.nextInt();
        }
        solve(dwarfs, visited);

        combination(dwarfs, visited, 0, 9, 7);
    }

    private static int solve(int[] dwarfs, boolean[] visited) {
        combination(dwarfs, visited, 0, 9, 7);

        return 0;
    }

    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            int result = 0;
            List<Integer> combinationNumbers = getCombinationNumbers(arr, visited, n);
            result = combinationNumbers.stream().mapToInt(o -> o).sum();
            if(result == 100 && count < 1) {
                count++;
                printResult(combinationNumbers);
            }
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;

        }
    }

    private static void printResult(List<Integer> combinationNumbers) {
        Collections.sort(combinationNumbers);
        combinationNumbers.forEach(o -> System.out.println(o));
    }

    static List<Integer> getCombinationNumbers(int[] arr, boolean[] visited, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                list.add(arr[i]);
            }
        }
        return list;
    }
}
