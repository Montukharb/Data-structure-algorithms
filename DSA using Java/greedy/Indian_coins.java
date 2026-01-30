package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Indian_coins {
    Integer[] coins = {1, 2, 5, 10, 20, 50, 100, 200, 500};
    ArrayList<Integer> coinList = new ArrayList<>();

    int distributedAmount(int amount) {
        int count = 0;
        Arrays.sort(coins, Collections.reverseOrder());
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                while (coins[i] <= amount) {
                    count++;
                    coinList.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }
        return count;
    }

    static void main(String[] args) {
        System.out.println("Indian coins");
        Indian_coins obj = new Indian_coins();
        System.out.println("Total coins = " + obj.distributedAmount(389));
        System.out.println(obj.coinList);
    }
}
