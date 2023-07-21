package DynamicProgramming.Memoization;

import java.util.Arrays;

/*
 * You are given an array of length n where a[i] represents how many steps we can jump ahead.
 * Calculate the minimum number of Jumps required to reach the end of the array
 */

public class MinimumNumberOfJumps {
    static int counter = 0;

    public static int minJumps(int[] arr, int index, int[] dp) {
        counter++;
        if (index == arr.length - 1)
            return 0;
        if (dp[index] != Integer.MAX_VALUE)
            return dp[index];
        int steps = arr[index];
        int i = 1;

        while (i <= steps) {
            if (index + i < arr.length) {
                int curr_steps = 1 + minJumps(arr, index + i, dp);
                dp[index] = Math.min(dp[index], curr_steps);
            }
            i++;
        }

        if (dp[index] == Integer.MAX_VALUE)
            return -1;
        else
            return dp[index];
    }

    public static void print(int[] dp) {
        for (int i : dp) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 1, 4 };
        int[] dp = new int[arr.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[dp.length - 1] = 0;
        int res = minJumps(arr, 0, dp);
        System.out.println(counter);
        print(dp);
        System.out.println("The minimum number of jumps required are : " + res);
    }

}
