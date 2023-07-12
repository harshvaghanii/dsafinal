package Recursion;

public class ClimbingStairs {
    public static int counter = 0;

    public static int numberOfWays(int n) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        counter++;
        return numberOfWays(n - 1) + numberOfWays(n - 2);

    }

    public static void main(String[] args) {
        int n = 10;
        int res = numberOfWays(n);
        System.out.println("The number of ways to climb the stairs is : " + res);
        System.out.println(counter);
    }
}