public class Queue_Using_Linklist {
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

    void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    boolean isEmpty() {
        return head == null;
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Linked list empty");
            return -1;
        }
        int res;
        if (head.next == null) {
            res = head.data;
            head = tail = null;
            return res;
        }
        res = head.data;
        head = head.next;
        return res;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Linked list is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    static void main(String[] args) {
        Queue_Using_Linklist queLink = new Queue_Using_Linklist();
        queLink.enqueue(10);
        queLink.enqueue(20);
        queLink.enqueue(30);
        queLink.enqueue(40);

        queLink.display();
        System.out.println("\nDel item = " + queLink.dequeue());
        System.out.println("Del item = " + queLink.dequeue());
        queLink.display();
    }
}
