package baeck2839;

import java.util.Scanner;

public class Baeck2839 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solve(n));
    }

    private static int solve(int n) {
        int[] dp = new int[5001];
        if(n <= 5 && n != 3 && n != 5) return -1;

        dp[3] = 1;
        dp[5] = 1;

        for(int i = 6; i <= n; i++) {
            if(dp[i - 3] == 0 && dp[i - 5] == 0) {
                dp[i] = 0;
            } else if(dp[i - 3] == 0 && dp[i - 5] != 0) {
                dp[i] = dp[i - 5] + 1;
            } else if(dp[i - 3] != 0 && dp[i - 5] == 0) {
                dp[i] = dp[i - 3] + 1;
            } else {
                dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
            }
        }
        //dp[i] = Min(dp[i - 3], dp[i - 5]);

        if(dp[n] == 0) return -1;
        else return dp[n];
    }
}
