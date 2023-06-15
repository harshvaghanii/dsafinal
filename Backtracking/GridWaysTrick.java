package Backtracking;

/*
 * The original grid ways problem takes exponential time period which is really bad
 * We can think of this problem as a Permutation problem.
 * To reach from the source to destination, we have m-1 down turns and n-1 right turns.
 * It can basically be a permutation of m-1 down turns and n-1 right turns.
 * The formula for this is (m-1 + n-1)! / (m-1)! (n-1)!
 */

public class GridWaysTrick {
    public static int numberOfWays(int m, int n) {
        return (factorial(m - 1 + n - 1) / (factorial(m - 1) * factorial(n - 1)));
    }

    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++)
            fact *= i;
        return fact;
    }

    public static void main(String[] args) {
        int m = 5;
        int n = 4;
        int res = numberOfWays(m, n);
        System.out.println("The number of ways to cross the grid is : " + res);
    }

}
