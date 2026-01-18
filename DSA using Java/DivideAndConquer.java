public class DivideAndConquer {
    static void main(String[] args) {
        System.out.println("Divide and conquer algorithms Merge sort, Quick sort etc");
        DivideAndConquer obj = new DivideAndConquer();

        //merge sort method call
        int[] unsortedarr = {6, 3, 9, 5, 2, 8};
        obj.mergeSort(unsortedarr, 0, unsortedarr.length - 1);
        obj.display_algorithm(unsortedarr);
    }


    void mergeSort(int[] arr, int st_ind, int en_ind) {
        if (st_ind >= en_ind) //base case
        {
            return;
        }
        //find mid index;
        int mid = st_ind + (en_ind - st_ind) / 2;

        //left array divided;
        mergeSort(arr, st_ind, mid);

        //right array divided;
        mergeSort(arr, mid + 1, en_ind);

        //call sorted array function;
        mergeSortAndShifting(arr, st_ind, mid, en_ind);
    }

    void mergeSortAndShifting(int[] arr, int st_ind, int mid, int en_ind) {
        //create a temporary array;
        int[] temp = new int[en_ind - st_ind + 1];
        int i = st_ind;
        int j = mid + 1;
        int k = 0;
        //left and right array compare and swaping two index ascending till end arr[left] <= mid And arr[right] <= ending index;
        while ((i <= mid) && (j <= en_ind)) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // for leftover element of left sorted array shifting to temp;
        while (i <= mid) {

            temp[k] = arr[i];
            k++;i++;
        }
        //for R over elements of second sorted shifting to temp;
        while (j <= en_ind) {

            temp[k] = arr[j];
            k++;j++;
        }
        //temporary array shift to original array;
        for (i = st_ind, k = 0; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }
    void display_algorithm(int[] arr) {
        for (var a : arr) {
            System.out.print(a + " ");
        }
    }
}
