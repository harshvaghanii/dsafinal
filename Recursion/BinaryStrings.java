// Print all binary strings with of size N without consecutive 1's

package Recursion;

public class BinaryStrings {
    public static void binaryStrings(String s, int N, int prevChar) {
        if (N == 0) {
            System.out.println(s);
            return;
        }
        binaryStrings(s + '0', N - 1, 0);
        if (prevChar == 0) {
            binaryStrings(s + '1', N - 1, 1);
        }
    }

    public static void main(String[] args) {
        int N = 3;
        binaryStrings("", N, 0);
    }

}
