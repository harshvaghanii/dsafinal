package Recursion;

public class FirstOccurence {
    public static int firstOccurence(int[] a, int target, int i) {
        if (i == a.length)
            return -1;
        if (a[i] == target)
            return i;
        return firstOccurence(a, target, i + 1);
    }

    public static void main(String[] args) {
        int[] a = { 34, 54, 13, 32, 45, 23, 32 };
        int index = firstOccurence(a, 22, 0);
        if (index != -1)
            System.out.println("The first occurence of the element is on index " + index);
        else
            System.out.println("The element does not exist in the array!");
    }
}