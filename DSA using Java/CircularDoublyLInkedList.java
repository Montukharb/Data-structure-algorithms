public class CircularDoublyLInkedList {
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
            head.next = head;
            head.prev = head;
            size++;
        } else {
            newNode.next = head;
            newNode.prev = tail;

            head.prev = newNode;  //back link;
            tail.next = newNode; //last next link;

            head = newNode; //start head;
            size++;
        }
    }


    void display() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        } else {
            Node temp = head;
            do {

                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
        }
    }

    void displayPrev() {
        if (tail == null) {
            System.out.println("Circular Linked list is empty");
            return;
        } else {
            Node temp = tail;
            do {
                System.out.print(temp.data + " ");
                temp = temp.prev;
            } while (temp != tail);
        }
    }

    void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            head.next = head;
            head.prev = head;
            size++;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;

            tail = newNode;
            head.prev = tail;
            size++;
        }
    }

    void addPosition(int data, int pos) {
        Node newNode = new Node(data);
        if (pos <= 0) {
            addFirst(data);
        }
        if (pos >= size) {
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

    static void main(String[] args) {
        System.out.println("Circular Doubly Linked list");
        CircularDoublyLInkedList ccLL = new CircularDoublyLInkedList();
        ccLL.addFirst(10);
        ccLL.addFirst(20);
        ccLL.addFirst(30);
        ccLL.addFirst(40);
        ccLL.addFirst(50);
        ccLL.addLast(1054);
        ccLL.addPosition(202, 3);
        ccLL.display();
        System.out.println("\nreversed display");
        ccLL.displayPrev();
        System.out.println("\nTotal size = " + ccLL.size);

    }
}
