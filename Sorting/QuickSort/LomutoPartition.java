package Sorting.QuickSort;

public class LomutoPartition {

    public static int partition(int[] a, int low, int high, int pivot) {
        int k = low - 1;
        for (int i = low; i <= high; i++) {
            if (a[i] < a[pivot]) {
                k++;
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
        int temp = a[k + 1];
        a[k + 1] = a[pivot];
        a[pivot] = temp;
        return k + 1;
    }

    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 3, 8, 6, 10, 7, 12, 10 };
        System.out.println("Printing the unsorted array :");
        print(arr);
        int pivot = partition(arr, 1, 4, 4);
        System.out.println("Sorting the array : ");
        print(arr);
    }
}
