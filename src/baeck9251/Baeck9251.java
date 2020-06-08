package baeck9251;

import java.util.Scanner;

public class Baeck9251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        System.out.println(solver(str1, str2));
    }

    // 같은 문자면 -> dp[i][j] = dp[i-1][j-1] + 1
    // 다른 문자면 -> dp[i][j] = MAX(dp[i-1][j], dp[i][j-1]
    private static int solver(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for(int i = 1; i <= str1.length(); i++) {
            for(int j = 1; j <= str2.length(); j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[str1.length()][str2.length()];
    }
}
