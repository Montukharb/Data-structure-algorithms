// import java.util.*;
public class ArrayQuestion11 {

    public static void main(String[] args) {
        {
            ArrayQuestion11 obj = new ArrayQuestion11();
            int arr[] = {1, 2, 3, 4}, arr2[] = {1, 2, 3, 4}, arr3[] = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

            System.out.println("duplicates value availability = " + obj.DuplicateCheck(arr2));
            int[] rotatedSortedArr = {7,6,5,4,0,1};
            int target = 6;
            int sorArrRes = obj.Sorted_RotatedArray(rotatedSortedArr, target);
            if(sorArrRes!= -1)
            {
              System.out.println("Index found = " + sorArrRes);
            }
            else
            {
              System.out.println("Index not found = " + sorArrRes);
            }
            int[] bSSarr = {7,1,5,3,6,4};
            int[] bSSarr2 = {7,6,4,3,1};
            System.out.println("Buy and Sell Stock Result = "+ obj.buyAndSellStock(bSSarr2));
        }
    }

    boolean DuplicateCheck(int arr[]) {
        //brute force check time complexity is O(n^2)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    //Rotated array unknown piot element;
    int Sorted_RotatedArray(int[] arr,int target) {
        int start = 0, end = arr.length - 1;

        //loop run till end start less than or equal to end;
        while (start <= end) {
            int mid = (start + end) / 2;
              if(arr[mid]==target)
              {
                return mid;
              }            
              //left part sorted
              if(arr[start]<= arr[mid])
              {
                if((arr[start]<=target) && target<arr[mid])
                {
                  end = mid-1;
                }
                else
                {
                  start = mid + 1;
                }
              }
              else //right part sorted
              {
                  if((arr[mid]< target) && (target<= arr[end]))
                  {
                       start = mid+1;
                  }
                  else
                  {
                       end = mid -1;
                  }
              }
        }
        return -1;
    }

    int buyAndSellStock(int[] prices)
    {
      int stockprice = Integer.MAX_VALUE;
      int maxprofit = 0;
      for(int i = 0;i<prices.length;i++)
      {
        if(stockprice < prices[i])
        {
           int profit = prices[i] - stockprice;
           maxprofit = Math.max(maxprofit,profit);
        }
      else{
        stockprice = prices[i];
      }
      }
      if(maxprofit < 0)
        {
          maxprofit = 0;
        }
      return maxprofit;
    }
}
