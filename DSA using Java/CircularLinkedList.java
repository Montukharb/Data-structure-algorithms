public class CircularLinkedList {
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
    int size = 0;

    void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        tail.next = head;
        size++;
    }

    void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            addFirst(data);
            return;
        }
        tail.next = newNode;
        tail = newNode;
        tail.next = head;
        size++;
    }

    void addPosition(int data, int pos) {
        Node newNode = new Node(data);
        if (head == null || pos <= 0) {
            addFirst(data);
            return;
        }
        if (pos >= size) {
            addLast(data);
            return;
        } else {
            Node temp = head;
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    void display() {
        Node temp = head;
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
    }

    int delRes = 0;

    int removeFirst() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return -1;
        }
        if (head.next == head) //only one element present;
        {
            delRes = head.data;
            head = tail = null;
            size--;
            return delRes;
        }
        delRes = head.data;
        head = head.next;
        tail.next = head;
        size--;
        return delRes;

    }

    int removeLast() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return -1;
        }
        if (head.next == head) {
            delRes = head.data;
            head = tail = null;
            size--;
            return delRes;
        } else {
            Node temp = head;
            while (temp.next.next != head) {
                temp = temp.next;
            }
            delRes = temp.data;
            temp.next = head;
            tail = temp;
            size--;
            return delRes;
        }

    }

    int removePosition(int pos) {
        if (head == null) {
            System.out.println("Linked list is empty");
            return -1;
        }
        if (pos <= 0) {
            return removeFirst();
        } else if (pos >= size) {
            return removeLast();
        } else {
            Node temp = head;
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
            }
            delRes = temp.next.data;
            temp.next = temp.next.next;
            size--;
            return delRes;
        }
    }

    static void main(String[] args) {
        CircularLinkedList ccLL = new CircularLinkedList();
        ccLL.addFirst(10);
        ccLL.addFirst(20);
        ccLL.addFirst(30);
        ccLL.addFirst(40);
        ccLL.addFirst(50);
        ccLL.addLast(100);
        ccLL.addLast(110);
        ccLL.addPosition(1995, 3);
/*
        ccLL.addPosition(199,55);
        ccLL.addPosition(1991,1);
        ccLL.addPosition(101,0);
*/

        ccLL.display();
        System.out.println("\nDeleted item first = " + ccLL.removeFirst());
//        System.out.println("\nDeleted item last = " + ccLL.removeLast());
//        System.out.println("\nDeleted item last = " + ccLL.removeLast());
//        System.out.println("\nDeleted item last = " + ccLL.removeLast());
//        System.out.println("\nDeleted item last = " + ccLL.removeLast());
//        System.out.println("\nDeleted item last = " + ccLL.removeLast());
//        System.out.println("\nDeleted item last = " + ccLL.removeLast());
        System.out.println("\nDeleted item last = " + ccLL.removeLast());
        System.out.println("\nDeleted at pos = " + ccLL.removePosition(3));
        System.out.println("\nDeleted at pos = " + ccLL.removePosition(3));
        ccLL.display();
        System.out.println("\nTotal size = " + ccLL.size);

    }
}
