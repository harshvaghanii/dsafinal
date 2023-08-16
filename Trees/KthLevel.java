package Trees;

public class KthLevel {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void printKthLevel(Node root, int curr_level, int k) {
        if (root == null)
            return;
        if (curr_level == k) {
            System.out.print(root.data + " ");
            return;
        }
        printKthLevel(root.left, curr_level + 1, k);
        printKthLevel(root.right, curr_level + 1, k);
    }

    /*
     * Function to calculate sum at the given level
     */

    public static int sumAtKthLevel(Node root, int curr_level, int k, int sum) {
        if (root == null)
            return 0;
        if (curr_level == k) {
            sum += root.data;
            return sum;
        }
        return sumAtKthLevel(root.left, curr_level + 1, k, sum) + sumAtKthLevel(root.right, curr_level + 1, k, sum);

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        printKthLevel(root, 1, 3);
        int sum = sumAtKthLevel(root, 1, 2, 0);
        System.out.println();
        System.out.println("The sum of the Kth level is : " + sum);

    }
}
