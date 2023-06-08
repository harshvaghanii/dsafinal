package Recursion;

public class SumOfNNumbers {
    public static int sum(int n) {
        if (n == 0 || n == 1)
            return n;
        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        int n = 2;
        int res = sum(n);
        System.out.println(res);
    }
}
