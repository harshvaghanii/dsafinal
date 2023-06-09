/*
 * Given n friends, each one can either pair up with someone, or remain single.
 * Each friend can be paired up only once.
 * Find out the total number of ways in which the friends can be either paired up or remain single.
 */

package Recursion;

public class FriendsPairing {
    public static int numberOfWaysToPair(int n) {
        if (n < 3)
            return n;
        int singleWays = numberOfWaysToPair(n - 1);
        int pairWays = (n - 1) * numberOfWaysToPair(n - 2);
        return singleWays + pairWays;
    }

    public static void main(String[] args) {
        int n = 3;
        int res = numberOfWaysToPair(n);
        System.out.println("The number of ways to arrange the friends is : " + res);
    }

}
