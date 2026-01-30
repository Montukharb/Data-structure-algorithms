package greedy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Job_sequencing {
    int[][] deadProfit = {
            {4, 20},
            {1, 10},
            {1, 40},
            {1, 30}
    };
    ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    int[] arr;

    int maximumProfit() {
        int time = 0;
        int maxProfit = 0;
//        Arrays.sort(deadProfit, (a, b) -> b[1] - a[1]);
        Arrays.sort(deadProfit, Comparator.comparingDouble(o -> o[1]));
        for (int i = deadProfit.length - 1; i >= 0; i--) {
            if (deadProfit[i][0] > time) {
                arrayList.add(new ArrayList<>());
                arrayList.get(time).add(deadProfit[i][0]);
                arrayList.get(time).add(deadProfit[i][1]);
                time++;
                maxProfit += deadProfit[i][1];
            }
        }
        return maxProfit;
    }


    static void main(String[] args) {
        System.out.println("Job sequencing problem");
        Job_sequencing obj = new Job_sequencing();
        System.out.println("Maximum profit = " + obj.maximumProfit());
        for (int x = 0; x < obj.arrayList.size(); x++) {
            System.out.print("job " + x + " = ");
            for (int y = 0; y < obj.arrayList.get(x).size(); y++) {
                System.out.print(" " + obj.arrayList.get(x).get(y) + " ");
            }
            System.out.println();
        }
    }

}
