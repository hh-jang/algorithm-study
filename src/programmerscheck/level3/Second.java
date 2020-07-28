package programmerscheck.level3;

public class Second {
    static int DIVIDE_CONST = 1000000007;

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 1}, {3, 2}};

        System.out.println(solution(m, n, puddles));
    }

    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n][m];
        // 0 정상, -1 물
        for(int i = 0; i < puddles.length; i++) {
            map[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
        }

        answer = dfs(map, n, m);

        return answer;

        // 코스트 동일
    }

    private static int dfs(int[][] map, int n, int m) {
        int[][] dp = new int[n][m];
        dp[0][0] = 1;

        for(int j = 0; j < m; j++) {
            if(map[0][j] == -1) {
                dp[0][j] = 0;
                break;
            } else {
                dp[0][j] = 1;
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == -1) {
                    dp[i][j] = 0;
                } else {
                    if(i - 1 < 0) {
                        dp[i][j] = dp[i][j - 1];
                    } else if(j - 1 < 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                    dp[i][j] = dp[i][j] % DIVIDE_CONST;
                }
            }
        }

        return dp[n - 1][m - 1];
    }
}
