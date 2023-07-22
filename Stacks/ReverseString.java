package Stacks;

import java.util.*;

public class ReverseString {

    public static String reverse(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
        }
        StringBuilder toReturn = new StringBuilder("");
        while (!stack.isEmpty())
            toReturn.append(stack.pop());
        return toReturn.toString();
    }

    public static void main(String[] args) {
        String s = "Harsh";
        String res = reverse(s);
        System.out.println("The reverse string is : " + res);
    }
}
