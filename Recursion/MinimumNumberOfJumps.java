package Recursion;

/*
 * You are given an array of length n where a[i] represents how many steps we can jump ahead.
 * Calculate the minimum number of Jumps required to reach the end of the array
 */

public class MinimumNumberOfJumps {
    static int counter = 0;

    public static int minJumps(int[] arr, int index) {
        counter++;
        if (index == arr.length - 1)
            return 0;
        int steps = arr[index];
        int i = 1, minSteps = Integer.MAX_VALUE;

        while (i <= steps) {
            if (index + i < arr.length) {
                int curr_steps = 1 + minJumps(arr, index + i);
                minSteps = Math.min(minSteps, curr_steps);
            }
            i++;
        }

        if (minSteps == Integer.MAX_VALUE)
            return -1;
        else
            return minSteps;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 1, 4 };
        int res = minJumps(arr, 0);
        System.out.println(counter);
        System.out.println("The minimum number of jumps required are : " + res);
    }

}
