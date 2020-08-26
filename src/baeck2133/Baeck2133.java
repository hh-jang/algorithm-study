package baeck2133;

import java.util.Scanner;

public class Baeck2133 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solve(n));
    }

    private static int solve(int n) {
        if(n % 2 == 1) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[2] = 3;

        for(int i = 4; i <= n; i+=2) {
            dp[i] = dp[i - 2] * 3;

            for (int j = i - 4; j >= 0; j-=2) {
                dp[i] += 2 * dp[j];
            }
        }

        return dp[n];
    }
}
