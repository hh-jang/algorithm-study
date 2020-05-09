package baeck11727;

import java.util.Scanner;

public class Baeck11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(solve(n) % 10007);
    }

    public static long solve(int n) {
        if(n == 1) return 1;
        if(n == 2) return 3;

        long [] dp = new long[n];
        dp[0] = 1;
        dp[1] = 3;

        // 점화식 도출
        // 1칸을 채우는 방법은 2x1개만 있음
        // 2칸을 채우는 방법은 1x2 2개, 2x2 총 2가지 가있음
        // 그러므로 dp[i] = dp[i-1] + dp[i-2] * 2가 된다.
        for(int i = 2; i < n; i++) {
            dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;
        }

        return dp[n-1];
    }
}
