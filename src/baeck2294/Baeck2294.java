package baeck2294;

import java.util.Scanner;

public class Baeck2294 {

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

    private static int solve(int[] coins, int k) {
        int[] dp = new int[100001];

        for(int i = 0; i < coins.length; i++) dp[coins[i]] = 1;

        for(int i = 1; i <= k; i++) {
            for(int j = 0; j < coins.length; j++) {
                int value = coins[j];

                if(i + value > k) continue;
                if(dp[i + value] != 0) dp[i + value] = Math.min(dp[i + value], dp[i] + 1);
                else dp[i + value] = dp[i] + 1;
            }
        }

        if(dp[k] == 0) return -1;
        return dp[k];
    }
}
