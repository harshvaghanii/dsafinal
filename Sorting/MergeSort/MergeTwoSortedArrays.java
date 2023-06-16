package Sorting.MergeSort;

public class MergeTwoSortedArrays {
    public static int[] merge(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] merged_array = new int[a.length + b.length];
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                merged_array[k] = a[i];
                i++;
            } else {
                merged_array[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < a.length) {
            merged_array[k] = a[i];
            i++;
            k++;
        }

        while (j < b.length) {
            merged_array[k] = b[j];
            j++;
            k++;
        }

        return merged_array;
    }

    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = { 5, 7, 9, 15 };
        int[] arr2 = { 3, 5, 8, 14, 14, 25 };
        int[] merged = merge(arr1, arr2);
        print(merged);
    }
}
