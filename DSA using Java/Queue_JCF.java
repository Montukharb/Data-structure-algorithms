import java.util.LinkedList;
import java.util.Queue;

public class Queue_JCF {

    static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();
        que.add(10);
        que.add(20);
        que.add(30);


        for (var x : que) {
            System.out.println(x + " ");
        }

        System.out.println("remove item = " + que.remove());
        System.out.println("is empty = " + que.isEmpty());
    }
}
