package DynamicProgramming.Tabulation;

public class RodCutting {

    public static int maxProfit(int n, int[] length, int[] price) {
        int[][] dp = new int[price.length + 1][n + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j >= i) {
                    dp[i][j] = Math.max(dp[i - 1][j], price[i - 1] + dp[i][j - i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[price.length][n];
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
