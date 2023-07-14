package DynamicProgramming.Tabulation;

public class LongestCommonSubstring {

    public static int lcSubstring(String s1, String s2, int m, int n) {
        int ans = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "acdghr";

        int ans = lcSubstring(s1, s2, s1.length(), s2.length());
        System.out.println("The length of the longest common substring is : " + ans);
    }
}
