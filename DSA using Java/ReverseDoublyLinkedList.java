public class ReverseDoublyLinkedList {
    static class Node {
        int data;
        Node next;
        Node prev;

        private Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    Node head = null;
    Node tail = null;
    int size = 0;

    void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    void display() {
        if (head == null) {
            System.out.println("linked list empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    void addPosition(int data, int pos) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        if (pos <= 0) {
            addFirst(data);

        } else if (pos >= size) {
            addLast(data);

        } else {
            Node temp = head;
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next.prev = newNode;
            temp.next = newNode;
            newNode.prev = temp;
            size++;
        }
    }

    void reverseDoublyList() {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
        }
        head = prev;

    }

    static void main(String[] args) {
        ReverseDoublyLinkedList rddLL = new ReverseDoublyLinkedList();

        rddLL.addFirst(5);
        rddLL.addFirst(4);
        rddLL.addFirst(3);
        rddLL.addFirst(2);
        rddLL.addFirst(1);

        rddLL.display();

        rddLL.reverseDoublyList();
        System.out.println("\nAfter reversed doubly linked list");
        rddLL.display();
    }
}

