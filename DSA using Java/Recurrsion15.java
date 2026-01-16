public class Recurrsion15 {
    static void main(String[] args) {
        System.out.println("Recurrsion");
        Recurrsion15 obj = new Recurrsion15();
        obj.decrese_num(10);
        System.out.println("Increasing order");
        int n = 10;
        // byte char short int float long double boolean 100
        int a = 12;

        //  System.out.println(n.toString());
        obj.increasing_num(n, 1);
        int fact = 5;
        System.out.println("Factorial of " + fact + " = " + obj.factorial_n(fact));

        //fibonacci series call here using loop
        for (int i = 0; i <= 10; i++) {
            System.out.print(obj.fibonacci_series(i) + " ");
        }


        //check is array sorted or not call here
        int[] arr = {0, 1, 2, 3, 4, 5, 6};
        int start = 0;
        System.out.println("\nis array sorted or not = " + obj.is_array_sorted(arr, start));

        //first occurence key search function call here;
        int[] wapArr = {8, 3, 6, 9, 5, 10, 2, 5, 3};
        int search_key = 5;
        System.out.println("WAP first occurrence search key found in index = " + obj.first_occurrence_search_key(wapArr, search_key, start));

        //last occurrence
        System.out.println("WAP first occurrence search key found in index = " + obj.last_occurrence_search_key(wapArr, search_key, start));

        //binary power optimized;
        System.out.println("binary power optimized power of 2 ^ 10 = " + obj.binary_power_optimized(2, 10));

    }

    //decreasing number n to 1
    int decrese_num(int n) {
        if (n == 0) {
            return 1;
        }
        System.out.println(n);
        return decrese_num(n - 1);
    }

    //increasing number 1 to n
    void increasing_num(int n, int si) {
        if (si > n) {
            return;
        }
        System.out.println(si);
        increasing_num(n, si + 1);
//        System.out.println(si);

    }

    //factorial of n number;
    int factorial_n(int n) {
        if (n == 0) {
            return 1;
        }
        return (n * factorial_n(n - 1));
    }

    //print nth fibonacci series
    //1,1,2,3,5,8,13,21 etc
    long fibonacci_series(int n) {
        if (n == 0) {    //base case 1
            return 0;
        }                          //time complexity = O(2^n)
        if (n == 1) {              //space complexity = O(n)
            return 1;   //base case 2
        }
//        int res = fibonacci_series(n - 1) + fibonacci_series(n - 2);
        return fibonacci_series(n - 1) + fibonacci_series(n - 2);
    }

    //CHECK IS ARRAY SORTED OR NOT
    boolean is_array_sorted(int[] arr, int start) {
        if (start == arr.length - 1) {
            return true; //reached end of call stack return true then stack unwinding;
        } else if (arr[start] > arr[start + 1]) {
            return false; //array not sorted
        }
        return is_array_sorted(arr, start + 1); //main case build call stack one by one till end not true first case start == length or second case ith index is greater than ith+1 if any one return any label if first then array is sorted because call stack reached end of our index else execute second case return false call stack return false in main function;
    }

    int first_occurrence_search_key(int[] arr, int key, int start) {
        if (start == arr.length) //Base case execute after all loop traversed key not found;
        {
            return -1;
        }
        if (arr[start] == key) //search key found and stop if any call stack build return key and unwinding stack with key index value return to main function;
        {
            return start; //key index;
        }
        return first_occurrence_search_key(arr, key, start + 1); //call stack build here after triggered first or second case unwinding process start returning with value one by one;
    }

    int last_occurrence_search_key(int[] arr, int key, int start) {
        if (start == arr.length) //base case active after complete all traverse zero to n and build stack
        {
            return -1;
        }
        int found = last_occurrence_search_key(arr, key, start + 1); //the main stack build here start zero to n after n occur first case and return -1 in found variable;

        if (found == -1 && arr[start] == key)  //this condition check case after unwinding stack top to down one by one if terminate condition means return -1 actually in this condition combination of last occurrence and first occurrence if last found then ok else first is always last and first equal;
        {
            return start;
        }

        return found; //if key not found anywhere in array;
    }

    int binary_power_optimized(int n, int pow) {
        if (pow == 0) {
            return 1;
        }
        int half = binary_power_optimized(n, pow / 2);
        int halfsq = half * half;
        if ((pow % 2) != 0) {
            halfsq = n * halfsq;
        }
        return halfsq;
    }

}

