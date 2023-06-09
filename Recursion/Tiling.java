// Given a "2 x n" board and tiles of size "2 x 1", count the number of ways to the tile the given board using the 2 x 1 tiles. (A tile can be either placed horizontally or vertically)

/*
 * The idea behind the problem is that we have 2*1 tiles and 2*n floor.
 * Therefore, if we place the tile horizontally, then we will have to find out the ways for n-2 width
 * and if we place the tile veritcally, then we have to find the ways for n-1 width.
 * The total number of ways if the addition of horizontal and vertical ways
 */

package Recursion;

public class Tiling {
    public static int numberOfWays(int n) {
        if (n < 0)
            return 0;
        if (n == 0 || n == 1)
            return 1;
        if (n < 4)
            return n;
        int verticalWays = numberOfWays(n - 1);
        int horizontalWays = numberOfWays(n - 2);
        return verticalWays + horizontalWays;
    }

    public static void main(String[] args) {
        int n = 4;
        int res = numberOfWays(n);
        System.out.println("The number of ways to tile the floor is : " + res);
    }
}