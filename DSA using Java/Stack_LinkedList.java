public class Stack_LinkedList {
    static class Node {
        int data;
        Node next;

        private Node(int data) {
            this.data = data;
            next = null;
        }

    }

    Node head = null;
    Node tail = null;

    void push(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    int pop() {
        int pop = -1;
        if (head == null) {
            System.out.println("Stack underflow");
            return pop;
        }
        if (head.next == null) {
            pop = head.data;
            head = tail = null;
            return pop;
        }
        pop = head.data;
        head = head.next;
        return pop;
    }

    void display() {
        Node temp = head;
        if (head == null) {
            System.out.println("Stack is empty");
        }
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    static void main(String[] args) {
        System.out.println("Stack using linked list");
        Stack_LinkedList stackL = new Stack_LinkedList();
        stackL.push(10);
        stackL.push(20);
        stackL.push(30);
        stackL.push(40);
        stackL.push(50);
        stackL.push(60);

        stackL.display();
        System.out.println("Pop item = " + stackL.pop());
        stackL.display();
    }

}
