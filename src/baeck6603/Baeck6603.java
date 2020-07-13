package baeck6603;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Baeck6603 {

    public static final int MAX_NUM = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        int[] array;

        while(true) {
            n = sc.nextInt();
            if(n == 0) break;

            array = new int[n];

            for(int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }

            solve(array, n);
        }
    }

    public static void solve(int[] array, int n) {
        boolean[] visited = new boolean[n];
        combination(array, visited, 0, n, MAX_NUM);
    }

    private static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
}
