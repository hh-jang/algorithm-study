package baeck9095;

import java.util.Scanner;

public class Baeck9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++)
            System.out.println(solve(sc.nextInt()));
    }

    private static int solve(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 4;

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i <= n; i++)
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];

        return dp[n];
    }
}
