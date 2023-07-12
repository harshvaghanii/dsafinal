package DynamicProgramming.Tabulation;

public class KnapSack {
    public static int maxProfit(int W, int[] val, int[] wt) {
        int[][] dp = new int[wt.length + 1][W + 1];
        int i = 1, j = 1;

        /*
         * i => Number of item
         * j => Capacity of the knapsack
         */

        for (i = 1; i < dp.length; i++) {
            for (j = 1; j < dp[0].length; j++) {
                if (j >= wt[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        print(dp);
        return dp[wt.length][W];
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

        int res = maxProfit(W, val, wt);
        System.out.println("The max Profit is : " + res);

    }
}
