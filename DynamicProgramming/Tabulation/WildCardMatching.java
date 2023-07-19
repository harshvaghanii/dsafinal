package DynamicProgramming.Tabulation;

/*
 * Conditions for this question : 
 * A "*" can match with any character or a sequence of characters and an empty string too
 * A "?" can match with a single character but not with an empty string
 * Hints for this Question : 
 * There will be three initialization conditions
 * When i and j are 0, we will initialize it to true since empty string matches with empty string
 * If the pattern string (j) is 0 and the main string length is greater than 0, set it to False
 * If the main string length is 0 and the pattern has more than 0 characters, follow the below conditions : 
 * 1. If the character at Jth position is a *, the answer will be dp[i][j-1]
 * 2. If the character at Jth positions is a ? or any valid character, the answer will be false
 * Conditions for the code : 
 * If the char at i == char at j, then the answer will be the substring answer
 * If the char at j == "?", still the answer will be the previous substring answer
 * If the character at j =="*", we have two choices. We can either include the * or discard it.
 * If we choose to discard, then the length of pattern string will decrease by 1.
 * If we choose to include, then the length of the main string will decrease by 1.
 * However, the length of the pattern string will be the same since we can use the * in future too.
 * In that case, we will return the OR of including or discarding the "*" character
 * The final case will be, if the characters at i-1 and j-1 are different and the character at j-1 isn't a wild card char,
 * we will return false.
 */

public class WildCardMatching {
    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        // Initialisation conditions

        dp[0][0] = true;
        for (int i = 1; i < m + 1; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            } else {
                dp[0][i] = false;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];

    }

    public static void main(String[] args) {
        String str1 = "aa";
        String str2 = "*";

        boolean res = isMatch(str1, str2);
        if (res) {
            System.out.println("The pattern matches the string!");
        } else {
            System.out.println("The pattern does not match the string!");
        }
    }
}
