public class LinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    //head and tail pointer;
    Node head = null;
    Node tail = null;
    int size = 0;


    void addFirst(int data) {
        Node newNode = new Node(data); //sending data first;
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //else case already data save hai
        newNode.next = head;
        head = newNode;
    }

    void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;

    }

    void addMiddle(int data, int pos) {
        pos -= 1;
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        if (pos == 0) {
            addFirst(data);
            return;
        }
        Node temp = head;

        for (int i = 1; i < pos; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;

    }

    int removeFirst() {
        int delData = head.data;

        if (tail == null) {
            System.out.println("Liked list is empty");
            return 0;
        } else if (size == 1) {

            head = tail = null;
            size = 0;
            return delData;
        } else {
            head = head.next;
            size--;
            return delData;
        }
    }

    int removeLast() {
        int delData;
        if (head == null) {
            System.out.println("Liked list is empty");
            return 0;
        }
        if (head == tail) {
            delData = head.data;
            head = tail = null;
            size = 0;
            return delData;
        }
        delData = tail.data;
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
        return delData;

    }

    int removePosition(int pos) {
        if (head == null) {
            System.out.println("Linked list is empty");
            return 0;
        }

        if (pos <= 0 || pos > size) {
            System.out.println("Wrong position");
            return 0;
        }

        // first position
        if (pos == 1) {
            return removeFirst();
        }

        // last position
        if (pos == size) {
            return removeLast();
        }

        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }

        int delData = temp.next.data;
        temp.next = temp.next.next;
        size--;

        return delData;
    }


    int searchItem(int key) {
        int i = 0;
        if (head == null) {
            System.out.println("linked list is empty before searching please enter some items");
            return 0;
        } else if (head.data == key) {
            System.out.println("key found");
            return 1;
        } else if (tail.data == key) {
            return size;
        } else {
            Node temp = head;
            int idx = 0;
            while (temp != null) {
                idx++;
                if (temp.data == key) {
                    return idx;
                }
                temp = temp.next;
            }
        }
        return -1;
    }

    int recursionSearch(Node temp, int key) {
        if (temp == null) {
            return -1;  //base case;
        }
        if (temp.data == key) {
            return 1; //key found;
        }
        int res = recursionSearch(temp.next, key);
        if (res == -1) {
            return -1; // not found;
        }
        return res + 1;
    }

    int backtrackingSearch(int key) {
        Node temp = head;
        return recursionSearch(temp, key);
    }

    void reverseList() {
        if (head == null) {
            System.out.println("Not possible linked list empty");
        }
        Node prev = null;
        Node current = tail = head;
        Node next;


        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    void display() {
        Node temp = head;  //create local variable for traversing
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
//          System.out.print(tail.data + " ");
//        System.out.print(tail.next + " ");  //always print null value
        System.out.println("\nLinked list size = " + size);
    }

    Node linkListMid() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // 1 step next;
            fast = fast.next.next; //2 step next;
        }
        return slow; //middle object of linked list;
    }

    boolean l_listPalindrome() {
        Node mid = linkListMid();

        //reverse half linked list;
        if (head == null || head.next == null) //if null or only one element;
        {
            return true;
        }

        Node prev = null;
        Node current = mid; //starting object to reverse;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        Node leftStart = head;
        Node rightStart = prev;

        //why check right side because left side we have not done any time left next is null;
        while (rightStart != null) {
            if (rightStart.data != leftStart.data) {
                return false;
            }
            leftStart = leftStart.next;
            rightStart = rightStart.next;

        }
        return true;
    }

    static void main(String[] args) {
        LinkedList link_list = new LinkedList();
//        for (int i = 1; i <= 5; i++) {
//            link_list.addFirst(i);
//        }
//        for (int i = 6; i <= 10; i++) {
//            link_list.addLast(i);
//        }
//        link_list.addMiddle(101, 3);
//        link_list.display();
//        System.out.println("deleted first item = " + link_list.removeFirst());
//        System.out.println("deleted first item = " + link_list.removeFirst());
//        System.out.println("deleted last item = " + link_list.removeLast());
//
//        link_list.display();
//        System.out.println("deleted by position & del item = " + link_list.removePosition(1));
//        System.out.println("deleted by position & del item = " + link_list.removePosition(1));
//
//        link_list.display();
//        System.out.println("key found at index = " + link_list.searchItem(6));
//
//        System.out.println("Backtracking key found at index = " + link_list.backtrackingSearch(101));
//        link_list.reverseList();

        link_list.addFirst(1);
        link_list.addFirst(2);
        link_list.addFirst(2);
        link_list.addFirst(1);

//        link_list.addFirst(1);


        link_list.display();
        System.out.println("linked list is palindrome = " + link_list.l_listPalindrome());
    }


}
