package Backtracking;

public class GridWays {
    public static int numberOfWays(int i, int j, int m, int n) {
        if (i == m - 1 || j == n - 1)
            return 1;

        return numberOfWays(i + 1, j, m, n) + numberOfWays(i, j + 1, m, n);
    }

    public static void main(String[] args) {
        int res = numberOfWays(0, 0, 3, 3);
        System.out.println("The number of ways to reach the end of the grid are : " + res);
    }

}
