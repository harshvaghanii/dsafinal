package DynamicProgramming.Memoization;

import java.util.Arrays;

public class KnapSack {

    public static int maxProfit(int[] wt, int[] val, int W, int index) {
        // Base Case
        if (index == wt.length)
            return 0;

        int[][] dp = new int[wt.length + 1][W + 1];

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        return util(wt, val, W, index + 1, dp);
    }

    public static int util(int[] wt, int[] val, int W, int index, int[][] dp) {
        // Base Case
        if (index > wt.length)
            return 0;
        if (dp[index][W] != -1)
            return dp[index][W];
        int item_included = 0;
        if (W >= wt[index - 1]) {
            item_included = util(wt, val, W - wt[index - 1], index + 1, dp) + val[index - 1];
        }
        int item_excluded = util(wt, val, W, index + 1, dp);
        dp[index][W] = Math.max(item_included, item_excluded);
        return dp[index][W];
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
        int[] val = { 15, 14, 10, 45, 30 };
        int[] wt = { 2, 5, 1, 3, 4 };
        int W = 7;
        // int[] val = { 1, 2, 3 };
        // int[] wt = { 4, 5, 1 };
        // int W = 4;

        int res = maxProfit(wt, val, W, 0);
        System.out.println("The max Profit is : " + res);

    }
}
