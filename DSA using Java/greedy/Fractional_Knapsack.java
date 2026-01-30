package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Fractional_Knapsack {
    int[] value = {60, 100, 120};
    int[] weight = {10, 20, 30};
    int maxWeight = 50; //50kg
    int capacity = maxWeight;
    double[][] ratioValue = new double[value.length][2];

    int fractKnapsack() {
        for (int i = 0; i < value.length; i++) {
            ratioValue[0][0] = i;
            ratioValue[0][1] = value[i] / (double) weight[i];
        }
        //sorting ascending order 2D matrix;
        Arrays.sort(ratioValue, Comparator.comparingDouble(o -> o[1]));
        int maxValue = 0;
        for (int i = ratioValue.length - 1; i >= 0; i--) {
            int index = (int) ratioValue[i][0];
            if (capacity >= weight[index]) {
                maxValue += value[index];
                capacity -= weight[index];
            } else {
                maxValue += (int) (ratioValue[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        return maxValue;
    }

    static void main(String[] args) {
        System.out.println("Fractional knapsack");
        Fractional_Knapsack obj = new Fractional_Knapsack();
        System.out.println("Max Value = " + obj.fractKnapsack());
    }
}
