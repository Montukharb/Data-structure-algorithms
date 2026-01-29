import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
public class Queue_Reverse {
    Stack<Integer> stack = new Stack<>();
    Queue<Integer> queue = new LinkedList<>();

    void revQueue()
    {
        for(int i = 0;i<5;i++)
        {
            queue.add(i + 1);
        }
        System.out.println(queue);
        //
        int size = queue.size();
        while (!queue.isEmpty())
        {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty())
        {
            queue.add(stack.pop());
        }
        System.out.println("After reverse");
        System.out.println(queue);

    }

    static void main(String[] args)
    {
        Queue_Reverse obj = new Queue_Reverse();
        System.out.println("Reverse queue");
        obj.revQueue();
    }
}
