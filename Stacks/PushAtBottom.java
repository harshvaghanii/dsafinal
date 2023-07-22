package Stacks;

import java.util.Stack;

public class PushAtBottom {
    public static void pushAtBottom(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int top = stack.pop();
        pushAtBottom(stack, data);
        stack.push(top);
    }

    public static void print(Stack<Integer> st) {
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(56);
        st.push(45);
        pushAtBottom(st, 50);
        print(st);
    }

}
