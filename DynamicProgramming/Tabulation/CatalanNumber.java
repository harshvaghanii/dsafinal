package DynamicProgramming.Tabulation;

/*
 * The application of this problem is widely asked
 * The question to generate valid parenthesis, is a direct implementation of catalan number
 */

public class CatalanNumber {
    public static int catalan(int n) {
        if (n < 2)
            return 1;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int ans = 0;
            for (int j = 0; j < i; j++) {
                ans += dp[j] * dp[i - j - 1];
            }
            dp[i] = ans;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        int res = catalan(n);
        System.out.println("The catalan number is : " + res);
    }

}
