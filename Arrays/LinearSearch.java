package Arrays;

public class LinearSearch {
    public static int search(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = { 34, 76, 23, 87, 56, 45 };
        int index = search(a, 87);
        if (index == -1) {
            System.out.println("The element does not exist in the array!");
        } else
            System.out.println("The element is present at index : " + index);
    }
}
