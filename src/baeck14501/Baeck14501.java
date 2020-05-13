package baeck14501;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baeck14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Counseling> list = new ArrayList<>();

        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int p = sc.nextInt();

            list.add(new Counseling(t, p));
        }

        System.out.println(solve(list, n));
    }

    private static int solve(List<Counseling> list, int n){
        int[] dp = new int[list.size() + 1];

        for(int i = list.size() - 1; i >= 0; i--) {
            if(i - 1 < n) dp[i] = dp[i+1];
            if(list.get(i).days + i > n && i - 1 < n) continue;
            if(dp[i + list.get(i).days] + list.get(i).amount > dp[i+1]) {
                dp[i] = dp[i + list.get(i).days] + list.get(i).amount;
            }
        }

        return dp[0];
    }

    static class Counseling {
        private int days;
        private int amount;

        Counseling(int days, int amount) {
            this.days = days;
            this.amount = amount;
        }
    }
}