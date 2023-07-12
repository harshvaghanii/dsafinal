package DynamicProgramming.Tabulation;

/*
 * You are given an array of Integers and a target sum.
 * Return true if the target sum if possible to achieve by adding sub sets of the numbers in the array
 */

public class TargetSumSubset {
    public static boolean targetSum(int[] number, int target) {
        boolean[][] dp = new boolean[number.length + 1][target + 1];

        // Initializing the DP Array
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        int i = 1, j = 1;
        for (i = 1; i < dp.length; i++) {
            for (j = 1; j < dp[0].length; j++) {

                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                } else if (j >= number[i - 1]) {
                    dp[i][j] = dp[i - 1][j - number[i - 1]];
                } 
            }
        }

        return dp[number.length][target];
    }

    public static void main(String[] args) {
        int[] numbers = { 4, 2, 7, 1, 3 };
        int target_sum = 18;
        boolean res = targetSum(numbers, target_sum);
        if (res) {
            System.out.println("The target sum is achievable!");
        } else {
            System.out.println("The target sum is not achievable!");
        }
    }

}
