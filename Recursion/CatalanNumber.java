package Recursion;

public class CatalanNumber {
    static int counter = 0;

    public static int catalan(int n) {
        counter++;
        if (n == 0 || n == 1)
            return 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catalan(i) * catalan(n - i - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 10;
        int res = catalan(n);
        System.out.println("The catalan number is : " + res);
        System.out.println(counter);
    }

}
