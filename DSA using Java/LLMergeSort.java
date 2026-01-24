public class LLMergeSort {
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

    Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; //mid
    }

    Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;  //base case;
        }
        //find mid;
        Node mid = findMid(head);
        Node righthead = mid.next;
        mid.next = null;

        //left part
        Node newLeft = mergeSort(head); //return left head after hitting base case;
        Node newRight = mergeSort(righthead); //return right head after hitting base case;

        return Merge(newLeft, newRight); //return new head;
    }

    Node Merge(Node head1, Node head2) {
        Node newLinkedList = new Node(-1);
        Node temp = newLinkedList;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            } else {
                temp.next = head2;
                temp = temp.next;
                head2 = head2.next;
            }
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return newLinkedList.next;
    }

    static void main(String[] args) {
        LLMergeSort ll_obj = new LLMergeSort();
        ll_obj.addFirst(1);
        ll_obj.addFirst(2);
        ll_obj.addFirst(3);
        ll_obj.addFirst(4);
        ll_obj.addFirst(5);

        ll_obj.display();
        System.out.println("\nafter merge sort");
        head = ll_obj.mergeSort(head); //new head return;

        ll_obj.display();

    }
}
