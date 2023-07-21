package DynamicProgramming.Tabulation;

import java.util.*;
/*
 * You are given an array of length n where a[i] represents how many steps we
 * can jump ahead.
 * Calculate the minimum number of Jumps required to reach the end of the array
 */

public class MinimumNumberOfJumps {

    public static int minJumps(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, n + 2);
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int current_step = Integer.MAX_VALUE;
            for (int j = 0; j <= arr[i]; j++) {
                if (i + j < n) {
                    current_step = 1 + dp[i + j];
                    dp[i] = Math.min(dp[i], current_step);
                }
            }
        }
        print(dp);
        return dp[0];

    }

    public static void print(int[] dp) {
        for (int i : dp) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // int[] arr = { 2, 3, 1, 1, 4 };
        int[] arr = { 2, 3, 0, 1, 4 };
        int res = minJumps(arr);
        System.out.println("The minimum number of jumps required are : " + res);
    }

}
