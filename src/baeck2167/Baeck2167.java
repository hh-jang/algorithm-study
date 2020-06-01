package baeck2167;

import java.util.Scanner;

public class Baeck2167 {
    public static long[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new long[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                arr[i][j] = sc.nextInt();
                arr[i][j] = arr[i][j] + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
            }
        }

        int k = sc.nextInt();

        for(int l = 0; l < k; l++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            System.out.println(solve(i, j, x, y));
        }
    }

    private static long solve(int i, int j, int x, int y) {
        return arr[x][y] - arr[i - 1][y] - arr[x][j - 1] + arr[i - 1][j - 1];
    }
}
