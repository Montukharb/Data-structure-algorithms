package greedy;

import java.util.Arrays;
import java.util.Collections;

public class Chocola_problem {
    Integer[] costVertical = {2, 1, 3, 1, 4};
    Integer[] costHorizontal = {4, 1, 2};

    int minimumCost() {
        int h, v;
        h = v = 0;
        int hp = 1; //horizontal pice's;
        int vp = 1; //vertical pice's;

        int totalCost = 0;
        //sorting in descending order;
        Arrays.sort(costHorizontal, Collections.reverseOrder());
        Arrays.sort(costVertical, Collections.reverseOrder());

        while (h < costHorizontal.length && v < costVertical.length) {
            if (costVertical[v] >= costHorizontal[h]) {
                totalCost += (costVertical[v] * hp);
                v++;
                vp++;
            } else {
                totalCost += (costHorizontal[h] * vp);
                h++;
                hp++;
            }
        }

        //left most elements vertical;
        while (v < costVertical.length) {
            totalCost += (costVertical[v] * hp);
            v++;
            vp++;
        }
        while (h < costHorizontal.length) {
            totalCost += (costHorizontal[h] * vp);
            h++;
            hp++;
        }
        return totalCost;
    }

    static void main(String[] args) {
        System.out.println("Chocola Question");
        Chocola_problem obj = new Chocola_problem();
        System.out.println("Minimum cost of chocolate cuts = " + obj.minimumCost());
    }
}
