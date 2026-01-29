import java.util.LinkedList;
import java.util.Queue;

public class Interleave_two_Halves_Queue {

    Queue<Integer> queue = new LinkedList<>();
    Queue<Integer> half = new LinkedList<>();

    void InterleaverHalves() {
        for (int i = 0; i < 10; i++) {
            queue.add(i + 1);
        }

        int div = (queue.size()) / 2;

        while (queue.size() != div) {
            half.add(queue.remove());
        }
        while (!half.isEmpty()) {
            queue.add(half.remove());
            queue.add(queue.remove());
        }
        for (var x : queue) {
            System.out.print(x + " ");
        }


    }

    static void main(String[] args) {
        Interleave_two_Halves_Queue obj = new Interleave_two_Halves_Queue();

        obj.InterleaverHalves();
    }
}
