package leetcode.uniquepaths;

public class UniquePaths {

    public static void main(String[] args) {
//        int m = 3;
//        int n = 2;

        int m = 3;
        int n = 7;

        int result = uniquePaths(m, n);
        System.out.println(result);
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[m][n];
    }
}
