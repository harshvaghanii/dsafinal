package Recursion;

public class KnapSack {

    public static int maxProfit(int[] wt, int[] val, int W, int index) {
        // Base Case
        if (index == wt.length)
            return 0;
        int item_included = 0;
        if (W >= wt[index]) {
            item_included = maxProfit(wt, val, W - wt[index], index + 1) + val[index];
        }
        int item_excluded = maxProfit(wt, val, W, index + 1);
        return Math.max(item_included, item_excluded);
    }

    public static void main(String[] args) {
        int[] val = { 15, 14, 10, 45, 30 };
        int[] wt = { 2, 5, 1, 3, 4 };
        int W = 7;
        // int[] val = { 1, 2, 3 };
        // int[] wt = { 4, 5, 1 };
        // int W = 4;

        int res = maxProfit(wt, val, W, 0);
        System.out.println("The max Profit is : " + res);

    }
}
