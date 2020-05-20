package baeck11055;

import java.util.Scanner;

public class Baeck11055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] values = new int[n];

        for(int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }
        System.out.println(solve(n, values));
    }

    private static int solve(int n, int[] values) {
        int[] dp = new int[n];
        dp[0] = values[0];
        if(n == 1) return dp[0];
        int result = dp[0];

        for(int i = 1; i < values.length; i++) {
            dp[i] = values[i];
            for(int j = 0; j < i; j++) {
                if(values[j] < values[i] && dp[j] + values[i] > dp[i]) {
                    dp[i] = dp[j] + values[i];
                    result = Math.max(result, dp[i]);
                }
            }
        }

        return result;
    }
}
