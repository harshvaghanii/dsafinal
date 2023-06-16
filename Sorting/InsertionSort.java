package Sorting;

public class InsertionSort {

    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            int key = a[i];
            while (j > -1 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;

        }
    }

    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 3, 2, 5, 2, 45, 32, 12, 34 };
        System.out.println("Printing the unsorted array :");
        print(arr);
        sort(arr);
        System.out.println("Sorting the array : ");
        print(arr);
    }
}
