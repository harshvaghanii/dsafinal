package Stacks;

public class MyStacks {

    Node top;
    int size;

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void push(int data) {
        if (top == null)
            top = new Node(data);
        else {
            Node toAdd = new Node(data);
            toAdd.next = top;
            top = toAdd;
        }
        this.size++;
    }

    public int peek() {
        if (isEmpty())
            return -1;
        return this.top.data;
    }

    public int pop() {
        if (this.top == null)
            return -1;
        int data = top.data;
        top = top.next;
        this.size--;
        return data;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        while (!isEmpty()) {
            System.out.print(pop() + " ");
        }
        System.out.println();
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}