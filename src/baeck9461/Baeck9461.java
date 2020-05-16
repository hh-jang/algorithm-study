package baeck9461;

import java.util.Scanner;

public class Baeck9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println(solve(n));
        }
    }

    public static long solve(int n) {
        long[] dp = new long[101];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        if(n < 6) return dp[n];

        for(int i = 6; i <= n; i++) {
            if(i-5 <= 0) {
                dp[i] = dp[i-1];
                continue;
            }
            dp[i] = dp[i-1] + dp[i-5];
        }

        return dp[n];
    }
}
