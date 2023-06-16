package LinkedList;

import java.io.OutputStream;

public class LinkedList {

    public Node head;
    public Node tail;
    public int length;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    // Linked list methods

    public int size() {
        return this.length;
    }

    public void add(int data) {
        Node toAdd = new Node(data);
        if (this.head == null) {
            this.head = toAdd;
            this.tail = toAdd;
            this.length++;
            return;
        }
        this.tail.next = toAdd;
        tail = toAdd;
        this.length++;
    }

    public void add(int data, int index) {
        if (index < 0 || index > this.size())
            return;
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == this.size()) {
            add(data);
            return;
        }
        Node toAdd = new Node(data);
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        toAdd.next = temp.next;
        temp.next = toAdd;
        this.length++;
    }

    public void addFirst(int data) {
        Node toAdd = new Node(data);
        if (this.head == null) {
            this.head = toAdd;
            this.tail = toAdd;
            this.length++;
            return;
        }
        toAdd.next = this.head;
        head = toAdd;
        this.length++;
    }

    public int remove(int index) {
        if (index < 0 || index >= this.size())
            return -1;

        int data = -1;
        // Special cases for head and tail element
        if (index == 0) {
            data = head.data;
            head = head.next;
            this.length--;
            return data;
        }

        Node temp = head;
        Node prev = temp;

        for (int i = 0; i < index; i++) {
            prev = temp;
            temp = temp.next;
        }

        prev.next = temp.next;
        temp.next = null;
        data = temp.data;
        if (index == this.size() - 1) {
            tail = prev;
        }
        this.length--;
        return data;
    }

    public void removeNthNodeFromBehind(int n) {
        if (head == null || n > this.size())
            return;
        if (n == this.size()) {
            head = head.next;
            return;
        }
        Node temp = head;
        int index = this.size() - n + 1;
        for (int i = 1; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public void reverseLinkedList() {
        if (this.size() == 0 || this.size() == 1)
            return;
        Node curr_node = head;
        Node prev_node = null;
        Node temp = null;

        while (curr_node != null) {
            temp = curr_node.next;
            curr_node.next = prev_node;
            if (curr_node.next == null)
                this.tail = curr_node;
            prev_node = curr_node;
            curr_node = temp;
        }
        this.head = prev_node;

    }

    public Node reverseLinkedListRecursively(Node head) {
        if (head == null || head.next == null)
            return head;
        Node newNode = reverseLinkedListRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public int recursiveSearch(int target) {
        return searchHelper(head, target);
    }

    public int searchHelper(Node head, int target) {
        if (head == null)
            return -1;
        if (head.data == target)
            return 0;
        int index = searchHelper(head.next, target);
        return index == -1 ? -1 : index + 1;
    }

    public void printList() {
        Node temp = this.head;
        if (temp == null) {
            System.out.println("The list is empty!");
            return;
        }
        System.out.print("[");
        while (temp != null) {
            if (temp.next == null) {
                System.out.print(temp.data);
            } else {
                System.out.print(temp.data + ", ");
            }
            temp = temp.next;
        }
        System.out.println("]");
    }
}

class LinkedListDriver {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int index = list.recursiveSearch(30);
        if (index == -1) {
            System.out.println("The element is not present in the linked list!");
            return;
        }
        System.out.println("The target is found at index : " + index);
    }
}
