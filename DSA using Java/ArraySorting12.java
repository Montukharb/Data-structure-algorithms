
import java.util.Arrays;
import java.util.Collections;

public class ArraySorting12 {

    static int[] unsorted_arr = {5, 8, 6, 1, 2, 0, 5, 4, 3};
    static Integer[] unsorted_arr2 = {56, 97, 2, 34, 8, 9, 1, 1, 0};

    public static void main(String[] args) {
        ArraySorting12 obj = new ArraySorting12();
        // int[] sorted_arr = {0,1,2,3,4,5,6,7,8,9,10};  

        //bubble sort;
        // obj.bubble_sort(unsorted_arr);
        //selection sort;
        // obj.selection_sort(unsorted_arr);
        //insertion sort;
        obj.insertion_sort(unsorted_arr);

        //display array;
        obj.display_arr(unsorted_arr);

        //inbuild sorting method;
        // obj.inbuild_arr_display(unsorted_arr2);
        obj.inbuild_sorting(unsorted_arr2);

        //counting sort;
        int ar[] = {4, 2, 2, 8, 3, 3, 1};
        obj.Counting_sort(ar);
        System.err.println();
        obj.display_arr(ar);

    }


    /* 1.bubble sort
    2.selection sort
    3.insertion sort
    4.build in sort
    5.counting sort   
     */
    void bubble_sort(int arr[]) {
        // idea The basic idea of bubble sort come from the vapours of water when heat any tube. Small elements exits first then bigger and bigger so on.
        //traverse the all array one by one;
        int swapping = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapping++;
                }

            }
            if (swapping == 0) {
                System.out.println("Array already sorted");
                break;
            }
        }
    }

    void selection_sort(int arr[]) {

        //traverse all loop one by one; Time Complexity = O(n^2);
        for (int i = 0; i < arr.length; i++) {
            int smallest = i;
            for (int j = i + 1; j < arr.length; j++) { //check one by one smallest element all of then one;
                if (arr[smallest] > arr[j]) {
                    smallest = j; //set index smallest array element;
                }
            }
            //swap array index current me smalles or smallest me current;
            int temp = arr[i]; //current element store ith index
            arr[i] = arr[smallest]; //array ith index set smallest element
            arr[smallest] = temp; //array smallest element set array ith bigest number
        }
    }

    void insertion_sort(int arr[]) {
        //idea = taking from card shifting ascending order;
        for (int i = 1; i < arr.length; i++) {
            int current_element = arr[i];
            int prev_element = i - 1;
            while (prev_element >= 0 && arr[prev_element] > current_element) {

                arr[prev_element + 1] = arr[prev_element]; //change the temperary current element  
                prev_element--;
            }
            //previous add 1 becasue previous are -1 after the loop completed
            arr[prev_element + 1] = current_element;

        }
    }

    void display_arr(int arr[]) {
        for (var i : arr) {
            System.out.print(i + " ");
        }
    }

    //inbuild sortin;
    void inbuild_sorting(Integer arr[]) {
        // Arrays.sort(arr); //ascending order;
        final int Start_Index = 0;
        final int End_Index = 4;

        // Arrays.sort(unsorted_arr2,Start_Index,End_Index); //range based sorting.
        //descending sorting;
        // Arrays.sort(unsorted_arr2,Collections.reverseOrder());
        //range based descending order;
        Arrays.sort(unsorted_arr2, Start_Index, End_Index, Collections.reverseOrder());
        inbuild_arr_display();

    }

    void inbuild_arr_display() {
        System.err.println();
        for (var i : unsorted_arr2) {
            System.out.print(i + " ");
        }
    }

    //counting sorting;
    /*Counting sort is a powerful algorithm 
   def: counting sort is efficient when the range of inpute data is not significantly greater than the number of elements.*/
    void Counting_sort(int arr[]) {
        //step 1 find the maximul array element;
        int bigest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > bigest) {
                bigest = arr[i];
            }
        }
        // System.out.println("max element" + bigest);
        // Step 2; Make a count array with length is bigest+1;
        int[] count = new int[bigest + 1]; //java automaticall stored zero value each index if not initalize;

        //step 3; traverse the orignal array and count the frequency of array;
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++; //means count array index number zero to n arr[0] = 4 count[4] = 1, arr[1] = 2 value  count[2] = 1 arr[2] = 2 count[2] = 1++(2)
        }

        //step 4 sorting;
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) //firt starting index count[1] = 1 > 0;
            {
                arr[index] = i; //orignal array indexing arr[0] = 1,arr[1] = 2 till end
                index++;
                count[i]--; //decrease the count array indexing frequency if zero end loop
            }
        }

    }

}
