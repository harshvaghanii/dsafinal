package DynamicProgramming.Memoization;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static int lcs(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return util(s1, s2, m, n, dp);
    }

    public static int util(String s1, String s2, int m, int n, int[][] dp) {
        if (m == 0 || n == 0)
            return 0;
        if (dp[m][n] != -1)
            return dp[m][n];
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            dp[m][n] = 1 + util(s1, s2, m - 1, n - 1, dp);
        } else {
            dp[m][n] = Math.max(util(s1, s2, m - 1, n, dp), util(s1, s2, m, n - 1, dp));
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        int res = lcs(s1, s2, s1.length(), s2.length());
        System.out.println("The length of LCS is : " + res);
    }
}
