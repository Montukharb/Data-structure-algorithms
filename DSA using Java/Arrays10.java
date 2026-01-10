
public class Arrays10 {

    public static void main(String[] args) {
        System.out.println("Arrays sorting");
        Arrays10 obj = new Arrays10();
        int res = obj.Linear_search(new int[]{10, 20, 30, 40, 5, 8, 46, 96, 6}, 6);
        if (res != -1) {
            System.out.println("Key found at index = " + res);
        } else {
            System.out.println("Not found");
        }
        int[] arr = {4, 56, 7, 69, -11, 6, 68, 45, 3, 0, 15, 6, -8};
        System.out.println("Largest number = " + obj.Largest_Numbers(arr));
        System.out.println("Smallest number = " + obj.Smallest_Numbers(arr));
        int[] sortedarr = {1, 3, 5, 6, 8, 10, 15, 19, 25, 28, 35, 45, 89, 98, 99, 100, 256};
        int binres = obj.Binary_Search(sortedarr, 89);
        if (binres != -1) {
            System.out.println("Search key found at index = " + binres);
        } else {
            System.out.println("Search key not found");
        }
        System.out.println("Original Array");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        //reverse array call
        obj.Reverse_arrary(arr);
        System.out.println("\nReversed Array");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        int[] arr2 = {1, 2, 3, 4, 5};
        obj.Pairs_in_array(arr2);
        obj.Sub_array(arr2);
        //call kaden's function
        int[] kadarr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("max sum of sub- array = " + obj.Kadans_Algorithm(kadarr));
        // int[] trapped_arr = {4, 2, 0, 3, 2, 5};
        int[] trapped_arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int building_width = 1;

        int trap_res = obj.Trapped_water(trapped_arr, building_width);
        System.out.println("Trapped water = " + trap_res);
        System.out.println("Maximum profit = " + obj.StockBuy_Sell(new int[]{7, 1, 5, 3, 6, 4}));
    }

    //Linear search array program
    int Linear_search(int arr[], int key) {
        System.out.println("Linear Search find the key");
        for (int i = 0; i < arr.length; i++) {
            if (key == arr[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    ;

//largest number in array 
    int Largest_Numbers(int arr[]) {
        int bigNum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > bigNum) {
                bigNum = arr[i];
            }
        }
        return bigNum;
    }

    //smallest number in array 
    int Smallest_Numbers(int arr[]) {
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        return smallest;
    }

    int Binary_Search(int sortedArr[], int key) {
        int start = 0;
        int end = sortedArr.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (sortedArr[mid] == key) {
                return mid;
            }
            if (sortedArr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    //Reversed array
    void Reverse_arrary(int arr[]) {
        int start = 0, end = arr.length - 1;

        while (start < end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;

            start++;
            end--;
        }
    }

    //Pairs in array;
    void Pairs_in_array(int arr[]) {
        System.out.println("\nPairs in array");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ")");
            }
            System.out.println();
        }
    }

    //print sub-array = a continuous part of array;
    void Sub_array(int arr[]) {
        int sum = 0;
        int biggest = Integer.MIN_VALUE;
        System.out.println("Sub Arrays");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                    if (biggest < sum) {
                        biggest = sum;
                    }
                    System.out.print(arr[k] + " ");

                }
                System.out.println("\nSum of sub array = " + sum);
                sum = 0;
            }
            System.out.println("Biggest Sum of array = " + biggest);
            System.out.println();
            biggest = Integer.MIN_VALUE;
        }
    }

    //kadan's algorithm find the largest sum of sub array;
    int Kadans_Algorithm(int arr[]) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum < 0) {
                currentSum = 0;
            }
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    int Trapped_water(int arr[], int width) {
        //create auxiliary array which name is left and right = helper array;
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        //set left and right one index;
        left[0] = arr[0]; //left array left to right stored;
        right[arr.length - 1] = arr[arr.length - 1]; //right array compare right side first then one index back right to left;
        //find max left boundary one by one using loop;
        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }
        //find right max boundary each index using loop right to left;
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }
        /*  count trap water usig this formula
              find min value left or right 
              minvalue - height of building * width;
         */
        int trappedwater = 0;
        for (int i = 0; i < arr.length; i++) {
            trappedwater += (Math.min(left[i], right[i]) - arr[i]) * width;
        }
        return trappedwater;
    }

    int StockBuy_Sell(int prices[]) {
        int maxprofit = 0;
        int buyStockPrice = Integer.MAX_VALUE; //set infinity value;

        for (int i = 0; i < prices.length; i++) {
            if (buyStockPrice < prices[i]) //check buy price is less than today prices
            {
                int profit = prices[i] - buyStockPrice; //calculate profit
                maxprofit = Math.max(maxprofit, profit); //store max profit value 
            } else //loss case;
            {
                buyStockPrice = prices[i];  //set today prices because is less than privious stock prices;
            }
        }
        return maxprofit;
    }

    
}
