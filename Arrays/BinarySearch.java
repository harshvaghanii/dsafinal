package Arrays;

import java.util.Arrays;

public class BinarySearch {

    public static int search(int[] a, int target) {
        int length = a.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target)
                return mid;
            if (a[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = { 23, 34, 45, 56, 76, 87 };
        int index = search(a, 45);
        if (index == -1) {
            System.out.println("The element does not exist in the array!");
        } else
            System.out.println("The element is present at index : " + index);
    }
}
