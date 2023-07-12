package DynamicProgramming.Memoization;

public class ClimbingStairs {
    public static int counter = 0;

    public static int numberOfWays(int n) {
        int[] dp = new int[n + 1];
        return util(n, dp);
    }

    public static int util(int n, int[] dp) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        if (dp[n] != 0)
            return dp[n];
        counter++;
        dp[n] = util(n - 1, dp) + util(n - 2, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        int res = numberOfWays(n);
        System.out.println("The number of ways to climb the stairs is : " + res);
        System.out.println(counter);
    }
}
