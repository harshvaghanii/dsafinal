package Sorting;

public class SelectionSort {

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min_index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min_index])
                    min_index = j;
            }
            int temp = a[i];
            a[i] = a[min_index];
            a[min_index] = temp;
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
        sort(arr);
        System.out.println("Sorting the array : ");
        print(arr);
    }
}
