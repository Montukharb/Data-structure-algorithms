public class DoublyLinkedList {
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

    void printReverse() {
        Node temp = tail;
        System.out.println("\nTrack using prev link");
        if (tail == null) {
            System.out.println("Linked list empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
    }

    void removeFirst() {
        if (head == null) {
            System.out.println("linked list is empty");
            return;
        } else if (head == tail) {
            head = tail = null;
            size--;
            return;
        }
        System.out.println("deleted item = " + head.data);
        head = head.next;
        head.prev = null;
        size--;
    }

    void removeLast() {
        if (head == null) {
            System.out.println("linked list is empty");
            return;
        } else if (head == tail) //for only one node available;
        {
            head = tail = null;
            size--;
            return;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    void removePostion(int pos) {
        if (head == null) {
            System.out.println("linked list is empty");
            return;
        }
        if (pos <= 0) {
            removeFirst();
        } else if (pos >= size) {
            removeLast();
        } else {
            Node temp = head;
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp;
            size--;

        }
    }

    static void main(String[] args) {
        DoublyLinkedList db = new DoublyLinkedList();

        db.addFirst(50);
        db.addFirst(40);
        db.addFirst(30);
        db.addFirst(20);
        db.addFirst(10);

        db.addLast(100);
        db.addLast(200);

        db.addPosition(1994, 4);

        db.addPosition(1874, -5);
        db.removeFirst();
        db.removeLast();
        db.removePostion(1);

        db.display();
        db.printReverse();
        System.out.println("\nTotal size = " + db.size);
    }
}
