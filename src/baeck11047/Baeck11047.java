package baeck11047;

import java.util.Scanner;

public class Baeck11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coins = new int[n];

        for(int i = 0; i < n; i++)
            coins[i] = sc.nextInt();

        System.out.println(solve(n, k, coins));
    }

    private static int solve(int n, int k, int[] coins) {
        int result = 0;

        for(int i = n - 1; i >= 0; i--) {
            int numberOfCoin = k / coins[i];
            k -= numberOfCoin * coins[i];
            result += numberOfCoin;
        }

        return result;
    }
}
