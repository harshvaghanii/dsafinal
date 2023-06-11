package Arrays;

public class LargestElement {
    public static int largestElement(int[] a) {
        int largest = Integer.MIN_VALUE;
        for (int i : a) {
            largest = i > largest ? i : largest;
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] a = { 23, 54, 56, 34, 54, 56, 87, 45, 32 };
        int largest = largestElement(a);
        System.out.println("The largest element in the array is : " + largest);
    }

}
