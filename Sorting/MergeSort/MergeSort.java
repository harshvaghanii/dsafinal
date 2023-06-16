package Sorting.MergeSort;

public class MergeSort {

    public static void sort(int[] arr, int left, int right) {
        if (right > left) {
            int mid = left + (right - left) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] a, int low, int mid, int high) {
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
        int[] arr = { 4, 5, 3, 2, 5, 2 };
        System.out.println("Printing the unsorted array :");
        print(arr);
        sort(arr, 0, arr.length - 1);
        System.out.println("Sorting the array : ");
        print(arr);
    }
}
