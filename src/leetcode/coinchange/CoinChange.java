package leetcode.coinchange;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2 , 5};
        int amount = 11;

        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount + 1];

        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(i - coins[j] == 0) {
                    dp[i] = 1;
                    continue;
                }

                if(i - coins[j] >= 0 && dp[i - coins[j]] > 0) {
                    if(dp[i] == 0) {
                        dp[i] = dp[i - coins[j]] + 1;
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
