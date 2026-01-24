public class ZigZag {
    static class Node {
        int data;
        Node next;

        private Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static Node head = null;
    Node tail = null;

    void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    void display() {
        Node temp = head;
        if (head == null) {
            System.out.println("linked list is empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    void ZigZagMaking() {
        //find mid node;
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;//move 1 step;
            fast = fast.next.next; //move 2 step;
        }

        Node mid = slow; //mid node assigned;

        //reverse second half;
        Node current = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next; //incrementing;
        }
        Node leftHead = head;
        Node rightHead = prev;
        Node nextLeft, nextRight;

        while (leftHead != null && rightHead != null) {
            nextLeft = leftHead.next;
            leftHead.next = rightHead;
            nextRight = rightHead.next;
            rightHead.next = nextLeft;

            leftHead = nextLeft;
            rightHead = nextRight;

        }

    }

    static void main(String[] args) {
        ZigZag zz_obj = new ZigZag();

        zz_obj.addFirst(6);
        zz_obj.addFirst(5);
        zz_obj.addFirst(4);
        zz_obj.addFirst(3);
        zz_obj.addFirst(2);
        zz_obj.addFirst(1);

        zz_obj.display();

        zz_obj.ZigZagMaking();
        System.out.println("\nAfter Zig Zag applied");
        zz_obj.display();
    }
}

