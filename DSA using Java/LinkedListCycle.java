public class LinkedListCycle {
    class Node {
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
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    void display() {
        if (head == null) {
            System.out.println("linked list empty");
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
        tail = newNode;
        size++;
    }

    void makingCycle() {

        if (head == null || head.next == null) {

            return;
        }
        tail.next = head.next.next.next;

    }

    void detectingCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                System.out.println("Cycle detect");
                return;
            }
        }
        System.out.println("Cycle not exits");
        return;
    }

    void removeCycle() {
        Node slow = head;
        Node fast = head;

        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                cycle = true;
                break;
            }
        }
        if (!cycle) {
            return;
        }

        slow = head;
        Node temp = null;

        while (slow != fast) {
            temp = fast;
            slow = slow.next;
            fast = fast.next;
        }
        temp.next = null;
        System.out.println("Cycle removed successfully");
    }

    static void main(String[] args) {
        LinkedListCycle l_inb = new LinkedListCycle();
        l_inb.addFirst(5);
        l_inb.addFirst(4);
        l_inb.addFirst(3);
        l_inb.addFirst(2);
        l_inb.addFirst(1);
        l_inb.addLast(10);
        l_inb.addLast(11);
        l_inb.addLast(12);
        l_inb.display();
        l_inb.makingCycle();

        l_inb.detectingCycle();
        l_inb.removeCycle();
        l_inb.display();
    }
}
