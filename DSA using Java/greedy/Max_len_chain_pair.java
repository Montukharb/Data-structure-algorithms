package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Max_len_chain_pair {
    static int[][] pairs = {
            {5, 24},
            {39, 60},
            {5, 28},
            {27, 40},
            {50, 90},
    };

    static int maxLengthChain() {
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int maxChainLength = 1;
        int chainLast = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > chainLast) {
                maxChainLength++;
                chainLast = pairs[i][1];
            }
        }
        return maxChainLength;
    }

    static void main(String[] args) {
        System.out.println("Maximum length chain of pairs = " + maxLengthChain());
    }

}
