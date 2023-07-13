package Recursion;

public class LongestCommonSubsequence {
    public static int lcs(String s1, String s2, int i, int j) {
        if (i < 0 || j < 0)
            return 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + lcs(s1, s2, i - 1, j - 1);
        }
        int ans1 = lcs(s1, s2, i - 1, j);
        int ans2 = lcs(s1, s2, i, j - 1);
        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        int res = lcs(s1, s2, s1.length() - 1, s2.length() - 1);
        System.out.println("The length of LCS is : " + res);
    }

}
