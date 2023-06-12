package Backtracking;

public class PermutationsOfString {
    public static int counter = 0;

    public static void printPermutations(String s, String curr) {
        if (s.length() == 0) {
            System.out.println(curr);
            counter++;
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            printPermutations(s.substring(0, i) + s.substring(i + 1), curr + c);
        }

    }

    public static void main(String[] args) {
        String s = "abcd";
        System.out.println("The permutations of the string are : ");
        printPermutations(s, "");
        System.out.println("The number of permutations are : " + counter);
    }
}
