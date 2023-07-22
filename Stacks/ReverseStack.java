package Stacks;

import java.util.*;

public class ReverseStack {
    public static void pushAtBottom(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int top = stack.pop();
        pushAtBottom(stack, data);
        stack.push(top);
    }

    public static void reverse(Stack<Integer> st) {
        if (st.isEmpty())
            return;
        int top = st.pop();
        reverse(st);
        pushAtBottom(st, top);
    }

    public static void print(Stack<Integer> st) {
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(50);
        stack.push(56);
        stack.push(45);

        reverse(stack);
        print(stack);

    }
}
