package Recursion;

public class PrintSubsequence {
    public static void printSubSequence(String s, String curr, int index) {
        if (index == s.length()) {
            System.out.println(curr);
            return;
        }
        printSubSequence(s, curr + s.charAt(index), index + 1);
        printSubSequence(s, curr, index + 1);
    }

    public static void main(String[] args) {
        String s = "abc";
        printSubSequence(s, "", 0);
    }

}
