import java.util.LinkedList;
public class LinkedListInbuild {

    static void main(String[] args)
    {
        System.out.println("helo");
        LinkedList<Integer> llist = new LinkedList<>();
        llist.add(20);
        llist.add(30);
        llist.add(40); //by default add last
        llist.add(2,50);  //at position
        llist.addFirst(100);  //add first function;
        llist.addLast(1000); //add last function;
        System.out.println(llist.getFirst());
        System.out.println(llist.getLast());
        System.out.println(llist.get(2));
        System.out.println(llist.contains(1000));

        LinkedList<LinkedList<Integer>> main = new LinkedList<>();
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(10);
        l1.add(20);
        l1.add(30);
        l1.add(40);
        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(11);
        l2.add(12);
        l2.add(13);
        l2.add(14);

//        l2.addAll(l1);  //means li complete add in list2;
        System.out.println(llist);
        main.add(l1);
        main.add(llist);
        main.add(l2);
        System.out.println(main);
    }
}
