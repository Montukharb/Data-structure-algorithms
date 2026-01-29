package greedy;

import java.util.ArrayList;

public class Activity_Selection01 {
    int[] start;
    int[] end;
    int count = 0;
    ArrayList<Integer> list = new ArrayList<>();

    int maximumJob() {
        count++;
        int lastJobEndTime = end[0];
        list.add(0);
        for (int i = 1; i < start.length; i++) {
            if (start[i] >= lastJobEndTime) {
                count++;
                list.add(i); //store index of job start;
                lastJobEndTime = end[i];
            }
        }
        return count;
    }

    static void main(String[] args) {
        System.out.println("Activity selection");
        Activity_Selection01 obj = new Activity_Selection01();
//        obj.start = new int[]{10, 20, 26};
        obj.start = new int[]{1, 3, 0, 5, 8, 5};
//        obj.end = new int[]{20, 25, 30};
        obj.end = new int[]{2, 4, 6, 7, 9, 9};
        System.out.println("Maximum job = " + obj.maximumJob());
        for (var x : obj.list) {
            System.out.print("A" + x + " ");
        }
    }
}
