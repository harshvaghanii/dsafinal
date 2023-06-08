package Recursion;

public class PowerOptimized {
    static int counter = 0;

    public static int power(int x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n % 2 == 0) {
            counter++;
            return power(x * x, n / 2);
        } else {
            counter++;
            return x * power(x, n - 1);
        }

    }

    public static void main(String[] args) {
        int x = 2;
        int n = 10;
        int res = power(x, n);
        System.out.println(res);
        System.out.println("The value of counter is : " + counter);
    }
}
