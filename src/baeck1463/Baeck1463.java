package baeck1463;

import java.util.Scanner;

public class Baeck1463 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solve(n));
    }

    private static int solve(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;

//        dp[i] = dp[i - 1] + 1;
//        dp[i] = dp[i / 2] + 1;
//        dp[i] = dp[i / 3] + 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = mustMin(dp, i);
        }

        return dp[n];
    }

    private static int mustMin(int[] dp, int i) {
        dp[i] = Integer.MAX_VALUE;

        if(i > 1) {
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        }
        if(i % 2 == 0) {
            dp[i] = Math.min(dp[i], dp[i / 2] + 1);
        }
        if(i % 3 == 0) {
            dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
        return dp[i];
    }
}
