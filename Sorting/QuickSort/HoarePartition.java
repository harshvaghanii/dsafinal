package Sorting.QuickSort;

public class HoarePartition {
    public static int partition(int[] a, int low, int high) {
        int pivot = a[low];
        int i = low - 1;
        int j = high + 1;
        while (true) {
            do {
                i++;
            } while (a[i] < pivot);
            do {
                j--;
            } while (a[j] > pivot);
            if (i >= j)
                return j;
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 4, 2, 7, 5, 10 };
        int index = partition(arr, 0, arr.length - 1);
        System.out.println(index);
        print(arr);
    }

}
