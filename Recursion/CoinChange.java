package Recursion;

public class CoinChange {

    public static int minWays(int[] coins, int amount, int index) {
        if (amount == 0)
            return 0;
        if (index == coins.length)
            return -1;
        int coin_included = -1;
        if (amount >= coins[index]) {
            coin_included = minWays(coins, amount - coins[index], index);
            if (coin_included != -1)
                coin_included += 1;
        }
        int coin_excluded = minWays(coins, amount, index + 1);
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
        int res = minWays(coins, amount, 0);
        System.out.println("The minimum number of coins is : " + res);
    }
}
