package DynamicProgramming.Tabulation;

import java.util.*;

public class LongestIncreasingSubsequence {

    public static int lis(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int[] copy = new int[set.size()];
        int i = 0;
        for (int k : set) {
            copy[i++] = k;
        }
        Arrays.sort(copy);
        int[][] dp = new int[nums.length + 1][copy.length + 1];

        for (i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (nums[i - 1] == copy[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        print(dp);
        return dp[nums.length][copy.length];
    }

    public static void print(int[][] nums) {
        for (int[] a : nums) {
            for (int i : a) {
                System.out.print(i + "");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] nums = { 50, 3, 10, 7, 40, 80 };
        int res = lis(nums);
        System.out.println("The longest increasing subsequence is : " + res);
    }
}
