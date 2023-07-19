package DynamicProgramming.Tabulation;

public class CoinWinner {
    public static int findWinner(int N, int X, int Y) {
        boolean[] dp = new boolean[N + 1];
        boolean case1 = false, case2 = false, case3 = false;
        for (int i = 1; i < dp.length; i++) {
            if (i == 1 || i == X || i == Y) {
                dp[i] = true;
            } else {
                if (i >= 1) {
                    case1 = !dp[i - 1];
                }
                if (i >= X) {
                    case2 = !dp[i - X];
                }
                if (i >= Y) {
                    case3 = !dp[i - Y];
                }
                dp[i] = case1 || case2 || case3;
            }
        }
        if (dp[N])
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) {
        int n = 5, x = 3, y = 4;
        int res = findWinner(n, x, y);
        if (res == 1) {
            System.out.println("Geek can win the game!");
        } else {
            System.out.println("Geek cannot win the game!");
        }
    }

}
