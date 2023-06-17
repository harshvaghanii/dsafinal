package Sorting.QuickSort;

public class QuickSortL {

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            sort(arr, low, pivot - 1);
            sort(arr, pivot + 1, high);
        }
    }

    public static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int k = low - 1;
        for (int i = low; i < high; i++) {
            if (a[i] < pivot) {
                k++;
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
        int temp = a[k + 1];
        a[k + 1] = pivot;
        a[high] = temp;
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
        System.out.println("Sorting the array : ");
        sort(arr, 0, arr.length - 1);
        print(arr);
    }
}
