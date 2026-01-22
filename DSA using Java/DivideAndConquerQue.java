public class DivideAndConquerQue {

    static void main(String[] args) {
        System.out.println("hello word");
        DivideAndConquerQue obj = new DivideAndConquerQue();

        //sortStringArray call here;
        String[] arr = {"sun", "earth", "mars", "Mercury"};
        int st_idx = 0;
        int en_idx = arr.length - 1;
        obj.sortstringArray(arr, st_idx, en_idx);

        //display function call here;
        obj.displayarr(arr, "String Sorting using divide and Conquer method");
        int[] arr_int = {2, 2, 1, 1, 1, 2, 2};
        int en_idx2 = arr_int.length - 1;
        int[] majArr = {2, 3, 2, 1, 2, 8, 8, 1, 1, 2, 2};
//        int[] majArr = {3,2,3};

        System.out.println("Majority element = " + obj.majority_Element_Solution(majArr, 0, majArr.length - 1));

        //inversion count in an array;
        int[] inv = {2, 4, 1, 3, 5};
//        int[] inv = {1,2,3,4,5,6,7,8,9};
//        int[] inv = {9,8,7,6,5,4,3,2,1};
        System.out.println("total inversion = " + obj.inversionSort(inv, 0, inv.length - 1));
    }

    void sortstringArray(String[] arr, int st_idx, int en_idx) {
        if (st_idx >= en_idx) {
            return;  //base case ;
        }
        //divide and conquer method;
        int mid = st_idx + (en_idx - st_idx) / 2;
        //left side;
        sortstringArray(arr, st_idx, mid);

        //right side array;
        sortstringArray(arr, mid + 1, en_idx);
        partition(arr, mid, st_idx, en_idx);

    }

    void partition(String[] arr, int mid, int st_idx, int en_idx) {
        //create temp array;
        String[] temp = new String[en_idx - st_idx + 1];
        int i = st_idx;
        int j = mid + 1;
        int k = 0;

        while ((i <= mid) && (j <= en_idx)) {
            int result = arr[i].compareToIgnoreCase(arr[j]);
            if (result < 0) {
                temp[k] = arr[i]; //less than second half first element;
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        //leftover elements shifting to right position;
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
        }

        //right side elements shifting to right position;

        while (j <= en_idx) {
            temp[k] = arr[j];
            j++;
        }

        //shifting temp array to original array;
        for (i = st_idx, k = 0; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }

    }

    void displayarr(String[] arr, String text) {
        System.out.println(text);
        for (var i : arr) {
            System.out.print(i + " ");
        }
    }


    //Majority element;
    int majority(int[] arr, int number, int i, int j) {
        int count = 0;
        for (int k = i; k < j; k++) {
            if (arr[k] == number) {
                count++;
            }
        }
        return count;
    }

    int majority_Element_Solution(int[] arr, int i, int j) {

        if (i == j) {
            return arr[i];  //base case;
        }

        int mid = i + (j - i) / 2;
        //recursion and backtracking;

        int left = majority_Element_Solution(arr, i, mid); //left array recursion;
        int right = majority_Element_Solution(arr, mid + 1, j); //right array recursion;
        if (left == right) {
            return left;
        }

        int L_count = majority(arr, left, i, j);
        int R_count = majority(arr, right, i, j);


        if (L_count > R_count) {
            return left;
        } else {
            return right;
        }
    }


    int mergeSortInversion(int[] arr, int mid, int st_idx, int en_idx) {
        int count = 0;
        int i = st_idx; //left array started;
        int j = mid + 1; //right array started;
        int k = 0;  //array traversed attribute;

        int[] temp = new int[en_idx - st_idx + 1];
        while (i <= mid && j <= en_idx) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                count += (mid - i) + 1;
                j++;
            }
            k++;
        }

        //left over sorted array;
        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;

        }
        //right side sorted array
        while (j <= en_idx) {
            temp[k] = arr[j];
            k++;
            j++;
        }
        for (int x = 0; x < temp.length; x++) {
            arr[st_idx + x] = temp[x];
        }

        return count;
    }

    //using merge and sort;
    int inversionSort(int[] arr, int st_idx, int en_idx) {
        int inversionCount = 0;
        if (st_idx >= en_idx) {
            return 0;
        }

        int mid = st_idx + (en_idx - st_idx) / 2;

        inversionCount += inversionSort(arr, st_idx, mid);

        inversionCount += inversionSort(arr, mid + 1, en_idx);

        inversionCount += mergeSortInversion(arr, mid, st_idx, en_idx);

        return inversionCount;
    }
}
