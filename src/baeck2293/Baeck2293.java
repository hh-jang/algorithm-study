package baeck2293;

import java.util.Scanner;

public class Baeck2293 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coins = new int[n];

        for(int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        System.out.println(solve(coins, k));
    }

    public static long solve(int[] coins, int k) {
        long[] dp = new long[k + 1];
        dp[0] = 1;

        for(int i = 0; i < coins.length; i++) {
            for(int j = coins[i]; j <= k; j++) {
                if(j - coins[i] >= 0) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }

        return dp[k];
    }
}
