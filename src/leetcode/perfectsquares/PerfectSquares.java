package leetcode.perfectsquares;

public class PerfectSquares {
    public static void main(String[] args) {
        int n = 12;
        int result = numSquares(n);
        System.out.println(result);
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        int rootNumber;
        dp[1] = 1;

        for(int i = 1;  i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            rootNumber = (int) Math.sqrt(i);

            for(int j = 1; j <= rootNumber; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}
