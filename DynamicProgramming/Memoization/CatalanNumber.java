package DynamicProgramming.Memoization;

public class CatalanNumber {

    static int counter = 0;

    public static int catalan(int n) {
        if(n < 2) return 1;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        return util(n, dp);
    }

    public static int util(int n, int[] dp) {
        counter++;
        if (n == 0 || n == 1)
            return 1;
        if (dp[n] != 0)
            return dp[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catalan(i) * catalan(n - i - 1);
        }
        return dp[n] = ans;
    }

    public static void main(String[] args) {
        int n = 10;
        int res = catalan(n);
        System.out.println("The catalan number is (memoization) : " + res);
        System.out.println(counter);
    }

}
