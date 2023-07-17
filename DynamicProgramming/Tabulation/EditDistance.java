package DynamicProgramming.Tabulation;

public class EditDistance {

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Initialization

        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(1 + dp[i][j - 1], Math.min(1 + dp[i - 1][j - 1], 1 + dp[i - 1][j]));
                }
            }
        }
        print(dp);
        return dp[m][n];
    }

    public static void print(int[][] arr) {
        for (int[] a : arr) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";

        int res = minDistance(word1, word2);
        System.out.println("The minimum steps to convert String 1 to String 2 is : " + res);

    }
}
