package DynamicProgramming.Memoization;

public class CoinChange {

    public static int minCoins(int[] coins, int amount, int index) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        return util(coins, amount, index, dp);
    }

    public static int util(int[] coins, int amount, int index, int[][] dp) {
        if (amount == 0)
            return 0;
        if (index == 0)
            return -1;
        if (dp[index][amount] != Integer.MAX_VALUE)
            return dp[index][amount];
        int coin_included = -1;
        if (amount >= coins[index]) {
            coin_included = minCoins(coins, amount - coins[index], index);
            if (coin_included != -1)
                coin_included += 1;
        }
        int coin_excluded = minCoins(coins, amount, index + 1);
        if (coin_included == -1 && coin_excluded == -1) {
            return -1;
        } else if (coin_included == -1)
            return coin_excluded;
        else if (coin_excluded == -1)
            return coin_included;
        else
            return Math.min(coin_included, coin_excluded);
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        int res = minCoins(coins, amount, coins.length - 1);
        System.out.println("The minimum number of coins is : " + res);
    }
}
