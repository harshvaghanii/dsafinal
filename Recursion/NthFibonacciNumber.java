package Recursion;

public class NthFibonacciNumber {
    public static int nthFibonacciNumber(int n) {
        if (n < 2)
            return n;
        return nthFibonacciNumber(n - 1) + nthFibonacciNumber(n - 2);
    }

    public static void main(String[] args) {
        int n = 5;
        int res = nthFibonacciNumber(n);
        System.out.println(res);
    }
}
