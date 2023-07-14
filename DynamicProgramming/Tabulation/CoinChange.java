package DynamicProgramming.Tabulation;

public class CoinChange {

    public static int minCoins(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 1; i < dp[0].length; i++)
            dp[0][i] = -1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int coin_included = -1;
                if (j >= coins[i - 1] && dp[i][j - coins[i - 1]] != -1) {
                    coin_included = 1 + dp[i][j - coins[i - 1]];
                }
                int coin_excluded = dp[i - 1][j];
                if (coin_included == -1 && coin_excluded == -1)
                    dp[i][j] = -1;
                else if (coin_included == -1)
                    dp[i][j] = coin_excluded;
                else if (coin_excluded == -1)
                    dp[i][j] = coin_included;
                else
                    dp[i][j] = Math.min(coin_included, coin_excluded);
            }
        }
        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        int res = minCoins(coins, amount);
        System.out.println("The minimum number of coins is : " + res);
    }
}
