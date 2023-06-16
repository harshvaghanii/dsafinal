package Sorting.MergeSort;

public class MergeFunction {
    /*
     * Elements from low to mid are sorted
     * Elements from mid + 1 to high are sorted
     * Sort the entire array
     */

    public static void merge(int[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int[] arr = new int[high - low + 1];
        int k = 0;
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                arr[k] = a[i];
                i++;
            } else {
                arr[k] = a[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            arr[k++] = a[i++];
        }
        while (j <= high) {
            arr[k++] = a[j++];
        }
        for (i = 0; i < arr.length; i++) {
            a[low + i] = arr[i];
        }
    }

    public static void merge2(int[] a, int low, int mid, int high) {
        int[] left = new int[mid - low + 1];
        int[] right = new int[high - mid];
        for (int i = 0; i < left.length; i++) {
            left[i] = a[low + i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = a[mid + 1 + i];
        }
        int i = 0, j = 0;
        int k = low;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            a[k++] = left[i++];
        }
        while (j < right.length) {
            a[k++] = right[j++];
        }
    }

    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 12, 23, 21, 234, 34, 4, 5, 6, 2, 21, 34, 1 };
        int low = 5;
        int high = 10;
        int mid = 7;
        merge2(arr, low, mid, high);
        print(arr);
    }
}
