package Recursion;

public class PrintIncreasingOrder {
    public static void printInIncreasingOrder(int n) {
        if (n == 0) {
            return;
        }
        printInIncreasingOrder(n-1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        int n = 10;
        printInIncreasingOrder(n);
        System.out.println();
    }
}
