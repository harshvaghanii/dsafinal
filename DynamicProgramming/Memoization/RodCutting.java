package DynamicProgramming.Memoization;

import java.util.Arrays;

public class RodCutting {

    public static int maxProfit(int n, int[] length, int[] price) {
        if (n == 0 || length.length == 0)
            return 0;
        int[][] dp = new int[length.length + 1][n + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        return util(n, length, price, 1, dp);
    }

    public static int util(int n, int[] length, int[] price, int index, int[][] dp) {
        if (n == 0 || index > length.length)
            return 0;
        if (dp[index][n] != -1)
            return dp[index][n];
        int item_included = 0;
        if (length[index - 1] <= n) {
            item_included = price[index - 1] + util(n - length[index - 1], length, price, index, dp);
        }
        int item_excluded = util(n, length, price, index + 1, dp);
        dp[index][n] = Math.max(item_included, item_excluded);
        return dp[index][n];
    }

    public static void print(int[][] arr) {
        for (int[] a : arr) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] length = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] price = { 3, 5, 8, 9, 10, 17, 17, 20 };
        int rodLength = 8;

        int max_profit = maxProfit(rodLength, length, price);
        System.out.println("The max profit after selling the pieces of rods is : " + max_profit);

    }
}
