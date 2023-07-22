package Stacks;

import java.util.Stack;

/*
 * Find the total number of max consecutive days from the current day when the price was less than or equal
 * to the current day's price.
 * Start consecutive from the current day and move behind
 */

public class StockSpan {
    public static int[] maxDays(int[] stocks) {
        int n = stocks.length;
        int[] span = new int[n];
        span[0] = 1;
        // The stack is used to store the index of the previous high element
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && stocks[stack.peek()] <= stocks[i]) {
                stack.pop();
            }
            if (stack.isEmpty())
                span[i] = i + 1;
            else
                span[i] = i - stack.peek();
            stack.push(i);
        }

        return span;
    }

    public static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] stocks = { 100, 80, 60, 70, 60, 85, 100 };
        int[] res = maxDays(stocks);
        System.out.println("The result is : ");
        print(res);
    }

}
