import java.util.LinkedList;
import java.util.Queue;

public class First_non_repeating_number {
    Queue<Character> queue = new LinkedList<>();

    void store_Queue(String str) {
        int[] frequency = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            queue.add(ch);

            frequency[ch - 'a']++;

            while (!queue.isEmpty() && frequency[queue.peek() - 'a'] > 1) {
                queue.remove();
            }
            if (queue.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(queue.peek() + " ");
            }
        }

    }

    static void main(String[] args) {
        System.out.println("First non repeating character");
        First_non_repeating_number obj = new First_non_repeating_number();
        String str = "aabccxb";
        obj.store_Queue(str);

    }
}
