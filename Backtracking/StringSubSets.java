package Backtracking;

public class StringSubSets {
    static int counter = 0;

    public static void printSubSets(String s, int index, String curr) {
        if (index == s.length()) {
            if (curr.length() == 0)
                System.out.println("null");
            else
                System.out.println(curr);
            counter++;
            return;
        }
        printSubSets(s, index + 1, curr + s.charAt(index));
        printSubSets(s, index + 1, curr);
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println("The subsets of the string are : ");
        printSubSets(s, 0, "");
        System.out.println("The number of subsets are : " + counter);
    }
}
