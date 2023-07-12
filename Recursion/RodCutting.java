package Recursion;

public class RodCutting {
    public static int maxProfit(int n, int[] length, int[] price, int index) {
        if (n == 0 || index == length.length)
            return 0;
        int item_included = 0;
        if (n >= length[index]) {
            item_included = price[index] + maxProfit(n - length[index], length, price, index);
        }
        int item_excluded = maxProfit(n, length, price, index + 1);
        return Math.max(item_included, item_excluded);
    }

    public static void main(String[] args) {
        int[] length = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] price = { 3, 5, 8, 9, 10, 17, 17, 20 };
        int rodLength = 8;

        int max_profit = maxProfit(rodLength, length, price, 0);
        System.out.println("The max profit after selling the pieces of rods is : " + max_profit);

    }

}
