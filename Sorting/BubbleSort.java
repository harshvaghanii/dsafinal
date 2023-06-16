package Sorting;

public class BubbleSort {

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swapped = true;
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            if (!swapped)
                break;
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
