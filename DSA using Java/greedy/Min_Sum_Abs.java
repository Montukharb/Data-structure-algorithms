package greedy;

import java.util.Arrays;

public class Min_Sum_Abs {

    static int minAbsSubValue()
    {
//        int[] Arr1 = {1,2,3};
//        int[] Arr2 = {2,1,3};
        int[] Arr1 = {4,1,8,7};
        int[] Arr2 = {2,3,6,5};
        Arrays.sort(Arr1);
        Arrays.sort(Arr2);
        int minAbsValue = 0;
        for(int i = 0;i<Arr1.length;i++)
        {
            minAbsValue += Math.abs(Arr1[i] - Arr2[i]);
        }
        return minAbsValue;
    }
     static void main(String[] args)
     {
         System.out.println("Minimum sum of Absolute difference = " + minAbsSubValue());
     }

}
