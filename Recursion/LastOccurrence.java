package Recursion;

public class LastOccurrence {
    public static int lastOccurrence(int[] a, int target, int i) {
        if (i == a.length)
            return -1;
        int lastOccurrence = lastOccurrence(a, target, i + 1);
        if (lastOccurrence != -1)
            return lastOccurrence;
        if (a[i] == target)
            return i;
        return -1;
    }

    public static void main(String[] args) {
        int[] a = { 34, 54, 13, 32, 45, 23, 32 };
        int index = lastOccurrence(a, 54, 0);
        if (index != -1)
            System.out.println("The last occurrence of the element is on index " + index);
        else
            System.out.println("The element does not exist in the array!");
    }
}